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
        if(Provider_Member.member_service.getMembers().isEmpty()){
            new Provider_Member();
        }
        if(Provider_Address.address_service.getAddresses().isEmpty()){
            new Provider_Address();
        }
        if(Provider_DeliveryStaff.staff_service.getStaffs().isEmpty()){
            new Provider_DeliveryStaff();
        }
        
        Provider_Address.address_service = new AddressService();
    }
}
