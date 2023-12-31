package com.u84.test;

import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test_4 {
    public static void main(String[] args) throws IOException {
        ImageColorEditor editor = new ImageColorEditor();
        ImageCompressor compressor = new ImageCompressor();
        String path = "img\\Ливси.jpg";
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        BufferedImage newImage = editor.grayScaleConversion(image);
        File file1 = new File("Origin.png");
        ImageIO.write(newImage, "png", file1);

    }
}
