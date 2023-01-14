/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author mingl
 */

enum ResponseStatus{
    SUCCESS,
    FAIL,
    
//    public String message;
//    
//    private ResponseStatus(String message) {
//        this.message = message;
//        
//    }
}

enum UserIdPrefix{
    ADM,
    MEM,
    DEL,
}

public class FileHandleMaster {
    public static void main(String[] args) {
        // TESTING
        // Object[] response = CreateFile("src\\main\\java\\com\\mycompany\\oodms\\files\\product.txt");
        // System.out.println(Arrays.toString(response));
        
        // FETCH
        Object[] fetchProduct = FetchRecord("src\\main\\java\\com\\mycompany\\oodms\\files\\product.txt");
        System.out.println(Arrays.toString(fetchProduct));
    }
    
    // -------------------------------------------------------
    // create new file
    public static Object[] CreateFile(String filePath) {
        try{
            File file = new File(filePath);
            if(file.createNewFile()) {
                Object[] response = {ResponseStatus.SUCCESS};
                return response;
            }
            else{
                Object[] response = {ResponseStatus.FAIL, "File name exist"};
                return response;
            }
        }
        catch (IOException e){
            Object[] response = {ResponseStatus.FAIL};
            e.printStackTrace();
            return response;
        }
    }
    // fetch data
        // fetch all data from a file
    public static Object[] FetchRecord(String filePath){
        Object[] response = {};
        ReadFileHelper readFile = new ReadFileHelper(filePath);
        Object[] res = readFile.getResponseMessage();
        System.out.println(Arrays.toString(res));
        if(res[0] == ResponseStatus.SUCCESS){
            BufferedReader bReader = readFile.getBufferedReader();
            response = bReader.lines().toArray();
            return response;
        }
        return response;
    }
    
        // fetch  by primary key
    public static Object[] FetchRecord(String filePath, String primaryKey){
        Object[] allRecord = FetchRecord(filePath);
        Object[] response = null;
        for (Object record : allRecord){
            String line = record.toString().trim();
            String[] dataRow = line.split(";");
            for (int i = 0; i < dataRow.length; i++) {
                    if (dataRow[0].equals(primaryKey)) {
                        response = dataRow;
                    }
            }
        }
        if (response == null) {
            response[0] = ResponseStatus.FAIL;
            response[1] = "No record found.";
            return response;
        }
        return response;
    }
    
        // fetch by linked key (pk + fk)
    public static Object[] FetchRecord(String filePath1, String filePath2, String primaryKey,String foreignKey){
        Object[] allRecord = FetchRecord(filePath1, primaryKey);
        return allRecord;
    }
    
    // insert data
    
    // update data
    
    // delete data
    
}
