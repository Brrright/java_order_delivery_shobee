package com.company.oodms.ui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    // left component //
    // image for shop btn
    ImageIcon productPage = new ImageIcon("src/com/company/ui/pictures/shopbtn.png");
    JLabel left ;
    JPanel leftContainer;


    // right component //
    JLabel heading;
    JLabel smallHeading;
    JLabel emailLabel;
    JLabel passwordLabel;
    JTextField emailTF;
    JTextField passwordTF;
    JButton signup;
    JButton login;
    JPanel rightContainer = new JPanel();




    public Login() {
        // ------------------------------ LEFT ------------------------------ //
        // JLabel - left
        left = new JLabel(productPage);
        left.setBackground(new Color(255, 165, 127));
        left.setOpaque(true);

        // JPanel - left component
        leftContainer = new JPanel();
        leftContainer.setBounds(0, 0, 863, 1024);
        leftContainer.setLayout(new BorderLayout());
        leftContainer.add(left);

        // ------------------------------ RIGHT ------------------------------ //
        // JLabel - Login header
        heading = new JLabel("Login");
        heading.setFont(new Font("MV Boli",Font.BOLD,45));
        heading.setBounds(942, 290, 136, 61);


        // JLabel - small heading
        smallHeading = new JLabel("Customer");
        smallHeading.setFont(new Font("MV Boli",Font.PLAIN,17));
        smallHeading.setForeground(new Color(255, 151, 98, 124));
        smallHeading.setBounds(947, 357, 105, 22);

        // JLabel - email
        emailLabel = new JLabel("Email :");
        emailLabel.setFont(new Font("MV Boli",Font.PLAIN,17));
        emailLabel.setBounds(947, 424, 56, 22);

        // JLabel - password
        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font("MV Boli",Font.PLAIN,17));
        passwordLabel.setBounds(947, 540, 94, 22);

        // JTextField - email
        emailTF = new JTextField();
        emailTF.setBounds(945,455,418,60);

        // JTextField - password
        passwordTF = new JTextField();
        passwordTF.setBounds(945,571,418,60);

        // JButton - sign up
        signup = new JButton("sign up");
        signup.setBounds(1118,665,112,49);
        signup.setFocusable(false);

        // JButton - Login
        login = new JButton("login");
        login.setBounds(1248,665,112,49);
        login.setFocusable(false);

        // JPanel - right component
        rightContainer = new JPanel();
        rightContainer.setBounds(863, 0, 577, 1024);
        rightContainer.setLayout(null);



        // ------------------------------ frame ------------------------------ //
        this.setSize(1440,1024);
        this.setTitle("Shobee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        // left component
        this.add(leftContainer);

        // right component
        this.add(heading);
        this.add(smallHeading);
        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(emailTF);
        this.add(passwordTF);
        this.add(signup);
        this.add(login);

        this.setVisible(true);
    }

}
