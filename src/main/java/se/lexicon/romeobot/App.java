package se.lexicon.romeobot;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        JunkFoodMachine myMachine = new JunkFoodMachine();

        int randomInt = (int)(Math.pow(10, (int)(Math.random() * 3))) * (int)(Math.random() * 5 + 1);

        System.out.println("Insert amount " + " kr.");
        myMachine.addCurrency(randomInt);
        myMachine.printList(myMachine.productList);
        myMachine.addCurrency(randomInt);
        System.out.println("You have " + myMachine.getBalance() + " kr left.");

        myMachine.request(101);
        myMachine.printList(myMachine.productList);
        myMachine.request(107);



        myMachine.addCurrency(randomInt);
        myMachine.request(111);
        myMachine.request(103);

        myMachine.addCurrency(12);
        myMachine.addCurrency(50);
        System.out.println("You have " + myMachine.getBalance() + " kr left.");

        System.out.println(Arrays.toString(myMachine.getProducts()));
        myMachine.request(113);
        myMachine.request(102);
        myMachine.addCurrency(1000);
        myMachine.request(123);
        myMachine.request(113);
        myMachine.request(106);
        myMachine.request(101);

        myMachine.endSession();

        System.out.println(Arrays.toString(myMachine.getProducts()));

        for (int i = 0; i < 3; i++) {
            randomInt = (int)(Math.pow(10, (int)(Math.random() * 3))) * (int)(Math.random() * 5 + 1);
            myMachine.addCurrency(randomInt);
            myMachine.addCurrency(randomInt);
        }
        myMachine.printList(myMachine.productList);

        for (int i = 0; i < myMachine.productList.length; i++) {
            myMachine.request(myMachine.productList[i].getProductId());
            myMachine.request((int)(Math.random()*20 + 100));
            if (myMachine.getBalance() < 20){
                randomInt = (int)(Math.pow(10, (int)(Math.random() * 3))) * (int)(Math.random() * 5 + 1);
                myMachine.addCurrency(randomInt);
            }
        }
        myMachine.endSession();
    }
}
