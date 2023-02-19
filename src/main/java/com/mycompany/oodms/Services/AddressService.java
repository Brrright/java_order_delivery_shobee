/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Address;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.OODMS_Main;
import java.util.List;

/**
 *
 * @author mingl
 */
public class AddressService {
    private List<Address> addresses;
    
    public AddressService(){
        FileHandler address_file = new FileHandler(FileName.MEMBER_ADDRESS);
        List<FileRecord> address_record = address_file.FetchRecord();
        address_record.forEach((record) -> {
            Address order_object = convertToObject(record);
            this.addresses.add(order_object);
        });
    }
    
    private Address convertToObject(FileRecord r){
        String[] address_data = r.getRecordList();
        if (address_data.length == 0){
            return null;
        }
        
        return new Address(r.getID(), address_data[1], address_data[2], address_data[3], address_data[4]);
    }
    
    public List<Address> getAddresses() {
        return this.addresses;
    }
    
    public Address getAddress(int id) {
        Address response = null;
        for(int i = 0; i < addresses.size(); i ++) {
            if(addresses.get(i).getAddressID() == id){
                response = addresses.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"addresses\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
