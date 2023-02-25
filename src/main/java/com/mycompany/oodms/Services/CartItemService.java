/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;


import com.mycompany.oodms.Cart;
import com.mycompany.oodms.CartItem;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.Product;
import com.mycompany.oodms.Services.Provider.Provider_Cart;
import com.mycompany.oodms.Services.Provider.Provider_Member;
import com.mycompany.oodms.Services.Provider.Provider_Product_Category;
import com.mycompany.oodms.Services.User.MemberService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CartItemService {
    private static CartItemService cart_item_service;
    
     public static CartItemService getCartItemServive()
    {
        //Not instantiated yet
        if (cart_item_service == null)
        {
            cart_item_service = new CartItemService();
        }
        
        return cart_item_service;
    }
    
    private ArrayList<CartItem> cart_items;
    FileHandler cart_item_file = new FileHandler(FileName.CART_ITEM);
    
    public CartItemService(){
            this.cart_items = new ArrayList<CartItem>();
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
        int cart_id = Integer.parseInt(cart_item_data[0]);
        
        Member member = MemberService.getMemberService().getMember(member_id);
        Product product = ProductService.getProductService().getProduct(product_id);
        Cart cart = CartService.getCartService().getCart(cart_id);
        
        return new CartItem(cart, member, product, qty);
    }
    
    private FileRecord convertToFileRecord(CartItem item){
        String cart_item_record_string = item.getCart().getCartID()+ ";" + item.getProduct().getProductID() + ";" + item.getQuantity() + ";" + item.getMember().getID();
        return new FileRecord(item.getCart().getCartID(), cart_item_record_string);
    }
    
    public ArrayList<CartItem> getCartItems(int member_id){
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
    
    public void addCartItem(CartItem item){
        this.cart_items.add(item);
        FileRecord cart_item_record=  convertToFileRecord(item);
        cart_item_file.InsertRecord(cart_item_record);
    }
    
    public void updateCartItem(CartItem item){
        for(int i=0; i < cart_items.size(); i++){
            if(cart_items.get(i).getCart().getCartID() == item.getCart().getCartID() && cart_items.get(i).getProduct().getProductID() == item.getProduct().getProductID()){
                cart_items.set(i, item);
                FileRecord cart_item_record = convertToFileRecord(item);
                cart_item_file.UpdateRecord(cart_item_record);
                break;
            }
        }
    }
    
    public void deleteCartItem(CartItem item){
        for(int i=0; i < cart_items.size(); i++){
            if(cart_items.get(i).getCart().getCartID() == item.getCart().getCartID() && cart_items.get(i).getProduct().getProductID() == item.getProduct().getProductID()){
                cart_items.set(i, item);
                FileRecord cart_item_record = convertToFileRecord(item);
                cart_item_file.DeleteRecord(cart_item_record);
                break;
            }
        }
    }
}
