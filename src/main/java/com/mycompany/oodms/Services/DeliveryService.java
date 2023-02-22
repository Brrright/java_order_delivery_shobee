/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Address;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.DeliveryStatus;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.Order;
import com.mycompany.oodms.Services.Provider.Provider_Address;
import com.mycompany.oodms.Services.Provider.Provider_DeliveryStaff;
import com.mycompany.oodms.Services.Provider.Provider_Member;
import com.mycompany.oodms.Services.Provider.Provider_Order_OrderItem;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mingl
 */
public class DeliveryService {
//    public static boolean isCreated = false;
    private ArrayList<Delivery> deliveries;
    FileHandler delivery_file = new FileHandler(FileName.DELIVERY);
    
    public DeliveryService(){
        this.deliveries = new ArrayList<Delivery>();
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
        int address_id = Integer.parseInt(delivery_data[3]);
        int staff_id = Integer.parseInt(delivery_data[4]);
        int member_id = Integer.parseInt(delivery_data[5]);
        int order_id = Integer.parseInt(delivery_data[6]);
        
        Order order = Provider_Order_OrderItem.order_service.getOrder(order_id);
            
        Member member_object = Provider_Member.member_service.getMember(member_id);
        Address address_object = Provider_Address.address_service.getAddress(address_id);
        DeliveryStaff staff =Provider_DeliveryStaff. staff_service.getStaff(staff_id);
            
        return new Delivery(delivery_id, order, delivery_date_time,staff, status, address_object, member_object);
    }
    
    private FileRecord convertToFileRecord(Delivery delivery){
        String delivery_record_string = delivery.getDeliveryID() + ";" + delivery.getStatus() + ";" + delivery.getDateTime() +";" + delivery.getStaff().getID() +";" + delivery.getMember().getID() +";" + delivery.getOrder().getOrderID();
        return new FileRecord(delivery.getDeliveryID(), delivery_record_string);
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
    
    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
        FileRecord dellivery_record = convertToFileRecord(delivery);
        delivery_file.InsertRecord(dellivery_record);
    }
    
    public void updateDelivery(Delivery delivery) {
        for (int i = 0; i < deliveries.size(); i++) {
            if (deliveries.get(i).getDeliveryID()== delivery.getDeliveryID()) {
                deliveries.set(i, delivery);
                FileRecord delivery_record = convertToFileRecord(delivery);
                delivery_file.UpdateRecord(delivery_record);
                break;
            }
        }
    }

    public void deleteDelivery(Delivery delivery) {
        for (int i = 0; i < deliveries.size(); i++) {
            if (deliveries.get(i).getDeliveryID()== delivery.getDeliveryID()) {
                deliveries.remove(deliveries.get(i));
                FileRecord delivery_record = convertToFileRecord(delivery);
                delivery_file.DeleteRecord(delivery_record);
                break;
            }
        }
    }
}
