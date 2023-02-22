/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;
import com.mycompany.oodms.Services.User.DeliveryStaffService;

/**
 *
 * @author mingl
 */
public class Provider_DeliveryStaff {
    public static DeliveryStaffService staff_service;
    
    public Provider_DeliveryStaff(){
        Provider_DeliveryStaff.staff_service = new DeliveryStaffService();
    }
}
