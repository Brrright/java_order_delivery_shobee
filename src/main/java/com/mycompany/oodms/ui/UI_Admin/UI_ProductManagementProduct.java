/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oodms.ui.UI_Admin;


import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.Product;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI_ProductManagementProduct extends JPanel {

    JButton backBtn;
    JLabel productImg;
    JLabel name;
    JLabel sold;
    JLabel description;
    JLabel stocks;
    JLabel price;
    
    JButton edit;
    JButton remove;

    public UI_ProductManagementProduct(){
        // REQUIRED DATA
        // ID, PICTURE, NAME, DESCRIPTION, STOCK, PRICE, SOLD
        
        
        ArrayList<String> productDetails = new ArrayList<>(); 
        productDetails.add("ITEM1");
        productDetails.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
        productDetails.add("Nameg");
        productDetails.add("Lorem ipsum dolor sit amet consectetur. Non habitant volutpat fames vel amet mollis. Massa sed sem diam tortor praesento");
        productDetails.add("22"); // stock
        productDetails.add("45.50");
        productDetails.add("Electronics"); //sold

        // JLabel - back
        backBtn = new JButton("< back");
        backBtn.setFont(new Font("MV Boli",Font.PLAIN,12));
        backBtn.setForeground(new Color(77, 77, 77, 124));
        backBtn.setBounds(73,77,45,11);
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagement());
        });
        

        //image (edited scale)
        ImageIcon itemPic = new ImageIcon(productDetails.get(1));
        Image image = itemPic.getImage();
        Image newImage = image.getScaledInstance(370, 426, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);

        // JLabel - picture
        productImg = new JLabel(newIcon);
        productImg.setBounds(145,182,370,426);

        // JLabel - name
        name = new JLabel(productDetails.get(2));
        name.setFont(new Font("MV Boli",Font.BOLD,30));
        name.setBounds(576,182,342,35);

        // Jlabel - sold
        sold = new JLabel(productDetails.get(6));
        sold.setFont(new Font("MV Boli",Font.PLAIN,12));
        sold.setForeground(new Color(255, 151, 98, 124));
        sold.setBounds(577,230,80,11);

        // Jlabel - description
        description = new JLabel("<html>Shobee is a trusted online store that provides quality assurance to its customers. They sell only high-quality products and work with reputable suppliers and manufacturers.</html>");
        description.setFont(new Font("MV Boli",Font.PLAIN,15));
        description.setForeground(Color.LIGHT_GRAY);
        description.setBounds(576,290,360,320);
        description.setVerticalAlignment(JLabel.TOP);

        // JLabel - stocks
        String stockStatus = (Integer.parseInt(productDetails.get(4)) > 0) ? productDetails.get(4) + " available" : "out of stock";
        stocks = new JLabel(stockStatus);
        stocks.setFont(new Font("MV Boli",Font.PLAIN,10));
        stocks.setForeground(new Color(121, 121, 121));
        stocks.setBounds(577,550,80,9);

        // JLabel - price
        price = new JLabel("RM " + productDetails.get(5));
        price.setFont(new Font("MV Boli",Font.PLAIN,26));
        price.setForeground(new Color(0, 0, 0));
        price.setBounds(576,575,200,25);

        // JButton - edit
        edit = new JButton("Edit");
        edit.setFont(new Font("MV Boli",Font.PLAIN,12));
        edit.setForeground(new Color(255, 255, 255));
        edit.setBounds(751,561,85,47);
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setBackground(new Color(255, 151, 98, 255));
        edit.setOpaque(true);
        edit.setFocusable(false);
        edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        edit.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagementProductEdit());
        });
        
        // JButton - remove
        remove = new JButton("Remove");
        remove.setFont(new Font("MV Boli",Font.PLAIN,12));
        remove.setForeground(new Color(255, 255, 255));
        remove.setBounds(842,561,85,47);
        remove.setBorder(BorderFactory.createEmptyBorder());
        remove.setBackground(new Color(255, 151, 98, 255));
        remove.setOpaque(true);
        remove.setFocusable(false);
        remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        remove.addActionListener(e -> {
            
            int removeConfirmation = JOptionPane.showOptionDialog(null, "Confirm to remove product" + "?", "Confirmation",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (removeConfirmation == JOptionPane.OK_OPTION) {
                    // remove product
                }
        });



        // ------------------------------ this main JPanel ------------------------------ //
        this.setSize(1080, 768);
        this.setBackground(Color.white);
        this.setLayout(null);

        this.add(backBtn);
        this.add(productImg);
        this.add(name);
        this.add(sold);
        this.add(description);
        this.add(stocks);
        this.add(price);
        this.add(edit);
        this.add(remove);
    }
}
