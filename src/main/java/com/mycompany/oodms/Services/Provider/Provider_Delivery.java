/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.CategoryService;
import com.mycompany.oodms.Services.DeliveryService;
import com.mycompany.oodms.Services.ProductService;
import com.mycompany.oodms.Services.User.MemberService;

/**
 *
 * @author mingl
 */
public class Provider_Delivery {
    public static DeliveryService delivery_service;
    
    public Provider_Delivery(){
        if(Provider_Member.member_service.getMembers().isEmpty()) {
            new Provider_Member();
        }
        
        if(Provider_Address.address_service.getAddresses().isEmpty()) {
            new Provider_Address();
        }
        
        if(Provider_DeliveryStaff.staff_service.getStaffs().isEmpty()) {
            new Provider_DeliveryStaff();
        }
        if(Provider_Delivery.delivery_service.getDeliveries().isEmpty()) {
            Provider_Delivery.delivery_service = new DeliveryService();
        }
    }
}
