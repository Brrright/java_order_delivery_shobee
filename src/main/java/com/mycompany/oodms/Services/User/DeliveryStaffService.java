/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.User;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.DeliveryStaff;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DeliveryStaffService {
    private ArrayList<DeliveryStaff> delivery_staffs;
    
    public DeliveryStaffService(){
        FileHandler staff_file = new FileHandler(FileName.DELIVERY_STAFF);
        List<FileRecord> staff_records = staff_file.FetchRecord();
        staff_records.forEach((record) -> {
            DeliveryStaff staff_object = convertToObject(record);
            this.delivery_staffs.add(staff_object);
        });
    }
    
    private DeliveryStaff convertToObject(FileRecord r){
        String[] staff_data = r.getRecordList();
        if(staff_data.length == 0){
            return null;
        }
        int staff_id = r.getID();
        String staff_name = staff_data[1];
        String staff_email = staff_data[2];
        String staff_password = staff_data[3];
        int staff_age = Integer.parseInt(staff_data[4]);
        Gender staff_gender = Gender.valueOf(staff_data[5]);
        String staff_phone_num = staff_data[6];
        String staff_picture = staff_data[7];
        
        return new DeliveryStaff(staff_id, staff_name, staff_email, staff_password, staff_age, staff_gender, staff_phone_num, staff_picture);
    }
    
    public ArrayList<DeliveryStaff> getStaffs(){
        return this.delivery_staffs;
    }
    
    public DeliveryStaff getStaff(int id){
        DeliveryStaff response = null;
        for(int i = 0; i < delivery_staffs.size(); i ++) {
            if(delivery_staffs.get(i).getID()== id){
                response = delivery_staffs.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"delivery_staffs\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
