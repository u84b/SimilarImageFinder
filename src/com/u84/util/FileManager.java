package com.u84.util;

import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
                boolean b = fileIsImage(file);
                System.out.println(b);
                if (b){
                    filesToCheck.add(file);
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
        return filesToCheck;
    }

    /**
     It is very useful for image searching.
     **/
    public static String getExtension(String path){
        String extension = "";
        String lpath = path.toLowerCase();
        int indexOfPoint = lpath.lastIndexOf(".");
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

    public void createImageFromFile(String pathToFile, String newName) throws IOException {
        File file = new File(pathToFile);
        ImageCompressor compressor = new ImageCompressor();
        ImageColorEditor editor = new ImageColorEditor();
        BufferedImage image = ImageIO.read(file);
        File newFile = new File(newName);
        ImageIO.write(editor.grayScaleConversion(compressor.compressImageTo8X8(image)), "png", newFile);
    }
}
