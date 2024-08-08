package com.u84.test;

import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareHashTest {
    public static void main(String[] args) throws IOException {
        ImageCompressor compressor = new ImageCompressor();
        BufferedImage img1 = compressor.compressImageTo8X8(ImageIO.read(new File("img/0.png")));
        BufferedImage img2 = compressor.compressImageTo8X8(ImageIO.read(new File("img/3.png")));
        HashImg hash = new HashImg();
        int[][] h1 = hash.generateArrayHash(img1), h2 = hash.generateArrayHash(img2);
        long time = System.currentTimeMillis();
        System.out.println(hash.compareHashes(h1, h2));
        System.out.println(System.currentTimeMillis() - time);

        System.out.println(hash.getAverageRGB(img1));
        System.out.println(hash.getAverageRGB(img2));
        time = System.currentTimeMillis();
        System.out.println(hash.getRGBDifference(img1, img2));
        System.out.println(System.currentTimeMillis() - time);
    }
}
