package com.company;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mw.setSize(700, 700);
        mw.setLocationRelativeTo(null);
        mw.setVisible(true);
    }
}