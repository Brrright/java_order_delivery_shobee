/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services.User;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AdminService {
    private ArrayList<Admin> admins;
    
    public AdminService(){
        FileHandler admin_file = new FileHandler(FileName.ADMIN);
        List<FileRecord> admin_records = admin_file.FetchRecord();
        admin_records.forEach((record) -> {
            Admin admin_object = convertToObject(record);
            this.admins.add(admin_object);
        });
    }
    
    private Admin convertToObject(FileRecord r){
        String[] admin_data = r.getRecordList();
        if(admin_data.length == 0){
            return null;
        }
        int admin_id = r.getID();
        String admin_name = admin_data[1];
        String admin_email = admin_data[2];
        String admin_password = admin_data[3];
        int admin_age = Integer.parseInt(admin_data[4]);
        Gender admin_gender = Gender.valueOf(admin_data[5]);
        String admin_phone_num = admin_data[6];
        String admin_picture = admin_data[7];
        
        return new Admin(admin_id, admin_name, admin_email, admin_password, admin_age, admin_gender, admin_phone_num, admin_picture);
    }
    
    public ArrayList<Admin> getAdmins(){
        return this.admins;
    }
    
    public Admin getAdmin(int id){
        Admin response = null;
        for(int i = 0; i < admins.size(); i ++) {
            if(admins.get(i).getID()== id){
                response = admins.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"admins\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}