package com.u84.realisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainScreen {
    private JFrame window;
    private JButton searchDirectoryButton;
    private JPanel panel;
    private JLabel label;
    private ActionListener listener;
    private String chosenPath;

    public MainScreen(){
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

    public String getPath() {
        return chosenPath;
    }
}
