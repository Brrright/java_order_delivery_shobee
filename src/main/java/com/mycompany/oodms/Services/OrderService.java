 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Services.User.MemberService;
import com.mycompany.oodms.Address;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mingl
 */
public class OrderService {
     private ArrayList<Order> orders;

    public OrderService() {
        FileHandler order_file = new FileHandler(FileName.ORDER);
        List<FileRecord> order_records = order_file.FetchRecord();
        order_records.forEach((record) -> {
            Order order_object = convertToObject(record);
            this.orders.add(order_object);
        });
        
    }
    
    private Order convertToObject(FileRecord r){
        String[] order_data = r.getRecordList();
            if (order_data.length == 0){
                return null;
            }
            
        // Order data
            int order_id  = r.getID();
            LocalDateTime order_date_time = LocalDateTime.parse(order_data[1]);
            double order_total_price = Double.parseDouble(order_data[2]);
            double order_paid = Double.parseDouble(order_data[3]);
            double order_change = Double.parseDouble(order_data[4]);
            int order_member_id = Integer.parseInt(order_data[5]);
            int order_address_id = Integer.parseInt(order_data[6]);
            
            AddressService address_service = new AddressService();
            Address address_object = address_service.getAddress(order_address_id);
            
            MemberService member_service = new MemberService();
            Member member_object = member_service.getMember(order_member_id);
            
            return new Order(order_id, order_date_time, order_total_price, order_paid, order_change,member_object, address_object);
    }
    
    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    public Order getOrder(String orderId) {
        for (Order order : orders) {
            String orderID = Integer.toString(order.getOrderID());
            if (orderID.equals(orderId)) {
                return order;
            }
        }
        System.out.println("No order found in order service");
        return null;
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
}
