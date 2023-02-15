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
public class Cart {
    private String cartID;
    private List<Product> products;
    private int quantity;
    
    Cart(String id, int quantity, Product product){
        this.cartID = id;
        this.quantity = quantity;
        this.products.add(product);
    }
    
    
    public String getCartID(){
        return this.cartID;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public List<Product> getCartProducts(){
        return this.products;
    }
}
