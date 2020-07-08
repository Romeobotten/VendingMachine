package se.lexicon.romeobot;


import se.lexicon.romeobot.models.*;
import se.lexicon.romeobot.models.Nuts;
import se.lexicon.romeobot.models.Products;

public class App {

    public static void main( String[] args ) {
            int[] denominations = {1,2,5,10,20,50,100,200,500,1000};

        Products cola33 = new Drinks
                ("Cola Can", "Massa text", 18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "Massa text", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "Massa text", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "Massa text", 22, 50, 0);
        Products pepsi33 = new Drinks
                ("Pepsi Can", "Massa text", 16, 33, 10);
        Products pepsimax33 = new Drinks
                ("Pepsi Max Can", "Massa text", 16, 33, 0);
        Products fanta50 = new Drinks
                ("Fanta Bottle", "Massa text", 22, 50, 10);
        Products peanuts150 = new Nuts
                ("Peanuts Small", "Massa text", 8, 150, true);
        Products cashew150 = new Nuts
                ("Cashewnuts Small", "Massa text", 18, 150, true);
        Products cashew150natural = new Nuts
                ("Cashewnuts Small Natural", "Massa text", 19, 150, false);
        Products walnut150 = new Nuts
                ("Walnuts Small Natural", "Massa text", 24, 150, false);
        Products peanuts500 = new Nuts
                ("Peanuts Big", "Massa text", 20, 500, true);
        Products cashew500 = new Nuts
                ("Cashewnuts Big", "Massa text", 45, 500, true);

        Products[] productList = new Products[] {cola33,colazero33,cola50,colazero50,pepsi33,pepsimax33,
        fanta50,peanuts150,cashew150,cashew150natural,walnut150,peanuts500,cashew500};

        System.out.println( "What do you want? Here is our products:" );
        for (int i = 0; i < productList.length; i++) {
            System.out.println(productList[i].examine());
        }

    }
}
