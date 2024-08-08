package com.u84.realisation;

import com.u84.util.RGB;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class ImageCompressor {

    public ImageCompressor(){
    }

    public BufferedImage improvedCompression(String path) throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(path));
        BufferedImage outputImage = new BufferedImage(8, 8, 1);
        Graphics2D g = outputImage.createGraphics();
        g.drawImage(inputImage, 0, 0, 8, 8, null);
        return outputImage;
    }

    /**
     Don't ask why I didn't make only one function here for all cases.
     Firstly, it's more readable, I think.
     Secondly, I love more letters.

     Compress image to 32 x 32 pixels.
     It is useful for some reasons.
     **/
    public BufferedImage compressImageTo32X32(BufferedImage image){

        int height = image.getHeight();
        int width = image.getWidth();
        if (height > 32 && width > 32){
            int[] positions = setXY(width, height);
            int initialX = positions[0], initialY = positions[1];
            int finalX = positions[2], finalY = positions[3];

            System.out.println(Arrays.toString(positions));
            float H = ((finalY - initialY) / 32f);
            float W = ((finalX - initialX) / 32f);
            System.out.println(H + " ; " + W);
            int minLength = Math.min(finalX, finalY);

            float min = (float) round(Math.min(H, W));
            int xIndex = (int) (initialX/min), yIndex = (int) (initialY/min);
            System.out.println(min);
            int d = (int)(minLength*1.1f) / 32 * (int)(minLength*1.1f) / 32; // square
            int averageRed = 0, averageGreen = 0, averageBlue = 0;

            BufferedImage newImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
            System.out.println(finalX + " " + finalY);
            for (int cy = initialY; cy <= finalY - min; cy+=min) {
                for (int cx = initialX; cx <= finalX - min; cx+=min) {
                    for (int x = cx; x < cx + min; x++) {
                        for (int y = cy; y < cy + min; y++) {
                            RGB rgb = new RGB(image.getRGB(x, y));
                            averageRed += rgb.getRed();
                            averageGreen += rgb.getGreen();
                            averageBlue   += rgb.getBlue();
                        }
                    }
                    Color color = new Color(averageRed/d, averageGreen/d, averageBlue/d);
                    //System.out.println((cx/min-xIndex) + " " + (cy/min - yIndex));
                    newImage.setRGB((int)(cx/min) - xIndex, (int)(cy/min) - yIndex, color.getRGB());
                    averageRed = 0; averageGreen = 0; averageBlue = 0;
                }

            }
            return newImage;
        }else{
            return image;
        }
    }

    /**
     But it MUCH more useful than previous...
     **/
    public BufferedImage compressImageTo8X8(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();

        if (height > 8 && width > 8){
            int[] positions = setXY(width, height);
            int initialX = positions[0], initialY = positions[1];
            int finalX = positions[2], finalY = positions[3];

            float H = ((finalY - initialY) / 8f);
            float W = ((finalX - initialX) / 8f);
            int minLength = Math.min(height, width);
            float min = (float) round(Math.min(H, W));
            int xIndex = (int) (initialX/min), yIndex = (int) (initialY/min);

            int d = (int)((minLength*1.1f / 8) * (minLength*1.1f / 8)); // square
            int averageRed = 0, averageGreen = 0, averageBlue = 0;

            BufferedImage newImage = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);

            for (int cy = initialY; cy <= finalY - min; cy+=min) {
                for (int cx = initialX; cx <= finalX - min; cx+=min) {
                    for (int x = cx; x < cx + min; x++) {
                        for (int y = cy; y < cy + min; y++) {
                            RGB rgb = new RGB(image.getRGB(x, y));
                            averageRed += rgb.getRed();
                            averageGreen += rgb.getGreen();
                            averageBlue   += rgb.getBlue();
                        }
                    }
                    //System.out.println(averageRed/d + " " + averageGreen/d + " " + averageBlue/d);
                    //System.out.print((cx/min-xIndex) + " " + (cy/min-yIndex) + " ; ");
                    Color color = new Color(averageRed / d, averageGreen / d, averageBlue / d);
                    newImage.setRGB( (int) (cx / min) - xIndex, (int) (cy / min) - yIndex, color.getRGB());
                    averageRed = 0; averageGreen = 0; averageBlue = 0;
                }
                //System.out.println();
            }
            return newImage;
        }else{
            return image;
        }
    }



    /**
     Here we find the coordinates of the beginning and end
     of the part of the image that we are processing.
     **/
    private int[] setXY(int width, int height){
        int max = Math.max(width, height), min = Math.min(width, height);
        int[] positions = new int[]{};
        float ratio = (float) max / min;
        if (ratio == 1f){
            positions = new int[]{0, 0, width, height};
        }
        else if (width > height){
            int start = (width - height) / 2;
            int x0 = start, y0 = 0, x1 = width - start, y1 = height;
            positions = new int[]{x0, y0, x1, y1};
        }
        else if (width < height){
            int start = (height - width) / 2;
            int x0 = 0, y0 = start, x1 = width, y1 = height - start;//height - start, y1 = height;
            positions = new int[]{x0, y0, x1, y1};
        }
        return positions;
    }

    /**
     Don't pay attention to it.
     **/
    private int round(float n){
        if (Math.ceil(n) - n < 0.2f) return Math.round(n);
        else return (int) Math.floor(n);
    }

    public BufferedImage compressImageToGrayImg8X8(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();

        if (height > 8 && width > 8){
            int[] positions = setXY(width, height);
            int initialX = positions[0], initialY = positions[1];
            int finalX = positions[2], finalY = positions[3];

            float H = ((finalY - initialY) / 8f);
            float W = ((finalX - initialX) / 8f);
            int minLength = Math.min(height, width);
            float min = (float) round(Math.min(H, W));
            int xIndex = (int) (initialX/min), yIndex = (int) (initialY/min);

            int d = (int)((minLength*1.1f / 8) * (minLength*1.1f / 8)); // square
            int averageRed = 0, averageGreen = 0, averageBlue = 0;

            BufferedImage newImage = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
            try{
                for (int cy = initialY; cy <= finalY - min; cy+=min) {
                    for (int cx = initialX; cx <= finalX - min; cx+=min) {
                        for (int x = cx; x < cx + min; x++) {
                            for (int y = cy; y < cy + min; y++) {
                                RGB rgb = new RGB(image.getRGB(x, y));
                                averageRed += rgb.getRed();
                                averageGreen += rgb.getGreen();
                                averageBlue   += rgb.getBlue();
                            }
                        }
                        int average = (averageRed / d + averageGreen / d + averageBlue / d) / 3;
                        Color color = new Color(average, average, average);
                        newImage.setRGB( (int) (cx / min) - xIndex, (int) (cy / min) - yIndex, color.getRGB());
                        averageRed = 0; averageGreen = 0; averageBlue = 0;
                    }
                }
            }catch (Exception e){}
        return newImage;
    }else{
        return image;
    }
}

}