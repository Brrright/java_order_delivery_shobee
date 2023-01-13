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
public class ReadFileHelper {
        File file;
        FileReader fReader;
        BufferedReader bReader;
        String filePath;
        
        public ReadFileHelper(String filePath) {
            try{
                this.filePath = filePath;
                this.file = new File(filePath);
                this.fReader = new FileReader(file);
                this.bReader = new BufferedReader(fReader);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        BufferedReader getBufferedReader(){
            return this.bReader;
        }

}
