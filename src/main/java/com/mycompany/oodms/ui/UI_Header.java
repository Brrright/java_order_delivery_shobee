package com.mycompany.oodms.ui;

import com.mycompany.oodms.OODMS_Main;
import com.mycompany.oodms.Services.AddressService;
import com.mycompany.oodms.Services.CartItemService;
import com.mycompany.oodms.Services.CartService;
import com.mycompany.oodms.Services.CategoryService;
import com.mycompany.oodms.Services.DeliveryService;
import com.mycompany.oodms.Services.OrderItemService;
import com.mycompany.oodms.Services.OrderService;
import com.mycompany.oodms.Services.ProductService;
import com.mycompany.oodms.Services.User.AdminService;
import com.mycompany.oodms.Services.User.DeliveryStaffService;
import com.mycompany.oodms.Services.User.MemberService;
import com.mycompany.oodms.User;
import static com.mycompany.oodms.UserRole.ADMIN;
import static com.mycompany.oodms.UserRole.DELIVERY_STAFF;
import static com.mycompany.oodms.UserRole.MEMBER;
import com.mycompany.oodms.ui.UI_Admin.UI_AdminDelivery;
import com.mycompany.oodms.ui.UI_Admin.UI_ReportOrders;
import com.mycompany.oodms.ui.UI_Admin.UI_UserManagement;
import com.mycompany.oodms.ui.UI_Delivery.UI_UpComing;
import javax.swing.*;
import java.awt.*;

public class UI_Header extends JPanel{
    JLabel logo;
    
    // Unregistered user
    JButton allProduct;
    JButton login;
    JButton signup;
    
    // Registered user
    // all products (in unregistered user)
    JButton profile;
    JButton cart;
    JButton logout;
    
    // Delivery man
    // profile, logout (in registered user)
    JButton delivery;
    
    // Admin
    // profile, logout (in registered user)
    JButton adminManagement;
    JButton adminDelivery;
    JButton adminReport;


