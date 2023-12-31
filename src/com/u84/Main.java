package com.u84;
import com.u84.realisation.HashImg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        HashImg generator = new HashImg();
        File file = new File("desktop\\39.png");
        File file1 = new File("desktop\\40.png");
        BufferedImage image = ImageIO.read(file);
        BufferedImage image1 = ImageIO.read(file1);
        int[][] arr0 = generator.generateArrayHash(image);
        int[][] arr1 = generator.generateArrayHash(image1);
        System.out.println(generator.compareHashes(arr0, arr1));

    }
}