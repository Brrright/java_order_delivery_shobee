/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
enum UserGender{
    MALE,
    FEMALE
}

abstract class User {
    protected String userId;
    protected String userEmail;
    protected String password;
    protected int age;
    protected UserGender gender;
    protected String phoneNum;
    protected String picturePath;
    
    User(String userId, String userEmail, String password, int age, UserGender gender, String phoneNum, String picturePath){
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.picturePath = picturePath;
    }
        
    abstract void updateProfile();
}