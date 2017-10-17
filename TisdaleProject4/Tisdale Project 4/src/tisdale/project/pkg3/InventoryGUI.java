/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tisdale.project.pkg3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/******************************************************
***  Class Name: InventoryGUI
***  Class Author: Chris Tisdale 
******************************************************
*** Purpose of the class:
*** This class builds the main GUI for the project.
****************************************************** 
*** October 3, 2017
******************************************************
*** September 20:   Created classes:    StoreItem, Book, Movie, Painting.
*** September 26:   Created classes:    TisdaleProject3 and tested class functionality.
*** September 27:   Created classes:    InventoryGUI, GUIBuilder, GUIComboBoxActionHandler,
***                                     AddBookFrame, AddMovieFrame, AddPaintingFrame.
*** September 28:   Created classes:    SellBookFrame, SellMovieFrame, SellPaintingFrame,
***                                     DisplayBookFrame, DisplayMovieFrame, DisplayPaitingFrame.
*** October 2, 3:      Final comments and testing.
******************************************************
***  
*******************************************************/
public class InventoryGUI extends JFrame {

    String[] items = {"", "Book", "Movie", "Painting"};
    JLabel addLabel, sellLabel, displayLabel;
    static JComboBox addItemList, sellItemList, displayItemList;

    static ArrayList<Book> books;
    static ArrayList<Movie> movies;
    static  ArrayList<Painting> paintings;
            
/*****************************************************
*** InventoryGUI Constructor
*** Author: Chris Tisdale
******************************************************
*** Purpose: Creates instance of InventoryGUI, passing it arrayLists for initial StoreItems.
***             Adds labels and combo boxes, as well as combo box action listener to the JFrame.
******************************************************
*** Date: September 20
******************************************************/
    public InventoryGUI(ArrayList<Book> initBooks, ArrayList<Movie> initMovies, ArrayList<Painting> initPaintings) {
        books = initBooks;
        movies = initMovies;
        paintings = initPaintings;

        JPanel mainPanel = new JPanel();
        this.getContentPane().setBackground(Color.white);
        this.setTitle("Inventory");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel.setLayout(new GridBagLayout());

        addLabel = new JLabel("   Add Inventory: ");
        sellLabel = new JLabel("   Sell Inventory: ");
        displayLabel = new JLabel("   Display Inventory: ");
        addItemList = new JComboBox(items);
        sellItemList = new JComboBox(items);
        displayItemList = new JComboBox(items);

        GUIComboBoxActionHandler lForComboBox = new GUIComboBoxActionHandler();
        addItemList.addActionListener(lForComboBox);
        sellItemList.addActionListener(lForComboBox);
        displayItemList.addActionListener(lForComboBox);

        GUIBuilder.addComponent(mainPanel, addLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, sellLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, displayLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, addItemList, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, sellItemList, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        GUIBuilder.addComponent(mainPanel, displayItemList, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setSize(250, 400);
        this.setResizable(true);
    }

}
