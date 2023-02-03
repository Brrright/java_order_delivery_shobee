package com.company.ui;

import javax.swing.*;
import java.awt.*;

public class Signup extends JFrame{
    heading heading = new heading();

    public Signup(){


        // ------------------------------ this JFrame ------------------------------ //
        this.setSize(1440, 1024);
        this.setTitle("Shobee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(new BorderLayout());
        this.add(heading, BorderLayout.NORTH);

        this.setVisible(true);
    }
}
