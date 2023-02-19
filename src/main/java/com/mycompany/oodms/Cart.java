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
    
    Cart(String id, Product product){
        this.cartID = id;
        this.products.add(product);
    }
    
    
    public String getCartID(){
        return this.cartID;
    }
    
    public List<Product> getCartProducts(){
        return this.products;
    }
}
