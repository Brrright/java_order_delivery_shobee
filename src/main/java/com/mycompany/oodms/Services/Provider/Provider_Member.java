/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.AddressService;
import com.mycompany.oodms.Services.CartItemService;
import com.mycompany.oodms.Services.CartService;
import com.mycompany.oodms.Services.CategoryService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
import com.mycompany.oodms.Services.ProductService;
import com.mycompany.oodms.Services.User.MemberService;

/**
 *
 * @author mingl
 */
public class Provider_Member {
    // pre-data
//    public static CategoryService category_service;
//    public static ProductService product_service;
    
    public static MemberService member_service;
//    public static AddressService address_service;
//    public static CartService cart_service;
//    public static CartItemService cart_item_service;
//    public static OrderService order_service;
//    public static OrderItemService order_item_service;
    
    public Provider_Member(){
//        Provider_Member.category_service = Provider_Product.category_service;
//        Provider_Member.product_service = Provider_Product.product_service;
        Provider_Member.member_service = new MemberService();
//        Provider_Member.address_service = Provider_Address.address_service;
//        Provider_Member.cart_service = new CartService();
//        Provider_Member.cart_item_service = new CartItemService();
//        Provider_Member.order_service = new OrderService();
//        Provider_Member.order_item_service = new OrderItemService();
    }
}
