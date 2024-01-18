/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

import java.util.ArrayList;

/**
 *
 * @author Mateusz
 */
public class ArrayWrapper {

    ArrayList<Coin> Arr1;
    ArrayList<Coin> Arr2;

    /**
     *
     * @param Arr1
     * @param Arr2
     */
    public ArrayWrapper(ArrayList<Coin> Arr1, ArrayList<Coin> Arr2) {

        this.Arr1 = Arr1;
        this.Arr2 = Arr2;
    }

    /**
     *
     * @return
     */
    public ArrayList<Coin> getArr1() {
        return Arr1;
    }

    /**
     *
     * @return
     */
    public ArrayList<Coin> getArr2() {
        return Arr2;
    }
}
