package se.lexicon.romeobot;

import se.lexicon.romeobot.models.Drinks;
import se.lexicon.romeobot.models.Nuts;
import se.lexicon.romeobot.models.Products;

public class JunkFoodMachine implements VendingMachine {

    final int FEMTILAPP = 50;
    final int HUNDRING = 100;
    final int FEMHUNDRING = 500;
    public enum DENOMINATIONS {FEMTILAPP, HUNDRING, FEMHUNDRING}

    // ENKRONA(1) = ,TVAKRONA(2) ,FEMMA(5) ,TIA(10), TJUGA(20),
    // FEMTILAPP(50), HUNDRING(100), TVAHUNDRING(200), FEMHUNDRING(500), TUSENLAPP(1000)

    int[] denominations2 = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    int depositPool = 0;

    Products[] productList = createList();

    public Products[] createList() {

        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 0);
        Products pepsi33 = new Drinks
                ("Pepsi Can", "-Carbonated water, cola flavour, no fat.", 16, 33, 11);
        Products pepsimax33 = new Drinks
                ("Pepsi Max Can", "-Carbonated water, cola flavour, no fat.", 16, 33, 0);
        Products fanta50 = new Drinks
                ("Fanta Bottle", "-Carbonated water, orange flavour, no fat.", 22, 50, 12);
        Products peanuts150 = new Nuts
                ("Peanuts Small", "-50% fat, 20% carbon hydrates, 25% protein.", 10, 150, true);
        Products cashew150 = new Nuts
                ("Cashewnuts Small", "-50% fat, 25% carbon hydrates, 20% protein.", 18, 150, true);
        Products cashew150natural = new Nuts
                ("Cashewnuts Sm Nat", "-50% fat, 25% carbon hydrates, 20% protein.", 19, 150, false);
        Products walnut150 = new Nuts
                ("Walnuts Sm Natural", "-60% fat, 15% carbon hydrates, 15% protein.", 24, 150, false);
        Products peanuts500 = new Nuts
                ("Peanuts Big", "-50% fat, 20% carbon hydrates, 25% protein.", 20, 500, true);
        Products cashew500 = new Nuts
                ("Cashewnuts Big", "-50% fat, 25% carbon hydrates, 20% protein.", 45, 500, true);

        Products[] productList = new Products[]{cola33, colazero33, cola50, colazero50, pepsi33, pepsimax33,
                fanta50, peanuts150, cashew150, cashew150natural, walnut150, peanuts500, cashew500};
        return productList;
    }

    public void printList(Products[] productList) {
        System.out.println("What do you want to buy? Here is our products:");
        for (int i = 0; i < productList.length; i++) {
            System.out.println(productList[i].examine());
        }
    }

    @Override
    public void addCurrency(int amount) {
        for (int i = 0; i < denominations2.length; i++) {
            if (amount == denominations2[i]) {
                depositPool = depositPool + amount;
                System.out.println(amount + " Kr added to the amount.");
                System.out.println("You now have " + getBalance() + " Kr.");
                return;
            }
        }
        if (amount > 15){
            System.out.println(amount + " Kr? This bill is not valid:");
        } else{
            System.out.println(amount + " Kr? This coin is not valid:");
        }
    }

    @Override
    public Products request(int productNumber) {

        for (int i = 0; i < productList.length; i++) {

             if(productNumber ==  productList[i].getProductId()) {
                 if(productList[i].getPrice() <= getBalance()){
                     depositPool = depositPool - productList[i].getPrice();
                     System.out.println("You bought " + productList[i].getName() + " for " +
                             productList[i].getPrice() + " Kr.");
                     System.out.println("You now have " + getBalance() + " Kr left.");
                     return productList[i];
                 } else {
                     System.out.println(productList[i].getName() + " for " + productList[i].getPrice() +
                             " Kr? You can't afford that!");
                     System.out.println("You have only " + getBalance() + " Kr left.");
                     return productList[i];
                 }
             }
        }
        System.out.println(productNumber + "? It is out of stock.");
        return null;
    }

    @Override
    public int endSession() { // always returns 0?
        int change = 0;

        for (int i = denominations2.length - 1; i >= 0; i--) {
            change = getBalance() / denominations2[i];
            depositPool = (getBalance() % denominations2[i]);

            if (change > 0){
                System.out.print("Change returned: " + change + " x " + denominations2[i]);
                if(i > 3){
                    System.out.println(" bill");
                } else {
                    System.out.println(" coin");
                }
            }
            if (depositPool == 0){
                return depositPool;
            }
        }
        return getBalance();
    }

    @Override
    public String getDescription(int productNumber) {
        return null;
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        String[] info = new String[productList.length];
        for (int i = 0; i < productList.length; i++) {
            info[i] = "Id nr: " + productList[i].getProductId() + "-" + productList[i].getName();
            if(productList[i].getProductId() % 5 == 0){
                info[i] = info[i] + "\n";
            }
        }
        return info;
    }
}
