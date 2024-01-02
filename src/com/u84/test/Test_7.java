package com.u84.test;

import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;
import com.u84.realisation.SimilarImagesSearch;
import com.u84.util.FileManager;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test_7 {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        ImageCompressor compressor = new ImageCompressor();
        ImageColorEditor editor = new ImageColorEditor();

        String path = "C:\\Users\\Dmitriy\\Desktop\\155CANON";

        ArrayList<File> imageFiles = fileManager.findImage(path);
        ArrayList<BufferedImage> images = new ArrayList<>();

        for (File file : imageFiles) {
            BufferedImage img = editor.grayScaleConversion(compressor.compressImageTo8X8(ImageIO.read(file)));
            images.add(img);
            System.out.println(file.getAbsolutePath());
        }
        SimilarImagesSearch imagesSearch = new SimilarImagesSearch(path);
        ArrayList<ArrayList<String>> comparedImages = imagesSearch.findSimilarImages();
        System.out.println(comparedImages);
        for (ArrayList<String> imgs : comparedImages) {
            System.out.println(imgs);
        }
    }
}
