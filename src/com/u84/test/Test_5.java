package com.u84.test;

import com.u84.util.FileManager;

import java.io.File;
import java.util.Objects;

public class Test_5 {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Dmitriy\\Desktop\\data");
        int count = 0;
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            int lastSlash = file.getPath().lastIndexOf('\\');
            String extension = FileManager.getExtension(file.getName());
            String pathToFile = file.getPath().substring(0, lastSlash);
            System.out.println(pathToFile+"\\"+count+extension);
            File rename = new File(pathToFile+"\\"+count+extension);
            boolean b = file.renameTo(rename);
            System.out.println(b);
            count++;
        }
    }
}
