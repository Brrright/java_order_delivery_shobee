/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author mingl
 */

enum ResponseStatus{
    SUCCESS,
    FAIL,
}

public class FileHandleMaster {
    public static void main(String[] args) {
        //test
//        Object[] response = CreateFile("src\\main\\java\\com\\mycompany\\oodms\\files\\product.txt");
//        System.out.println(Arrays.toString(response));
    }
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
    
    // insert data
    
    // update data
    
    // delete data
    
}
