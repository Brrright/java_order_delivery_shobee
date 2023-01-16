/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author mingl
 */


public class ReadFileHelper extends FileHelper{
        FileReader fReader;
        BufferedReader bReader;
        
        public ReadFileHelper(String filePath) {
            super(filePath);
            try{
                this.fReader = new FileReader(super.file);
                this.bReader = new BufferedReader(fReader);
                Object[] res = {ResponseStatus.SUCCESS};
                super.setResponseMessage(res);
            }   
            catch(IOException e){
                e.printStackTrace();
                Object[] res = {ResponseStatus.FAIL, "Error occured when reading file: " + e.getMessage()};
                super.setResponseMessage(res);
            }
        }
        
        BufferedReader getBufferedReader(){
            return this.bReader;
        }
        
        void closeReader() throws IOException{
            this.fReader.close();
            this.bReader.close();
        }

}
