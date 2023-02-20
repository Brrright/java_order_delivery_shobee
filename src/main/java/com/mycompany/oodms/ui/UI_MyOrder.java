/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui;

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
public class UI_MyOrder extends JPanel{
  UI_Header heading = new UI_Header();
  
  JScrollPane scrollPane;
  
  JPanel tittle_panel;
  JLabel title;
  
  ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/orangecircle.png");
  JPanel buttons_panel;
  JPanel orderStatus_btns;
  JButton packing;
  JButton packed;
  JButton delivering;
  JButton delivered;
  
  // orders
  ArrayList<ArrayList<String>> tempOrder = new ArrayList<>();
  ArrayList<String> tempContainer = new ArrayList<>();
  JPanel orders_panel;
  JButton[] orders; // with product image, name and purchased quantity
  
  public UI_MyOrder() {
    
      // JLabel - title
      title = new JLabel("My order");
      title.setFont(new Font("MV Boli",Font.BOLD,30));
      title.setPreferredSize(new Dimension(1080,150));
      title.setHorizontalAlignment(JLabel.CENTER);
      title.setHorizontalTextPosition(JLabel.CENTER);
      
      // JButton - packing
      packing = new JButton("Packing");
      packing.setForeground(Color.WHITE);
      packing.setIcon(orangeCircle);
      packing.setFocusPainted(false);
      packing.setBorderPainted(false);
      packing.setFont(new Font("MV Boli",Font.PLAIN,15));
      packing.setPreferredSize(new Dimension(153,153));
      packing.setHorizontalAlignment(JLabel.CENTER);
      packing.setVerticalAlignment(JLabel.CENTER);
      packing.setHorizontalTextPosition(JLabel.CENTER);
      packing.setVerticalTextPosition(JLabel.CENTER);
      
      // JButton - packed
      packed = new JButton("Packed");
      packed.setForeground(Color.WHITE);
      packed.setIcon(orangeCircle);
      packed.setFocusPainted(false);
      packed.setBorderPainted(false);
      packed.setFont(new Font("MV Boli",Font.PLAIN,15));
      packed.setPreferredSize(new Dimension(153,153));
      packed.setHorizontalAlignment(JLabel.CENTER);
      packed.setVerticalAlignment(JLabel.CENTER);
      packed.setHorizontalTextPosition(JLabel.CENTER);
      packed.setVerticalTextPosition(JLabel.CENTER);
      
      // JButton - delivering
      delivering = new JButton("Delivering");
      delivering.setForeground(Color.WHITE);
      delivering.setIcon(orangeCircle);
      delivering.setFocusPainted(false);
      delivering.setBorderPainted(false);
      delivering.setFont(new Font("MV Boli",Font.PLAIN,15));
      delivering.setPreferredSize(new Dimension(153,153));
      delivering.setHorizontalAlignment(JLabel.CENTER);
      delivering.setVerticalAlignment(JLabel.CENTER);
      delivering.setHorizontalTextPosition(JLabel.CENTER);
      delivering.setVerticalTextPosition(JLabel.CENTER);
      
      // JButton - delivered
      delivered = new JButton("Delivered");
      delivered.setForeground(Color.WHITE);
      delivered.setIcon(orangeCircle);
      delivered.setFocusPainted(false);
      delivered.setBorderPainted(false);
      delivered.setFont(new Font("MV Boli",Font.PLAIN,15));
      delivered.setPreferredSize(new Dimension(153,153));
      delivered.setHorizontalAlignment(JLabel.CENTER);
      delivered.setVerticalAlignment(JLabel.CENTER);
      delivered.setHorizontalTextPosition(JLabel.CENTER);
      delivered.setVerticalTextPosition(JLabel.CENTER);
      
      
      // JPanel - orderStatus (flowlayout)
      orderStatus_btns = new JPanel();
      orderStatus_btns.setPreferredSize(new Dimension(1080,220));
      orderStatus_btns.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
      orderStatus_btns.setBackground(Color.WHITE);
      
      orderStatus_btns.add(packing);
      orderStatus_btns.add(packed);
      orderStatus_btns.add(delivering);
      orderStatus_btns.add(delivered);
      
      
      // order generator
      int orderAmt = 5;
      for (int i = 0; i < orderAmt; i++) {
          tempContainer.add("Product Name");
          tempContainer.add("1/1/2023");
          tempContainer.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
          tempOrder.add(tempContainer);
      }
      
      
      // orders
      orders = new JButton[tempOrder.size()];
      for (int i = 0; i < tempOrder.size(); i++) {
          
          orders[i] = new JButton();
          
          ImageIcon productImg = new ImageIcon(tempOrder.get(i).get(2));

          Image image = productImg.getImage();
          Image scaleImage = image.getScaledInstance(154, 174, Image.SCALE_SMOOTH);
          ImageIcon scaleImageIcon = new ImageIcon(scaleImage);
          
          orders[i].setIcon(scaleImageIcon);
          orders[i].setText("<html>"+ tempOrder.get(i).get(0) + "<br><br>Purchased on: " + tempOrder.get(i).get(1) + "</html>");
          orders[i].setPreferredSize(new Dimension(737,202));
          orders[i].setFocusPainted(false);
          orders[i].setHorizontalAlignment(JLabel.LEFT);
          orders[i].setVerticalAlignment(JLabel.CENTER);
          orders[i].setHorizontalTextPosition(JLabel.RIGHT);
          orders[i].setVerticalTextPosition(JLabel.TOP);
          orders[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
          orders[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          orders[i].setIconTextGap(30);
          orders[i].setFont(new Font("MV Boli",Font.PLAIN,15));
      }
      
        
        orders_panel = new JPanel();
        orders_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
        orders_panel.setPreferredSize(new Dimension(780, tempOrder.size() * (210 + 20) + 30)); // 210 = order height, 20 = gap height
        orders_panel.setBackground(Color.WHITE);
        
        for (JButton order : orders){
            orders_panel.add(order);
        }
      
      
      // JPanel - buttons_panel
      buttons_panel = new JPanel();
      buttons_panel.setLayout(new BorderLayout());
      buttons_panel.setBackground(Color.WHITE);
      buttons_panel.add(orderStatus_btns, BorderLayout.NORTH);
      buttons_panel.add(orders_panel, BorderLayout.CENTER);
      
      
      
      // JPanel - title panel
      tittle_panel = new JPanel();
      tittle_panel.setLayout(new BorderLayout());
      tittle_panel.setBackground(Color.WHITE);
      tittle_panel.add(title, BorderLayout.NORTH);
      tittle_panel.add(buttons_panel, BorderLayout.CENTER);
      
      // JScrollPane - main pane
      scrollPane = new JScrollPane(tittle_panel);
      scrollPane.setBorder(BorderFactory.createEmptyBorder());
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      
      
      // JPanel - this
      this.setBackground(Color.WHITE);
      this.setLayout(new BorderLayout());
      this.add(heading, BorderLayout.NORTH);
      this.add(scrollPane, BorderLayout.CENTER);
 }
    
}
