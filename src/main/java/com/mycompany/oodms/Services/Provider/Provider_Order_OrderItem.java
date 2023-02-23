/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.AddressService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
//import static com.mycompany.oodms.Services.Provider.Provider_Member.order_item_service;
//import static com.mycompany.oodms.Services.Provider.Provider_Member.order_service;

/**
 *
 * @author mingl
 */
public class Provider_Order_OrderItem { 
    public static OrderService order_service;
    public static OrderItemService order_item_service;
    
    public Provider_Order_OrderItem(){
        if(Provider_Address.address_service == null){
            new Provider_Address();
        }
        if(Provider_Member.member_service == null) {
            new Provider_Member();
        }
        Provider_Order_OrderItem.order_service = new OrderService();
        if(Provider_Product_Category.product_service == null){
            new Provider_Product_Category();
        }
        if(Provider_Order_OrderItem.order_service == null) {
            Provider_Order_OrderItem.order_item_service = new OrderItemService();
        }
    }
}
