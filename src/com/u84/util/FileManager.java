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
            System.out.println("Incorrect input.");
        } else {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                //String extension = FileManager.getExtension(nameOfFile);
                if (fileIsImage(file))
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

    public void traverseDirectory(String path){
        File directory = new File(path);
        if (directory.isDirectory()){
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isDirectory()){
                    traverseDirectory(file.getPath());
                    System.out.println(file.getPath());
                }else{
                    if (fileIsImage((file)))
                        System.out.println(file.getAbsolutePath());
                }
                break;
            }
        }else{
            System.out.println("ERROR");
        }
    }

    private boolean fileIsImage(File file){
        String path = file.getName();
        String extension = getExtension(path);
        return extension.equals(".gif") || extension.equals(".jpg") || extension.equals(".png") || extension.equals(".jpeg");
    }
}
