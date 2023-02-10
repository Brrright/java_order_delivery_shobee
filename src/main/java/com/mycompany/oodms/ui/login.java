package com.mycompany.oodms.ui;

import com.mycompany.oodms.OODMS_Main;
import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    // left component //
    // image for shop btn
    ImageIcon productPage = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/shopbtn.png");
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
        leftContainer.setBounds(0, 0, 367, 768);
        leftContainer.setLayout(new BorderLayout());
        leftContainer.add(left);

        // ------------------------------ RIGHT ------------------------------ //
        // JLabel - Login header
        heading = new JLabel("Login");
        heading.setFont(new Font("MV Boli",Font.BOLD,45));
        heading.setBounds(478, 155, 136, 61);

        // JLabel - small heading
        smallHeading = new JLabel("Customer");
        smallHeading.setFont(new Font("MV Boli",Font.PLAIN,17));
        smallHeading.setForeground(new Color(255, 151, 98, 124));
        smallHeading.setBounds(478, 222, 105, 22);

        // JLabel - email
        emailLabel = new JLabel("Email :");
        emailLabel.setFont(new Font("MV Boli",Font.PLAIN,17));
        emailLabel.setBounds(478, 287, 56, 22);

        // JLabel - password
        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font("MV Boli",Font.PLAIN,17));
        passwordLabel.setBounds(478, 404, 94, 22);

        // JTextField - email
        emailTF = new JTextField();
        emailTF.setBounds(478, 318, 488, 60);

        // JTextField - password
        passwordTF = new JTextField();
        passwordTF.setBounds(478, 435, 488, 60);

        // JButton - sign up
        signup = new JButton("sign up");
        signup.setBounds(722,550,112,49);
        signup.setFocusable(false);

        // JButton - Login
        login = new JButton("login");
        login.setBounds(853,550,112,49);
        login.setFocusable(false);

        // JPanel - right component
        rightContainer = new JPanel();
        rightContainer.setBounds(863, 0, 711, 766);
        rightContainer.setLayout(null);



        // ------------------------------ this.JPanel ------------------------------ //
        this.setSize(1080,768);
        this.setLayout(null);
        this.setBackground(Color.white);

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
    }
//    example of usage
//    public void LoginToCustomer(){
//        OODMS_Main.frame.replacePanel(new JPanel());
//    }
}
