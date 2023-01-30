/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Cart;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mingl
 */
public class CartService {
    private List<Cart> carts;
    
    public CartService(){
        this.carts = new ArrayList<>();
    }
    
     public void addOrder(Cart cart) {
        carts.add(cart);
    }

    public void updateOrder(Cart cart) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getCartID().equals(cart.getCartID())) {
                carts.set(i, cart);
                break;
            }
        }
    }

    public void deleteOrder(String orderId) {
        Iterator<Cart> iterator = carts.iterator();
        while (iterator.hasNext()) {
            Cart order = iterator.next();
            if (order.getCartID().equals(orderId)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Cart> getAllOrders() {
        return carts;
    }

    public Cart getOrder(String orderId) {
        for (Cart cart : carts) {
            if (cart.getCartID().equals(orderId)) {
                return cart;
            }
        }
        return null;
    }
}
