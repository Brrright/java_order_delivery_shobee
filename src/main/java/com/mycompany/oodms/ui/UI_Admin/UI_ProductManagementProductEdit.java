package com.mycompany.oodms.ui.UI_Admin;


import static com.mycompany.oodms.OODMS_Main.frame;
import com.mycompany.oodms.ui.UI_Login;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UI_ProductManagementProductEdit extends JPanel {

    JButton back;
    
    JLabel title;
    
    JLabel name_header;
    JLabel category_header; 
    JLabel price_header;
    JLabel stock_header; 
    JLabel productPic_header;
    JLabel productPic_fileName;
    
    JTextField name;
    JComboBox category;
    JTextField price;
    JTextField stock;
    JButton productPic_upload;
    
    JButton update;
    JButton cancel;
    
    public UI_ProductManagementProductEdit(){
        // REQUIRED DATA
        // ID, PICTURE, NAME, GENDER, DOB, EMAIL, PHONE NO
        ArrayList<String> productDetails = new ArrayList<>();
        productDetails.add("PRODUCT1");
        productDetails.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
        productDetails.add("Product name");
        productDetails.add("Electronics");
        productDetails.add("34.00"); // price
        productDetails.add("23"); // stocks
                        

        // JButton - back (to login page)
        back = new JButton("< back");
        back.setFont(new Font("MV Boli",Font.PLAIN,12));
        back.setForeground(new Color(77, 77, 77, 124));
        back.setBounds(68,70,45,11);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagementProduct());
        });
        
        // JLabel - title
        title = new JLabel(productDetails.get(0));
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setBounds(144,136,250,40);
        
        // JLabel - name header
        name_header = new JLabel("Product Name :");
        name_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        name_header.setBounds(144,213,150,20);        
        
        // JTextField - product name
        name = new JTextField(productDetails.get(2));
        name.setBounds(140,233,587,48);
        name.setText(productDetails.get(2));
        
        // JLabel - category header
        category_header = new JLabel("Category :");
        category_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        category_header.setBounds(763,213,100,20);
        
        // JTextField - category
        String[] genderList = {"Electronics","Foods and beverage"};
        category = new JComboBox(genderList);
        category.setBounds(759,233,174,48);
        category.setSelectedItem(productDetails.get(3));

        
        // JLabel - price header
        price_header = new JLabel("Price :");
        price_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        price_header.setBounds(144,307,50,20);
        
        // JTextField - price
        price = new JTextField(productDetails.get(4));
        price.setBounds(140,327,793,48);
        price.setText(productDetails.get(4));
        
        // JLabel - stock header
        stock_header = new JLabel("Stock :");
        stock_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        stock_header.setBounds(144,406,100,20);
        
        // JTextField - stock
        stock = new JTextField();
        stock.setBounds(140,426,793,48);
        stock.setText(productDetails.get(5));
                
        // JLabel - product picture
        productPic_header = new JLabel("Product Picture :");
        productPic_header.setFont(new Font("MV Boli",Font.PLAIN,12));
        productPic_header.setBounds(144,505,100,20);
        
        // JLabel - product Picture file name
        productPic_fileName = new JLabel();
        productPic_fileName.setBounds(230,521,378,40);
        
        // JButton - Profile Picture
        productPic_upload = new JButton("Upload");
        productPic_upload.setBounds(136,530,80,25);
        productPic_upload.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                productPic_fileName.setText(file.getName());

                // get file path
                // imagePath[0] = file.getAbsolutePath();
                // uploadImgDir = imagePath[0].split("\\.");
            }
        });


        // JButton - sign up button
        update = new JButton("update");
        update.setBorder(BorderFactory.createEmptyBorder());
        update.setHorizontalTextPosition(JLabel.CENTER);
        update.setVerticalTextPosition(JLabel.CENTER);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.setBackground(new Color(255, 151, 98, 255));
        update.setOpaque(true);
        update.setBounds(850,141,84,42);
        update.setFont(new Font("MV Boli",Font.PLAIN,12));
        update.setForeground(Color.WHITE);
        update.addActionListener(e -> {
            
        });
        
        // JButton - cancel button
        cancel = new JButton("cancel");
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setHorizontalTextPosition(JLabel.CENTER);
        cancel.setVerticalTextPosition(JLabel.CENTER);
        cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancel.setBackground(new Color(255, 151, 98, 255));
        cancel.setOpaque(true);
        cancel.setBounds(755,141,84,42);
        cancel.setFont(new Font("MV Boli",Font.PLAIN,12));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(e -> {
            frame.replacePanel(new UI_ProductManagementProduct());
            // with profile object or id ??
        });
        
        ////////////////////////////////////////////////////////////////////////
        /////////////////////////////// - this - ///////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        this.setSize(1080, 768);
        this.setBackground(Color.white);
        this.setLayout(null);
        
        this.add(back);
        this.add(title);
        
        this.add(name_header);
        this.add(category_header);
        this.add(price_header);
        this.add(stock_header);
        this.add(productPic_header);
        this.add(productPic_fileName);

        this.add(name);
        this.add(category);
        this.add(price);
        this.add(stock);
        this.add(productPic_upload);
        
        this.add(update);
        this.add(cancel);
    }
}
