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
public class UI_ReportPayments extends JPanel{
    UI_Header heading;
    
    // first section (management selection)
    JLabel generalManagementIcon_label;
    ImageIcon generalManagementIcon = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/reportIcon.png");
    
    
    JButton orderBtn;
    JButton paymentBtn;
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    
    // 2nd section (search, add, filter-customer,delivery)

    JTextField search_textfield;
    
    JButton search_btn;
    ImageIcon searchBtn = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Admin/pictures/searchBtn.png");
    
    
    // 3rd section (users)
    JButton[] reports;
    ArrayList<ArrayList<String>> allReports = new ArrayList<>();
    ArrayList<String> report = new ArrayList<>();
    
    // panels
     JPanel report_panel;
     JPanel search_panel;
     JPanel reportSelection_panel;
     
     // container
     JPanel title_container;
     JPanel selection_container;
     JPanel search_container;
     JScrollPane main_container;
     
    
    public UI_ReportPayments() {
        // heading
        heading = new UI_Header();
        
        // 1st section (management selection)
        // JLabel - general Management Icon
        generalManagementIcon_label = new JLabel(generalManagementIcon);
        generalManagementIcon_label.setPreferredSize(new Dimension(1080, 175));
        
        // JButton - Order button
        orderBtn = new JButton("Order");
        orderBtn.setIcon(grayCircle1);
        orderBtn.setBorder(BorderFactory.createEmptyBorder());
        orderBtn.setHorizontalTextPosition(JLabel.CENTER);
        orderBtn.setVerticalTextPosition(JLabel.CENTER);
        orderBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        orderBtn.setBackground(new Color(0, 0, 0, 0));
        orderBtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        orderBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        orderBtn.setForeground(Color.GRAY);
        orderBtn.addActionListener(e -> {
            frame.replacePanel(new UI_ReportOrders());
        });
        
        // JButton - payment button
        paymentBtn = new JButton("Payment");
        paymentBtn.setIcon(orangeCircle);
        paymentBtn.setHorizontalTextPosition(JLabel.CENTER);
        paymentBtn.setVerticalTextPosition(JLabel.CENTER);
        paymentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        paymentBtn.setBackground(new Color(0, 0, 0, 0));
        paymentBtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        paymentBtn.setFont(new Font("MV Boli",Font.BOLD,12));
        paymentBtn.setForeground(Color.WHITE);
        
        
        // JPanel - Management Selection panel
        reportSelection_panel = new JPanel();
        reportSelection_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        reportSelection_panel.setPreferredSize(new Dimension(1080, 150));
        reportSelection_panel.setBackground(Color.WHITE);
        reportSelection_panel.add(orderBtn);
        reportSelection_panel.add(paymentBtn);
        
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
        
        // JPanel - search panel (search)
        search_panel = new JPanel();
        search_panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
        search_panel.setPreferredSize(new Dimension(1080, 70));
        search_panel.setBackground(Color.WHITE);
        search_panel.add(search_textfield);
        search_panel.add(search_btn);
        
        // JButton[] - users
        // create temp user 
        for (int i = 0; i < 5; i++){
            report.add("PYM001");
            report.add("2/2/2022"); // order date
            report.add("23.00"); // status
//            report.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg"); // picture
            allReports.add(report);
        }
        
        reports = new JButton[allReports.size()];
        
        for (int i = 0; i < allReports.size();i++){
//            
//            ImageIcon originalIcon = new ImageIcon(allReports.get(i).get(3));
//            Image originalImage = originalIcon.getImage();
//            Image scaledImage = originalImage.getScaledInstance(105, 110, Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon = new ImageIcon(scaledImage);
//            
            // button (order)
            reports[i] = new JButton();
            reports[i].setText("<html>Payment ID : " + allReports.get(i).get(0) + "<br>Payment date : " + allReports.get(i).get(1) + "<br>Amount : RM " + allReports.get(i).get(2));
            reports[i].setPreferredSize(new Dimension(600,120));
            reports[i].setBackground(new Color(0, 0, 0, 0));
            reports[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            reports[i].setHorizontalAlignment(JLabel.LEFT);
            reports[i].setVerticalAlignment(JLabel.CENTER);
            reports[i].setHorizontalTextPosition(JLabel.RIGHT);
            reports[i].setVerticalTextPosition(JLabel.CENTER);
            reports[i].setIconTextGap(40);
            reports[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            reports[i].addActionListener(e -> {
                frame = new Main_Frame(new UI_ReportPayment());        
            });
        }
        
        // Panel for report
        int product_panel_height = (150 * allReports.size()) + 30;
        
        report_panel = new JPanel();
        report_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
        report_panel.setPreferredSize(new Dimension(700, product_panel_height));
        report_panel.setBackground(Color.WHITE);
        
        for (JButton theCategory : reports){
            report_panel.add(theCategory);
        }
        
        // third container (search container)
        search_container = new JPanel();
        search_container.setLayout(new BorderLayout());
        search_container.setBackground(Color.WHITE);
        search_container.add(search_panel, BorderLayout.NORTH);
        search_container.add(report_panel, BorderLayout.CENTER);
        
        // second container (report selection)
        selection_container = new JPanel();
        selection_container.setLayout(new BorderLayout());
        selection_container.setBackground(Color.WHITE);
        selection_container.add(reportSelection_panel, BorderLayout.NORTH);
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
