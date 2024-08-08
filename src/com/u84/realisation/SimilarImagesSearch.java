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
    private HashMap<String, Long> hashOfImages; /**  String - path to files; Long - hash of image  **/

    public SimilarImagesSearch(){
    }


    public SimilarImagesSearch(String path){
        this.pathToDirectory = path;
        this.hash = new HashImg();
        this.fileManager = new FileManager();

        this.compressor = new ImageCompressor();
        this.editor = new ImageColorEditor();

        this.hashOfImages = new HashMap<>();
    }

    public boolean loadRequiredData(){

        return true;
    }

    /**
     Here is the realisation of first algorithm to find same images.
     I'll create more efficient one in future.
     **/
    // return hashmap
    public void findSimilarImages() throws IOException {
        System.out.println(this.loadRequiredData());
    }




    public String getPathToDirectory() {
        return pathToDirectory;
    }
}
