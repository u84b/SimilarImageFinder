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
        ImageCompressor compressor = new ImageCompressor();
        String path = "C:\\Users\\Dmitriy\\Desktop\\ВидИзОкна\\IMG_2021.jpg";
        BufferedImage img = compressor.compressImageTo8X8(ImageIO.read(new File(path)));
        String bin0 = hashImg.convertHashToString(hashImg.generateArrayHash(img));
        String bin1 = hashImg.convertHashToString(hashImg.generateArrayHash(ImageIO.read(
                new File("l0.png"))));
    }
}