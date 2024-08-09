package com.u84.test;

import com.u84.realisation.HashImg;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Compress8X8Test {
    public static void main(String[] args) throws IOException {
        FileManager manager = new FileManager();
        HashImg h = new HashImg();
        String path = "somepath";
        manager.create8x8ImageFromFile(path, "h.png");
        BufferedImage image = h.createImageFromHash(h.generateArrayHash(ImageIO.read(new File("h.png"))));
        File newFile = new File("img.png");
        ImageIO.write(image, "png", newFile);
    }
}
