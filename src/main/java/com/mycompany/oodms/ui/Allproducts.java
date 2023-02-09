package com.mycompany.oodms.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;
import java.util.Arrays;

public class AllProducts extends JFrame {
    UI_Header heading = new UI_Header();
    JPanel mainContainer; // container for category and items
    JPanel catContainer;
    JPanel allCategories;
    JPanel allItems;
    JButton[] categories;
    JButton[] items;
    ArrayList<ArrayList<String>> categoryArray;
    ArrayList<ArrayList<String>> itemArray;
    ArrayList<String> tempContainer;

    //!! should have get data from parameter (2d arraylist or array of all categories and items)
    public AllProducts() {
        // ------------------------------ category JLabel ------------------------------ //
        // TITLE - the word "category"
        JLabel cattitle = new JLabel("Category");
        cattitle.setForeground(new Color(0, 0, 0));
        cattitle.setFont(new Font("Sarif", Font.BOLD, 30));

        JPanel catTitle = new JPanel();
        catTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 70));
        catTitle.add(cattitle);
        catTitle.setBackground(Color.WHITE);


        // Create category array by using data from txt file
        // Required data = category name, category ID
        // *sample*

        tempContainer = new ArrayList<>();
        categoryArray = new ArrayList<>();// the 2d array with all category (ID, cat name)

        for (int i = 0; i < 12; i++) {
            tempContainer.add("ID");
            tempContainer.add("cat");
            categoryArray.add(tempContainer);
        }


        // JLabel - buttons (get from array)
        categories = new JButton[categoryArray.size()];
        ImageIcon orangeCircle = new ImageIcon("src/com/company/ui/pictures/orangecircle.png");
        // create JLabel with the array
        for (int i = 0; i < categoryArray.size(); i++) {
            categories[i] = new JButton();
            categories[i].setText(categoryArray.get(i).get(1));
            categories[i].setFont(new Font("Sarif", Font.PLAIN, 20));
            categories[i].setIcon(orangeCircle);
            categories[i].setHorizontalTextPosition(JLabel.CENTER);
            categories[i].setVerticalTextPosition(JLabel.CENTER);
            categories[i].setBorder(BorderFactory.createEmptyBorder());
            categories[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//            categories[i].setFocusable(false);
        }


        // ------------------------------ category JPanel ------------------------------ //
        // get all data from txt file
        allCategories = new JPanel();
        allCategories.setBackground(Color.WHITE);
        allCategories.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        // category column height
        int catHeight = (((categoryArray.size() / 7) + 1) * 210);

        allCategories.setPreferredSize(new Dimension(0, catHeight));

        for (JButton category : categories) {
            allCategories.add(category);
        }


        // ------------------------------ Item JLabel ------------------------------ //
        // REQUIRED DATA = ID, name, price, data

        // Create ITEM array by using data from txt file
        // *sample*

        itemArray = new ArrayList<>();// the 2d array with all category (ID, name, price, pictureFile)

        for (int i = 0; i < 6; i++) {
            tempContainer.clear();
            tempContainer.add("ID");
            tempContainer.add("hutao");
            tempContainer.add("RM 30.00");
            tempContainer.add("src/com/company/ui/pictures/hudao.jpg");
            itemArray.add(tempContainer);
        }


        // JLabel - buttons (get from array)
        items = new JButton[itemArray.size()];
        // create JLabel with the array
        for (int i = 0; i < itemArray.size(); i++) {
            items[i] = new JButton();
            items[i].setText(itemArray.get(i).get(1) + "  " + itemArray.get(i).get(2));
            items[i].setFont(new Font("Sarif", Font.PLAIN, 20));

            ImageIcon itemPic = new ImageIcon(itemArray.get(i).get(3));
            Image image = itemPic.getImage();
            Image newImage = image.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImage);
            items[i].setIcon(newIcon);
            items[i].setHorizontalTextPosition(JLabel.CENTER);
            items[i].setVerticalTextPosition(JLabel.BOTTOM);
            items[i].setBorder(BorderFactory.createEmptyBorder());
            items[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

            // ------------------------------ Item JPanel ------------------------------ //
            allItems = new JPanel();
            allItems.setBackground(Color.WHITE);
            allItems.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 40));
            int extraHeight = (items.length%3 == 0) ? 0 : 1;
            allItems.setPreferredSize(new Dimension(1000,500 * (items.length/3 + extraHeight)));
            for (JButton item : items) {
                allItems.add(item);
            }



        // cat container
            catContainer = new JPanel();
            catContainer.setLayout(new BorderLayout());
            catContainer.add(catTitle, BorderLayout.NORTH);
            catContainer.add(allCategories, BorderLayout.CENTER);


            // ------------------------------ cat and item container ------------------------------ //
            mainContainer = new JPanel();
            mainContainer.setLayout(new BorderLayout());
            mainContainer.add(catContainer, BorderLayout.NORTH);
            mainContainer.add(allItems, BorderLayout.CENTER);

            JScrollPane scroll = new JScrollPane(mainContainer);



            // ------------------------------ this JFrame ------------------------------ //

            this.setSize(1440, 1024);
            this.setTitle("Shobee");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.getContentPane().setBackground(new Color(255, 255, 255));
            this.setLayout(new BorderLayout());
            this.add(heading, BorderLayout.NORTH);
            this.add(scroll, BorderLayout.CENTER);
//            this.add(mainContainer, BorderLayout.CENTER);
            this.setVisible(true);

        }
}
