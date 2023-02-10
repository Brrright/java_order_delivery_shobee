/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author mingl
 */
public class Main_Frame extends JFrame{
     public JPanel currentPanel;
    
    public Main_Frame(JPanel panel) {
        this.currentPanel = panel;
        // set layout, and add it to this class, default operation, pack, set visible, location        
        this.setSize(1080,768);
        this.setTitle("Shobee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        
        this.add(panel);
        
        this.setVisible(true);
        
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
