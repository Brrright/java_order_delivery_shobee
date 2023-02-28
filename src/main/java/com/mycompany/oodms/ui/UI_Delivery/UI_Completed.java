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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author hw
 */
public class UI_Completed extends JPanel{
    UI_Header header;
    JLabel title;
    ImageIcon truck = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/truck.png");
    ImageIcon orangeCircle = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/orangeCircle.png");
    ImageIcon grayCircle1 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    ImageIcon grayCircle2 = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/grayCircle.png");
    
    JLabel orderInfo;
    
    JButton upComingPage;
    JButton onGoingPage;
    JButton completedPage;
   
    public UI_Completed() {
        
        // required date
        // 1. Cart object list of specific user
        ArrayList<ArrayList<String>> inCart = new ArrayList<>();
        ArrayList<String> inCartSingleProduct = new ArrayList<>();
        
        // create temp data
        for (int i = 0; i < 100; i++) {
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
        upComingPage.setOpaque(false);
        upComingPage.setFocusPainted(false);
        upComingPage.setContentAreaFilled(false);
        upComingPage.setOpaque(false);

        upComingPage.addActionListener(e -> {
                frame.replacePanel(new UI_UpComing());
        });
        
        // JButton - completed (direct to upcoming page)
        onGoingPage = new JButton("on going");
        onGoingPage.setIcon(grayCircle2);
        onGoingPage.setBorder(BorderFactory.createEmptyBorder());
        onGoingPage.setHorizontalTextPosition(JLabel.CENTER);
        onGoingPage.setVerticalTextPosition(JLabel.CENTER);
        onGoingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onGoingPage.setBounds(683,135,90,90);
        onGoingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        onGoingPage.setForeground(Color.GRAY);
        onGoingPage.setOpaque(false);
        onGoingPage.setFocusPainted(false);
        onGoingPage.setContentAreaFilled(false);
        onGoingPage.setOpaque(false);
        onGoingPage.addActionListener(e -> {
                frame.replacePanel(new UI_OnGoing());
        });
        
        // JButton - upComingPage (direct to upcoming page)
        completedPage = new JButton("completed");
        completedPage.setIcon(orangeCircle);
        completedPage.setBorder(BorderFactory.createEmptyBorder());
        completedPage.setHorizontalTextPosition(JLabel.CENTER);
        completedPage.setVerticalTextPosition(JLabel.CENTER);
        completedPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        completedPage.setBounds(803,135,90,90);
        completedPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        completedPage.setForeground(Color.WHITE);
        completedPage.setOpaque(false);
        completedPage.setFocusPainted(false);
        completedPage.setContentAreaFilled(false);
        completedPage.setOpaque(false);

        
        
        
        // set JTable model
        DefaultTableModel model = new DefaultTableModel(){
            public Class<?> getColumnClass(int column)
            {
                // to set the data type of each column (mainly for the boolean - checkbox)
                switch(column)
                {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
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
                return false;
            }
        };
        
        
        // JTable - cart
        JTable cart = new JTable();
        cart.setModel(model);
        cart.getTableHeader().setReorderingAllowed(false);
        ListSelectionModel selectionModel = cart.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = cart.getSelectedRow();
                if (selectedRow != -1) {
                    // get data of selected row from table (base on table column index)
                    String deliveryId_display = String.valueOf(cart.getValueAt(selectedRow, 0));
                    String orderId_display = String.valueOf(cart.getValueAt(selectedRow, 1));
                    String city_display = String.valueOf(cart.getValueAt(selectedRow, 2));
                    String status_display = String.valueOf(cart.getValueAt(selectedRow, 3));
                   
                    // set text to the JLabel
                    orderInfo.setText("<html>Delivery ID : " + deliveryId_display + 
                            "<br> Order ID : " + orderId_display + 
                            "<br> City : " + city_display + 
                            "<br> Status : " + status_display + 
                            "<br> Products : ..." + 
                            "</html>");
                }
            }
        });
        
        model.addColumn("No");
        model.addColumn("Product");
        model.addColumn("Qty");
        model.addColumn("Price");

        // set cart table row
        
        for (int i = 0; i < inCart.size(); i++) {
            model.addRow(new Object[0]);
            model.setValueAt(i+1, i, 0);
            model.setValueAt(inCart.get(i).get(0), i, 1);
            model.setValueAt(inCart.get(i).get(1), i, 2);
            model.setValueAt(inCart.get(i).get(2), i, 3);
        }
        
        // set column size (if nessesary)
        //        TableColumn selectColumn = cart.getColumnModel().getColumn(0);
        //        selectColumn.setPreferredWidth(5);
        //        selectColumn.setResizable(false);

        // scrollpane for JTable
        JScrollPane scrollPane = new JScrollPane(cart);
        scrollPane.setBounds(193,245,400,290);
        
        // JLabel - selected order information label
        orderInfo = new JLabel();
        orderInfo.setBackground(Color.LIGHT_GRAY);
        orderInfo.setOpaque(true);
        orderInfo.setBounds(593,245,300,290); 
        orderInfo.setHorizontalAlignment(JLabel.LEFT);
        orderInfo.setVerticalAlignment(JLabel.TOP);
        
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
        this.add(orderInfo);
        
    }
    
}
