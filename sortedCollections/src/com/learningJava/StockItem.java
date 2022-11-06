package com.learningJava;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    //    getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

//    setters

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }else {
            System.out.println("wrong price value");
        }
    }// end function

    public void adjustStock(int quantity){
        if(quantity + this.quantityStock >= 0){
            this.quantityStock += quantity;
        }else {
            System.out.println("we cant\'t add ");
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(this == obj)
            return true;
        if(obj instanceof StockItem)
            return this.name.equals(((StockItem) obj).getName());
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.CompareTo ");
        if(this == o)
            return 0;
        if(o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price ;
    }
}
