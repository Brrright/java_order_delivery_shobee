/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
public class DeliveryStaff  extends User{

    public DeliveryStaff(int userId, String userName, String userEmail, String password, int age, Gender gender, String phoneNum, String picturePath) {
        super(userId, userName, userEmail, password, age, gender, phoneNum, picturePath);
    }

    DeliveryStaff(int user_id) {
        super(user_id);
    }

    @Override
    void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
