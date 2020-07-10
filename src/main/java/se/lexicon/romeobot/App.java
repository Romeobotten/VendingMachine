package se.lexicon.romeobot;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        JunkFoodMachine myMachine = new JunkFoodMachine();

        System.out.println("Insert amount " + " kr.");
        myMachine.addCurrency(20);
        myMachine.printList(myMachine.productList);
        myMachine.addCurrency(10);
        myMachine.addCurrency(25);
        myMachine.addCurrency(5);
        System.out.println("You have " + myMachine.getBalance() + " kr left.");

        myMachine.printList(myMachine.productList);
        myMachine.request(107);
        myMachine.request(101);

        myMachine.addCurrency(5);
        myMachine.addCurrency(10);
        myMachine.request(107);
        myMachine.request(101);
        myMachine.addCurrency(12);
        myMachine.addCurrency(100);
        System.out.println("You have " + myMachine.getBalance() + " kr left.");

        System.out.println(Arrays.toString(myMachine.getProducts()));

        myMachine.request(123);
        myMachine.request(113);


        myMachine.endSession();

    }
}
