/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.OODMS_Main;
import com.mycompany.oodms.User;

/**
 *
 * @author mingl
 */
public class Provider_User {
    public static Provider_Member member_provider;
    public static Provider_Admin admin_provider;
    public static Provider_DeliveryStaff staff_provider;
    public User user;
    
    public Provider_User(){
         user = OODMS_Main.current_user;
    }
}
