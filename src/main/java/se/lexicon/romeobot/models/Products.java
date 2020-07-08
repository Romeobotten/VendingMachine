package se.lexicon.romeobot.models;

import se.lexicon.romeobot.Data.ProductIdSequencer;

public abstract class Products {
    private int productId;
    private String name;
    private String description;
    private int price;

    public abstract String examine();

    String use(){
        return " Eat it!";
    }

    public Products(String name, String description, int price) {
        this.productId = ProductIdSequencer.nextProductId();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
