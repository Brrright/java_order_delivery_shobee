/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
public class Admin extends User{

    public Admin(String userId, String userEmail, String password, int age, UserGender gender, String phoneNum, String picturePath) {
        super(userId, userEmail, password, age, gender, phoneNum, picturePath);
    }

    @Override
    void updateProfile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
