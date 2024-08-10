package com.u84.realisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImageComparator {
    private HashImg hashImg;
    
    public ImageComparator(HashImg hashImg){
        this.hashImg = hashImg;
    }
    
    public ArrayList<ArrayList<String>> compareImagesByHash(Map<String, String> dataset){
        ArrayList<ArrayList<String>> filesToCheck = new ArrayList<>();
        ArrayList<String> names = (ArrayList<String>) dataset.keySet(),
                values = (ArrayList<String>) dataset.values();
        int currentNum = 0;
        for (int i = currentNum; i < values.size();) {
            int j = i++;
            ArrayList<String> currentFiles = new ArrayList<>();
            currentFiles.add(values.get(i));
            while (hashImg.compareHashes(values.get(i), values.get(j)) >= 0.85f){
                currentFiles.add(values.get(j));
                j++;
            }
            if (currentFiles.size() >= 2) filesToCheck.add(currentFiles);
            currentNum = j;
        }
        return null;
    }
}
