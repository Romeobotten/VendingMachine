package se.lexicon.romeobot;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        JunkFoodMachine myMachine = new JunkFoodMachine();

        /**
        String[] shortList = myMachine.getProducts();
        System.out.println(Arrays.toString(myMachine.productList));
        for (int i = 0; i < shortList.length; i++) {
            System.out.println(shortList[i]);
        }

        // randomInt could have values 1-5,10-50,100-500. 3-4,30-40,300-400 is not valid.
        int randomInt = (int) (Math.pow(10, (int) (Math.random() * 3))) * (int) (Math.random() * 5 + 1);
        myMachine.addCurrency(randomInt);

        randomInt = (int) (Math.pow(10, (int) (Math.random() * 3))) * (int) (Math.random() * 5 + 1);
        myMachine.addCurrency(randomInt);
        myMachine.addCurrency(randomInt);

        randomInt = (int) (Math.pow(10, (int) (Math.random() * 3))) * (int) (Math.random() * 5 + 1);
        myMachine.addCurrency(randomInt);
        myMachine.addCurrency(randomInt);

        myMachine.printList(myMachine.productList);
        // Buying everything + one random item every time
        for (int i = 0; i < myMachine.productList.length; i++) {
            myMachine.request(myMachine.productList[i].getProductId());
            myMachine.request((int) (Math.random() * 22 + 100));
            if (myMachine.getBalance() < 20) {  // Trying to add amount if you have less than 20
                randomInt = (int) (Math.pow(10, (int) (Math.random() * 3))) * (int) (Math.random() * 5 + 1);
                myMachine.addCurrency(randomInt);
            }
        }
        System.out.println("Drinks:");
        myMachine.getProducts('d');

        System.out.println("Nuts:");
        myMachine.getProducts('n');

        System.out.println("ChocolateBars:");
        myMachine.getProducts('c');


        myMachine.endSession(); // End of auto part
        */

        Scanner reader = new Scanner(System.in);
        String input;
        int inputNr;

        while (true) {
            System.out.println("Welcome to my Junkfood Machine!");
            System.out.println("Enter q to quit, or an Id number to buy things.");
            System.out.print("Enter a number to insert coins and bills. Enter 0 to see the products.");
            System.out.println("These coins and bills are valid.");
            for (JunkFoodMachine.DENOMINATIONS kr : JunkFoodMachine.DENOMINATIONS.values())
                System.out.print(kr + ", ");

            System.out.println("\nInsert amount or Id number: ");
            input = reader.nextLine();  // Reading a number

            if (input.equalsIgnoreCase("q")) { // Want to quit?
                myMachine.endSession();
                System.out.println("Thank you and goodbye!");
                break; // Program ends if input is q
            }
            inputNr = Integer.parseInt(input); // Throw Exeption here?

            if (inputNr < 1 || inputNr > 1000) {
                if (inputNr == 0) {
                    myMachine.printList(myMachine.productList);
                } else {
                    System.out.println("I can't accept that.");
                }
            } else {
                if (inputNr > 100 && inputNr < 200) {
                    myMachine.request(inputNr);
                } else {
                    myMachine.addCurrency(inputNr);
                }
            }
        }
    }
}
