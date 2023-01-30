/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author mingl
 */
public class Cart {
    private String cartID;
    private Product product;
    private int quantity;
    
    Cart(String id){
        this.cartID = id;
    }
    
    Cart(String id, int quantity){
        this.cartID = id;
        this.product = new Product();//?
        this.quantity = quantity;
    }
    
    
    public String getCartID(){
        return this.cartID;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
}
