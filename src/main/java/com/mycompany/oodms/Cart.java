/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import java.util.ArrayList;

/**
 *
 * @author mingl
 */
public class Cart {
    private String cartID;
    private ArrayList<Product> products;
    
    Cart(String id, Product product){
        this.cartID = id;
        this.products.add(product);
    }
    
    
    public String getCartID(){
        return this.cartID;
    }
    
    public ArrayList<Product> getCartProducts(){
        return this.products;
    }
}
