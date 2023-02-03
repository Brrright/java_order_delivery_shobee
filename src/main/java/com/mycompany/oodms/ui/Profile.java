package com.company.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Profile extends JFrame {
    JButton backBtn;

    JLabel profilePic;
    JLabel name;
    JLabel idHeader;
    JLabel id;
    JLabel genderHeader;
    JLabel gender;
    JLabel dobHeader;
    JLabel dob;
    JLabel emailHeader;
    JLabel email;
    JLabel phoneNoHeader;
    JLabel phoneNo;

    JButton myOrder;
    JButton addressBook;
    JButton editProfile;
    JButton changePwd;

    ImageIcon orangeCircle = new ImageIcon("src/com/company/ui/pictures/orangecircle.png");

    public Profile(){
        // REQUIRED DATA
        // ID, PICTURE, NAME, GENDER, DOB, EMAIL, PHONE NO

        ArrayList<String> profileDetails = new ArrayList<>();
        profileDetails.add("PROFILE1");
        profileDetails.add("src/com/company/ui/pictures/hudao.jpg");
        profileDetails.add("Hong Wei");
        profileDetails.add("Male");
        profileDetails.add("2/2/2002"); // stock
        profileDetails.add("hw@gmail.com");
        profileDetails.add("0192583948"); //sold

        // JLabel - back
        backBtn = new JButton("< back");
        backBtn.setFont(new Font("MV Boli",Font.PLAIN,18));
        backBtn.setForeground(new Color(77, 77, 77, 124));
        backBtn.setBounds(76,76,68,25);
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //image
        ImageIcon itemPic = new ImageIcon(profileDetails.get(1));
        Image image = itemPic.getImage();
        Image newImage = image.getScaledInstance(508, 585, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);

        // JLabel - picture
        profilePic = new JLabel(newIcon);
        profilePic.setBounds(186,177,456,525);

        // JLabel - name
        name = new JLabel(profileDetails.get(2));
        name.setFont(new Font("MV Boli",Font.BOLD,45));
        name.setBounds(702,177,554,54);

        // JLabel - ID header
        idHeader = new JLabel("Id :");
        idHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        idHeader.setForeground(new Color(152, 152, 152, 255));
        idHeader.setBounds(702,250,100,35);

        // JLabel - ID
        id = new JLabel(profileDetails.get(0));
        id.setFont(new Font("MV Boli",Font.PLAIN,22));
        id.setForeground(new Color(0, 0, 0, 255));
        id.setBounds(702,284,554,46);

        // JLabel - gender header
        genderHeader = new JLabel("Gender :");
        genderHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        genderHeader.setForeground(new Color(152, 152, 152, 255));
        genderHeader.setBounds(702,341,100,35);

        // Jlabel - gender
        gender = new JLabel(profileDetails.get(3));
        gender.setFont(new Font("MV Boli",Font.PLAIN,22));
        gender.setForeground(new Color(0, 0, 0, 255));
        gender.setBounds(702,375,554,46);

        // JLabel - dob header
        dobHeader = new JLabel("Date of Birth :");
        dobHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        dobHeader.setForeground(new Color(152, 152, 152, 255));
        dobHeader.setBounds(702,432,200,35);

        // Jlabel - dob
        dob = new JLabel(profileDetails.get(4));
        dob.setFont(new Font("MV Boli",Font.PLAIN,22));
        dob.setForeground(new Color(0, 0, 0, 255));
        dob.setBounds(702,466,554,46);

        // JLabel - email header
        emailHeader = new JLabel("Email :");
        emailHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        emailHeader.setForeground(new Color(152, 152, 152, 255));
        emailHeader.setBounds(702,532,100,35);

        // JLabel - email
        email = new JLabel(profileDetails.get(5));
        email.setFont(new Font("MV Boli",Font.PLAIN,22));
        email.setForeground(new Color(0, 0, 0));
        email.setBounds(702,557,554,46);

        // JLabel - phone no header
        phoneNoHeader = new JLabel("Phone Number :");
        phoneNoHeader.setFont(new Font("MV Boli",Font.PLAIN,15));
        phoneNoHeader.setForeground(new Color(152, 152, 152, 255));
        phoneNoHeader.setBounds(702,614,200,35);

        // JLabel - phoneNo
        phoneNo = new JLabel(profileDetails.get(6));
        phoneNo.setFont(new Font("MV Boli",Font.PLAIN,22));
        phoneNo.setForeground(new Color(0, 0, 0));
        phoneNo.setBounds(702,648,554,46);

        // JButton - myOrder
        myOrder = new JButton("<html><body>My<br>order</html>");
        myOrder.setFont(new Font("MV Boli",Font.PLAIN,18));
        myOrder.setForeground(new Color(255, 255, 255));
        myOrder.setIcon(orangeCircle);
        myOrder.setHorizontalTextPosition(JLabel.CENTER);
        myOrder.setVerticalAlignment(JLabel.CENTER);
        myOrder.setHorizontalAlignment(JLabel.CENTER);
        myOrder.setBounds(247,750,170,170);
        myOrder.setBorder(BorderFactory.createEmptyBorder());
        myOrder.setFocusable(false);
        myOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // JButton - addressBook
        addressBook = new JButton("<html><body>Address<br>book</html>");
        addressBook.setFont(new Font("MV Boli",Font.PLAIN,18));
        addressBook.setForeground(new Color(255, 255, 255));
        addressBook.setIcon(orangeCircle);
        addressBook.setHorizontalTextPosition(JLabel.CENTER);
        addressBook.setVerticalAlignment(JLabel.CENTER);
        addressBook.setHorizontalAlignment(JLabel.CENTER);
        addressBook.setBounds(515,750,170,170);
        addressBook.setBorder(BorderFactory.createEmptyBorder());
        addressBook.setFocusable(false);
        addressBook.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // JButton - editProfile
        editProfile = new JButton("<html><body>Edit<br>profile</html>");
        editProfile.setFont(new Font("MV Boli",Font.PLAIN,18));
        editProfile.setForeground(new Color(255, 255, 255));
        editProfile.setIcon(orangeCircle);
        editProfile.setHorizontalTextPosition(JLabel.CENTER);
        editProfile.setVerticalAlignment(JLabel.CENTER);
        editProfile.setHorizontalAlignment(JLabel.CENTER);
        editProfile.setBounds(767,750,170,170);
        editProfile.setBorder(BorderFactory.createEmptyBorder());
        editProfile.setFocusable(false);
        editProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // JButton - changePwd
        changePwd = new JButton("<html><body>Change<br>password</html>");
        changePwd.setFont(new Font("MV Boli",Font.PLAIN,18));
        changePwd.setForeground(new Color(255, 255, 255));
        changePwd.setIcon(orangeCircle);
        changePwd.setHorizontalTextPosition(JLabel.CENTER);
        changePwd.setVerticalAlignment(JLabel.CENTER);
        changePwd.setHorizontalAlignment(JLabel.CENTER);
        changePwd.setBounds(1027,750,170,170);
        changePwd.setBorder(BorderFactory.createEmptyBorder());
        changePwd.setFocusable(false);
        changePwd.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // ------------------------------ this JFrame ------------------------------ //
        this.setSize(1440, 1024);
        this.setTitle("Shobee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(null);

        this.add(backBtn);
        this.add(profilePic);
        this.add(name);
        this.add(idHeader);
        this.add(id);
        this.add(genderHeader);
        this.add(gender);
        this.add(dobHeader);
        this.add(dob);
        this.add(emailHeader);
        this.add(email);
        this.add(phoneNoHeader);
        this.add(phoneNo);

        this.add(myOrder);
        this.add(addressBook);
        this.add(editProfile);
        this.add(changePwd);

        this.setVisible(true);
    }
}
