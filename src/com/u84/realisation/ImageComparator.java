package com.u84.realisation;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageComparator {
    private final HashImg hashImg;
    
    public ImageComparator(HashImg hashImg){
        this.hashImg = hashImg;
    }
    
    public ArrayList<ArrayList<String>> compareImagesByHash(HashMap<String, String> dataset){
        ArrayList<ArrayList<String>> filesToCheck = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>(dataset.keySet()),
                values = new ArrayList<>(dataset.values());
        ArrayList<String> current = new ArrayList<>();
        for (int i = 0; i < values.size() - 1; i++) {
            if (hashImg.compareHashes(values.get(i), values.get(i+1)) >= 0.9f){
                if (current.contains(names.get(i))) current.add(names.get(i+1));
                else {
                    current.add(names.get(i));
                    current.add(names.get(i + 1));
                    //System.out.println(current);
                }
            } else {
                ArrayList<String> copy = new ArrayList<>(current);
                if (copy.size() != 0) filesToCheck.add(copy);
                current.clear();
            }
        }
        return filesToCheck;
    }
}
//            System.out.println(currentNum);
//            int j = i++;
//            ArrayList<String> currentFiles = new ArrayList<>();
//            currentFiles.add(names.get(i));
//            while (hashImg.compareHashes(values.get(i), values.get(j)) >= 0.85f){
//                currentFiles.add(names.get(j));
//                j++;
//            }
//            if (currentFiles.size() >= 2) {
//                System.out.println(j + " " + currentFiles);
//                filesToCheck.add(currentFiles);
//                currentNum = j;
//            } else currentNum = j + 1;