/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */

public class Delivery {
    private int id;
    private Order order;
    private LocalDateTime date_time;
    private DeliveryStaff deliveryStaff;
    private DeliveryStatus status;

  // constructor, getters, and setters
    public Delivery(int id, Order order, LocalDateTime date_time, DeliveryStaff deliveryStaff, DeliveryStatus status){
        this.id = id;
        this.order = order;
        this.date_time = date_time;
        this.deliveryStaff = deliveryStaff;
        this.status = status;
    }
    
    public int getDeliverID(){
        return this.id;
    }
    
    public Order getOrder(){
        return this.order;
    }
    
    public void setOrder(Order order){
        this.order = order;
    }
    
    public DeliveryStaff getStaff() {
        return this.deliveryStaff;
    }
    
    public void setStaff(DeliveryStaff staff){
       this.deliveryStaff = staff;
    }
    
    public DeliveryStatus getStatus(){
        return this.status;
    }
    
    public void setStatus(DeliveryStatus status){
        this.status = status;
    }
}
