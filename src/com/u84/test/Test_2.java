package com.u84.test;

import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;
import com.u84.util.FileManager;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test_2 {
    public static void main(String[] args) throws IOException {
        File imageDirectory = new File("desktop\\");
        HashMap<String, Float> images = new HashMap<>();
        ImageCompressor compressor = new ImageCompressor();
        ImageColorEditor editor = new ImageColorEditor();
        for (File file: Objects.requireNonNull(imageDirectory.listFiles())) {
            String extension = FileManager.getExtension(file.getPath());
            if (extension.equals(".png") | extension.equals(".jpg")) {
                BufferedImage image = ImageIO.read(file);
                System.out.println(file.getName());
                BufferedImage newImage =  editor.grayScaleConversion(compressor.compressImageTo8X8(image));
                File newFile = new File("pdata\\"+file.getName());
                ImageIO.write(newImage, "png", newFile);
                images.put(file.getPath(), (float) image.getHeight() / image.getWidth());
            }
        }
        System.out.println(images);
        System.out.println(3f/4f);
        //LinkedHashMap<String, Float> linked = images.entrySet().stream().sorted(Map.Entry.comparingByValue()).
        //        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (f1, f2) -> f1, LinkedHashMap::new));

        //System.out.println(linked);
    }
}
