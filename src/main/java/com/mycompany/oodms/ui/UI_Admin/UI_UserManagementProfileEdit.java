package com.mycompany.oodms.ui.UI_Admin;


import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.ui.UI_Login;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI_UserManagementProfileEdit extends JPanel {

    JButton back;
    
    JLabel title;
    
    JLabel name_header;
    JLabel gender_header; 
    JLabel age_header;
    JLabel phoneNo_header;
    JLabel email_header; 
    JLabel profilePic_header;
    JLabel profilePic_fileName;
    
    JTextField name;
    JComboBox gender;
    JTextField age;
    JTextField phoneNo;
    JTextField email;
    JButton profilePic_upload;
    
    JButton signup;
    JButton cancel;
    
    public UI_UserManagementProfileEdit(){
        // REQUIRED DATA
        // ID, PICTURE, NAME, GENDER, DOB, EMAIL, PHONE NO
        ArrayList<String> profileDetails = new ArrayList<>();
        profileDetails.add("PROFILE1");
        profileDetails.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
        profileDetails.add("Hong Wei");
        profileDetails.add("Male");
        profileDetails.add("24"); // age
        profileDetails.add("hw@gmail.com");
        profileDetails.add("0192583948");
                        

        // JButton - back (to login page)
        back = new JButton("< back");
        back.setFont(new Font("MV Boli",Font.PLAIN,12));
        back.setForeground(new Color(77, 77, 77, 124));
        back.setBounds(68,70,45,11);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(e -> {
            frame.replacePanel(new UI_UserManagementProfile());
        });
        
        // JLabel - title
        title = new JLabel(profileDetails.get(0));
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setBounds(144,136,250,40);
        
        // JLabel - name header
        name_header = new JLabel("Name :");
        name_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        name_header.setBounds(144,213,50,20);
        
        // JTextField - name
        name = new JTextField();
        name.setBounds(140,233,587,48);
        name.setText(profileDetails.get(2));
        
        // JLabel - gender header
        gender_header = new JLabel("Gender :");
        gender_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        gender_header.setBounds(763,213,100,20);
        
        // JTextField - gender
        String[] genderList = {"Male","Female"};
        gender = new JComboBox(genderList);
        gender.setBounds(759,233,174,48);
        gender.setSelectedItem(profileDetails.get(3));

        
        // JLabel - age header
        age_header = new JLabel("Age :");
        age_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        age_header.setBounds(144,307,50,20);
        
        // JTextField - age
        age = new JTextField();
        age.setBounds(140,327,378,48);
        age.setText(profileDetails.get(4));
        
        // JLabel - phone number header
        phoneNo_header = new JLabel("Phone number :");
        phoneNo_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        phoneNo_header.setBounds(558,307,150,20);
        
        // JTextField - phone number
        phoneNo = new JTextField();
        phoneNo.setBounds(554,327,379,48);
        phoneNo.setText(profileDetails.get(6));

        // JLabel - Email header
        email_header = new JLabel("Email :");
        email_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        email_header.setBounds(144,406,100,20);
        
        // JTextField - Email
        email = new JTextField();
        email.setBounds(140,426,793,48);
        email.setEditable(false);
        email.setText(profileDetails.get(5));
        email.setForeground(Color.LIGHT_GRAY);
                
        // JLabel - Profile picture
        profilePic_header = new JLabel("Profile Picture :");
        profilePic_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        profilePic_header.setBounds(144,505,100,20);
        
        // JButton - Profile Picture
        profilePic_upload = new JButton("Upload Profile Image");
        profilePic_upload.setBounds(140,525,60,25);
        profilePic_upload.addActionListener(e -> {
            
        });

        
        // JLabel - Profile Picture file name
        pwd = new JPasswordField();
        pwd.setBounds(140,525,378,48);

        // JButton - sign up button
        signup = new JButton("update");
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
        
        // JButton - cancel button
        cancel = new JButton("cancel");
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setHorizontalTextPosition(JLabel.CENTER);
        cancel.setVerticalTextPosition(JLabel.CENTER);
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.setBackground(new Color(255, 151, 98, 255));
        cancel.setOpaque(true);
        cancel.setBounds(755,141,84,42);
        cancel.setFont(new Font("MV Boli",Font.PLAIN,12));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(e -> {
            
        });
        
        ////////////////////////////////////////////////////////////////////////
        /////////////////////////////// - this - ///////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        this.setSize(1080, 768);
        this.setBackground(Color.white);
        this.setLayout(null);
        
        this.add(back);
        this.add(title);
        
        this.add(name_header);
        this.add(gender_header);
        this.add(age_header);
        this.add(phoneNo_header);
        this.add(email_header);
        this.add(profilePic_header);
        
        this.add(name);
        this.add(gender);
        this.add(age);
        this.add(phoneNo);
        this.add(email);
        this.add(pwd);
        
        this.add(signup);
        this.add(cancel);
    }
}
