package com.u84.test;

import com.u84.realisation.SimilarImagesSearch;

import java.io.IOException;

public class Test_6 {
    public static void main(String[] args) throws IOException {
        String path = "pdata\\";
        SimilarImagesSearch search = new SimilarImagesSearch(path);
        search.findSimilarImages();
    }
}
