/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.AddressService;

/**
 *
 * @author mingl
 */
public class Provider_Address {
    public static AddressService address_service;
    
    public Provider_Address()
    {
        if(Provider_Member.member_service == null){
            Provider_Member provider_Member = new Provider_Member();
        }
//        if(Provider_DeliveryStaff.staff_service == null){
//            Provider_DeliveryStaff provider_DeliveryStaff = new Provider_DeliveryStaff();
//        }
        if(Provider_Address.address_service == null){
            Provider_Address.address_service = new AddressService();        
        }
    }
}
