/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

import java.util.ArrayList;

/**
 *
 * @author Mateusz
 * 
 */
public class CompareArrays {
/**
 *
 * @author Mateusz
 * 
 * @param Arr1 first array to comparison
 * @param Arr2 second array to comparison
 * @return ArrayWrapper object which has 2 compared Arrays of type Coin
 */
    public ArrayWrapper compareTwoArrs(ArrayList<Coin> Arr1, ArrayList<Coin> Arr2) {

        ArrayList<Coin> sortedReturnArr1 = new ArrayList<>();
        ArrayList<Coin> sortedReturnArr2 = new ArrayList<>();

        for (Coin item1 : Arr1) {
            String name1 = item1.name;

            for (Coin item2 : Arr2) {
                String name2 = item2.name;

                if (name1.equals(name2)) {
                    sortedReturnArr1.add(item1);
                    sortedReturnArr2.add(item2);

                }
            }
        }
        return new ArrayWrapper(sortedReturnArr1, sortedReturnArr2);
    }
}
