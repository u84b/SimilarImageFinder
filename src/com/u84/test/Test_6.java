package com.u84.test;

import com.u84.realisation.SimilarImagesSearch;
import com.u84.util.FileManager;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Test_6 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Dmitriy\\Desktop\\data";
        SimilarImagesSearch search = new SimilarImagesSearch(path);
        ArrayList<ArrayList<String>> similarImages = search.findSimilarImages();
        for (ArrayList<String> array: similarImages) {
            System.out.println(array);
        }
    }
}
