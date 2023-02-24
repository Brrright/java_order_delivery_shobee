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
    
    public static boolean StartProvider()
    {
        if(Provider_Member.member_service == null){
            Provider_Member.StartProvider();
        }  
        if(Provider_Address.address_service == null){
            Provider_Address.address_service = new AddressService();    
             if (address_service.getAddresses().size() == 0){
                 return false;
             }
        }
        return true;
    }
}
