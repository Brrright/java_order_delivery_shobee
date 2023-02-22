/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Admin;

import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.ui.Main_Frame;
import com.mycompany.oodms.ui.UI_Header;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author hw
 */
public class UI_ReportOrders extends JPanel{
    UI_Header heading;
    
    // first section (management selection)
    JLabel generalManagementIcon_label;
    ImageIcon generalManagementIcon = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/generalManagementIcon.png");
    
    
    JButton orderBtn;
    JButton paymentBtn;
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    
    // 2nd section (search, add, filter-customer,delivery)

    JTextField search_textfield;
    
    JButton search_btn;
    ImageIcon searchBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/searchBtn.png");
    
    
    // 3rd section (users)
    JButton[] categories;
    ArrayList<ArrayList<String>> allCategory = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    
    // panels
     JPanel product_panel;
     JPanel search_panel;
     JPanel managementSelection_panel;
     
     // container
     JPanel title_container;
     JPanel selection_container;
     JPanel search_container;
     JScrollPane main_container;
     
    
    public UI_ReportOrders() {
        // heading
        heading = new UI_Header();
        
        // 1st section (management selection)
        // JLabel - general Management Icon
        generalManagementIcon_label = new JLabel(generalManagementIcon);
        generalManagementIcon_label.setPreferredSize(new Dimension(1080, 175));
        
        // JButton - user management button
        orderBtn = new JButton("Category");
        orderBtn.setIcon(orangeCircle);
        orderBtn.setBorder(BorderFactory.createEmptyBorder());
        orderBtn.setHorizontalTextPosition(JLabel.CENTER);
        orderBtn.setVerticalTextPosition(JLabel.CENTER);
        orderBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        orderBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        orderBtn.setForeground(Color.WHITE);
        
        
        // JButton - Category management button
        paymentBtn = new JButton("Category");
        paymentBtn.setIcon(grayCircle1);
        paymentBtn.setBorder(BorderFactory.createEmptyBorder());
        paymentBtn.setHorizontalTextPosition(JLabel.CENTER);
        paymentBtn.setVerticalTextPosition(JLabel.CENTER);
        paymentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        paymentBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        paymentBtn.setForeground(Color.GRAY);
        paymentBtn.addActionListener(e -> {
            frame.replacePanel(new UI_UserManagement());
        });
        
        
        // JPanel - Management Selection panel
        managementSelection_panel = new JPanel();
        managementSelection_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        managementSelection_panel.setPreferredSize(new Dimension(1080, 150));
        managementSelection_panel.setBackground(Color.WHITE);
        managementSelection_panel.add(orderBtn);
        managementSelection_panel.add(paymentBtn);
        
        
        // JTextField - search bar
        search_textfield = new JTextField();
        search_textfield.setPreferredSize(new Dimension(432,48));
        
        // JButton - search button
        search_btn = new JButton(searchBtn);
        search_btn.setPreferredSize(new Dimension(69,48));
        search_btn.setOpaque(false);
        search_btn.setBorder(BorderFactory.createEmptyBorder());
        search_btn.setHorizontalAlignment(JLabel.CENTER);
        search_btn.setVerticalAlignment(JLabel.CENTER);
        search_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search_btn.addActionListener(e -> {
            // search user
        });
        
        // JPanel - search panel (add, search, filter)
        search_panel = new JPanel();
        search_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        search_panel.setPreferredSize(new Dimension(1080, 70));
        search_panel.setBackground(Color.WHITE);
        search_panel.add(search_textfield);
        search_panel.add(search_btn);
        
        
        // JButton[] - users
        // create temp user 
        for (int i = 0; i < 5; i++){
            category.add("Foods and beverage");
            allCategory.add(category);
        }
        
        categories = new JButton[allCategory.size()];
        
        for (int i = 0; i < allCategory.size();i++){
            
            // button (category)
            categories[i] = new JButton();
            categories[i].setText(i + 1 + ". " + allCategory.get(i).get(1));
            categories[i].setPreferredSize(new Dimension(700,120));
            categories[i].setOpaque(false);
            categories[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            categories[i].setHorizontalAlignment(JLabel.LEFT);
            categories[i].setVerticalAlignment(JLabel.CENTER);
            categories[i].setHorizontalTextPosition(JLabel.RIGHT);
            categories[i].setVerticalTextPosition(JLabel.CENTER);
            categories[i].setIconTextGap(40);
            categories[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            categories[i].addActionListener(e -> {
                frame = new Main_Frame(new UI_CategoryManagementCategory());        
            });
        }
        
        // Panel for users
        int product_panel_height = (150 * allCategory.size()) + 30;
        
        product_panel = new JPanel();
        product_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
        product_panel.setPreferredSize(new Dimension(700, product_panel_height));
        product_panel.setBackground(Color.WHITE);
        
        for (JButton theCategory : categories){
            product_panel.add(theCategory);
        }
        
        // third container (search container)
        search_container = new JPanel();
        search_container.setLayout(new BorderLayout());
        search_container.setBackground(Color.WHITE);
        search_container.add(search_panel, BorderLayout.NORTH);
        search_container.add(product_panel, BorderLayout.CENTER);
        
        // second container (management selection)
        selection_container = new JPanel();
        selection_container.setLayout(new BorderLayout());
        selection_container.setBackground(Color.WHITE);
        selection_container.add(managementSelection_panel, BorderLayout.NORTH);
        selection_container.add(search_container, BorderLayout.CENTER);
        
        // first Container (title - the icon)
        title_container = new JPanel();
        title_container.setLayout(new BorderLayout());
        title_container.setBackground(Color.WHITE);
        title_container.add(generalManagementIcon_label, BorderLayout.NORTH);
        title_container.add(selection_container, BorderLayout.CENTER);
        
        // scroll pane
        main_container = new JScrollPane(title_container);
        main_container.setBorder(BorderFactory.createEmptyBorder());
        main_container.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // this panel
        this.setLayout(new BorderLayout());
        this.add(heading, BorderLayout.NORTH);
        this.add(main_container, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);
    }

}
