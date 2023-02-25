/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui;

import com.mycompany.oodms.Address;
import com.mycompany.oodms.CartItem;
import com.mycompany.oodms.OODMS_Main;
import com.mycompany.oodms.Services.AddressService;
import com.mycompany.oodms.Services.CartItemService;
import com.mycompany.oodms.Services.Provider.Provider_Address;
import com.mycompany.oodms.Services.Provider.Provider_Cart;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author hw
 */
public class UI_Payment extends JPanel {
    JButton back;
//    JLabel orderAmt_header;
//    JLabel cartItemLabel;
    JLabel price_header;
    JLabel price;
    JLabel shippingFee_header;
    JLabel shippingFee;
    JLabel totalPrice_header;
    JLabel totalPrice;
    JLabel payment_header;
    JLabel payment;
    JLabel billingAddress_header;
    JLabel billingAddress;
   
    JButton paymentBtn;
    ImageIcon orangeRect = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/orangeRectanger.png");


    JPanel panel;
    int member_id = OODMS_Main.current_user.getID();

    
    public Address initialize_address(){
        Provider_Address provider_address = new Provider_Address();
        return AddressService.getAddressService().getAddressByMemberId(member_id);
    }
    
    public ArrayList<CartItem> initialize_cart_item(){
        Provider_Cart provider_cart = new Provider_Cart();
        return CartItemService.getCartItemService().getCartItems(member_id);
    }
    
    public double calculateTotal(ArrayList<CartItem> cart_items) {
        double total = 0;
        for(int i = 0; i < cart_items.size(); i++){
            total += cart_items.get(i).getTotal();
        }
        return total;
    }

   
   public UI_Payment(){
        Address address = initialize_address();
        ArrayList<CartItem> cart_items = initialize_cart_item();
        double total_price = calculateTotal(cart_items);
       
       // JButton - back
       back = new JButton("< back");
       back.setBounds(76,76,65,30);
       back.setBorderPainted(false);
       back.setContentAreaFilled(false);
       back.setFont(new Font("Sarif",Font.PLAIN,15));
       back.setBorder(BorderFactory.createEmptyBorder());
       back.setFocusable(false);
       back.setCursor(new Cursor(Cursor.HAND_CURSOR));
       back.addActionListener(e -> {
            OODMS_Main.frame.replacePanel(OODMS_Main.previous_panel);
        });
       
       // JLabel - price header
       price_header = new JLabel("Price");
       price_header.setForeground(new Color(255,166,101));
       price_header.setFont(new Font("Sarif",Font.PLAIN,15));
       price_header.setBounds(206, 234, 161, 27);
       
       // JLabel - price
       price = new JLabel("RM " + total_price);
       price.setForeground(Color.BLACK);
       price.setFont(new Font("Sarif",Font.PLAIN,15));
       price.setBounds(480, 234, 430, 27);
       
       // JLabel - shipping fee header
       shippingFee_header = new JLabel("Shipping fee");
       shippingFee_header.setForeground(new Color(255,166,101));
       shippingFee_header.setFont(new Font("Sarif",Font.PLAIN,15));
       shippingFee_header.setBounds(206, 294, 161, 27);
       
       // JLabel - price
       shippingFee = new JLabel("RM 5.00");
       shippingFee.setForeground(Color.BLACK);
       shippingFee.setFont(new Font("Sarif",Font.PLAIN,15));
       shippingFee.setBounds(480, 294, 430, 27);
       
       // JLabel - Total price header
       totalPrice_header = new JLabel("Total price");
       totalPrice_header.setForeground(new Color(255,166,101));
       totalPrice_header.setFont(new Font("Sarif",Font.PLAIN,15));
       totalPrice_header.setBounds(206, 354, 161, 27);
       
       
        // JLabel - Total price
       totalPrice = new JLabel("RM " + (total_price + 5.0));
       totalPrice.setForeground(Color.BLACK);
       totalPrice.setFont(new Font("Sarif",Font.BOLD,15));
       totalPrice.setBounds(480, 354, 430, 27);
       
       // JLabel - payment method header
       payment_header = new JLabel("Payment method");
       payment_header.setForeground(new Color(255,166,101));
       payment_header.setFont(new Font("Sarif",Font.PLAIN,15));
       payment_header.setBounds(206, 414, 161, 27);
       
        // JLabel - payment method
       payment = new JLabel("credit/debit card");
       payment.setForeground(Color.BLACK);
       payment.setFont(new Font("Sarif",Font.PLAIN,15));
       payment.setBounds(480, 414, 430, 27);
       
       // JLabel - Billing address header
       billingAddress_header = new JLabel("Billing address");
       billingAddress_header.setForeground(new Color(255,166,101));
       billingAddress_header.setFont(new Font("Sarif",Font.PLAIN,15));
       billingAddress_header.setBounds(206, 474, 161, 27);
       
        // JLabel - Billing address
       billingAddress = new JLabel("<html>"+ address.getStreetName() + "\n" +address.getPostcode()+ "  " +  address.getCity()+ "\n" + address.getState()  + "</html>");
       billingAddress.setForeground(Color.BLACK);
       billingAddress.setFont(new Font("Sarif",Font.PLAIN,15));
       billingAddress.setBounds(480, 474, 380, 60);
       
       // JButton - Payment button
       paymentBtn = new JButton(orangeRect);
       paymentBtn.setText("<html>continue<br>checkout</html>");
       paymentBtn.setFont(new Font("Sarif",Font.PLAIN,12));
       paymentBtn.setForeground(Color.WHITE);
       paymentBtn.setHorizontalAlignment(JLabel.CENTER);
       paymentBtn.setVerticalAlignment(JLabel.CENTER);
       paymentBtn.setHorizontalTextPosition(JLabel.CENTER);
       paymentBtn.setVerticalTextPosition(JLabel.CENTER);
       paymentBtn.setBounds(805,600,125,58);
       paymentBtn.setBorder(BorderFactory.createEmptyBorder());
       paymentBtn.setFocusable(false);
       paymentBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       
//       for(int i = 0; i < cart_items.size(); i++) {
//        // JLabel - cart item header
//       orderAmt_header = new JLabel("Product");
//       orderAmt_header.setForeground(new Color(255,166,101));
//       orderAmt_header.setFont(new Font("Sarif",Font.PLAIN,15));
//       orderAmt_header.setBounds(206, 750, 161, 27);
//
//       // JLabel - cart item 
//       cartItemLabel = new JLabel(cart_items.get(i).getProduct().getProductName() + " x" + cart_items.get(i).getQuantity());
//       cartItemLabel.setForeground(Color.BLACK);
//       cartItemLabel.setFont(new Font("Sarif",Font.PLAIN,15));
//       cartItemLabel.setBounds(480, 750, 430, 27);
//       }
       
       // JPanel - container
       panel = new JPanel();
       panel.setSize(1080,768);
       panel.setLayout(null);
       panel.setBackground(Color.WHITE);
       
       panel.add(back);
//       panel.add(orderAmt_header);
//       panel.add(cartItemLabel);
       panel.add(price_header);
       panel.add(price);
       panel.add(shippingFee_header);
       panel.add(shippingFee);
       panel.add(totalPrice_header);
       panel.add(totalPrice);
       panel.add(payment_header);
       panel.add(payment);
       panel.add(billingAddress_header);
       panel.add(billingAddress);
       panel.add(paymentBtn);
       
       
       // JPanel - this
       this.setSize(1080,768);
       this.setBackground(Color.white);
       this.setLayout(new BorderLayout());
       this.add(panel, BorderLayout.CENTER);
       
   }
    
}
