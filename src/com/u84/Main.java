package com.u84;


import com.u84.realisation.*;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Here will be start...
         **/
        HashImg hashImg = new HashImg();
        FileManager manager = new FileManager();
        ImageComparator comparator = new ImageComparator(hashImg);
        ImageCompressor compressor = new ImageCompressor();
        SameImageSearcher searcher = new SameImageSearcher();
        //Scanner scanner = new Scanner(System.in);
        MainScreen mainScreen = new MainScreen(searcher); // chose path
        mainScreen.show();
//        System.out.println(pathToDirectory);
//
//        ArrayList<File> imageFiles = manager.traverseDirectoryToFindImages(pathToDirectory);
//        ArrayList<String> binaryHashes = new ArrayList<>();
//        HashMap<String, String> hashDataSet = new HashMap<>();
//        for (File f : imageFiles) {
//            //System.out.println(f.getPath());
//            BufferedImage currentImage = compressor.improvedCompression(f.getAbsolutePath(), 16);
//
//            String currentBinaryHash = hashImg.convertHashToString(hashImg.generateArrayHash(currentImage, 16, 16));
//            //System.out.println(currentBinaryHash);
//            binaryHashes.add(currentBinaryHash);
//        }
//        for (int i = 0; i < imageFiles.size(); i++) hashDataSet.put(imageFiles.get(i).toString(), binaryHashes.get(i));
//        LinkedHashMap<String, String> h =  (LinkedHashMap<String, String>) hashImg.sortHashMap(hashDataSet);
        ArrayList<ArrayList<String>> saved = mainScreen.getFiles();
        for (ArrayList<String> files : saved) {
            System.out.println(files);
        }
//        for (String key : h.keySet()) {
//            System.out.println(key);
//            System.out.println(h.get(key));
//        }

    }
}