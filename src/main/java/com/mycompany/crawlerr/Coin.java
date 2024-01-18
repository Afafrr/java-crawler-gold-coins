/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

/**
 *
 * @author Mateusz
 */
public class Coin {

    String name;
    double price;
    /**
     * @param name
     * @param price
     */
    public Coin(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }
}
