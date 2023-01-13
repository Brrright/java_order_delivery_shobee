/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author mingl
 */
abstract class FileHelper{
    File file;
    String filePath;
    Object[] response = null;
}

public class ReadFileHelper {
        File file;
        FileReader fReader;
        BufferedReader bReader;
        String filePath;
        Object[] response = null;
        
        public ReadFileHelper(String filePath) {
            try{
                this.filePath = filePath;
                this.file = new File(filePath);
                this.fReader = new FileReader(file);
                this.bReader = new BufferedReader(fReader);
                this.response[0] = ResponseStatus.SUCCESS;
            }   
            catch(IOException e){
                e.printStackTrace();
                this.response[0] = ResponseStatus.FAIL;
                this.response[1] = "Error occured during reading file: " + e.getMessage();
            }
        }
        
        BufferedReader getBufferedReader(){
            return this.bReader;
        }
        
        Object[] getResponseMessage(){
            return this.response;
        }

}
