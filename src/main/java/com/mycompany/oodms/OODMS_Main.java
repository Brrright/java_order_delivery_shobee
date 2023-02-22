/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.Services.Provider.Provider_Product_Category;
import com.mycompany.oodms.ui.*;

/**
 *
 * @author mingl
 */ 
public class OODMS_Main {
    public static Main_Frame frame;
    public static User current_user; // make user detail globally accessible
    
     public void initialize(){
        // setup Records (necessary record ) NOT USER RELATED DATA
        Provider_Product_Category provider_product  = new Provider_Product_Category();
        
        // setup UI screen
        // Customer interface
        // unregistered
        frame = new Main_Frame(new UI_Login());
//        frame = new Main_Frame(new UI_Signup());
//        frame = new Main_Frame(new UI_AllProducts());
//        frame = new Main_Frame(new UI_Product(sampleProduct));

        // registered
//        frame = new Main_Frame(new UI_Profile());
//        frame = new Main_Frame(new UI_MyOrder());
//        frame = new Main_Frame(new UI_OrderDetails());
//        frame = new Main_Frame(new UI_Cart());
//        frame = new Main_Frame(new UI_Payment());


        // Delivery interface
//        frame = new Main_Frame(new UI_UpComing());
//        frame = new Main_Frame(new UI_OnGoing());
//        frame = new Main_Frame(new UI_Completed());


        // Admin interface
//        frame = new Main_Frame(new UI_AdminMain());
//        frame = new Main_Frame(new UI_UserManagement());        
//        frame = new Main_Frame(new UI_UserManagementProfile());        
//        frame = new Main_Frame(new UI_UserManagementProfileEdit());        
//        frame = new Main_Frame(new UI_CategoryManagement());        
    }
    
    public static void main(String[] args) {
//        initialize();
        OODMS_Main main = new OODMS_Main();
        main.initialize();
    }
}
