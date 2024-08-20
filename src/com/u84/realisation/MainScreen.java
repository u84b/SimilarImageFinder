package com.u84.realisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainScreen {
    private JFrame window;
    private JButton searchDirectoryButton;
    private JPanel panel;
    private JLabel label;
    private ActionListener listener;
    private String chosenPath;
    private SameImageSearcher searcher;
    private ArrayList<ArrayList<String>> files;

    public MainScreen(SameImageSearcher searcher){
        window = new JFrame();
        label = new JLabel();
        searchDirectoryButton = new JButton("Search directory!");

        panel = new JPanel();
        listener = e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = chooser.showOpenDialog(window);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                chosenPath = file.getAbsolutePath();
                label.setText("Folder selected: " + file.getAbsolutePath());
                try {
                    files = searcher.search(chosenPath);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else{
                label.setText("Folder doesn't selected.");
            }
            chooser.showOpenDialog(null);
        };

        window.setTitle("Similar image finder.");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(900, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLocation(new Point(200, 200));

        searchDirectoryButton.addActionListener(listener);

        panel.add(searchDirectoryButton);
        panel.add(label);

        window.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void show(){
        window.setVisible(true);
    }

    public ArrayList<ArrayList<String>> getFiles() {
        return files;
    }

    //    public String getPath() {
//        return chosenPath;
//    }
}
