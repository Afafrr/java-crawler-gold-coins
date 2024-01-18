/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

/**
 *
 * @author Mateusz
 */
public class CoinWebsite {

    String url;
    String productClass;
    String productNameClass;
    String productPriceClass;
/**
 * 
 * @param url
 * @param productClass
 * @param productNameClass
 * @param productPriceClass
 * 
 */
    public CoinWebsite(String url, String productClass, String productNameClass, String productPriceClass) {
        this.url = url;
        this.productClass = productClass;
        this.productNameClass = productNameClass;
        this.productPriceClass = productPriceClass;
    }
}
