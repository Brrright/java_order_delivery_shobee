/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.DeliveryStatus;
import com.mycompany.oodms.Delivery_Column_Index;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mingl
 */
public class DeliveryService {
    private ArrayList<Delivery> deliveries;
    
    public DeliveryService(){
        FileHandler delivery_file = new FileHandler("delivery");
        List<FileRecord> delivery_records = delivery_file.FetchRecord();
        delivery_records.forEach((d) -> {
            String[] delivery_data = d.getRecordList();
            if (delivery_data.length == 0){
                return;
            }
            
            // Delivery data
                int delivery_id  = d.getID();
                LocalDateTime delivery_date_time = LocalDateTime.parse(delivery_data[2]);
                DeliveryStatus status = DeliveryStatus.valueOf(delivery_data[1]);
                int staff_id = Integer.parseInt(delivery_data[4]);
            
            int order_id = Integer.parseInt(delivery_data[6]);
            FileHandler order_file = new FileHandler("order");
            FileRecord order_record = order_file.FetchRecord(order_id);
            String[] order_data = order_record.getRecordList();
            if (order_data.length == 0){
                return;
            }
            
            // Order data
                LocalDateTime order_date_time = LocalDateTime.parse(order_data[1]);
                int address_id = Integer.parseInt(order_data[6]);
                double total_price = Double.parseDouble(order_data[2]);
                double paid  = Double.parseDouble(order_data[3]);
                double change  = Double.parseDouble(order_data[4]);
                int member_id = Integer.parseInt(order_data[5]);
           
            // Member data - shouldn't be ere but i put as sample la
                FileHandler member_file = new FileHandler("member");
                FileRecord member_record = member_file.FetchRecord(member_id);
                String[] member_data = member_record.getRecordList();
                String member_name = member_data[1];
                String member_email = member_data[2];
                String member_password = member_data[3];
                int member_age = Integer.parseInt(member_data[4]);
                Gender member_gender  = Gender.valueOf(member_data[5]);
                String member_phoneNum = member_data[6];
                String member_picture = member_data[7];
            
          // Delivery staff data
                FileHandler staff_file = new FileHandler("delivery_staff");
                FileRecord staff_record = staff_file.FetchRecord(staff_id);
                String[] staff_data = staff_record.getRecordList();
                String staff_name = staff_data[1];
                String staff_email = staff_data[2];
                String staff_password = staff_data[3];
                int staff_age = Integer.parseInt(staff_data[4]);
                Gender staff_gender = Gender.valueOf(staff_data[5]);
                String staff_phoneNum = staff_data[6];
                String staff_picture = staff_data[7];
                
                
           // Create object
                Member member = new Member(member_id, member_name, member_email, member_password, member_age, member_gender, member_phoneNum, member_picture);
                Order order = new Order(order_id, order_date_time, address_id, total_price, paid, change, member);
                DeliveryStaff staff  = new DeliveryStaff(staff_id, staff_name, staff_email, staff_password, staff_age, staff_gender, staff_phoneNum, staff_picture);
                this.deliveries.add(new Delivery(delivery_id, order, delivery_date_time,staff, status));
                 
            System.out.println(Arrays.toString(delivery_data));
            System.out.println(Arrays.toString(order_data));
            
//            this.deliveries.add(new Delivery(x[0], new Order(), new DeliveryStaff(), new DeliveryStatus()));
        });
//        this.deliveries = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
    }
}
