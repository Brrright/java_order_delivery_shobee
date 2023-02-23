/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.Provider;

import com.mycompany.oodms.Services.CategoryService;
import com.mycompany.oodms.Services.ProductService;

/**
 *
 * @author mingl
 */
public class Provider_Product_Category {
    public static CategoryService category_service;
    public static ProductService product_service;
    
    public Provider_Product_Category(){
        if(Provider_Product_Category.product_service == null ||Provider_Product_Category.category_service == null ){
            Provider_Product_Category.category_service  = new CategoryService();
            Provider_Product_Category.product_service  = new ProductService();
        }
    }
}
