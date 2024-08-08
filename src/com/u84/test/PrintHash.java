package com.u84.test;

import com.u84.realisation.HashImg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrintHash {
    public static void main(String[] args) throws IOException {
        HashImg hashManager = new HashImg();
        BufferedImage image = ImageIO.read(new File("pdata\\0.png"));

    }
}
