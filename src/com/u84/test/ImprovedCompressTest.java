package com.u84.test;

import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImprovedCompressTest {
    public static void main(String[] args) throws IOException {
        ImageCompressor compressor = new ImageCompressor();
        FileManager manager = new FileManager();
        HashImg hashImg = new HashImg();
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Dmitriy\\Desktop\\фоти\\Я.jpg"));
        BufferedImage image1 = hashImg.createImageFromHash(hashImg.generateArrayHash(compressor.compressImageToGrayImg8X8(image)));

        File file = new File("me1.png");
        ImageIO.write(image1, "png", file);
    }
}
