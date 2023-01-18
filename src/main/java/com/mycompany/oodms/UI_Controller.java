/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;

/**
 *
 * @author User
 */
public class UI_Controller {
    public Window window
    public Page currentPage;
    
    public void ChangePage(Page page)
    {
        //Delete current stuff in window
        
        LoginPage newLoginPage = new LoginPage(this);
         //Put new page to the window
         this.currentPage = page;

        
    }
}

class LoginPage
{
    
    private UI_Controller contr_inst;
 
       public LoginPage(UI_Controller ui_controller)
    {
        this.contr_inst = ui_controller;
    }
 
    public void OnLoginSucess()
    {
        ui_controller.ChangePage(MainHomepage mainHomepage)
    }
}