    public UI_Header() {
        // JLabel - logo
        logo = new JLabel("ShoBee");
        logo.setFont(new Font("MV Boli",Font.BOLD,25));
        logo.setForeground(new Color(255, 151, 98, 255));

        ////////////////////////////////////////////////////////////////////////
        //////////////////////// unregistered user /////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        // all product button
        allProduct = new JButton();
        allProduct.setText("All Products");
        allProduct.setBorder(BorderFactory.createEmptyBorder());
        allProduct.setFocusable(false);
        allProduct.setForeground(new Color(0, 0, 0));
        allProduct.setFont(new Font("Sarif",Font.BOLD,15));
        allProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        allProduct.setOpaque(false);
        allProduct.setFocusPainted(false);
        allProduct.setContentAreaFilled(false);
        allProduct.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_AllProducts());
        });


        // login button
        login = new JButton();
        login.setText("Login");
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setFocusable(false);
        login.setForeground(new Color(0, 0, 0));
        login.setFont(new Font("Sarif",Font.BOLD,15));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setOpaque(false);
        login.setFocusPainted(false);
        login.setContentAreaFilled(false);
        login.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_Login());
        });


        // sign up button
        signup = new JButton();
        signup.setText("Sign up");
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setFocusable(false);
        signup.setForeground(new Color(0, 0, 0));
        signup.setFont(new Font("Sarif",Font.BOLD,15));
        signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signup.setOpaque(false);
        signup.setFocusPainted(false);
        signup.setContentAreaFilled(false);
        signup.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_Signup());
        });
        
        ////////////////////////////////////////////////////////////////////////
        //////////////////////// - registered user - ///////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        // all products (in unregistered user section)
        
        // profile button
        profile = new JButton();
        profile.setText("Profile");
        profile.setBorder(BorderFactory.createEmptyBorder());
        profile.setFocusable(false);
        profile.setForeground(new Color(0, 0, 0));
        profile.setFont(new Font("Sarif",Font.BOLD,15));
        profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profile.setOpaque(false);
        profile.setFocusPainted(false);
        profile.setContentAreaFilled(false);
        profile.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_Profile());
        });
        
        // cart button
        cart = new JButton();
        cart.setText("Cart");
        cart.setBorder(BorderFactory.createEmptyBorder());
        cart.setFocusable(false);
        cart.setForeground(new Color(0, 0, 0));
        cart.setFont(new Font("Sarif",Font.BOLD,15));
        cart.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cart.setOpaque(false);
        cart.setFocusPainted(false);
        cart.setContentAreaFilled(false);
        cart.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_Cart());
        });
        
        // logout button
        logout = new JButton();
        logout.setText("Logout");
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setFocusable(false);
        logout.setForeground(new Color(0, 0, 0));
        logout.setFont(new Font("Sarif",Font.BOLD,15));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setOpaque(false);
        logout.setFocusPainted(false);
        logout.setContentAreaFilled(false);
        logout.addActionListener(e -> {
            OODMS_Main.previous_panel = null;
            OODMS_Main.current_user = null;
            OODMS_Main.isLogIn = false;
            AddressService.offAddressService();
            CartItemService.offCartItemService();
            CartService.offCartService();
            CategoryService.offCategoryService();
            DeliveryService.offDeliveryService();
            OrderItemService.offOrderItemService();
            OrderService.offOrderService();
            ProductService.offProductService();
            AdminService.offAdminService();
            DeliveryStaffService.offDeliveryStaffService();
            MemberService.offMemberService();
            OODMS_Main.frame.replacePanel(new UI_Login());
        });
                
        
        ////////////////////////////////////////////////////////////////////////
        ///////////////////////// - Delivery man - /////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        // delivery page button
        delivery = new JButton();
        delivery.setText("Delivery");
        delivery.setBorder(BorderFactory.createEmptyBorder());
        delivery.setFocusable(false);
        delivery.setForeground(new Color(0, 0, 0));
        delivery.setFont(new Font("Sarif",Font.BOLD,15));
        delivery.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delivery.setOpaque(false);
        delivery.setFocusPainted(false);
        delivery.setContentAreaFilled(false);
        delivery.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_UpComing());
        });
        
        // profile, logout (in registered user section)
        
        
        ////////////////////////////////////////////////////////////////////////
        //////////////////////////// - Admin  - ////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        // Admin management button
        adminManagement = new JButton();
        adminManagement.setText("Management");
        adminManagement.setBorder(BorderFactory.createEmptyBorder());
        adminManagement.setFocusable(false);
        adminManagement.setForeground(new Color(0, 0, 0));
        adminManagement.setFont(new Font("Sarif",Font.BOLD,15));
        adminManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminManagement.setOpaque(false);
        adminManagement.setFocusPainted(false);
        adminManagement.setContentAreaFilled(false);
        adminManagement.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_UserManagement());
        });
        
        // Admin delivery button
        adminDelivery = new JButton();
        adminDelivery.setText("Delivery");
        adminDelivery.setBorder(BorderFactory.createEmptyBorder());
        adminDelivery.setFocusable(false);
        adminDelivery.setForeground(new Color(0, 0, 0));
        adminDelivery.setFont(new Font("Sarif",Font.BOLD,15));
        adminDelivery.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminDelivery.setOpaque(false);
        adminDelivery.setFocusPainted(false);
        adminDelivery.setContentAreaFilled(false);
        adminDelivery.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_AdminDelivery());
        });
        
        // Admin report button
        adminReport= new JButton();
        adminReport.setText("Report");
        adminReport.setBorder(BorderFactory.createEmptyBorder());
        adminReport.setFocusable(false);
        adminReport.setForeground(new Color(0, 0, 0));
        adminReport.setFont(new Font("Sarif",Font.BOLD,15));
        adminReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminReport.setOpaque(false);
        adminReport.setFocusPainted(false);
        adminReport.setContentAreaFilled(false);
        adminReport.addActionListener(e -> {
            OODMS_Main.previous_panel = Main_Frame.currentPanel;
            OODMS_Main.frame.replacePanel(new UI_ReportOrders());
        });
        
        // profile, logout (in registered user section)
        
        ////////////////////////////////////////////////////////////////////////
        // JPanel - this
        this.setLayout(new FlowLayout(FlowLayout.LEADING,50,20));
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        
        this.add(logo);
        
        // got bug
        User user = OODMS_Main.current_user;
        
        if (user == null)
        {
            this.add(allProduct);
            this.add(login);
            this.add(signup);
        }
        else 
        {
            switch(user.getRole()){
                case ADMIN -> {
                    this.add(adminManagement);
                    this.add(adminDelivery);
                    this.add(adminReport);
                    this.add(profile);
                    this.add(logout);
                }
                case MEMBER -> {
                    this.add(allProduct);
                    this.add(cart);
                    this.add(profile);
                    this.add(logout);
                }
                case DELIVERY_STAFF -> {
                    this.add(delivery);
                    this.add(profile);
                    this.add(logout);
                }
            }
        }
    }
}