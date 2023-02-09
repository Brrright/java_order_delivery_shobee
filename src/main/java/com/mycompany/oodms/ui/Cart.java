package com.mycompany.oodms.ui;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cart extends JFrame {
    UI_Header heading = new UI_Header();

    JLabel cartTitle;
    JPanel cartTitlePanel;

    JPanel cartBody;

    JPanel cartContainer;




    public Cart() {
        // ------------------------------ Cart Title ------------------------------ //
        cartTitle = new JLabel("Cart");
        cartTitle.setForeground(new Color(0, 0, 0));
        cartTitle.setFont(new Font("Sarif", Font.BOLD, 30));

        cartTitlePanel = new JPanel();
        cartTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 70));
        cartTitlePanel.add(cartTitle);
        cartTitlePanel.setBackground(Color.RED);


        // -------------------------------- Cart -------------------------------- //
        // ## a cart
        // get cart data with customer ID (product ID, cart ID, quantity, customer ID)
        // sample
        ArrayList<ArrayList<String>> cartArray = new ArrayList<>();
        ArrayList<String> cartData = new ArrayList<>();

        cartData.add("Product");
        cartData.add("10");
        cartData.add("34.00");

        for (int i = 0; i < 4; i++){
            cartData.set(1, String.valueOf(i + 1));
            cartArray.add(cartData);
        }




        cartBody = new JPanel();



        // --------------------- JPanel borderLayout for cart --------------------- //
        cartContainer = new JPanel();
        cartContainer.setLayout(new BorderLayout());
        cartContainer.add(cartTitlePanel,BorderLayout.NORTH);



        // ------------------------------ this JFrame ------------------------------ //

        this.setSize(1440, 1024);
        this.setTitle("Cart");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(new BorderLayout());
        this.add(heading, BorderLayout.NORTH);
        this.add(cartContainer, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
