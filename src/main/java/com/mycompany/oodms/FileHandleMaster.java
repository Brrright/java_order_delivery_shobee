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
import java.util.ArrayList;
import java.util.Arrays;

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
    public static Object[] FetchRecord(String filePath) throws IOException{
        Object[] response = {ResponseStatus.NONE};
        ReadFileHelper readFile = new ReadFileHelper(filePath);
        Object[] res = readFile.getResponseMessage();
        System.out.println(Arrays.toString(res));
        if(res[0] == ResponseStatus.SUCCESS){
            BufferedReader bReader = readFile.getBufferedReader();
            response = bReader.lines().toArray();
            readFile.closeReader();
            return response;
        }
        return response;
    }
    
        // fetch  by primary key
    public static Object[] FetchRecord(String filePath, String primaryKey) throws IOException{
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
    
        // fetch by linked key (pk + fk)
    public static Object[] FetchRecord(String filePath, String primaryKey,String[] foreignKeyList) throws IOException{
        for (String fkey : foreignKeyList) {
            System.out.println(fkey);
            // get prefix
            // loop thru array see match mou?
        }
        Object[] allRecord = FetchRecord(filePath, primaryKey);
        return allRecord;
    }
    
    // insert data
    public static Object[] InsertRecord(String filePath, String[] fileContent, String fileHeader, boolean isAppend) throws IOException{
        Object[] response = {ResponseStatus.NONE};
        WriteFileHelper writeFile = new WriteFileHelper(filePath, isAppend);
        ReadFileHelper readFile = new ReadFileHelper(filePath);
        Object[] res1 = writeFile.getResponseMessage();
        Object[] res2 = readFile.getResponseMessage();
        if(res1[0] == ResponseStatus.SUCCESS && res2[0] == ResponseStatus.SUCCESS){
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
        boolean isRemoved = false;
        ArrayList<String> listOfOriginalRecord = new ArrayList<>();
        Object[] origainalRecords = FetchRecord(filePath);
        for (Object record : origainalRecords){
            //
        }
        return origainalRecords;
    }
}
