/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Services.User.MemberService;
import com.mycompany.oodms.Cart;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author mingl
 */
public class CartService { //might no use le, since 1 person 1 cart, no place for us to show all cart oso, but CART ITEM SERVICE IS NEEDED
    private ArrayList<Cart> carts;
    
    public CartService(){
        FileHandler cart_file = new FileHandler(FileName.CART);
        List<FileRecord> order_records = cart_file.FetchRecord();
        order_records.forEach((record) -> {
            Cart cart_object = convertToObject(record);
            this.carts.add(cart_object);
        });
    }
    
    private Cart convertToObject(FileRecord r){
        String[] cart_data = r.getRecordList();
        if (cart_data.length == 0){
            return null;
        }
        
        // Cart data
        int cart_id = r.getID();
        int member_id= Integer.parseInt(cart_data[1]);
        
        MemberService member_service = new MemberService();
        Member member_object = member_service.getMember(member_id);
        
        return new Cart(cart_id, member_object);
    }
    
     public ArrayList<Cart> getCarts() {
        return carts;
    }

    public Cart getOrder(String orderId) {
        for (Cart cart : carts) {
            if (Integer.toString(cart.getCartID()).equals(orderId)) {
                return cart;
            }
        }
        return null;
    }
    
     public void addOrder(Cart cart) {
        carts.add(cart);
    }

    public void updateOrder(Cart cart) {
        for (int i = 0; i < carts.size(); i++) {
            if (Integer.toString(cart.getCartID()).equals(cart.getCartID())) {
                carts.set(i, cart);
                break;
            }
        }
    }

    public void deleteOrder(String orderId) {
        Iterator<Cart> iterator = carts.iterator();
        while (iterator.hasNext()) {
            Cart order = iterator.next();
            if (Integer.toString(order.getCartID()).equals(orderId)) {
                iterator.remove();
                break;
            }
        }
    }

   
}
