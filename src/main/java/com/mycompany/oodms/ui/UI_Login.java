package com.mycompany.oodms.ui;

import com.mycompany.oodms.Admin;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.OODMS_Main;
import com.mycompany.oodms.UserRole;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.Member;
import static com.mycompany.oodms.OODMS_Main.frame;
import javax.swing.*;
import java.awt.*;

public class UI_Login extends JPanel {

    // left component //
    // image for shop btn
    ImageIcon productPage = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/shopbtn.png");
    JLabel left;
    JPanel leftContainer;

    // right component //
    JLabel heading;
    JLabel emailLabel;
    JLabel passwordLabel;
    JTextField emailTF;
    JTextField passwordTF;
    JButton signup;
    JButton login;
    JPanel rightContainer = new JPanel();
    
    // login credential purpose
    UserRole[] user_roles = {UserRole.MEMBER, UserRole.DELIVERY_STAFF, UserRole.ADMIN};
    String fileName;


    public UI_Login() {
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
        JComboBox userRoleComboBox = new JComboBox(user_roles);
        userRoleComboBox.setFont(new Font("MV Boli",Font.PLAIN,17));
        userRoleComboBox.setForeground(new Color(255, 151, 98, 124));
        userRoleComboBox.setBounds(478, 222, 105, 22);

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
        signup.addActionListener(e -> {
            frame.replacePanel(new UI_Signup());
        });

        // JButton - Login
        
        login = new JButton("login");
        login.setBounds(853,550,112,49);
        login.setFocusable(false);
        
        login.addActionListener(e -> {
            // validation needed.
            // is email or null
            
            Object user_role = userRoleComboBox.getSelectedItem();
            String user_email = emailTF.getText();
            String user_password = passwordTF.getText();
            
            if(user_role == UserRole.ADMIN){
                fileName = FileName.ADMIN;
                Admin.login(user_email, user_password, fileName);
            }
            else if(user_role == UserRole.DELIVERY_STAFF){
                fileName = FileName.DELIVERY_STAFF;
                DeliveryStaff.login(user_email, user_password, fileName);
            }
            else if(user_role == UserRole.MEMBER){
                fileName = FileName.MEMBER;
                Member.login(user_email, user_password, fileName);
            } else{
                JOptionPane.showMessageDialog(OODMS_Main.frame,"No user role selected.","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        
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
        this.add(userRoleComboBox);
        this.add(emailLabel);
        this.add(passwordLabel);
        this.add(emailTF);
        this.add(passwordTF);
        this.add(signup);
        this.add(login);
    }
}
