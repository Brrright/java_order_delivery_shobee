/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Admin;

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
import javax.swing.JComboBox;
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
public class UI_AdminDelivery extends JPanel{
    UI_Header header;
    JLabel title;
    ImageIcon truck = new ImageIcon("src/main/java/com/mycompany/oodms/ui/UI_Delivery/pictures/truck.png");
    
    JLabel deliveryMan_header;
    JComboBox deliveryMan;
    JButton assignOrder;
    
    public UI_AdminDelivery() {
        
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
        
        // JLabel - deliveryMan header
        deliveryMan_header = new JLabel("Assign order to");
        deliveryMan_header.setBounds(580,123,150,54);
        deliveryMan_header.setFont(new Font("MV Boli",Font.PLAIN,13));
        deliveryMan_header.setHorizontalAlignment(JLabel.CENTER);
        deliveryMan_header.setVerticalAlignment(JLabel.BOTTOM);
        
        // JComboBox - deliveryman
        String[] deliveryman = {"Deliveryman 1","Deliveryman 2", "Deliveryman 3"};
        deliveryMan = new JComboBox(deliveryman);
        deliveryMan.setBounds(598,180,300,35);
        
        
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
        scrollPane.setBounds(193,237,700,290);
        
        
        // JButton - assign order
        assignOrder = new JButton("Pack & Assign order");
        assignOrder.setBorder(BorderFactory.createEmptyBorder());
        assignOrder.setHorizontalTextPosition(JLabel.CENTER);
        assignOrder.setVerticalTextPosition(JLabel.CENTER);
        assignOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        assignOrder.setBackground(new Color(255, 151, 98, 255));
        assignOrder.setOpaque(true);
        assignOrder.setBounds(745,545,148,45);
        assignOrder.setFont(new Font("MV Boli",Font.PLAIN,12));
        assignOrder.setForeground(Color.WHITE);
        assignOrder.addActionListener(e -> {
            
            
            
            // assign delivery man
            int checkoutConfirmation = JOptionPane.showOptionDialog(null, "Confirm to assign orders to " + deliveryMan.getSelectedItem() + "?", "Confirmation",
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
        this.add(deliveryMan_header);
        this.add(deliveryMan);
        
        this.add(scrollPane);
        this.add(assignOrder);
        
    }
    
}
