/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Order;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mingl
 */
public class OrderService {
     private List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void updateOrder(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            String orderID = Integer.toString(orders.get(i).getOrderID());
            if (orderID.equals(order.getOrderID())) {
                orders.set(i, order);
                break;
            }
        }
    }

    public void deleteOrder(String orderId) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            String orderID = Integer.toString(order.getOrderID());
            if (orderID.equals(orderId)) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrder(String orderId) {
        for (Order order : orders) {
            String orderID = Integer.toString(order.getOrderID());
            if (orderID.equals(orderId)) {
                return order;
            }
        }
        return null;
    }
}
