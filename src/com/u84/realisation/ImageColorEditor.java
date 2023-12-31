package com.u84.realisation;

import com.u84.util.RGB;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageColorEditor {

    public ImageColorEditor(){

    }

    public BufferedImage grayScaleConversion(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                RGB c = new RGB(image.getRGB(y, x));
                int r = c.getRed(), g = c.getGreen(), b = c.getBlue();
                int gray = (r + g + b) / 3;
                outputImage.setRGB(y, x, new Color(gray, gray, gray).getRGB());
            }
        }
        return outputImage;
    }

}
