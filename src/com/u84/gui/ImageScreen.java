package com.u84.gui;


import com.u84.util.FileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ImageScreen {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Image");
        JLabel label = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        label.setVisible(true);

        BufferedImage image = ImageIO.read(new File("Livesey.png"));

        frame.setSize(image.getWidth(), image.getHeight());

        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        frame.getContentPane().add(label);
        frame.pack();

    }
}


//    FileManager manager = new FileManager();
//    File dir = new File("C:\\Users\\Dmitriy\\IdeaProjects\\SimilarImageFinder");
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        for (File file : Objects.requireNonNull(dir.listFiles())) {
//                if (manager.fileIsImage(file)) {
//                  System.out.println(file.getAbsolutePath());
//                  System.out.println("Delete or Not? Answer D/N");
//                  String ans = reader.readLine();
//                  if (ans.equals("D")) {
//                      System.out.println(file.delete());
//                  }
//             }
//        }