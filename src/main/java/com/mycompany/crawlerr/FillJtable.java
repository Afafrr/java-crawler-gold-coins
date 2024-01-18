/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mateusz
 */
public class FillJtable {
/**
 * Method used to fill out given jTable model with some array
 * 
 *@param model
 *@param ItemsArray
 */
    public void fillTable(DefaultTableModel model, ArrayList<Coin> ItemsArray) {
        
        for (Coin item : ItemsArray) {
            model.addRow(new Object[]{item.name, item.price});
        }
    }
}
