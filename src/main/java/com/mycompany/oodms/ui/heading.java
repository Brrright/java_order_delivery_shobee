package com.company.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class heading extends JPanel{
    JLabel logo;
    JButton allProduct;
    JButton login;
    JButton signup;


    public heading() {
        // JLabel - logo
        logo = new JLabel("ShoBee");
        logo.setFont(new Font("MV Boli",Font.BOLD,25));
        logo.setForeground(new Color(255, 151, 98, 255));

        // all product button
        allProduct = new JButton();
        allProduct.setText("All Products");
        allProduct.setBorder(BorderFactory.createEmptyBorder());
        allProduct.setFocusable(false);
        allProduct.setForeground(new Color(0, 0, 0));
        allProduct.setFont(new Font("Sarif",Font.BOLD,15));
        allProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        allProduct.addActionListener(e -> {

        });


        // login button
        login = new JButton();
        login.setText("Login");
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setFocusable(false);
        login.setForeground(new Color(0, 0, 0));
        login.setFont(new Font("Sarif",Font.BOLD,15));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.addActionListener(e -> {

        });


        // sign up button
        signup = new JButton();
        signup.setText("Sign up");
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setFocusable(false);
        signup.setForeground(new Color(0, 0, 0));
        signup.setFont(new Font("Sarif",Font.BOLD,15));
        signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signup.addActionListener(e -> {

        });


        // JPanel - this
        this.setLayout(new FlowLayout(FlowLayout.LEADING,50,20));
        this.add(logo);
        this.add(allProduct);
        this.add(login);
        this.add(signup);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
    }
}
