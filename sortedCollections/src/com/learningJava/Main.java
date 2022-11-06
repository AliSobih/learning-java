package com.learningJava;
/**
 * created by ali on 4/11/2022
 */
public class Main {
    private static final StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", .86,100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50,2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 620.,10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99,35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76,40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket myBasket = new Basket("myBasket");

        sellItem(myBasket, "car",1);
        System.out.println(myBasket);

        sellItem(myBasket, "car",1);
        System.out.println(myBasket);

        sellItem(myBasket, "car",1);
        sellItem(myBasket, "spanner",5);
        sellItem(myBasket, "car",1);
        sellItem(myBasket, "car",1);
        sellItem(myBasket, "juice",4);
        sellItem(myBasket, "cup",12);
        sellItem(myBasket, "bread",1);
        System.out.println(myBasket);
        System.out.println(stockList);

    }
    public static int sellItem(Basket basket, String item, int quantity){
//        retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we don't sell " + item);
            return 0;
        }
        if(stockList.sellSock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
