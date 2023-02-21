/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Delivery;

import static com.mycompany.oodms.OODMS_Main.frame;
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
public class UI_OnGoing extends JPanel{
    UI_Header header;
    JLabel title;
    ImageIcon truck = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/truck.png");
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    ImageIcon grayCircle2 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    JButton upComingPage;
    JButton onGoingPage;
    JButton completedPage;
    JButton orderDelivered;
    
    boolean isSelected = false;
    
    public UI_OnGoing() {
        
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
        upComingPage.setIcon(grayCircle1);
        upComingPage.setBorder(BorderFactory.createEmptyBorder());
        upComingPage.setHorizontalTextPosition(JLabel.CENTER);
        upComingPage.setVerticalTextPosition(JLabel.CENTER);
        upComingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        upComingPage.setBounds(563,135,90,90);
        upComingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        upComingPage.setForeground(Color.GRAY);
        upComingPage.addActionListener(e -> {
                frame.replacePanel(new UI_UpComing());
        });
        
        // JButton - on going (direct to upcoming page)
        onGoingPage = new JButton("on going");
        onGoingPage.setIcon(orangeCircle);
        onGoingPage.setBorder(BorderFactory.createEmptyBorder());
        onGoingPage.setHorizontalTextPosition(JLabel.CENTER);
        onGoingPage.setVerticalTextPosition(JLabel.CENTER);
        onGoingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onGoingPage.setBounds(683,135,90,90);
        onGoingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        onGoingPage.setForeground(Color.WHITE);
        
        // JButton - completed (direct to upcoming page)
        completedPage = new JButton("completed");
        completedPage.setIcon(grayCircle2);
        completedPage.setBorder(BorderFactory.createEmptyBorder());
        completedPage.setHorizontalTextPosition(JLabel.CENTER);
        completedPage.setVerticalTextPosition(JLabel.CENTER);
        completedPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        completedPage.setBounds(803,135,90,90);
        completedPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        completedPage.setForeground(Color.GRAY);
        completedPage.addActionListener(e -> {
                frame.replacePanel(new UI_Completed());
        });
        
        
        
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
            
            // to make JTable uneditable accept the checkbox
            @Override 
            public boolean isCellEditable(int row, int column) 
            {
                // Make column other than checkbox read-only
                return column == 0;
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
        
        
        
        // JButton - order delivered
        orderDelivered = new JButton("Delivered");
        orderDelivered.setBorder(BorderFactory.createEmptyBorder());
        orderDelivered.setHorizontalTextPosition(JLabel.CENTER);
        orderDelivered.setVerticalTextPosition(JLabel.CENTER);
        orderDelivered.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        orderDelivered.setBackground(new Color(255, 151, 98, 255));
        orderDelivered.setOpaque(true);
        orderDelivered.setBounds(778,545,115,45);
        orderDelivered.setFont(new Font("MV Boli",Font.PLAIN,12));
        orderDelivered.setForeground(Color.WHITE);
        orderDelivered.addActionListener(e -> {
            
            // deliver product confirmation
            int checkoutConfirmation = JOptionPane.showOptionDialog(null, "Confirm to deliver?", "Confirmation",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (checkoutConfirmation == JOptionPane.OK_OPTION) {
                
                // User clicked the "OK" button
                for (int i = 0; i < cart.getRowCount(); i++)
                {
                    if ((boolean)cart.getValueAt(i, 0) == true)
                    {
                        System.out.println(cart.getValueAt(i, 1) + " is true");
                    }
                }
                
                // if something is picked (get the size of arraylist of what)
                
                
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
        this.add(orderDelivered);
        
    }
    
}
