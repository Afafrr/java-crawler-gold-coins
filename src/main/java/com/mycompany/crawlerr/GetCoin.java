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
public class GetCoin {

    public ArrayList<Coin> ITEMS1ARR = new ArrayList<>();
    public ArrayList<Coin> ITEMS2ARR = new ArrayList<>();
    public ArrayList<Coin> ITEMS3ARR = new ArrayList<>();

    CoinWebsite MetaleLokacyjne = new CoinWebsite(
            "https://www.metalelokacyjne.pl/zha_m_Produkty_Monety_zlote-546.html?filter_traits%5B4779%5D=&filter_traits%5B1%5D=&filter_traits%5B512%5D=&filter_traits%5B510%5D=481&filter_traits%5B4582%5D=&filter_pricerange=&filter_traits%5B304%5D=&filter_traits%5B69%5D=&filter_availability=&filter_instock=&filter_new=&filter_bestseller=&filter_default=n#",
            "product_wrapper_sub",
            "product-name",
            "price");

    CoinWebsite WyrobyMennicze = new CoinWebsite(
            "https://www.wyrobymennicze.pl/pol_m_Zlote-monety-397.html?filter_traits%5B1%5D=&filter_traits%5B512%5D=&filter_traits%5B510%5D=481&filter_pricerange=&filter_traits%5B304%5D=&filter_traits%5B69%5D=&filter_availability=y",
            "product__sub",
            "product__name",
            "price");

    CoinWebsite MetalMarket = new CoinWebsite(
            "https://www.metalmarket.eu/pl/menu/zlote-monety-850.html?filter_traits[510]=481&filter_availability=y&counter=1",
            "product",
            "product__name",
            "price");

    /**
     * Method uses FetchedCoin class which returns array of coins and separates
     * every website items to different arrays
     */
    public void fetchCoins() {
        FetchCoin fetchedItems1 = new FetchCoin();
        FetchCoin fetchedItems2 = new FetchCoin();
        FetchCoin fetchedItems3 = new FetchCoin();

        ITEMS1ARR = fetchedItems1.coinData(MetaleLokacyjne);
        ITEMS2ARR = fetchedItems2.coinData(WyrobyMennicze);
        ITEMS3ARR = fetchedItems3.coinData(MetalMarket);
    }
}
