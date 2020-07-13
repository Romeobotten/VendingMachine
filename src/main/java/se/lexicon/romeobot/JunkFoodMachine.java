package se.lexicon.romeobot;

import se.lexicon.romeobot.models.ChocolateBars;
import se.lexicon.romeobot.models.Drinks;
import se.lexicon.romeobot.models.Nuts;
import se.lexicon.romeobot.models.Products;

public class JunkFoodMachine implements VendingMachine {

    private final int ENKRONA = (1);
    private final int TVAKRONA = (2);
    private final int FEMMA = (5);
    private final int TIA = (10);
    private final int TJUGA = (20);
    private final int FEMTILAPP = (50);
    private final int HUNDRING = (100);
    private final int TVAHUNDRING = (200);
    private final int FEMHUNDRING = (500);
    private final int TUSENLAPP = (1000);

    public enum DENOMINATIONS {ENKRONA, TVAKRONA, FEMMA, TIA,
        TJUGA, FEMTILAPP, HUNDRING, TVAHUNDRING, FEMHUNDRING, TUSENLAPP}
    int[] denominations2 = {ENKRONA, TVAKRONA, FEMMA, TIA,
            TJUGA, FEMTILAPP, HUNDRING, TVAHUNDRING, FEMHUNDRING, TUSENLAPP};
    int depositPool;

    Products[] productList = createList();

    public Products[] createList() {

        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.",
                        18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.",
                        18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.",
                        22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.",
                        22, 50, 0);
        Products pepsi33 = new Drinks
                ("Pepsi Can", "-Carbonated water, cola flavour, no fat.",
                        16, 33, 11);
        Products pepsimax33 = new Drinks
                ("Pepsi Max Can", "-Carbonated water, cola flavour, no fat.",
                        16, 33, 0);
        Products fanta50 = new Drinks
                ("Fanta Bottle", "-Carbonated water, orange flavour, no fat.",
                        22, 50, 12);
        Products peanuts150 = new Nuts
                ("Peanuts Small", "-50% fat, 20% carbon hydrates, 25% protein.",
                        10, 150, true);
        Products cashew150 = new Nuts
                ("Cashewnuts Small", "-50% fat, 25% carbon hydrates, 20% protein.",
                        18, 150, true);
        Products cashew150natural = new Nuts
                ("Cashewnuts Sm Nat", "-50% fat, 25% carbon hydrates, 20% protein.",
                        19, 150, false);
        Products walnut150 = new Nuts
                ("Walnuts Sm Natural", "-60% fat, 15% carbon hydrates, 15% protein.",
                        24, 150, false);
        Products peanuts500 = new Nuts
                ("Peanuts Big", "-50% fat, 20% carbon hydrates, 25% protein.",
                        20, 500, true);
        Products cashew500 = new Nuts
                ("Cashewnuts Big", "-50% fat, 25% carbon hydrates, 20% protein.",
                        45, 500, true);
        Products twix60 = new ChocolateBars
                ("Twix Small", "-25% fat, 50% sugar, 20% coconut. Chocolate-",
                        10, 60,25);
        Products twix200 = new ChocolateBars
                ("Twix Big", "-25% fat, 50% sugar, 20% coconut. Chocolate-",
                        18, 200, 25);
        Products snickers60 = new ChocolateBars
                ("Snickers Small", "-28% fat, 45% sugar, 22% peanuts. Chocolate-",
                        10, 60,22);
        Products snickers200 = new ChocolateBars
                ("Snickers Big", "-28% fat, 45% sugar, 22% peanuts. Chocolate-",
                        18, 200, 22);
        Products mars60 = new ChocolateBars
                ("Mars Small", "-22% fat, 55% sugar, 18% caramel. Chocolate-",
                        10, 60,28);
        Products mars200 = new ChocolateBars
                ("Mars Big", "-22% fat, 55% sugar, 18% caramel. Chocolate-",
                        18, 200, 28);

        Products[] productList = new Products[]
                {cola33, colazero33, cola50, colazero50, pepsi33, pepsimax33, fanta50,
                peanuts150, cashew150, cashew150natural, walnut150, peanuts500, cashew500,
                twix60, twix200, snickers60, snickers200, mars60, mars200};
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
        int change;

        if(getBalance() == 0){
            System.out.println("No change:");
        }
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
        for (int i = 0; i < productList.length; i++) {
            if(productList[i].getProductId() == productNumber){
                return productList[i].getDescription();
            }
        }
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
        }
        return info;
    }
}
