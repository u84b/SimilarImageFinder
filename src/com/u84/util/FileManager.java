package com.u84.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 Work with files. Processing files. Find images.
 **/

public class FileManager {

    public FileManager(){

    }

    public ArrayList<File> findImage(String path) {
        File directory = new File(path);
        ArrayList<File> filesToCheck = new ArrayList<>();
        if (!directory.isDirectory()) {
            System.out.println("INCORRECT INPUT!");
        } else {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                String nameOfFile = file.getName();
                String extension = FileManager.getExtension(nameOfFile);
                if (extension.equals(".png") || extension.equals(".jpg"))
                    filesToCheck.add(file);
            }
        }
        return filesToCheck;
    }

    /**
     It is very useful for image searching.
     **/
    public static String getExtension(String path){
        String extension = "";
        int indexOfPoint = path.lastIndexOf(".");
        if (indexOfPoint >= 1)
            extension = path.substring(indexOfPoint);
        return extension;
    }

    public void traverseDirectory(){

    }
}
