package com.u84.test;

import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Dmitriy\\Desktop\\ВАЖНО\\мастерская пикч\\Ваня.png");
        BufferedImage van = ImageIO.read(file);
        System.out.println((float)van.getHeight() / 32 + " " + (float)van.getWidth() / 32);
        ImageCompressor compressor = new ImageCompressor();
        BufferedImage image = compressor.compressImageTo32X32(van);
        File newFile = new File("1.png");
        ImageIO.write(image, "png", newFile);
    }
}
