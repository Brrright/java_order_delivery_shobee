/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Admin;

import static com.mycompany.oodms.OODMS_Main.frame;
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
public class UI_ProductManagement extends JPanel{
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
    JButton addProduct;
    ImageIcon addBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/addBtn.png");

    JTextField search_textfield;
    
    JButton search_btn;
    ImageIcon searchBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/searchBtn.png");

    JComboBox productType;
    String[] productCategory = {"Foods n Beverage", "Furnitures", "Electronics"};
    
    
    // 3rd section (users)
    JButton[] products;
    ArrayList<ArrayList<String>> allProducts = new ArrayList<>();
    ArrayList<String> product = new ArrayList<>();
    final int imageWidth = 203;
    final int imageHeight = 203;
    
    
    // panels
     JPanel product_panel;
     JPanel search_panel;
     JPanel managementSelection_panel;
     
     // container
     JPanel title_container;
     JPanel selection_container;
     JPanel search_container;
     JScrollPane main_container;
     
    
    public UI_ProductManagement() {
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
        productManagementBtn.setIcon(orangeCircle);
        productManagementBtn.setBorder(BorderFactory.createEmptyBorder());
        productManagementBtn.setHorizontalTextPosition(JLabel.CENTER);
        productManagementBtn.setVerticalTextPosition(JLabel.CENTER);
        productManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        productManagementBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        productManagementBtn.setForeground(Color.WHITE);
        
        
        // JButton - Category management button
        categoryManagementBtn = new JButton("Category");
        categoryManagementBtn.setIcon(grayCircle2);
        categoryManagementBtn.setBorder(BorderFactory.createEmptyBorder());
        categoryManagementBtn.setHorizontalTextPosition(JLabel.CENTER);
        categoryManagementBtn.setVerticalTextPosition(JLabel.CENTER);
        categoryManagementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        categoryManagementBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        categoryManagementBtn.setForeground(Color.GRAY);
        categoryManagementBtn.addActionListener(e -> {
            frame.replacePanel(new UI_CategoryManagement());
        });
        
        
        // JPanel - Management Selection panel
        managementSelection_panel = new JPanel();
        managementSelection_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        managementSelection_panel.setPreferredSize(new Dimension(1080, 150));
        managementSelection_panel.setBackground(Color.WHITE);
        managementSelection_panel.add(userManagementBtn);
        managementSelection_panel.add(productManagementBtn);
        managementSelection_panel.add(categoryManagementBtn);
        
        
        // JButton - Add user button
        addProduct = new JButton(addBtn);
        addProduct.setPreferredSize(new Dimension(59,48));
        addProduct.setOpaque(false);
        addProduct.setBorder(BorderFactory.createEmptyBorder());
        addProduct.setHorizontalAlignment(JLabel.CENTER);
        addProduct.setVerticalAlignment(JLabel.CENTER);
        addProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addProduct.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagementAdd());
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
        
        // JComboBox - user role
        productType = new JComboBox(productCategory);
        productType.setFont(new Font("MV Boli",Font.PLAIN,13));
        productType.setPreferredSize(new Dimension(153,48));
        
        // JPanel - search panel (add, search, filter)
        search_panel = new JPanel();
        search_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        search_panel.setPreferredSize(new Dimension(1080, 85));
        search_panel.setBackground(Color.WHITE);
        search_panel.add(addProduct);
        search_panel.add(search_textfield);
        search_panel.add(search_btn);
        search_panel.add(productType);
        
        
        // JButton[] - users
        // create temp user 
        for (int i = 0; i < 9; i++){
            product.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
            product.add("product name");
            product.add("RM 10.50");
            allProducts.add(product);
        }
        
        products = new JButton[allProducts.size()];
        
        for (int i = 0; i < allProducts.size();i++){
            
            // image icon rescale
            ImageIcon originalIcon = new ImageIcon(allProducts.get(i).get(0));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            
            // button (user) 
            products[i] = new JButton(scaledIcon);
            products[i].setText(allProducts.get(i).get(1) + " " + allProducts.get(i).get(2));
            products[i].setPreferredSize(new Dimension(202,247));
            products[i].setOpaque(false);
            products[i].setBorder(BorderFactory.createEmptyBorder());
            products[i].setHorizontalAlignment(JLabel.CENTER);
            products[i].setVerticalAlignment(JLabel.CENTER);
            products[i].setHorizontalTextPosition(JLabel.CENTER);
            products[i].setVerticalTextPosition(JLabel.BOTTOM);
            products[i].setIconTextGap(15);
            products[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            products[i].addActionListener(e -> {
                frame.replacePanel(new UI_ProductManagementProduct());
            });
        }
        
        // Panel for users
        float rowCount = (float)allProducts.size()/3;
        int product_panel_height = 290 * (int)Math.ceil(rowCount);
        
        product_panel = new JPanel();
        product_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
        product_panel.setPreferredSize(new Dimension(700, product_panel_height));
        product_panel.setBackground(Color.WHITE);
        
        for (JButton theProduct : products){
            product_panel.add(theProduct);
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
