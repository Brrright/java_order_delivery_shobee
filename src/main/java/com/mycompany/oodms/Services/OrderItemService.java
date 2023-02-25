/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Order;
import com.mycompany.oodms.OrderItem;
import com.mycompany.oodms.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderItemService {
    
    private static OrderItemService order_item_service;
    
    public static OrderItemService getOrderItemService()
    {
        if(OrderItemService.order_item_service == null)
        {
            System.out.println("turning on order item service");
            OrderItemService.order_item_service = new OrderItemService();
        }
        
        return OrderItemService.order_item_service;
    }
    
    private ArrayList<OrderItem> order_items;
    FileHandler order_item_file = new FileHandler(FileName.ORDER_ITEM);
    
    public OrderItemService() {        
        this.order_items = new ArrayList<OrderItem>();
        List<FileRecord> order_item_records = order_item_file.FetchRecord();
        order_item_records.forEach((record) -> {
            System.out.println("orderitem details: " + record.getRecord());
            OrderItem order_item_object = convertToObject(record);
            this.order_items.add(order_item_object);
        });
    }
    
    private OrderItem convertToObject(FileRecord r){
        String[] order_item_data = r.getRecordList();
        if(order_item_data.length == 0){
            return null;
        }
//        Order Item Data
        int product_id = Integer.parseInt(order_item_data[0]);
        int quantity = Integer.parseInt(order_item_data[1]);
        int order_id  = Integer.parseInt(order_item_data[2]);
//        int member_id  = Integer.parseInt(order_item_data[3]);

        Order order = OrderService.getOrderService().getOrder(order_id);
        Product product = ProductService.getProductService().getProduct(product_id);
//        Member member = Provider_Member.member_service.getMember(member_id);
        System.out.println("p_qty" + quantity);
        System.out.println("p_price" + product.getProductPrice());
        return new OrderItem(quantity, product.getProductPrice(), product, order);
    }
    
    private FileRecord convertToFileRecord(OrderItem order_item) {
        int product_id = order_item.getProduct().getProductID();
        int qty = order_item.getQuantity();
        int order_id = order_item.getOrder().getOrderID();
        int member_id = order_item.getOrder().getCustomer().getID();
        String member_record = product_id + ";" + qty + ";" + order_id + ';' + member_id;
        return new FileRecord(product_id, member_record);
    }
    
     public ArrayList<OrderItem> getOrderItems() {
        return order_items;
    }
    
    public OrderItem getOrderItem(int orderId) {
//        System.out.println("in getOrderItem, received orderid : "  + orderId);
        for (OrderItem item : order_items) {
//            System.out.println("found available order id in here: " + item.getOrder().getOrderID());
            if (item.getOrder().getOrderID() == orderId) {
                return item;
            }
        }
        System.out.println("No order found in order service");
        return null;
    }
    
    public void addOrderItem(OrderItem orderItem){
        order_items.add(orderItem);
        FileRecord order_item_record = convertToFileRecord(orderItem);
        order_item_file.InsertRecord(order_item_record);
    }
    
    public void updateOrderItem(OrderItem orderItem) {
        for (int i = 0; i < order_items.size(); i++) {
            if (order_items.get(i).getProduct().getProductID()== orderItem.getProduct().getProductID() && order_items.get(i).getOrder().getOrderID() == orderItem.getOrder().getOrderID()) {
                order_items.set(i, orderItem);
                FileRecord order_record = convertToFileRecord(orderItem);
                order_item_file.UpdateRecord(order_record);
                break;
            }
        }
    }
    
        public void deleteOrderItem(OrderItem orderItem) {
        for (int i = 0; i < order_items.size(); i++) {
            if (order_items.get(i).getProduct().getProductID()== orderItem.getProduct().getProductID() && order_items.get(i).getOrder().getOrderID() == orderItem.getOrder().getOrderID()) {
                order_items.remove(orderItem);
                FileRecord order_record = convertToFileRecord(orderItem);
                order_item_file.DeleteRecord(order_record);
                break;
            }
        }
    }
}
