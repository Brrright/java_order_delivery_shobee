package com.mycompany.oodms.ui;


import com.mycompany.oodms.Admin;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.OODMS_Main;
import com.mycompany.oodms.Services.Provider.Provider_Admin;
import com.mycompany.oodms.Services.Provider.Provider_DeliveryStaff;
import com.mycompany.oodms.Services.Provider.Provider_Member;
import com.mycompany.oodms.Services.User.AdminService;
import com.mycompany.oodms.Services.User.DeliveryStaffService;
import com.mycompany.oodms.Services.User.MemberService;
import com.mycompany.oodms.User;
import com.mycompany.oodms.UserRole;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI_Profile extends JPanel {
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
    JButton editProfile;
    JButton changePwd;
    
    
    ImageIcon orangeRect = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/orangeRectanger.png");

    public UI_Profile(){
         User user = OODMS_Main.current_user;
        switch(user.getRole()){
            case ADMIN -> {
                Admin admin = (Admin) OODMS_Main.current_user;
                Provider_Admin provider_admin = new Provider_Admin();
                user  = AdminService.getAdminService().getAdmin(admin.getID());
            }
            case MEMBER -> {
                Member member = (Member) OODMS_Main.current_user;
                Provider_Member provider_admin = new Provider_Member();
                user = MemberService.getMemberService().getMember(member.getID()); 
            }
            case DELIVERY_STAFF -> {
                DeliveryStaff staff = (DeliveryStaff) OODMS_Main.current_user;
                Provider_DeliveryStaff provider_staff = new Provider_DeliveryStaff();
                user = DeliveryStaffService.getDeliveryStaffService().getStaff(staff.getID());
            }
            default -> {
                System.out.println("no user role selected");
                return;
            }
        }

//        ArrayList<String> profileDetails = new ArrayList<>();
//        profileDetails.add("PROFILE1");
//        profileDetails.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
//        profileDetails.add("Hong Wei");
//        profileDetails.add("Male");
//        profileDetails.add("2/2/2002"); // stock
//        profileDetails.add("hw@gmail.com");
//        profileDetails.add("0192583948"); //sold

        // JLabel - back
        backBtn = new JButton("< back");
        backBtn.setFont(new Font("MV Boli",Font.PLAIN,12));
        backBtn.setForeground(new Color(77, 77, 77, 124));
        backBtn.setBounds(73,82,45,11);
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //image
        ImageIcon itemPic = new ImageIcon(user.getPicturePath());
        Image image = itemPic.getImage();
        Image newImage = image.getScaledInstance(370, 426, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);

        // JLabel - picture
        profilePic = new JLabel(newIcon);
        profilePic.setBounds(145,182,370,426);

        // JLabel - name
        name = new JLabel(user.getName());
        name.setFont(new Font("MV Boli",Font.BOLD,30));
        name.setBounds(577,189,342,35);

        // JLabel - ID header
        idHeader = new JLabel("ID :");
        idHeader.setFont(new Font("MV Boli",Font.PLAIN,12));
        idHeader.setForeground(new Color(152, 152, 152, 255));
        idHeader.setBounds(577,239,49,26);

        // JLabel - ID
        id = new JLabel(Integer.toString(user.getID()));
        id.setFont(new Font("MV Boli",Font.PLAIN,16));
        id.setForeground(new Color(0, 0, 0, 255));
        id.setBounds(577,265,90,31);

        // JLabel - gender header
        genderHeader = new JLabel("Gender :");
        genderHeader.setFont(new Font("MV Boli",Font.PLAIN,12));
        genderHeader.setForeground(new Color(152, 152, 152, 255));
        genderHeader.setBounds(708,239,70,26);

        // Jlabel - gender
        gender = new JLabel(String.valueOf(user.getGender()));
        gender.setFont(new Font("MV Boli",Font.PLAIN,16));
        gender.setForeground(new Color(0, 0, 0, 255));
        gender.setBounds(708,265,90,31);

        /////////
        
        // JLabel - dob header
        dobHeader = new JLabel("Age :");
        dobHeader.setFont(new Font("MV Boli",Font.PLAIN,12));
        dobHeader.setForeground(new Color(152, 152, 152, 255));
        dobHeader.setBounds(577,312,90,26);

        // Jlabel - dob
        dob = new JLabel(Integer.toString(user.getAge()));
        dob.setFont(new Font("MV Boli",Font.PLAIN,16));
        dob.setForeground(new Color(0, 0, 0, 255));
        dob.setBounds(577,338,180,31);

        // JLabel - email header
        emailHeader = new JLabel("Email :");
        emailHeader.setFont(new Font("MV Boli",Font.PLAIN,12));
        emailHeader.setForeground(new Color(152, 152, 152, 255));
        emailHeader.setBounds(577,385,50,26);

        // JLabel - email
        email = new JLabel(user.getEmail());
        email.setFont(new Font("MV Boli",Font.PLAIN,16));
        email.setForeground(new Color(0, 0, 0));
        email.setBounds(577,411,340,31);

        // JLabel - phone no header
        phoneNoHeader = new JLabel("Phone Number :");
        phoneNoHeader.setFont(new Font("MV Boli",Font.PLAIN,12));
        phoneNoHeader.setForeground(new Color(152, 152, 152, 255));
        phoneNoHeader.setBounds(577,458,200,26);

        // JLabel - phoneNo
        phoneNo = new JLabel(user.getPhoneNum());
        phoneNo.setFont(new Font("MV Boli",Font.PLAIN,16));
        phoneNo.setForeground(new Color(0, 0, 0));
        phoneNo.setBounds(577,484,200,31);
        
        
        ///////////////////////////////////////////////////////////////////////////
        ///////////////////////////////// BUTTONS /////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        // JButton - myOrder
        myOrder = new JButton("<html><body>My<br>order</html>");
        myOrder.setFont(new Font("MV Boli",Font.PLAIN,12));
        myOrder.setForeground(new Color(255, 255, 255));
        myOrder.setIcon(orangeRect);
        myOrder.setHorizontalTextPosition(JLabel.CENTER);
        myOrder.setVerticalAlignment(JLabel.CENTER);
        myOrder.setHorizontalAlignment(JLabel.CENTER);
        myOrder.setBounds(577,555,112,53);
        myOrder.setBorder(BorderFactory.createEmptyBorder());
        myOrder.setFocusable(false);
        myOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // JButton - editProfile
        editProfile = new JButton("<html><body>Edit<br>profile</html>");
        editProfile.setFont(new Font("MV Boli",Font.PLAIN,12));
        editProfile.setForeground(new Color(255, 255, 255));
        editProfile.setIcon(orangeRect);
        editProfile.setHorizontalTextPosition(JLabel.CENTER);
        editProfile.setVerticalAlignment(JLabel.CENTER);
        editProfile.setHorizontalAlignment(JLabel.CENTER);
        editProfile.setBounds(692,555,112,53);
        editProfile.setBorder(BorderFactory.createEmptyBorder());
        editProfile.setFocusable(false);
        editProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // JButton - changePwd
        changePwd = new JButton("<html><body>Change<br>password</html>");
        changePwd.setFont(new Font("MV Boli",Font.PLAIN,12));
        changePwd.setForeground(new Color(255, 255, 255));
        changePwd.setIcon(orangeRect);
        changePwd.setHorizontalTextPosition(JLabel.CENTER);
        changePwd.setVerticalAlignment(JLabel.CENTER);
        changePwd.setHorizontalAlignment(JLabel.CENTER);
        changePwd.setBounds(807,555,112,53);
        changePwd.setBorder(BorderFactory.createEmptyBorder());
        changePwd.setFocusable(false);
        changePwd.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // ------------------------------ this JFrame ------------------------------ //
        this.setSize(1080, 1024);
        this.setBackground(Color.white);
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
        this.add(editProfile);
        this.add(changePwd);

    }
}
