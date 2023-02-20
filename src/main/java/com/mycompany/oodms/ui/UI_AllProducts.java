package com.mycompany.oodms.ui;

import com.mycompany.oodms.Product;
import com.mycompany.oodms.Services.ProductService;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI_AllProducts extends JPanel {
    
    // HEADING AND TITLE OBJECTS
    UI_Header heading = new UI_Header();
    JLabel title;
    JLabel subTitle;
    
    // SEARCH AND FILTER OBJECTS
    JTextField searchBar;
    String[] categoryList;
    JComboBox<String> categories;
    JButton searchBtn;
    
    // ITEM OBJECT
    ProductService product_service = new ProductService();
    ArrayList<Product> product_list = product_service.getProducts();
    
    ArrayList<ArrayList<String>> tempProduct = new ArrayList<>(); // should store object instead 
    ArrayList<String> tempProductContainer = new ArrayList<>();
    JButton[] products;
    
    // TEMP : add temp product into temp arraylist
    int loopCount;
    private void tempProductGenerator(int productAmt) {
        for (int i = 0; i < productAmt; i++) {
            tempProductContainer.add("Product Name");
            tempProductContainer.add("RM 10.00");
            tempProductContainer.add("src/main/java/com/mycompany/oodms/ui/pictures/hudao.jpg");
            tempProduct.add(tempProductContainer);
        }   
    }
    
     
    // ALL REQUIRED PANELS
    JScrollPane scrollPane;
    JPanel title_panel;
    JPanel subTitle_panel;
    JPanel searchFilter_panel;
    JPanel products_panel;
    JPanel searchNproduct_Panel;
    
    
    public UI_AllProducts() {
        
        // Title
        title = new JLabel("Products");
        title.setFont(new Font("MV Boli",Font.BOLD,30));
        title.setPreferredSize(new Dimension(1080,150));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.BOTTOM);
        
        
        // subtitle
        subTitle = new JLabel("We only sell best product");
        subTitle.setFont(new Font("MV Boli",Font.PLAIN,10));
        subTitle.setForeground(Color.GRAY);
        subTitle.setPreferredSize(new Dimension(1080,55));
        subTitle.setHorizontalAlignment(JLabel.CENTER);
        subTitle.setVerticalAlignment(JLabel.TOP);
        
        
        // Search bar 
        // searchBar.getText()
        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(382,45));
        searchBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        
        // filter 
        categories = new JComboBox<>(new String[] {"Option 1", "Option 2", "Option 3"});
        categories.setPreferredSize(new Dimension(150,45));
        
        
        // search button
        ImageIcon searchIcon = new ImageIcon("src/main/java/com/mycompany/oodms/ui/pictures/searchIcon.png");
        searchBtn = new JButton(searchIcon);
        searchBtn.setPreferredSize(new Dimension(45,45));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        
        
        // Panel for search n filter section
        searchFilter_panel = new JPanel();
        searchFilter_panel.setSize(1080, 60);
        searchFilter_panel.setBackground(Color.WHITE);
        searchFilter_panel.setLayout(new FlowLayout());
        searchFilter_panel.add(searchBar);
        searchFilter_panel.add(categories);
        searchFilter_panel.add(searchBtn);
        
        
        // Products
        loopCount = 2;
        tempProductGenerator(loopCount); // temp product generator
        
        products = new JButton[product_list.size()];
        for (int i = 0; i < product_list.size(); i++) {
           
            products[i] = new JButton();
            
            // add product name, price
            products[i].setText(tempProduct.get(i).get(0) + " " + tempProduct.get(i).get(1));
            
            
            // add image
            ImageIcon productImg = new ImageIcon(tempProduct.get(i).get(2));
            Image image = productImg.getImage();
            Image scaleImage = image.getScaledInstance(331, 365, Image.SCALE_SMOOTH);
            ImageIcon scaleImageIcon = new ImageIcon(scaleImage);
            products[i].setIcon(scaleImageIcon);
            
            
            // Button looking configuration
            products[i].setIconTextGap(20);
            products[i].setPreferredSize(new Dimension(332, 470));
            products[i].setHorizontalTextPosition(JLabel.CENTER);
            products[i].setVerticalTextPosition(JLabel.BOTTOM);
            products[i].setBorder(BorderFactory.createEmptyBorder());
            products[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
        }
        
        
        // Panel for products
        float rowCount = (float)tempProduct.size()/2;
        int products_panel_height = 490 * (int)Math.ceil(rowCount);
        
        products_panel = new JPanel();
        products_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 1));
        products_panel.setPreferredSize(new Dimension(780, products_panel_height));
        products_panel.setBackground(Color.WHITE);
        
        for (JButton product : products){
            products_panel.add(product);
        }
        
        
        // Panel for search bar and products
        searchNproduct_Panel = new JPanel();
        searchNproduct_Panel.setLayout(new BorderLayout());
        searchNproduct_Panel.setBackground(Color.WHITE); 
        searchNproduct_Panel.add(searchFilter_panel, BorderLayout.NORTH);
        searchNproduct_Panel.add(products_panel, BorderLayout.CENTER); 
        
        
        // Panel for subtitle
        subTitle_panel = new JPanel();
        subTitle_panel.setLayout(new BorderLayout());
        subTitle_panel.setBackground(Color.WHITE);
        subTitle_panel.add(subTitle, BorderLayout.NORTH);
        subTitle_panel.add(searchNproduct_Panel, BorderLayout.CENTER);
        
        // Panel for title
        title_panel = new JPanel();
        title_panel.setLayout(new BorderLayout());
        title_panel.setBackground(Color.WHITE);
        title_panel.add(title, BorderLayout.NORTH);
        title_panel.add(subTitle_panel, BorderLayout.CENTER);
        
        // Panel - scrollPane
        scrollPane = new JScrollPane(title_panel);
        scrollPane.setSize(780, products_panel_height);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        
        // Main Panel
        this.setLayout(new BorderLayout());
        this.add(heading, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);
    }
}
