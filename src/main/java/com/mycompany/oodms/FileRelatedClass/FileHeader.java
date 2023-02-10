/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.FileRelatedClass;

/**
 *
 * @author mingl
 */
public class FileHeader {
    final static String ADMIN_HEADER = "AdminID;Admin Name;Admin Email;Password;Age;Gender;Phone Number;Picture";
    final static String DELIVERY_STAFF_HEADER = "StaffID;Staff Name;Staff Email;Password;Age;Gender;State;Phone Number;Picture";
    final static String MEMBER_HEARDER = "MemberID;Member Name;Member Email;Password;Age;Gender;Phone Number;Picture";

    final static String PRODUCT_HEADER = "ProductID;Product Name;Price;Stock Quantity;Picture;CategoryID";
    final static String CATEGORY_HEADER = "CategoryID;CategoryName";
    
    final static String WAREHOUSE_HEADER = "Name;Street Name;City;State;Postcode";
    final static String DELIVERY_HEADER = "DeliveryID;Status;Date;AddressID";
    
    final static String MEMBER_ADDRESS_HEADER = "AddressID;MemberID;StreetName;City;State;Postcode";
    final static String CART_HEADER = "CartID;CustID;ProductID;Quantity";
    final static String ORDER_HEADER = "OrderID;DateTime;DeliveryAddressID;TotalPrice;Paid;Change";
    final static String ORDER_ITEM_HEADER = "ProductID;Quantity;OrderID";
}
