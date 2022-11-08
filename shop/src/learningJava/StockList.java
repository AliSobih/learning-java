package learningJava;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if(inStock != item){
//                if item has changed price we will note that
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        throw new NullPointerException();
    }

    public int sellSock(String item, int quantity){
        StockItem inStock = list.get(item);
        if(inStock != null && quantity >0){
            return inStock.finaliseStock(quantity);
        }
        return 0;

//        StockItem inStock = list.getOrDefault(item, null);
//        if((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)){
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        System.out.println("there are no " + item + " more in stock");
//        return 0;
    }

    public int reservedStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0){
            return inStock.reservedStock(quantity);
        }
        return 0;
    }

    public int unreservedStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if(inStock != null && quantity > 0){
            return inStock.unreservedStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }
    public Map<String, Double> priceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
    public Map<String, StockItem>  Item(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem +". there are " + stockItem.availableQuantity() + " in stock. and value of items: ";
            s = s+ String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return  s + "Total stock value " + String.format("%.2f",totalCost);
    }
}
