package com.u84;


import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;
import com.u84.realisation.SimilarImagesSearch;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) throws IOException {
        long millis = System.currentTimeMillis();
        HashImg hashImg = new HashImg();
        String bin0 = hashImg.convertHashToString(hashImg.generateArrayHash(ImageIO.read(
                new File("C:\\Users\\Dmitriy\\Desktop\\155CANON\\IMG_0032.JPG"))));
        String bin1 = hashImg.convertHashToString(hashImg.generateArrayHash(ImageIO.read(
                new File("l0.png"))));
        int start = bin0.indexOf('1');
        int start1 = bin1.indexOf('1');
        String processed = bin0.substring(start);
        String processed1 = bin1.substring(start1);
        Long l0 = Long.parseUnsignedLong(processed, 2);
        Long l1 = Long.parseUnsignedLong(processed1, 2);
        System.out.println(l0);
        System.out.println(l1);
    }
}