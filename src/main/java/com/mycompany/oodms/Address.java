/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import com.mycompany.oodms.FileRelatedClass.FileHandler;

/**
 *
 * @author mingl
 */

// 1 postcode can have multiple city

public class Address {
    private int addressID;
    private String streetName;
    private String city;
    private String state;
    private String postcode;
    static final String ADDRESS_FILE = "address";
    
    Address(String streetName, String city, String state, String postcode){
        FileHandler fHandler = new FileHandler(ADDRESS_FILE);
        this.addressID = fHandler.GenerateID();
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }
}
