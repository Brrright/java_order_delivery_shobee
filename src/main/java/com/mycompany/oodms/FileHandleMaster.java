/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mingl
 */

enum ResponseStatus{
    SUCCESS,
    FAIL,
    NONE
    
//    public String message;
//    
//    private ResponseStatus(String message) {
//        this.message = message;
//        
//    }
}


public class FileHandleMaster {
    String filePathPrefix = "src\\main\\java\\com\\mycompany\\oodms\\files\\";
    public static void main(String[] args) {
        // TESTING
        // CREATE FILE
        // Object[] response = CreateFile("src\\main\\java\\com\\mycompany\\oodms\\files\\product.txt");
        // System.out.println(Arrays.toString(response));
        
        // FETCH
//        Object[] fetchProduct = FetchRecord("src\\main\\java\\com\\mycompany\\oodms\\files\\product.txt");
//        System.out.println(Arrays.toString(fetchProduct));
    }
    
    // ------------------------------------------------------------------------------
    
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
        Object[] response = {ResponseStatus.NONE};
        ReadFileHelper readFile = new ReadFileHelper(filePath);
        Object[] res = readFile.getResponseMessage();
        System.out.println(Arrays.toString(res));
        if(res[0] == ResponseStatus.SUCCESS){
            BufferedReader bReader = readFile.getBufferedReader();
            response = bReader.lines().toArray();
            try {
                readFile.closeReader();
            } catch (IOException ex) {
                response[0] = ResponseStatus.FAIL;
                response[1] = ex.getMessage();
                Logger.getLogger(FileHandleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            return response;
        }
        return response;
    }
    
        // fetch  by primary key
    public static Object[] FetchRecord(String filePath, String primaryKey){
        Object[] allRecord = FetchRecord(filePath);
        Object[] response = {ResponseStatus.NONE};
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
    
    // to fetch by using more than 1 key, fetch record multiple times by using diff key
//        // fetch by linked key (pk + fk)
//    public static Object[] FetchRecord(String filePath, String primaryKey,String[] foreignKeyList){
//        for (String fkey : foreignKeyList) {
//            System.out.println(fkey);
//            // get prefix
//            // loop thru array see match mou?
//        }
//        Object[] allRecord = FetchRecord(filePath, primaryKey);
//        return allRecord;
//    }
    
    // insert data
    public static Object[] InsertRecord(String filePath, String[] fileContent, String fileHeader, boolean isAppend){
        Object[] response = {ResponseStatus.NONE};
        WriteFileHelper writeFile = new WriteFileHelper(filePath, isAppend);
        ReadFileHelper readFile = new ReadFileHelper(filePath);
        Object[] res1 = writeFile.getResponseMessage();
        Object[] res2 = readFile.getResponseMessage();
        if(res1[0] == ResponseStatus.SUCCESS && res2[0] == ResponseStatus.SUCCESS){
            try {
                BufferedWriter bWriter = writeFile.getBufferedWriter();
                BufferedReader bReader = readFile.getBufferedReader();
                Object[] fetchedContent = bReader.lines().toArray();
                
                if(fetchedContent.length == 0){
                    String firstLine = fileHeader;
                    bWriter.write(firstLine + "\n");
                }
                for (String content : fileContent){
                    bWriter.write(content);
                    bWriter.newLine();
                }
                response[0] = ResponseStatus.SUCCESS;
                readFile.closeReader();
                writeFile.closeWriter();
            } catch (IOException ex) {
                response[0] = ResponseStatus.FAIL;
                response[1] = "Error occured during writing : "+ ex.getMessage();
                Logger.getLogger(FileHandleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            response[0] = ResponseStatus.FAIL;
            response[1] = "Error occured during writing to file.";
        }
        return response; 
    }
    
    // update data
    
    // delete data
    public static Object[] DeleteRecord(String filePath, Object[] toBeDelete) throws IOException {
        Object[] response = {};
        boolean isRemoved = false;
        ArrayList<String> originalRecordList = new ArrayList<>();
        Object[] origainalRecords = FetchRecord(filePath);
         for (Object record : origainalRecords){
            if(record != ResponseStatus.FAIL){
                originalRecordList.add((String) record);
            }
            else{
                response[0] = ResponseStatus.FAIL;
                response[1] = record;
                return response;
            }
        }
                     
        // check if the array is exist, if yes, remove
        for (int num = 0; num < originalRecordList.size(); num++) {
            String[] line = originalRecordList.get(num).split(";");
            if (Arrays.equals(line, toBeDelete)) {
                originalRecordList.remove(num);
                isRemoved = true;
            }
        }

        if(isRemoved == false) {
            response[0] = ResponseStatus.FAIL;
            response[1] = "Record no found";
            return response;
        }
        
        ArrayList<String> modifiedRecord = originalRecordList;
        try{
            WriteFileHelper writeFile = new WriteFileHelper(filePath, true);
            BufferedWriter bWriter = writeFile.getBufferedWriter();
            for (String eachLine :  modifiedRecord){
                bWriter.write(eachLine + "\n");
            }
            writeFile.closeWriter();
            response[0] = ResponseStatus.SUCCESS;
            response[1] = "Record deleted successfully.";
            
        } catch (IOException ex) {
            response[0] = ResponseStatus.FAIL;
            response[1] = ex.getMessage();
        }
        return response;
    }
}
