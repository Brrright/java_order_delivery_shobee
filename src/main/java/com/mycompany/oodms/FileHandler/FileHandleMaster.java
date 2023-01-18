/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.FileHandler;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    private String filePathPrefix = "src\\main\\java\\com\\mycompany\\oodms\\files\\";
    private String fileName;
    private String filePath;
    private Object[] response = new Object[2];
    
    FileHandleMaster(String fileName) {
        this.fileName = fileName;
        this.filePath = filePathPrefix + fileName;
    }
    
    private void setFileName(String fileName){
        this.fileName = fileName; 
    }
    
    private String getFilePath(){
        return this.filePath;
    }
    
    private String getFileName(){
        return this.fileName;
    }
    
    public static void main(String[] args) {
//        // TESTING
//        FileHandleMaster handler = new FileHandleMaster("product.txt");
//        // CREATE FILE
//        Object[] res = handler.CreateFile();
//         System.out.println(Arrays.toString(res));
//        
//        // FETCH
//        Object[] fetchProduct = handler.FetchRecord();
//        System.out.println(Arrays.toString(fetchProduct));
        
        
    }    
    // ------------------------------------------------------------------------------
    
    // create new file
    public  Object[] CreateFile() {
        try{
            File file = new File(this.filePath);
            if(file.createNewFile()) {
                this.response[0] = ResponseStatus.SUCCESS;
                return this.response;
            }
            else{
                this.response[0] = ResponseStatus.FAIL;
                this.response[1] = "File name exist";
                return this.response;
            }
        }
        catch (IOException e){
            this.response[0] = ResponseStatus.FAIL;
            e.printStackTrace();
            return response;
        }
    }
    
    // fetch data
        // fetch all data from a file
    public Object[] FetchRecord(){
        this.response[0] = ResponseStatus.NONE;
        ReadFileHelper readFile = new ReadFileHelper(this.filePath);
        Object[] res = readFile.getResponseMessage();
        System.out.println(Arrays.toString(res));
        if(res[0] == ResponseStatus.SUCCESS){
            BufferedReader bReader = readFile.getBufferedReader();
            this.response = bReader.lines().toArray();
            try {
                readFile.closeReader();
            } catch (IOException ex) {
                this.response[0] = ResponseStatus.FAIL;
                this.response[1] = ex.getMessage();
                Logger.getLogger(FileHandleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            return response;
        }
        return response;
    }
    
    // fetch  by unique key
    public Object[] FetchRecord(String primaryKey){
        Object[] allRecord = FetchRecord();
        if (allRecord[0] == ResponseStatus.FAIL){
            response[0] = ResponseStatus.FAIL;
            response[1] = allRecord;
            return response;
        }
        this.response[0] = ResponseStatus.NONE;
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
    
    // insert data
    public Object[] InsertRecord(String[] fileContent, String fileHeader, boolean isAppend){
        response[0] = ResponseStatus.NONE;
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
    public Object[] UpdateRecord(String id, String field, String newValue) {
        Object[] allRecords = FetchRecord();
        if (allRecords[0] == ResponseStatus.FAIL){
            response[0] = ResponseStatus.FAIL;
            response[1] = allRecords;
            return response;
        }
        String header = (String) allRecords[0];
        List<String> convertedList = new ArrayList(Arrays.asList(allRecords));
        

        for(int x = 0; x < convertedList.size(); x++) {
            String[] fields  = convertedList.get(x).split(";");
            if (fields [0].equals(id)){
                fields[Integer.parseInt(field)] = newValue;
                convertedList.set(x, String.join(";", fields));
                this.response[0] = ResponseStatus.SUCCESS;
            }
            else{
                this.response[0] = ResponseStatus.FAIL;
                this.response[1] = "Record not found.";
                return response;
            }
        }
        // write files
        
        String[] fileContent = convertedList.toArray(String[]::new);
        Object[] insertMessage = InsertRecord(fileContent, header, false);
        if (insertMessage[0] == ResponseStatus.FAIL){
            response[0] = ResponseStatus.FAIL;
            response[1] = insertMessage;
            return response;
        }
        return response;
    }
    
    
    // delete data
    public Object[] DeleteRecord(Object[] toBeDelete) throws IOException {
        this.response[0] = ResponseStatus.NONE;
        boolean isRemoved = false;
        ArrayList<String> originalRecordList = new ArrayList<>();
        Object[] origainalRecords = FetchRecord(filePath);
        if (origainalRecords[0] == ResponseStatus.FAIL){
            response[0] = ResponseStatus.FAIL;
            response[1] = origainalRecords;
            return response;
        }
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
             Object[] res = writeFile.getResponseMessage();
            if(res[0] == ResponseStatus.SUCCESS){
                for (String eachLine :  modifiedRecord){
                    bWriter.write(eachLine + "\n");
                }
                writeFile.closeWriter();
                response[0] = ResponseStatus.SUCCESS;
                response[1] = "Record deleted successfully.";     
            }
            else{
                response[0] = ResponseStatus.FAIL;
                response[1] = res;
            }     
        } catch (IOException ex) {
            response[0] = ResponseStatus.FAIL;
            response[1] = ex.getMessage();
        }
        return response;
    }
}
