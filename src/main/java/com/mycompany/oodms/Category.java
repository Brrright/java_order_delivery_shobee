/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mingl
 */
public class Category {
    private int categoryID;
    private String categoryName;
    private List<Product> products;
    
    public Category(int id,String name){
        this.categoryID = id;
        this.categoryName = name;
        this.products = new ArrayList<>();
    }
    
    public int getCategoryID(){
        return this.categoryID;
    }
    
    public String getCategoryName(){
        return this.categoryName;
    }
    
    public List<Product> getProducts(){
        return this.products;
    }
    
    public void setCategoryID(int id){
        this.categoryID = id;
    }
    
    public void setCategoryName(String name){
        this.categoryName = name;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // method to add a product to the category
    public void addProduct(Product product) {
        this.products.add(product);
        product.setCategory(this);
    }
}
