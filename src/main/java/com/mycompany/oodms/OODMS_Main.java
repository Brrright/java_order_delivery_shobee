/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.ui.*;

/**
 *
 * @author mingl
 */ 
public class OODMS_Main {
    public static Main_Frame frame;
    public static User current_user; // make user detail globally accessible
    
     public void initialize(){
        // setup Records (fetch necessary record first)
        Category cat = new Category(1, "hi");
         Product sampleProduct = new Product(1, "Fish",3.0, 2, "src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg", cat);
        // setup UI screen
        frame = new Main_Frame(new UI_Product(sampleProduct));
        
    }
    
    public static void main(String[] args) {
//        initialize();
        OODMS_Main main = new OODMS_Main();
        main.initialize();
    }
}
