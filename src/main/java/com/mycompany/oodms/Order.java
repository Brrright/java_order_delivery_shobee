/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author mingl
 */
public class Order {
    private int orderID;
    private LocalDateTime date_time;
    private int addressID;
    private double totalPrice;
    private double paid;
    private double change;
    private Member customer;
    
    private List<OrderItem> orderItems;
    private List<Delivery> deliveries;
    
    static final String ORDER_FILE = "order";
    
    public Order(int orderID, LocalDateTime date_time, int address_ID, double totalPrice, double paid, double change, Member customer){
//        FileHandler fHandler = new FileHandler(PRODUCT_FILE);
//        this.orderID = fHandler.GenerateID();
        this.orderID = orderID;
        this.date_time = date_time;
        this.addressID = address_ID;
        this.totalPrice = totalPrice;
        this.paid  = paid;
        this.change = change;
        this.customer = customer;
    }
    
    public int getOrderID() {
        return this.orderID;
    }
    
    public LocalDateTime getOrderDateTime() {
        return this.date_time;
    }
    
    public int getAddressID(){
        return this.addressID;
    }
    
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    public double getPaid(){
        return this.paid;
    }
    
    public Member getCustomer(){
        return this.customer;
    }

    public void setOrderDateTime(LocalDateTime date_time){
        this.date_time = date_time;
    }
    
    public void setAddressID(int add_id){
        this.addressID = add_id;
    }
    
    public void setTotalPrice(double paid){
        this.paid = paid;
    }
    
    public void setChange(double change) {
        this.change = change;
    }
    
    public void setCustomer(Member cust) {
        this.customer = cust;
    }
}
