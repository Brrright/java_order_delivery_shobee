/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author mingl
 */
public class Main_Frame extends JFrame{
     public JPanel currentPanel;
    
    Main_Frame(JPanel panel) {
        this.currentPanel = panel;
        // set layout, and add it to this class, default operation, pack, set visible, location
        this.setLayout(new BorderLayout());
        this.add(panel);
        
    }
    
    public void replacePanel(JPanel new_panel){
        // remove old panel
        // change panel variable
        // add new panel
        // set bg color
        // refresh jpanel, adjust panel size and change the element
        // set panel position to middle
    }
}
