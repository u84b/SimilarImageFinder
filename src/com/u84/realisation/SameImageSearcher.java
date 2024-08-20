package com.u84.realisation;

import com.u84.util.FileManager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SameImageSearcher {
    public SameImageSearcher(){
    }

    public ArrayList<ArrayList<String>> search(String path) throws IOException {
        HashImg hashImg = new HashImg();
        FileManager manager = new FileManager();
        ImageComparator comparator = new ImageComparator(hashImg);
        ImageCompressor compressor = new ImageCompressor();

        ArrayList<File> imageFiles = manager.traverseDirectoryToFindImages(path);
        ArrayList<String> binaryHashes = new ArrayList<>();
        HashMap<String, String> hashDataSet = new HashMap<>();
        for (File f : imageFiles) {
            //System.out.println(f.getPath());
            BufferedImage currentImage = compressor.improvedCompression(f.getAbsolutePath(), 16);

            String currentBinaryHash = hashImg.convertHashToString(hashImg.generateArrayHash(currentImage, 16, 16));
            //System.out.println(currentBinaryHash);
            binaryHashes.add(currentBinaryHash);
        }
        for (int i = 0; i < imageFiles.size(); i++) hashDataSet.put(imageFiles.get(i).toString(), binaryHashes.get(i));
        LinkedHashMap<String, String> h =  (LinkedHashMap<String, String>) hashImg.sortHashMap(hashDataSet);
        return comparator.compareImagesByHash(h);
    }
}
