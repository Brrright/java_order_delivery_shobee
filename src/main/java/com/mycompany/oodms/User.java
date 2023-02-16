/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
enum Gender{
    MALE,
    FEMALE
}

enum UserIdPrefix{
    ADM,
    MEM,
    DEL,
}

abstract class User {
    protected int userId;
    protected String userEmail;
    protected String password;
    protected int age;
    protected Gender gender;
    protected String phoneNum;
    protected String picturePath;
    
    User(int userId, String userEmail, String password, int age, Gender gender, String phoneNum, String picturePath){
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.picturePath = picturePath;
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
        
    abstract void login(String email, String password);
    
    abstract void logout();
}