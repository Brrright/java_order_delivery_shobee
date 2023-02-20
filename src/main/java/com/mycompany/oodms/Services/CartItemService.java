/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;


import com.mycompany.oodms.Services.User.MemberService;
import com.mycompany.oodms.CartItem;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CartItemService {
    private ArrayList<CartItem> cart_items;
    
    public CartItemService(){
            FileHandler cart_item_file = new FileHandler(FileName.CART_ITEM);
            List<FileRecord> item_records = cart_item_file.FetchRecord();
            item_records.forEach((record) -> {
            CartItem cart_item_object = convertToObject(record);
            this.cart_items.add(cart_item_object);
        });
    }
    
    private CartItem convertToObject(FileRecord r){
        String[] cart_item_data = r.getRecordList();
        if (cart_item_data.length == 0){
            return null;
        }
        
        int qty = Integer.parseInt(cart_item_data[2]);
        int product_id = Integer.parseInt(cart_item_data[1]);
        int member_id = Integer.parseInt(cart_item_data[3]);
        
        MemberService member_service = new MemberService();
        Member member = member_service.getMember(member_id);
        
        ProductService product_service = new ProductService();
        Product product = product_service.getProduct(product_id);
        return new CartItem(member, product, qty);
    }
    
    public ArrayList<CartItem> getCartItems(){
        return this.cart_items;
    }
    
    public CartItem getCartItem(int member_id, int product_id){
        CartItem response = null;
        for(int i = 0; i < cart_items.size(); i ++) {
            if(cart_items.get(i).getMember().getID()== member_id && cart_items.get(i).getProduct().getProductID() == product_id){
                response = cart_items.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"cart_items\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
