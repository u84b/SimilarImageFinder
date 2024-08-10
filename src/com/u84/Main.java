package com.u84;


import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;
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
        Scanner scanner = new Scanner(System.in);
        FileManager manager = new FileManager();
        ImageCompressor compressor = new ImageCompressor();
        HashImg hashImg = new HashImg();

        String pathToDirectory = scanner.next(); // input path
        ArrayList<File> imageFiles = manager.traverseDirectoryToFindImages(pathToDirectory);
        ArrayList<String> binaryHashes = new ArrayList<>();
        HashMap<String, String> hashDataSet = new HashMap<>();
        for (File f : imageFiles) {
            BufferedImage currentImage = compressor.compressImageTo8X8(ImageIO.read(f));
            String currentBinaryHash = hashImg.convertHashToString(hashImg.generateArrayHash(currentImage));
            binaryHashes.add(currentBinaryHash);
        }
        for (int i = 0; i < imageFiles.size(); i++) hashDataSet.put(imageFiles.get(i).toString(), binaryHashes.get(i));
        LinkedHashMap<String, String> h =  (LinkedHashMap<String, String>) hashImg.sortHashMap(hashDataSet);
        for (String key : h.keySet()) {
            System.out.println(key);
            System.out.println(h.get(key));
        }

    }
}