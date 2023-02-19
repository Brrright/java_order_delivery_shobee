/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.Services;

import com.mycompany.oodms.Category;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.FileRelatedClass.FileRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mingl
 */
public class CategoryService {
    private ArrayList<Category> categories;
    
    public CategoryService(){
        FileHandler category_file = new FileHandler(FileName.CATEGORY);
        List<FileRecord>  category_records = category_file.FetchRecord();
        category_records.forEach((c) -> {
            Category category_object = convertToObject(c);
            this.categories.add(category_object);
        });
    }
    
    private Category convertToObject(FileRecord r) {
        String[] category_data = r.getRecordList();
        return new Category(r.getID(), category_data[1]);
    }
    
    public List<Category> getCategories(){
        return this.categories;
    }
    
    public Category getCategory(int id){
        Category response = null;
        
        for(int i = 0; i < categories.size(); i ++) {
            if(categories.get(i).getCategoryID()== id){
                response = categories.get(i);
                break;
            }
        }
         if(response == null){
            System.out.println("not such record in this \"categories\".  FIND A WAY TO HANDLE**");
        }
        return response;
    }
}
