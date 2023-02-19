/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import com.mycompany.oodms.Gender;
import com.mycompany.oodms.Member;
import java.util.List;

/**
 *
 * @author mingl
 */
public class MemberService {
    private List<Member> members;
    
    public MemberService(){
        FileHandler member_file = new FileHandler(FileName.MEMBER);
        List<FileRecord> member_records = member_file.FetchRecord();
        member_records.forEach((record) -> {
            Member member_object = convertToObject(record);
            this.members.add(member_object);
        });
    }
    
    private Member convertToObject(FileRecord r){
        String[] member_data = r.getRecordList();
        if(member_data.length == 0){
            return null;
        }
        int member_id = r.getID();
        String member_name = member_data[1];
        String member_email = member_data[2];
        String member_password = member_data[3];
        int member_age = Integer.parseInt(member_data[4]);
        Gender member_gender = Gender.valueOf(member_data[5]);
        String member_phone_num = member_data[6];
        String member_picture = member_data[7];
        
        return new Member(member_id, member_name, member_email, member_password, member_age, member_gender, member_phone_num, member_picture);
    }
    
    public List<Member> getMembers(){
        return this.members;
    }
    
    public Member getMember(int id){
        Member response = null;
        for(int i = 0; i < members.size(); i ++) {
            if(members.get(i).getID()== id){
                response = members.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"members\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
