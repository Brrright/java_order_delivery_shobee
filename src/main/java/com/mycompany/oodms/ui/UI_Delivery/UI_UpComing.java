/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Delivery;

import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStaff;
import com.mycompany.oodms.DeliveryStatus;
import com.mycompany.oodms.OODMS_Main;
import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.Order;
import com.mycompany.oodms.OrderItem;
import com.mycompany.oodms.Services.DeliveryService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
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
    
    JLabel orderInfo;
    
    JButton upComingPage;
    JButton onGoingPage;
    JButton completedPage;
    JButton packOrder;
    
    public ArrayList<Delivery> initialize_delivery_data(){
        return DeliveryService.getDeliveryService().getDeliveryForStaffUpComing((DeliveryStaff) OODMS_Main.current_user);
    }
    
    public ArrayList<Order> initialize_order_data(ArrayList<Delivery>deliveries){
        return OrderService.getOrderService().getOrdersForDeliveryStaff(deliveries, (DeliveryStaff) OODMS_Main.current_user);
    }
    
    public ArrayList<OrderItem> initialize_order_item_data(ArrayList<Order> orders){
        return OrderItemService.getOrderItemService().getOrderItem(orders);
    }
    
    public UI_UpComing() {
        ArrayList<Delivery> deliveries = initialize_delivery_data();
        ArrayList<Order> orders;
        ArrayList<OrderItem> orderItems;
        String orderItemString = "<html>";
        if(deliveries.isEmpty()){
            System.out.println("deliveries is empty in UI UPComing");
            orders = new ArrayList<Order>();
            orderItems = new ArrayList<OrderItem>();
        }else{
            orders = initialize_order_data(deliveries);
            orderItems = initialize_order_item_data(orders);
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
        
        // JButton - on going (direct to ongoing page)
        onGoingPage = new JButton("on going");
        onGoingPage.setIcon(grayCircle1);
        onGoingPage.setBorder(BorderFactory.createEmptyBorder());
        onGoingPage.setHorizontalTextPosition(JLabel.CENTER);
        onGoingPage.setVerticalTextPosition(JLabel.CENTER);
        onGoingPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onGoingPage.setBounds(683,135,90,90);
        onGoingPage.setFont(new Font("MV Boli",Font.PLAIN,12));
        onGoingPage.setForeground(Color.GRAY);
        onGoingPage.addActionListener(e -> {
            frame.replacePanel(new UI_OnGoing());
        });
        
        // JButton - completed (direct to completed page)
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
        };
        
        
        // JTable - cart
        JTable cart = new JTable();
        cart.setModel(model);
        
        model.addColumn("Select");
        model.addColumn("DeliveryID");
        model.addColumn("OrderID");
        model.addColumn("City");
        model.addColumn("Status");
//        model.addColumn("Address");
//        model.addColumn("Product ID and Quantity");
        
        // set order item string
//        for(OrderItem item : orderItems){
//            orderItemString = orderItemString + "ID: " +item.getProduct().getProductID()+ " [" +item.getProduct().getProductName() + "] x " + item.getQuantity() + "<br>";
//            orderItemString = orderItemString + "[ID: " +item.getProduct().getProductID()+ " | " +  item.getProduct().getProductName() + "] x " + item.getQuantity() + "<br>";
//        }
//        orderItemString = orderItemString + "</html>";
        
        // set cart table row
        
        for (int i = 0; i < deliveries.size(); i++) {
            Delivery delivery = deliveries.get(i);
            
            model.addRow(new Object[0]);
            model.setValueAt(false,i,0);
            model.setValueAt(deliveries.get(i).getDeliveryID(), i, 1);
            model.setValueAt(deliveries.get(i).getOrder().getOrderID(), i, 2);
            model.setValueAt(deliveries.get(i).getAddress().getCity(), i, 3);
            model.setValueAt(deliveries.get(i).getStatus(), i, 4);
 //            model.setValueAt(orderItemString, i, 3);
//            model.setValueAt(delivery.getAddress().toString(), i, 5);
        }
        
        // set column size
//        cart.setRowHeight(30);
        TableColumn selectColumn = cart.getColumnModel().getColumn(0);
        selectColumn.setPreferredWidth(5);
        selectColumn.setResizable(false);
        
        TableColumn deliveryIDColumn = cart.getColumnModel().getColumn(1);
        deliveryIDColumn.setPreferredWidth(10);
        deliveryIDColumn.setResizable(false);
        
        TableColumn orderIDColumn = cart.getColumnModel().getColumn(2);
        orderIDColumn.setPreferredWidth(10);
        orderIDColumn.setResizable(false);

        TableColumn statusColumn = cart.getColumnModel().getColumn(2);
        statusColumn.setPreferredWidth(10);
        statusColumn.setResizable(false);
        
        TableColumn addressColumn = cart.getColumnModel().getColumn(2);
        addressColumn.setPreferredWidth(10);
        addressColumn.setResizable(false);
        
        // scrollpane for JTable
        JScrollPane scrollPane = new JScrollPane(cart);
        scrollPane.setBounds(193,245,400,290);
        
        
        // selected order information panel
        orderInfo = new JLabel();
        orderInfo.setBackground(Color.LIGHT_GRAY);
        orderInfo.setOpaque(true);
        orderInfo.setBounds(593,245,300,290); 
        
        // JButton - Checkout
        packOrder = new JButton("Pack Order");
        packOrder.setBorder(BorderFactory.createEmptyBorder());
        packOrder.setHorizontalTextPosition(JLabel.CENTER);
        packOrder.setVerticalTextPosition(JLabel.CENTER);
        packOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        packOrder.setBackground(new Color(255, 151, 98, 255));
        packOrder.setOpaque(true);
        packOrder.setBounds(778,545,115,45);
        packOrder.setFont(new Font("MV Boli",Font.PLAIN,12));
        packOrder.setForeground(Color.WHITE);
        packOrder.addActionListener(e -> {
            if(!isSelected(cart)){
                JOptionPane.showMessageDialog(null, "Please select a product.", "Nothing selected", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
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
        this.add(orderInfo);
        this.add(packOrder);
    }
    
    public boolean isSelected(JTable cart){
        for (int i = 0; i < cart.getRowCount(); i++)
        {
            if ((boolean)cart.getValueAt(i, 0) == true)
            {
                return true;
            }
        }
        return false;
    }
}
