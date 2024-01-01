package com.u84.test;

import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test_0 {
    public static void main(String[] args) throws IOException {
        String path = "path";
        FileManager finder = new FileManager();
        ArrayList<File> files = finder.findImage(path);
        ImageCompressor compressor = new ImageCompressor();
        ImageColorEditor editor = new ImageColorEditor();
        for (File f: files) {
            BufferedImage image = ImageIO.read(f);
            try{
                BufferedImage newImage = compressor.compressImageTo8X8(image);
                File newFile = new File("desktop\\"+f.getName());
                ImageIO.write(newImage, "png", newFile);
            }catch (IllegalArgumentException e){
                System.out.println(f.getName());
                System.out.println(image.getHeight() + " " + image.getWidth());
            }catch (ArrayIndexOutOfBoundsException e1){
                System.out.println("Array index out of bounds");
            }
        }
    }
}