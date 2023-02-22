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
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author hw
 */
public class UI_CategoryManagement extends JPanel{
    UI_Header heading;
    
    // first section (management selection)
    JLabel generalManagementIcon_label;
    ImageIcon generalManagementIcon = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/generalManagementIcon.png");
    
    
    JButton userManagementBtn;
    JButton productManagementBtn;
    JButton categoryManagementBtn;
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    ImageIcon grayCircle2 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    
    // 2nd section (search, add, filter-customer,delivery)
    JButton addCategory;
    ImageIcon addBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/addBtn.png");

    JTextField search_textfield;
    
    JButton search_btn;
    ImageIcon searchBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/searchBtn.png");
    
    
    // 3rd section (users)
    JLabel reminder;
    JButton[] categories;
    ArrayList<ArrayList<String>> allCategory = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    ImageIcon xBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/xbtn.png");
    
    
    // panels
     JPanel product_panel;
     JPanel search_panel;
     JPanel managementSelection_panel;
     
     // container
     JPanel title_container;
     JPanel selection_container;
     JPanel search_container;
     JScrollPane main_container;
     
    
    public UI_CategoryManagement() {
        // heading
        heading = new UI_Header();
        
        // 1st section (management selection)
        // JLabel - general Management Icon
        generalManagementIcon_label = new JLabel(generalManagementIcon);
        generalManagementIcon_label.setPreferredSize(new Dimension(1080, 175));
        
        // JButton - user management button
        userManagementBtn = new JButton("User");
        userManagementBtn.setIcon(grayCircle1);
        userManagementBtn.setBorder(BorderFactory.createEmptyBorder());
        userManagementBtn.setHorizontalTextPosition(JLabel.CENTER);
        userManagementBtn.setVerticalTextPosition(JLabel.CENTER);
        userManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userManagementBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        userManagementBtn.setForeground(Color.GRAY);
        userManagementBtn.addActionListener(e -> {
            frame.replacePanel(new UI_UserManagement());
        });
        
        // JButton - Product management button
        productManagementBtn = new JButton("Product");
        productManagementBtn.setIcon(grayCircle2);
        productManagementBtn.setBorder(BorderFactory.createEmptyBorder());
        productManagementBtn.setHorizontalTextPosition(JLabel.CENTER);
        productManagementBtn.setVerticalTextPosition(JLabel.CENTER);
        productManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        productManagementBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        productManagementBtn.setForeground(Color.GRAY);
        productManagementBtn.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagement());
        });
        
        
        // JButton - Category management button
        categoryManagementBtn = new JButton("Category");
        categoryManagementBtn.setIcon(orangeCircle);
        categoryManagementBtn.setBorder(BorderFactory.createEmptyBorder());
        categoryManagementBtn.setHorizontalTextPosition(JLabel.CENTER);
        categoryManagementBtn.setVerticalTextPosition(JLabel.CENTER);
        categoryManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        categoryManagementBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        categoryManagementBtn.setForeground(Color.WHITE);
        
        
        // JPanel - Management Selection panel
        managementSelection_panel = new JPanel();
        managementSelection_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        managementSelection_panel.setPreferredSize(new Dimension(1080, 150));
        managementSelection_panel.setBackground(Color.WHITE);
        managementSelection_panel.add(userManagementBtn);
        managementSelection_panel.add(productManagementBtn);
        managementSelection_panel.add(categoryManagementBtn);
        
        
        // JButton - Add category button
        addCategory = new JButton(addBtn);
        addCategory.setPreferredSize(new Dimension(59,48));
        addCategory.setOpaque(false);
        addCategory.setBorder(BorderFactory.createEmptyBorder());
        addCategory.setHorizontalAlignment(JLabel.CENTER);
        addCategory.setVerticalAlignment(JLabel.CENTER);
        addCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addCategory.addActionListener(e -> {
            String categotyInput = JOptionPane.showInputDialog("Enter new category:");

            // read if user entered or not
            if (categotyInput == null || categotyInput.trim().isEmpty())
            {
                // cancel clicked / null input
                System.out.print("user clicked cancel");
            } 
            else 
            {
                // have to read if user entered or not
                if (!"".equals(categotyInput))
                {
                    // create new category
                    System.out.println("input: " + categotyInput);
                }
            
            } 
        });
        
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
        search_panel.setPreferredSize(new Dimension(1080, 85));
        search_panel.setBackground(Color.WHITE);
        search_panel.add(addCategory);
        search_panel.add(search_textfield);
        search_panel.add(search_btn);
        
        
        // JLabel - reminder
        reminder = new JLabel("* reminder - please make sure the category is empty before remove");
        reminder.setFont(new Font("MV Boli",Font.PLAIN,13));
        reminder.setForeground(Color.RED);
        
        
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
        
        product_panel.add(reminder);
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
