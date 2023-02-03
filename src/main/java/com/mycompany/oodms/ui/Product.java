package com.company.ui;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Product extends JFrame {

    JButton backBtn;
    JLabel productImg;
    JLabel name;
    JLabel sold;
    JLabel description;
    JLabel stocks;
    JLabel price;
    JButton addToCartBtn;
    JButton ratings;

    public Product(){
        // REQUIRED DATA
        // ID, PICTURE, NAME, DESCRIPTION, STOCK, PRICE, SOLD

        ArrayList<String> productDetails = new ArrayList<>();
        productDetails.add("ITEM1");
        productDetails.add("src/com/company/ui/pictures/hudao.jpg");
        productDetails.add("Nameg");
        productDetails.add("Lorem ipsum dolor sit amet consectetur. Non habitant volutpat fames vel amet mollis. Massa sed sem diam tortor praesento");
        productDetails.add("22"); // stock
        productDetails.add("45.50");
        productDetails.add("10"); //sold

        // JLabel - back
        backBtn = new JButton("< back");
        backBtn.setFont(new Font("MV Boli",Font.PLAIN,18));
        backBtn.setForeground(new Color(77, 77, 77, 124));
        backBtn.setBounds(85,89,68,25);
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //image
        ImageIcon itemPic = new ImageIcon(productDetails.get(1));
        Image image = itemPic.getImage();
        Image newImage = image.getScaledInstance(508, 585, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);

        // JLabel - picture
        productImg = new JLabel(newIcon);
        productImg.setBounds(183,237,508,585);

        // JLabel - name
        name = new JLabel(productDetails.get(2));
        name.setFont(new Font("MV Boli",Font.BOLD,45));
        name.setBounds(767,237,490,54);

        // Jlabel - sold
        sold = new JLabel(productDetails.get(6)+ " " + "sold");
        sold.setFont(new Font("MV Boli",Font.PLAIN,18));
        sold.setForeground(new Color(255, 151, 98, 124));
        sold.setBounds(767,296,100,34);

        // Jlabel - description
        description = new JLabel("<html>" + productDetails.get(3) + "</html>");
        description.setFont(new Font("MV Boli",Font.PLAIN,18));
        description.setForeground(new Color(121, 121, 121, 124));
        description.setBounds(767,373,490,300);
        description.setVerticalAlignment(JLabel.TOP);

        // JLabel - stocks
        String stockStatus = (Integer.parseInt(productDetails.get(4)) > 0) ? productDetails.get(4) + " available" : "out of stock";
        stocks = new JLabel(stockStatus);
        stocks.setFont(new Font("MV Boli",Font.PLAIN,14));
        stocks.setForeground(new Color(121, 121, 121));
        stocks.setBounds(767,745,150,30);

        // JLabel - price
        price = new JLabel("RM " + productDetails.get(5));
        price.setFont(new Font("MV Boli",Font.PLAIN,40));
        price.setForeground(new Color(0, 0, 0));
        price.setBounds(767,785,200,36);

        // JButton - addToCartBtn
        addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.setFont(new Font("MV Boli",Font.PLAIN,18));
        addToCartBtn.setForeground(new Color(255, 255, 255));
        addToCartBtn.setBounds(1080,762,177,64);
        addToCartBtn.setBorder(BorderFactory.createEmptyBorder());
        addToCartBtn.setFocusable(false);
        addToCartBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addToCartBtn.setBackground(new Color(255, 151, 98, 255));
        addToCartBtn.setOpaque(true);

        ratings = new JButton("Ratings & Reviews");
        ratings.setFont(new Font("MV Boli",Font.PLAIN,15));
        ratings.setForeground(new Color(243, 143, 93, 255));
        ratings.setBounds(1080,837,177,25);
        ratings.setBorder(BorderFactory.createEmptyBorder());
        ratings.setFocusable(false);
        ratings.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // ------------------------------ this JFrame ------------------------------ //
        this.setSize(1440, 1024);
        this.setTitle("Shobee");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(null);

        this.add(backBtn);
        this.add(productImg);
        this.add(name);
        this.add(sold);
        this.add(description);
        this.add(stocks);
        this.add(price);
        this.add(addToCartBtn);
        this.add(ratings);

        this.setVisible(true);
    }
}
