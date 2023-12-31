package com.u84.realisation;

import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SimilarImagesSearch {
    private String pathToDirectory;
    private HashImg hash;
    private FileManager fileManager;
    private HashMap<String, ArrayList<String>> similarImageMap;

    public SimilarImagesSearch(){
    }


    public SimilarImagesSearch(String path){
        this.pathToDirectory = path;
        this.hash = new HashImg();
        this.fileManager = new FileManager();
    }

    /**
     Here is the realisation of first algorithm to find same images.
     I'll create more efficient one in future.
     **/
    public void findSimilarImages() throws IOException {
        ArrayList<File> files = fileManager.findImage(this.pathToDirectory);
        ArrayList<ArrayList<String>> similarImages = new ArrayList<>();
        int sizeOfList = files.size();

        for (int i = 0; i < sizeOfList; i++) {
            File currentFile = files.get(i);
            ArrayList<String> names = new ArrayList<>();
            BufferedImage currentImage = ImageIO.read(currentFile);
            int[][] currentImageHash = hash.generateArrayHash(currentImage);
            names.add(currentFile.getName());
            int count = 0;
            for (int j = i + 1; j < sizeOfList - 1; j++) {
                File comparedFile = files.get(j);
                BufferedImage comparedImage = ImageIO.read(comparedFile);
                int[][] comparedImageHash = hash.generateArrayHash(comparedImage);
                float cind = hash.compareHashes(currentImageHash, comparedImageHash);
                if (cind > 0.85f){
                    names.add(comparedFile.getName());
                    count++;
                }
            }
            if (count > 0) similarImages.add(names);
        }
        for (ArrayList<String> s : similarImages) {
            System.out.println(s);
        }
    }

    public String getPathToDirectory() {
        return pathToDirectory;
    }
}
