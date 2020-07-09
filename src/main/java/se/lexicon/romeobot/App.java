package se.lexicon.romeobot;


import se.lexicon.romeobot.models.*;
import se.lexicon.romeobot.models.Nuts;
import se.lexicon.romeobot.models.Products;

public class App implements VendingMachine {

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
        int depositPool = 0;

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

        System.out.println("What do you want? Here is our products:");
        for (int i = 0; i < productList.length; i++) {
            System.out.println(productList[i].examine());
        }
        depositPool = depositPool + addCurrency(1000);
    }

    @Override
    public void addCurrency(int amount) {

    }
    @Override
    public Products request(int productNumber) {

    }
    @Override
    public int endSession() {

        int amount = 0;
        return amount;
    }
    @Override
    public String getDescription(int productNumber) {

    }
    @Override
    public int getBalance() {

    }

    @Override
    public String[] getProducts() {

    }
}


