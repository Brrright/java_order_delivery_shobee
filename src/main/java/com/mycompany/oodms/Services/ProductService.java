/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Category;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductService {
    private ArrayList<Product> products;
    FileHandler product_file = new FileHandler(FileName.PRODUCT);

    public ProductService(){
        List<FileRecord> product_records = product_file.FetchRecord();
        product_records.forEach((record) -> {
            Product product_object = convertToObject(record);
            this.products.add(product_object);
        });
    }
    private Product convertToObject(FileRecord p){
        String[] product_data = p.getRecordList();
            if (product_data.length == 0){
                return null;
            }
            
        // Product data
            int product_id  = p.getID();
            String product_name = product_data[1];
            double product_price = Double.parseDouble(product_data[2]);
            int product_stock = Integer.parseInt(product_data[3]);
            String product_picture = product_data[4];
            int product_cate_id = Integer.parseInt(product_data[5]);
          
        // Category object
            CategoryService category_service = new CategoryService();
            Category category = category_service.getCategory(product_cate_id);
            
            return new Product(product_id, product_name, product_price, product_stock, product_picture, category);
    }
    
    private FileRecord convertToFileRecord(Product product){
        String product_record_string = product.getProductID() + ";" + product.getProductName() + ";" + product.getProductPrice() + ";" + product.getStockQty() + ";" + product.getProcuctPicture() + ";" + product.getCategory().getCategoryID();
        return new FileRecord(product.getProductID(), product_record_string);
    }
    
    public ArrayList<Product> getProducts(){
        return this.products;
    }
    
    public Product getProduct(int id) {
        Product response = null;
        for(int i = 0; i < products.size(); i ++) {
            if(products.get(i).getProductID() == id){
                response = products.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"products\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
        FileRecord product_record = convertToFileRecord(product);
        product_file.InsertRecord(product_record);
    }
    
    public void updateProduct(Product product){
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getProductID() == product.getProductID()){
                products.set(i, product);
                FileRecord product_record = convertToFileRecord(product);
                product_file.UpdateRecord(product_record);
                break;
            }
        }
    }
    
    public void deleteProduct(Product product){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductID() == product.getProductID()){
                products.remove(products.get(i));
                FileRecord product_record = convertToFileRecord(product);
                product_file.DeleteRecord(product_record);
            }
        }
    }
}
