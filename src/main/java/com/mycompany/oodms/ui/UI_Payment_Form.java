/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.oodms.ui;

import com.mycompany.oodms.Address;
import com.mycompany.oodms.CartItem;
import com.mycompany.oodms.Delivery;
import com.mycompany.oodms.DeliveryStatus;
import com.mycompany.oodms.FileRelatedClass.FileHandler;
import com.mycompany.oodms.FileRelatedClass.FileName;
import com.mycompany.oodms.Member;
import com.mycompany.oodms.OODMS_Main;
import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.Order;
import com.mycompany.oodms.OrderItem;
import com.mycompany.oodms.Product;
import com.mycompany.oodms.Services.AddressService;
import com.mycompany.oodms.Services.CartItemService;
import com.mycompany.oodms.Services.DeliveryService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
import com.mycompany.oodms.Services.ProductService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mingl
 */
public class UI_Payment_Form extends javax.swing.JPanel {
    double total_price;
    Address address;
    ArrayList<CartItem> items;
    /**
     * Creates new form UI_Payment_Form
     */
    public UI_Payment_Form(double total_price, Address address, ArrayList<CartItem> items) {
        this.total_price = total_price;
        this.address = address;
        this.items = items;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaymentTitle = new javax.swing.JLabel();
        cardnoTitle = new javax.swing.JLabel();
        cardNoTF = new javax.swing.JTextField();
        expDateLabel = new javax.swing.JLabel();
        expDateTF = new javax.swing.JTextField();
        cvvNoLabel = new javax.swing.JLabel();
        ccvTF = new javax.swing.JTextField();
        confirmBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1080, 768));
        setMinimumSize(new java.awt.Dimension(1080, 768));
        setPreferredSize(new java.awt.Dimension(1080, 768));

        PaymentTitle.setBackground(new java.awt.Color(0, 0, 0));
        PaymentTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PaymentTitle.setForeground(new java.awt.Color(0, 0, 0));
        PaymentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PaymentTitle.setText("Payment");

        cardnoTitle.setBackground(new java.awt.Color(0, 0, 0));
        cardnoTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cardnoTitle.setForeground(new java.awt.Color(0, 0, 0));
        cardnoTitle.setText("CARD NUMBER");

        cardNoTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cardNoTF.setForeground(new java.awt.Color(0, 0, 0));

        expDateLabel.setBackground(new java.awt.Color(0, 0, 0));
        expDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        expDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        expDateLabel.setText("EXP DATE");

        expDateTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        expDateTF.setForeground(new java.awt.Color(0, 0, 0));

        cvvNoLabel.setBackground(new java.awt.Color(0, 0, 0));
        cvvNoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cvvNoLabel.setForeground(new java.awt.Color(0, 0, 0));
        cvvNoLabel.setText("CVV / CVC");

        ccvTF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ccvTF.setForeground(new java.awt.Color(0, 0, 0));

        confirmBtn.setBackground(new java.awt.Color(255, 204, 153));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(0, 0, 0));
        confirmBtn.setText("Confirm Payment");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setForeground(new java.awt.Color(51, 51, 51));
        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardnoTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardNoTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ccvTF, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cvvNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(130, 130, 130))))
            .addGroup(layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(PaymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaymentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardnoTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(expDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cvvNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccvTF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        OODMS_Main.frame.replacePanel(OODMS_Main.previous_panel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        if(cardNoTF.getText().isBlank() || ccvTF.getText().isBlank() || expDateTF.getText().isBlank()){
            JOptionPane.showMessageDialog(frame,"Please enter valid input","Oops",JOptionPane.WARNING_MESSAGE);
            return;
        }        
        payment(this.items);
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void payment(ArrayList<CartItem> items){
        FileHandler order_file = new FileHandler(FileName.ORDER);
        FileHandler delivery_file = new FileHandler(FileName.DELIVERY);
        // turn payment into order
        Order order = new Order(order_file.GenerateID(), 
                LocalDateTime.now(), 
                this.total_price, 
                this.total_price, 0, 
                (Member) OODMS_Main.current_user, 
                this.address);
        OrderService.getOrderService().addOrder(order);
        // turn cart item into order item, remove cart item
        // add delivery record
        this.address = AddressService.getAddressService().getAddressByMemberId(
                OODMS_Main.current_user.getID());
        for(CartItem item :  items) {
            Product product  = ProductService.getProductService().getProduct(item.getProduct().getProductID());
            product.setProductStock(product.getStockQty() - 1);
            ProductService.getProductService().updateProduct(product);
            OrderItem order_item = new OrderItem(
                    item.getQuantity(), 
                    item.getProduct().getProductPrice(), 
                    item.getProduct(), order);
            OrderItemService.getOrderItemService().addOrderItem(order_item);
            CartItemService.getCartItemService().deleteCartItem(item);
            Delivery delivery = new Delivery(DeliveryService.getDeliveryService().getNewDeliveryID(), 
                    order , LocalDateTime.now(), 
                    null, DeliveryStatus.PACKING, 
                    -1,address , (Member) OODMS_Main.current_user);
            DeliveryService.getDeliveryService().addDelivery(delivery);
        }
        OODMS_Main.frame.replacePanel(new UI_SuccessPayment());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PaymentTitle;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cardNoTF;
    private javax.swing.JLabel cardnoTitle;
    private javax.swing.JTextField ccvTF;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel cvvNoLabel;
    private javax.swing.JLabel expDateLabel;
    private javax.swing.JTextField expDateTF;
    // End of variables declaration//GEN-END:variables
}
