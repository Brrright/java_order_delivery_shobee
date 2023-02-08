/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;


/**
 *
 * @author mingl
 */
public class Order {
    private int orderID;
    private String date_time;
    private String addressID;
    private double totalPrice;
    private double paid;
    private double change;
    private Member customer;
    
    public int getOrderID() {
        return this.orderID;
    }


    
}
