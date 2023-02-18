/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;

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
    
    private void setID(int id){
        this.userId = id;
    }
    
    private void setEmail(String email){
        this.userEmail = email;
    }
    
    private void setPassword(String pw){
        this.password = pw;
    }
    
    private void setAge(int age) {
        this.age = age;
    }
    
    private void setGender(Gender gender) {
        this.gender = gender;
    }
    
    private void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    private void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    
    private int getID()
    {
        return this.userId;
    }
    
    
    private String getEmail()
    {
        return this.userEmail;
    }
    
    private String getPassword()
    {
        return this.password;
    }
    
    private int getAge(){
        return this.age;
    }
    
    private Gender getGender(){
        return this.gender;
    }
    
    private String getPhoneNum(){
        return this.password;
    }
    
    private String getPicturePath(){
        return this.picturePath;
    }
        
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
    }
    
    abstract void logout();
}