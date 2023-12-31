package com.u84.realisation;

import com.u84.util.RGB;
import java.awt.*;
import java.awt.image.BufferedImage;



public class ImageCompressor {

    public ImageCompressor(){
    }

    /**
     Don't ask why I didn't make only one function here for all cases.
     Firstly, it's more readable, I think.
     Secondly, I love more letters.
     **/

    /**
     Compress image to 32 x 32 pixels.
     It is useful for some reasons.
     **/
    public BufferedImage compressImageTo32X32(BufferedImage image){

        int height = image.getHeight();
        int width = image.getWidth();
        if (height > 32 && width > 32){
            float H = (height / 32f * 0.97f);
            float W = (width / 32f * 0.97f);
            int minLength = Math.min(height, width);
            float min = Math.min(H, W);
            int d = (int)(minLength*1.1f) / 31 * (int)(minLength*1.1f) / 31;
            int averageRed = 0, averageGreen = 0, averageBlue = 0;
            BufferedImage newImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
            for (int cy = 0; cy <= minLength-min; cy+=min) {
                for (int cx = 0; cx <= minLength-min; cx+=min) {
                    for (int x = cx; x < cx+min; x++) {
                        for (int y = cy; y < cy+min; y++) {
                            RGB rgb = new RGB(image.getRGB(x, y));
                            averageRed += rgb.getRed();
                            averageGreen += rgb.getGreen();
                            averageBlue   += rgb.getBlue();
                        }
                    }
                    Color color = new Color(averageRed/d, averageGreen/d, averageBlue/d);
                    newImage.setRGB((int)((float)cx/(min)), (int)((float)cy/(min)), color.getRGB());
                    averageRed = 0; averageGreen = 0; averageBlue = 0;
                }

            }
            return newImage;
        }else{
            return image;
        }
    }

    /**
     But it more useful than previous...
     **/
    public BufferedImage compressImageTo8X8(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();

        if (height > 8 && width > 8){
            float H = (height / 8f);
            float W = (width / 8f);
            int minLength = Math.min(height, width);
            int min = (int)Math.min(H, W);
            int d = (minLength / 8) * (minLength / 8);
            int averageRed = 0, averageGreen = 0, averageBlue = 0;

            BufferedImage newImage = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);

            for (int cy = 0; cy <= minLength-min; cy+=min) {
                for (int cx = 0; cx <= minLength-min; cx+=min) {
                    for (int x = cx; x < cx+min; x++) {
                        for (int y = cy; y < cy+min; y++) {
                            RGB rgb = new RGB(image.getRGB(x, y));
                            averageRed += rgb.getRed();
                            averageGreen += rgb.getGreen();
                            averageBlue   += rgb.getBlue();
                        }
                    }
                    Color color = new Color(averageRed/d, averageGreen/d, averageBlue/d);
                    newImage.setRGB( cx/min, cy/min, color.getRGB());
                    averageRed = 0; averageGreen = 0; averageBlue = 0;
                }

            }
            return newImage;
        }else{
            return image;
        }
    }

    /**
     I'll add more functions here in future.

     I need functions for more accurate calculation of proportions, etc.
     **/

}
