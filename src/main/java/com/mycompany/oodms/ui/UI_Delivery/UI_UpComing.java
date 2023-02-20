/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Delivery;

import com.mycompany.oodms.ui.UI_Header;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author hw
 */
public class UI_UpComing extends JPanel{
    UI_Header header;
    JLabel title;
    ImageIcon truck = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/truck.png");
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    ImageIcon grayCircle2 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    JButton upComingPage;
    JButton onGoingPage;
    JButton completedPage;
    JButton delete;
    JButton checkout;
    
    public UI_UpComing() {
        
        // required date
        // 1. Cart object list of specific user
        ArrayList<ArrayList<String>> inCart = new ArrayList<>();
        ArrayList<String> inCartSingleProduct = new ArrayList<>();
        
        // create temp data
        for (int i = 0; i < 10; i++) {
            inCartSingleProduct.add("product name"); // product name
            inCartSingleProduct.add("3"); // quantity
            inCartSingleProduct.add("RM 3.50"); // price
            inCart.add(inCartSingleProduct);
        }
        
        
        header = new UI_Header();
        header.setBounds(0,0,1080,50);
        
        // JLabel - title
        title = new JLabel(truck);
        title.setBounds(193,152,98,54);
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setPreferredSize(new Dimension(1080,150));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.BOTTOM);
        
        
        // JButton - upComingPage (direct to upcoming page)
        upComingPage = new JButton("up coming");
        upComingPage.setIcon(orangeCircle);
        upComingPage.setBorder(BorderFactory.createEmptyBorder());
        upComingPage.setHorizontalTextPosition(JLabel.CENTER);
        upComingPage.setVerticalTextPosition(JLabel.CENTER);
        upComingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        upComingPage.setBounds(563,135,90,90);
        upComingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        upComingPage.setForeground(Color.WHITE);
        
        // JButton - completed (direct to upcoming page)
        onGoingPage = new JButton("on going");
        onGoingPage.setIcon(grayCircle1);
        onGoingPage.setBorder(BorderFactory.createEmptyBorder());
        onGoingPage.setHorizontalTextPosition(JLabel.CENTER);
        onGoingPage.setVerticalTextPosition(JLabel.CENTER);
        onGoingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onGoingPage.setBounds(683,135,90,90);
        onGoingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        onGoingPage.setForeground(Color.GRAY);
        
        // JButton - upComingPage (direct to upcoming page)
        completedPage = new JButton("completed");
        completedPage.setIcon(grayCircle2);
        completedPage.setBorder(BorderFactory.createEmptyBorder());
        completedPage.setHorizontalTextPosition(JLabel.CENTER);
        completedPage.setVerticalTextPosition(JLabel.CENTER);
        completedPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        completedPage.setBounds(803,135,90,90);
        completedPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        completedPage.setForeground(Color.GRAY);
        
        
        
        // set JTable model
        DefaultTableModel model = new DefaultTableModel(){
            public Class<?> getColumnClass(int column)
            {
                switch(column)
                {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        
        
        // JTable - cart
        JTable cart = new JTable();
        cart.setModel(model);
        
        model.addColumn("Select");
        model.addColumn("No");
        model.addColumn("Product");
        model.addColumn("Qty");
        model.addColumn("Price");

        // set cart table row
        
        for (int i = 0; i < inCart.size(); i++) {
            model.addRow(new Object[0]);
            model.setValueAt(false,i,0);
            model.setValueAt(i+1, i, 1);
            model.setValueAt(inCart.get(i).get(0), i, 2);
            model.setValueAt(inCart.get(i).get(1), i, 3);
            model.setValueAt(inCart.get(i).get(2), i, 4);
        }
        
        // set column size
        TableColumn selectColumn = cart.getColumnModel().getColumn(0);
        selectColumn.setPreferredWidth(5);
        selectColumn.setResizable(false);
        
        TableColumn noColumn = cart.getColumnModel().getColumn(1);
        noColumn.setPreferredWidth(5);
        noColumn.setResizable(false);
        
        TableColumn productColumn = cart.getColumnModel().getColumn(2);
        productColumn.setPreferredWidth(400);
        productColumn.setResizable(false);
        
        // scrollpane for JTable
        JScrollPane scrollPane = new JScrollPane(cart);
        scrollPane.setBounds(193,245,700,290);
        
        
                
        // JButton - delete
        delete = new JButton("Remove");
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setHorizontalTextPosition(JLabel.CENTER);
        delete.setVerticalTextPosition(JLabel.CENTER);
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.setBackground(new Color(255, 151, 98, 255));
        delete.setOpaque(true);
        delete.setBounds(655,545,115,45);
        delete.setFont(new Font("MV Boli",Font.PLAIN,12));
        delete.setForeground(Color.WHITE);
        delete.addActionListener(e -> {
            int removeConfirmation = JOptionPane.showOptionDialog(null, "Confirm to remove selected product?", "Confirmation",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (removeConfirmation == JOptionPane.OK_OPTION) {
                // User clicked the "OK" button
                // get the selected product
                
                for (int i = 0; i < cart.getRowCount(); i++)
                {
                    if ((boolean)cart.getValueAt(i, 0) == true)
                    {
                        System.out.print(cart.getValueAt(i, 1) + " is ture");
                    }
                }
                
                // remove selected product and update to the txt file
                // remove cart panel and redirect to the same panel with updated cart
                
                System.out.println("item removed");
            }

        });
        
        
        // JButton - Checkout
        checkout = new JButton("Checkout");
        checkout.setBorder(BorderFactory.createEmptyBorder());
        checkout.setHorizontalTextPosition(JLabel.CENTER);
        checkout.setVerticalTextPosition(JLabel.CENTER);
        checkout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkout.setBackground(new Color(255, 151, 98, 255));
        checkout.setOpaque(true);
        checkout.setBounds(778,545,115,45);
        checkout.setFont(new Font("MV Boli",Font.PLAIN,12));
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(e -> {
            
            // checkout confirmation
            int checkoutConfirmation = JOptionPane.showOptionDialog(null, "Confirm to checkout?", "Confirmation",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (checkoutConfirmation == JOptionPane.OK_OPTION) {
                // User clicked the "OK" button
                for (int i = 0; i < cart.getRowCount(); i++)
                {
                    if ((boolean)cart.getValueAt(i, 0) == true)
                    {
                        System.out.print(cart.getValueAt(i, 1) + " is ture");
                    }
                }
                // get the selected product
                //direct to checkout page
                System.out.println("go to checkout page");
            }

        });
        
       
        // this
        this.setSize(1080, 768);
        this.setBackground(Color.white);
        this.setLayout(null);
        
        
        this.add(header);
        this.add(title);
        this.add(upComingPage);
        this.add(onGoingPage);
        this.add(completedPage);
        
        this.add(scrollPane);
        this.add(delete);
        this.add(checkout);
        
    }
    
}
