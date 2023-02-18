/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import java.util.List;

/**
 *
 * @author mingl
 */
public class Member extends User {
    private List<Order> orders;
    private List<Cart> carts;
    
    public Member(int userId, String userName, String userEmail, String password, int age, Gender gender, String phoneNum, String picturePath) {
        super(userId, userName, userEmail, password, age, gender, phoneNum, picturePath);
//        this.cart = new Cart();
    }
    
    public Member(int userId){
        super(userId);
    }

    @Override
    void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
