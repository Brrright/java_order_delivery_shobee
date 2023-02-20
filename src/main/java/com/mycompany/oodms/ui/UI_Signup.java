package com.mycompany.oodms.ui;

import static com.mycompany.oodms.OODMS_Main.frame;
import javax.swing.*;
import java.awt.*;

public class UI_Signup extends JPanel{
    
    JButton back;
    
    JLabel title;
    JLabel subTitle;
    
    JLabel name_header;
    JLabel gender_header; 
    JLabel age_header;
    JLabel phoneNo_header;
    JLabel email_header; 
    JLabel pwd_header;
    JLabel confirmPwd_header;
    
    JTextField name;
    JComboBox gender;
    JTextField age;
    JTextField phoneNo;
    JTextField email;
    JPasswordField pwd;
    JPasswordField confirmPwd;
    
    JButton signup;

    public UI_Signup(){
        
        // JButton - back (to login page)
        back = new JButton("< back");
        back.setFont(new Font("MV Boli",Font.PLAIN,12));
        back.setForeground(new Color(77, 77, 77, 124));
        back.setBounds(68,70,45,11);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(e -> {
            frame.replacePanel(new UI_Login());
        });
        
        // JLabel - title
        title = new JLabel("Sign up");
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setBounds(144,116,133,40);
        
        // JLabel - subtitle
        subTitle = new JLabel("as customer");
        subTitle.setFont(new Font("MV Boli",Font.PLAIN,12));
        subTitle.setForeground(new Color(255,153,79));
        subTitle.setBounds(148,165,80,11);
        
        // JLabel - name header
        name_header = new JLabel("Name :");
        name_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        name_header.setBounds(144,213,50,20);
        
        // JTextField - name
        name = new JTextField();
        name.setBounds(140,233,587,48);
        
        // JLabel - gender header
        gender_header = new JLabel("Gender :");
        gender_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        gender_header.setBounds(763,213,100,20);
        
        // JTextField - gender
        String[] genderList = {"Male","Female"};
        gender = new JComboBox(genderList);
        gender.setBounds(759,233,174,48);

        // JLabel - name header
        name_header = new JLabel("Name :");
        name_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        name_header.setBounds(144,213,50,20);
        
        // JTextField - name
        name = new JTextField();
        name.setBounds(140,233,587,48);
        
        // JLabel - age header
        age_header = new JLabel("Age :");
        age_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        age_header.setBounds(144,307,50,20);
        
        // JTextField - age
        age = new JTextField();
        age.setBounds(140,327,378,48);
        
        // JLabel - phone number header
        phoneNo_header = new JLabel("Phone number :");
        phoneNo_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        phoneNo_header.setBounds(558,307,150,20);
        
        // JTextField - phone number
        phoneNo = new JTextField();
        phoneNo.setBounds(554,327,379,48);
        
        // JLabel - Email header
        email_header = new JLabel("Email :");
        email_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        email_header.setBounds(144,406,100,20);
        
        // JTextField - Email
        email = new JTextField();
        email.setBounds(140,426,793,48);
        
        // JLabel - Password header
        pwd_header = new JLabel("Password :");
        pwd_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        pwd_header.setBounds(144,505,100,20);
        
        // JPasswordField - Password
        pwd = new JPasswordField();
        pwd.setBounds(140,525,378,48);
        
        // JLabel - Confirm password header
        confirmPwd_header = new JLabel("Confirm Password :");
        confirmPwd_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        confirmPwd_header.setBounds(558,505,200,20);
        
        // JPasswordField - Confirm password
        confirmPwd = new JPasswordField();
        confirmPwd.setBounds(554,525,378,48);
        
        
        // JButton - sign up button
        signup = new JButton("Sign up");
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setHorizontalTextPosition(JLabel.CENTER);
        signup.setVerticalTextPosition(JLabel.CENTER);
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signup.setBackground(new Color(255, 151, 98, 255));
        signup.setOpaque(true);
        signup.setBounds(850,141,84,42);
        signup.setFont(new Font("MV Boli",Font.PLAIN,12));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(e -> {
            
        });
        
        ////////////////////////////////////////////////////////////////////////
        /////////////////////////////// - this - ///////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        this.setSize(1080, 768);
        this.setBackground(Color.white);
        this.setLayout(null);
        
        this.add(back);
        this.add(title);
        this.add(subTitle);
        
        this.add(name_header);
        this.add(gender_header);
        this.add(age_header);
        this.add(phoneNo_header);
        this.add(email_header);
        this.add(pwd_header);
        this.add(confirmPwd_header);
        
        this.add(name);
        this.add(gender);
        this.add(age);
        this.add(phoneNo);
        this.add(email);
        this.add(pwd);
        this.add(confirmPwd);
        
        this.add(signup);
        
    }
}
