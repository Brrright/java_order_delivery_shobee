/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.FileHandler;

import java.io.File;

/**
 *
 * @author User
 */
abstract class FileHelper{
    protected File file;
    protected String filePath;
    protected Object[] response = {};
    
    protected FileHelper(String filePath){
        this.filePath = filePath;
        this.file = new File(filePath);
    }
    
     Object[] getResponseMessage()
     {
         return this.response;
     }
    
     void setResponseMessage(Object[] res)
     {
         this.response = res;
     }
}
