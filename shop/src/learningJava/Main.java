package learningJava;

import java.util.Map;

/**
 * created by ali on 6/11/2022
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
//        System.out.println(myBasket);
//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket,"cup", 10);
        sellItem(basket,"juice", 5);
        removeItem(basket,"cup", 1);
        System.out.println(basket);

        removeItem(myBasket, "car", 1);
        removeItem(myBasket, "cup", 9);
        removeItem(myBasket, "car", 1);
        System.out.println("care removed " + removeItem(myBasket, "car", 1));
        System.out.println(myBasket);

        // remove all items from myBasket
        removeItem(myBasket, "bread", 1);
        removeItem(myBasket, "cup", 3);
        removeItem(myBasket, "juice", 4);
        removeItem(myBasket, "cup", 3);
        System.out.println(myBasket);

        System.out.println("\n Display stock list before and after checkout ");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity){
//        retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we don't sell " + item);
            return 0;
        }
        if(stockList.reservedStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
//        retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreservedStock(item, quantity);
        }
        return 0;
    }
    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            stockList.sellSock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
