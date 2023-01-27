/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.FileHandler;

/**
 *
 * @author mingl
 */
public class FileHeader {
    final static String admin = "AdminID;Admin Name;Admin Email;Password;Age;Gender;Phone Number;Picture";
    final static String delivery_staff = "StaffID;Staff Name;Staff Email;Password;Age;Gender;State;Phone Number;Picture";
    final static String member = "MemberID;Member Name;Member Email;Password;Age;Gender;Phone Number;Picture";

    final static String product = "ProductID;Product Name;Price;Stock Quantity;Picture;CategoryID";
    final static String category = "CategoryID;CategoryName";
    
    final static String warehouse = "Name;Street Name;City;State;Postcode";
    final static String delivery = "DeliveryID;Status;Date;AddressID";
    
    final static String member_address = "AddressID;MemberID;StreetName;City;State;Postcode";
    final static String cart = "CartID;CustID;ProductID;Quantity";
    final static String order = "OrderID;DateTime;DeliveryAddressID;TotalPrice;Paid;Change";
    final static String order_item = "ProductID;Quantity;OrderID";
}
