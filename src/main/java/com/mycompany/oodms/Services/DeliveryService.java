/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.DeliveryStatus;
import com.mycompany.oodms.Delivery_Column_Index;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.OODMS_Main;
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
        FileHandler delivery_file = new FileHandler(FileName.DELIVERY);
        List<FileRecord> delivery_records = delivery_file.FetchRecord();
        delivery_records.forEach((d) -> {
            Delivery delivery_object = convertToObject(d);
            this.deliveries.add(delivery_object);
        });
    }
    
    private Delivery convertToObject(FileRecord d){
        // since file only store id, we need fetch the id and get other records' data for making instances of the object
        String[] delivery_data = d.getRecordList();
            if (delivery_data.length == 0){
                return null;
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
                System.out.println("in convert to object: cant find order data for the delivery");
                return null;
            }
            
            // Order data
                LocalDateTime order_date_time = LocalDateTime.parse(order_data[1]);
                int address_id = Integer.parseInt(order_data[6]);
                double total_price = Double.parseDouble(order_data[2]);
                double paid  = Double.parseDouble(order_data[3]);
                double change  = Double.parseDouble(order_data[4]);
                
                Member member = (Member) OODMS_Main.current_user;
            
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
                Order order = new Order(order_id, order_date_time, address_id, total_price, paid, change, member);
                DeliveryStaff staff  = new DeliveryStaff(staff_id, staff_name, staff_email, staff_password, staff_age, staff_gender, staff_phoneNum, staff_picture);
                

                 
            // need to wait till i have login details setup data
            System.out.println(Arrays.toString(delivery_data));
            System.out.println(Arrays.toString(order_data));
            
            return new Delivery(delivery_id, order, delivery_date_time,staff, status);
    }
    
    public List<Delivery>getDeliveries(){
        return this.deliveries;
    }
    
    public Delivery getDelivery(int id){
        Delivery response = null;
        for(int i = 0; i < deliveries.size(); i ++) {
            if(deliveries.get(i).getDeliveryID() == id){
                response = deliveries.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"deliveries\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
