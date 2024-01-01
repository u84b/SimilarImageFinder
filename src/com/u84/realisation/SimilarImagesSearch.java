package com.u84.realisation;

import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class SimilarImagesSearch {
    private String pathToDirectory;
    private HashImg hash;
    private FileManager fileManager;
    private ImageCompressor compressor;
    private ImageColorEditor editor;
    private ArrayList<BufferedImage> images;

    public SimilarImagesSearch(){
    }


    public SimilarImagesSearch(String path){
        this.pathToDirectory = path;
        this.hash = new HashImg();
        this.fileManager = new FileManager();
        this.compressor = new ImageCompressor();
        this.editor = new ImageColorEditor();
    }

    public SimilarImagesSearch(ArrayList<BufferedImage> images){
        this.images = images;
        this.hash = new HashImg();
        this.fileManager = new FileManager();
        this.compressor = new ImageCompressor();
        this.editor = new ImageColorEditor();
    }

    /**
     Here is the realisation of first algorithm to find same images.
     I'll create more efficient one in future.
     **/
    public ArrayList<ArrayList<String>> findSimilarImages() throws IOException {
        ArrayList<File> files = fileManager.findImage(this.pathToDirectory);
        ArrayList<ArrayList<String>> similarImages = new ArrayList<>();
        int sizeOfList = files.size();
        int[] isChecked = new int[sizeOfList];

        for (int i = 0; i < sizeOfList; i++) {
            if (isChecked[i] == 0){
                File currentFile = files.get(i);
                ArrayList<String> names = new ArrayList<>();
                BufferedImage currentImage = editor.grayScaleConversion(compressor.compressImageTo8X8(ImageIO.read(currentFile)));
                int[][] currentImageHash = hash.generateArrayHash(currentImage);
                names.add(currentFile.getAbsolutePath());
                int count = 0;
                for (int j = i + 1; j < sizeOfList - 1; j++) {
                    File comparedFile = files.get(j);
                    BufferedImage comparedImage = editor.grayScaleConversion(compressor.compressImageTo8X8(ImageIO.read(comparedFile)));
                    int[][] comparedImageHash = hash.generateArrayHash(comparedImage);
                    float cind = hash.compareHashes(currentImageHash, comparedImageHash);

                    if (cind > 0.845f && isChecked[j] == 0){
                        names.add(comparedFile.getAbsolutePath());
                        isChecked[j] = 1;
                        count++;
                    }
                }
                if (count > 0) similarImages.add(names);
            }
        }
        return similarImages;
    }

    public String getPathToDirectory() {
        return pathToDirectory;
    }
}
