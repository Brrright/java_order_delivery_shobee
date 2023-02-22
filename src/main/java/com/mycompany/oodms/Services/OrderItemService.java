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
import com.mycompany.oodms.Services.Provider.Provider_Order_OrderItem;
import com.mycompany.oodms.Services.Provider.Provider_Product_Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderItemService {
    private ArrayList<OrderItem> order_items;
    
    
    public OrderItemService() {        
        this.order_items = new ArrayList<OrderItem>();
        FileHandler order_item_file = new FileHandler(FileName.ORDER_ITEM);
        List<FileRecord> order_item_records = order_item_file.FetchRecord();
        order_item_records.forEach((record) -> {
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

        Order order = Provider_Order_OrderItem.order_service.getOrder(order_id);
        Product product = Provider_Product_Category.product_service.getProduct(product_id);
        
        return new OrderItem(quantity, product.getProductPrice(), product, order);
    }
    
     public ArrayList<OrderItem> getOrderItems() {
        return order_items;
    }
    
    public OrderItem getOrder(int orderId, int productId) {
        for (OrderItem item : order_items) {
            if (item.getProduct().getProductID() == productId && item.getOrder().getOrderID() == orderId) {
                return item;
            }
        }
        System.out.println("No order found in order service");
        return null;
    }
}
