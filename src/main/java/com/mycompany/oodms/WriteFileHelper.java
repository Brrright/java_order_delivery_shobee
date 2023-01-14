/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 *
 * @author User
 */
public class WriteFileHelper extends FileHelper{
    FileWriter fWriter;
    BufferedWriter bWriter;
    boolean isAppendMode;

    public WriteFileHelper (String filePath, boolean isAppendMode) {
        super(filePath);
        try{
            this.isAppendMode = isAppendMode;
            this.fWriter = new FileWriter(super.file, this.isAppendMode);
            this.bWriter = new BufferedWriter(fWriter);
            Object[] res = {ResponseStatus.SUCCESS};
            super.setResponseMessage(res);
        }   
        catch(IOException e){
            e.printStackTrace();
            Object[] res = {ResponseStatus.FAIL, "Error occured when getting buffered writter: " + e.getMessage()};
            super.setResponseMessage(res);
        }
    }

    BufferedWriter getBufferedWritter(){
        return this.bWriter;
    }
}
