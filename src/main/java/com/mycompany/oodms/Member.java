/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
public class Member extends User {
        Member(String userId, String userEmail, String password, int age, UserGender gender, String phoneNum, String picturePath) {
        super(userId, userEmail, password, age, gender, phoneNum, picturePath);
    }


    @Override
    void login(String email, String password) {
        //
    }

    @Override
    void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
