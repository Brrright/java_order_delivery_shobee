/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Admin;

import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.OODMS_Main;
import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.Services.DeliveryService;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
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
    
    JLabel orderInfo;
    
    JLabel deliveryMan_header;
    JComboBox deliveryMan;
    JButton assignOrder;
    
    public ArrayList<Delivery> initialize_delivery_data(){
//        return DeliveryService.getDeliveryService().getDeliveryForStaffUpComing((DeliveryStaff) OODMS_Main.current_user);
        return DeliveryService.getDeliveryService().getDeliveries(); // just to display 
    }
    
    public UI_AdminDelivery() {
        // Required data
        ArrayList<Delivery> deliveries = initialize_delivery_data();

        
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
            @Override
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
            // set column other than 0  (select) uneditable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        
        
        // JTable - cart
        JTable deliveryTable = new JTable();
        deliveryTable.setModel(model);
        deliveryTable.getTableHeader().setReorderingAllowed(false);
        ListSelectionModel selectionModel = deliveryTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = deliveryTable.getSelectedRow();
                if (selectedRow != -1) {
                    // get data of selected row from table (base on table column index)
                    String deliveryId_display = String.valueOf(deliveryTable.getValueAt(selectedRow, 1));
                    String orderId_display = String.valueOf(deliveryTable.getValueAt(selectedRow, 2));
                    String status_display = String.valueOf(deliveryTable.getValueAt(selectedRow, 4));
//                    String address = DeliveryService.getDeliveryService().getDelivery(Integer.parseInt(deliveryId_display)).getAddress().toString();
//                    ArrayList<OrderItem> tempOrderItems = OrderItemService.getOrderItemService().getOrderItems(Integer.parseInt(orderId_display));
//   
//                    String tempOrderItemString = "<html>";
//                     // set order item string
//                    for(OrderItem item : tempOrderItems){
//                            tempOrderItemString = tempOrderItemString + "<br>[ID: " +item.getProduct().getProductID()+ "]  " +  item.getProduct().getProductName() + " x " + item.getQuantity();
//                    }
//                    tempOrderItemString = tempOrderItemString + "</html>";
//
//                     set text to the JLabel
//                    orderInfo.setText("<html>Delivery ID : " + deliveryId_display + 
//                            "<br> Order ID : " + orderId_display + 
//                            "<br> Address : " + address + 
//                            "<br> Status : " + status_display + 
//                            "<br> Products : " + tempOrderItemString + 
//                            "</html>");

                    // testing (remove this)
                    orderInfo.setText(orderId_display);
                }
            }
        });
        
        model.addColumn("Select");
        model.addColumn("DeliveryID");
        model.addColumn("OrderID");
        model.addColumn("City");
        model.addColumn("Status");

        // set cart table row
        
        for (int i = 0; i < deliveries.size(); i++) {
            Delivery delivery = deliveries.get(i);
            
            model.addRow(new Object[0]);
            model.setValueAt(false,i,0);
            model.setValueAt(delivery.getDeliveryID(), i, 1);
            model.setValueAt(delivery.getOrder().getOrderID(), i, 2);
            model.setValueAt(delivery.getAddress().getCity(), i, 3);
            model.setValueAt(delivery.getStatus(), i, 4);
        }
        
        // set column size
        deliveryTable.setRowHeight(30);
        TableColumn selectColumn = deliveryTable.getColumnModel().getColumn(0);
        selectColumn.setPreferredWidth(5);
        selectColumn.setResizable(false);
        
        TableColumn deliveryIDColumn = deliveryTable.getColumnModel().getColumn(1);
        deliveryIDColumn.setPreferredWidth(10);
        deliveryIDColumn.setResizable(false);
        
        TableColumn orderIDColumn = deliveryTable.getColumnModel().getColumn(2);
        orderIDColumn.setPreferredWidth(10);
        orderIDColumn.setResizable(false);

        TableColumn statusColumn = deliveryTable.getColumnModel().getColumn(2);
        statusColumn.setPreferredWidth(10);
        statusColumn.setResizable(false);
        
        TableColumn addressColumn = deliveryTable.getColumnModel().getColumn(2);
        addressColumn.setPreferredWidth(10);
        addressColumn.setResizable(false);
        
        // scrollpane for JTable
        JScrollPane scrollPane = new JScrollPane(deliveryTable);
        scrollPane.setBounds(193,245,400,290);
        
        // JLabel - selected order information label
        orderInfo = new JLabel("Select a row to view the details");
        orderInfo.setBackground(Color.LIGHT_GRAY);
        orderInfo.setOpaque(true);
        orderInfo.setBounds(593,245,300,290); 
        orderInfo.setHorizontalAlignment(JLabel.LEFT);
        orderInfo.setVerticalAlignment(JLabel.TOP);
        
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
                for (int i = 0; i < deliveryTable.getRowCount(); i++)
                {
                    if ((boolean)deliveryTable.getValueAt(i, 0) == true)
                    {
                        System.out.print(deliveryTable.getValueAt(i, 1) + " is ture");
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
        this.add(orderInfo);
        this.add(assignOrder);
        
    }
    
}
