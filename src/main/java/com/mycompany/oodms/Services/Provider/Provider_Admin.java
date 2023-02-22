/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.CategoryService;
import com.mycompany.oodms.Services.DeliveryService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
import com.mycompany.oodms.Services.ProductService;
//import static com.mycompany.oodms.Services.Provider.Provider_Member.order_item_service;
//import static com.mycompany.oodms.Services.Provider.Provider_Member.order_service;
import com.mycompany.oodms.Services.User.AdminService;
import com.mycompany.oodms.Services.User.DeliveryStaffService;

/**
 *
 * @author mingl
 */
public class Provider_Admin {
// pre-data 
    // for manage product and category
//    public static CategoryService category_service;
//    public static ProductService product_service;
    
    // for user management
    public static AdminService admin_service;
//    public static DeliveryStaffService staff_service;
    
    // for payment and order
//    public static OrderService order_service;
//    public static OrderItemService order_item_service;
    
    // for manage delivery
//    public static DeliveryService delivery_service;
    
    public Provider_Admin(){
//        Provider_Admin.category_service = Provider_Product.category_service;
//        Provider_Admin.product_service = Provider_Product.product_service;
        Provider_Admin.admin_service = new AdminService();
//        Provider_Admin.staff_service = new DeliveryStaffService();
//        Provider_Admin.order_service = new OrderService(); // for search payment and order
//        Provider_Admin.order_item_service = new OrderItemService(); // for order's item
//        Provider_Admin.delivery_service = new DeliveryService();
    }
}
