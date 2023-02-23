/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.CartItemService;
import com.mycompany.oodms.Services.CartService;

/**
 *
 * @author mingl
 */
public class Provider_Cart {
    public static CartService cart_service;
    public static CartItemService cart_item_service;
    
    public Provider_Cart(){
        if(Provider_Member.member_service.getMembers().isEmpty()){
            Provider_Member provider_Member = new Provider_Member();
        }
        cart_service = new CartService();
        
        if(Provider_Product_Category.product_service.getProducts().isEmpty()){
            Provider_Product_Category provider_Product_Category = new Provider_Product_Category();
        }
        if(Provider_Cart.cart_service.getCarts().isEmpty()) {
            cart_item_service = new CartItemService();
        }
    }
}
