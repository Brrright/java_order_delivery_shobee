/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.ui.UI_Admin.UI_AdminMain;
import com.mycompany.oodms.ui.UI_AllProducts;
import com.mycompany.oodms.ui.UI_Delivery.UI_UpComing;
import com.mycompany.oodms.ui.UI_Login;
import javax.swing.JOptionPane;

/**
 *
 * @author mingl
 */


enum UserIdPrefix{
    ADM,
    MEM,
    DEL,
}

abstract class User {
    protected int userId;
    protected String userName;
    protected String userEmail;
    protected String password;
    protected int age;
    protected Gender gender;
    protected String phoneNum;
    protected String picturePath;
    
    User(int userId, String userName, String userEmail, String password, int age, Gender gender, String phoneNum, String picturePath){
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.picturePath = picturePath;
    }
    
    User(int userId){
        this.userId = userId;
    }
    
    abstract void setID(int id);
    
    abstract void setEmail(String email);
    
    abstract void setName(String name);
    
    abstract void setPassword(String password);
    
    abstract void setAge(int age);
    
    abstract void setGender(Gender gender);
    
    abstract void setPhoneNum(String phononeNum);
    
    abstract void setPicturePath(String picturecturePath);
    
    abstract int getID();
    
    abstract String getName();
    
    abstract String getEmail();
    
    abstract String getPassword();
    
    abstract int getAge();
    
    abstract Gender getGender();
    
    abstract String getPhoneNum();
    
    abstract String getPicturePath();
        
    public static void login(String email, String password, String fileName){
        FileHandler fHandler = new FileHandler(fileName);
        FileRecord user_record = fHandler.FetchRecord(email, 2);
        int user_id = user_record.getID();
        String[] splitted_user_record = user_record.getRecordList();
        
        if(fileName == null ? FileName.ADMIN == null : fileName.equals(FileName.ADMIN)){
            OODMS_Main.current_user = new Admin(user_id);
        }
        
        if(fileName == null ? FileName.DELIVERY_STAFF == null : fileName.equals(FileName.DELIVERY_STAFF)){
            OODMS_Main.current_user = new DeliveryStaff(user_id);
        }
        
        if(fileName == null ? FileName.MEMBER == null : fileName.equals(FileName.MEMBER)){
            OODMS_Main.current_user = new Member(user_id);
        }
        
        OODMS_Main.current_user.setAge(Integer.parseInt(splitted_user_record[4]));
        OODMS_Main.current_user.setEmail(splitted_user_record[2]);
        OODMS_Main.current_user.setGender(Gender.valueOf(splitted_user_record[5]));
        OODMS_Main.current_user.setPassword(splitted_user_record[3]);
        OODMS_Main.current_user.setPhoneNum(splitted_user_record[6]);
        OODMS_Main.current_user.setPicturePath(splitted_user_record[7]);
        
        
        switch(fileName) {
            case FileName.ADMIN -> {
                frame.replacePanel(new UI_AdminMain());
            }
            case FileName.MEMBER -> {
                frame.replacePanel(new UI_AllProducts());
            }
            case FileName.DELIVERY_STAFF -> {                
                frame.replacePanel(new UI_UpComing());
            }
        }
        
        System.out.println("User login successfully");

        JOptionPane.showMessageDialog(frame,"Welcome to Shobee!","Successfully Login",JOptionPane.INFORMATION_MESSAGE);
        // need to setup user related data

    }
    
    public static void logout(){
        OODMS_Main.current_user = null;
        // think what should do when logging out.
        OODMS_Main.frame.currentPanel = new UI_Login();
    }
    
    
    
}