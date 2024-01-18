/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crawlerr;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Mateusz
 */
public class FetchCoin {

    /**
     * Method which trimms string price to double
     * 
     * @param word string which will be trimmed
     * @return trimmed string which has only price of double type
     */
    
    private double getTrimmedPrice(String word) {
        int wordIndex = word.indexOf('z');
        if (wordIndex == -1) {
            return 0;
        }
        String value = word.substring(0, wordIndex);
        String cleanedValue = value.replace(" ", "").replace(",", ".");
        double priceDouble = Double.parseDouble(cleanedValue);

        return priceDouble;
    }
    
    /**
     * The method is used to get coin values from website based on
     * website url, css class of: product, name of item and price of item
     * 
     * @param coinWebsite 
     * @return coinsArr Array of Coin objects 
     */
    public ArrayList<Coin> coinData(CoinWebsite coinWebsite) {

        ArrayList<Coin> coinsArr = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(coinWebsite.url).get();
            Elements Product = doc.getElementsByClass(coinWebsite.productClass);
            int row = 0;

            for (Element product : Product) {
                row++;
                Elements names = product.getElementsByClass(coinWebsite.productNameClass);
//                String nameTrim = getTrimmedSName(names.text());
                String nameTrim = names.text();

                Elements prices = product.getElementsByClass(coinWebsite.productPriceClass);
                double priceDouble = getTrimmedPrice(prices.text());
                if (priceDouble != 0) {
                    coinsArr.add(new Coin(nameTrim, priceDouble));
//                    model.addRow(new Object[]{nameTrim, priceDouble});
                }
            }
            return coinsArr;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
