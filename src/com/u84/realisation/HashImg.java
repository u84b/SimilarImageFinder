package com.u84.realisation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HashImg {
    public void print2DArray(int[][] arr){
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                System.out.printf("%d ", arr[y][x]);
            }
            System.out.println();
        }
    }

    public void print2DArray(float[][] arr){
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                System.out.printf("%f ", arr[y][x]);
            }
            System.out.println();
        }
    }

    /**
     Get average RGB pixels of an image.
     **/
    public float getAverageRGB(BufferedImage image){
        float averageRGB = 0;
        int height = image.getHeight();
        int width = image.getWidth();
        float square = height * width;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                averageRGB += image.getRGB(x, y);
            }
        }
        return averageRGB / square;
    }

    /**
     RGB difference between two images.
     **/
    public float getRGBDifference(BufferedImage image, BufferedImage image1){
        float averageRGBDifference = 0;
        int square = image.getHeight() * image.getWidth();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                float maxRGB = Math.max(image1.getRGB(x, y), image.getRGB(x, y));
                float minRGB = Math.min(image1.getRGB(x, y), image.getRGB(x, y));
                averageRGBDifference += (maxRGB / minRGB);
            }
        }
        return averageRGBDifference / square;
    }

    /**
     It returns 2d array hash of image.
     Only for 8X8 images.
     **/
    public int[][] generateArrayHash(BufferedImage image, int height, int width){
        int[][] arrayHash = new int[height][width];
        float averageRGB = getAverageRGB(image);
        for (int y = 0; y < arrayHash.length; y++) {
            for (int x = 0; x < arrayHash[y].length; x++) {
                int pixelRGB = image.getRGB(x, y);
                arrayHash[x][y] = (pixelRGB >= averageRGB) ? 1 : 0;
            }
        }
        return arrayHash;
    }
    /**
     It is just baaaaaased...
     **/
    public int[][] generateArrayHash(BufferedImage image){
        int[][] arrayHash = new int[8][8];
        float averageRGB = getAverageRGB(image);
        for (int y = 0; y < arrayHash.length; y++) {
            for (int x = 0; x < arrayHash[y].length; x++) {
                int pixelRGB = image.getRGB(x, y);
                arrayHash[x][y] = (pixelRGB >= averageRGB) ? 1 : 0;
            }
        }
        return arrayHash;
    }

    /**
     It returns readable binary hash.
     **/
    public String convertHashToString(int[][] hash){
        StringBuilder str = new StringBuilder();
        for (int y = 0; y < hash.length; y++) {
            for (int x = 0; x < hash[y].length; x++) {
                str.append(hash[y][x]);
            }
        }
        return str.toString();
    }

    public long convertHashToLong(int[][] hash){
        String stringOfHash = convertHashToString(hash);
        int index = stringOfHash.indexOf('1');
        return Long.parseUnsignedLong(stringOfHash.substring(index));
    }

    /**
     Comparing of two array hashes.
     **/
    public float compareHashes(int[][] h0, int[][] h1){
        float coincidence = 0;

        if (h0.length == h1.length){
            for (int y = 0; y < h0.length; y++) {
                for (int x = 0; x < h0[y].length; x++) {
                    boolean isSame = (h0[x][y] == h1[x][y]);
                    if (isSame) coincidence++;
                }
            }
        }

        return coincidence/64f;
    }

    public BufferedImage createImageFromHash(int[][] hash){
        BufferedImage image = new BufferedImage(hash.length, hash[0].length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < hash.length; y++) {
            for (int x = 0; x < hash[y].length; x++) {
                if (hash[y][x] == 0){
                    Color color = Color.BLACK;
                    image.setRGB(y, x, color.getRGB());
                }
                if (hash[y][x] == 1){
                    Color color = Color.WHITE;
                    image.setRGB(y, x, color.getRGB());
                }
            }
        }
        return image;
    }


}
