/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;


/**
 *
 * @author User
 */
public class CartItem {
    Member member;
    Product product;
    int quantity;
    
    public CartItem(Member member, Product product, int qty){
        this.member = member;
        this.product = product;
        this.quantity = qty;
    }
    
    public Member getMember(){
        return this.member;
    }

    public Product getProduct(){
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
    
    public double getTotal(){
        return this.product.getProductPrice() * this.quantity;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    public void setProduct(Product product){        
        this.product = product;
    }
    
    public void setQuantity(int qty) {
        this.quantity = qty;
    }
}
