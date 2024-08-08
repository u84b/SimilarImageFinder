package com.u84.gui;

import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResize {
    public static void main(String[] args) throws IOException {
        ImageCompressor compressor = new ImageCompressor();
        String path = "C:\\Users\\Dmitriy\\Desktop\\155CANON\\IMG_0032.JPG";
//
//        long millis = System.currentTimeMillis();
//        BufferedImage image = compressor.compressImageTo8X8(ImageIO.read(new File(path)));
//        File file = new File("TEST1.png");
//        ImageIO.write(image, "png", file);
//        System.out.println(System.currentTimeMillis() - millis);
        HashImg hashImg = new HashImg();
        long millis = System.currentTimeMillis();
        BufferedImage image1 = hashImg.createImageFromHash(hashImg.generateArrayHash(create(path, 4, 4), 4, 4));
        File file1 = new File("TEST2.png");
        ImageIO.write(image1, "png", file1);
        System.out.println(System.currentTimeMillis() - millis);
    }

    private static BufferedImage create(String imagePath, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(new File( imagePath));
        BufferedImage newImage = new BufferedImage(width, height, 1);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        return newImage;
    }
}
