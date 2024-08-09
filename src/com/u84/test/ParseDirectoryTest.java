package com.u84.test;

import com.u84.realisation.HashImg;
import com.u84.realisation.ImageColorEditor;
import com.u84.realisation.ImageCompressor;
import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseDirectoryTest {
    public static void main(String[] args) throws IOException {
        String path = "desktop/";
        FileManager finder = new FileManager();
        HashImg hash = new HashImg();

        //ArrayList<File> files = finder.findImage(path);
        //ImageCompressor compressor = new ImageCompressor();
        //for (File f: files) {
        //    System.out.println(f.toPath());
        //}
        ArrayList<File> imgFiles = finder.traverseDirectoryToFindImages(path);
        for (File f: imgFiles) {
            int[][] currentHash = hash.generateArrayHash(ImageIO.read(new File(f.toPath().toString())));
            System.out.println(f.toPath() + "\n" + hash.convertHashToString(currentHash));
        }
    }
}