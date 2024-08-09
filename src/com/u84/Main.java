package com.u84;


import com.u84.realisation.HashImg;
import com.u84.realisation.ImageCompressor;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Here will be start...
         **/
        Scanner scanner = new Scanner(System.in);
        FileManager manager = new FileManager();
        HashImg hashImg = new HashImg();
        String pathToDirectory = scanner.next();
        ArrayList<File> imageFiles = manager.traverseDirectoryToFindImages(pathToDirectory);
        ArrayList<String> binaryHashes = new ArrayList<>();
        for (File f : imageFiles) {
            BufferedImage currentImage = ImageIO.read(f);
            String currentBinaryHash = hashImg.convertHashToString(hashImg.generateArrayHash(currentImage));
            binaryHashes.add(currentBinaryHash);
        }
        for (String bin : binaryHashes) {
            System.out.println(bin);
        }
    }
}