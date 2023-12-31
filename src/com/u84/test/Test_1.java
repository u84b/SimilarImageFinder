package com.u84.test;

import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test_1 {
    public static void main(String[] args) throws IOException {
        String path = "img\\dm.jpg";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        ImageCompressor generator = new ImageCompressor();
        BufferedImage anotherImage =  generator.compressImageTo32X32(image);
        File newFile = new File("nimg\\newdm.png");
        ImageIO.write(anotherImage, "png", newFile);
    }
}
