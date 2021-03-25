import java.util.Locale;
import java.util.Scanner;

/**
 Representation of a fort / shop for the player to interact with

 @since 3.24.21
 @author Dominic Hupp
 */

public class Landmark {

    //Variables to store the current prices
    private int oxPrice;
    private int foodPrice;
    private int clothesPrice;
    private int ammoPrice;
    private int partsPrice;
    private final static int PURCHASE_RANGE = 3;

    /**
     * Initializes the landmark object with random prices to begin
     */
    public Landmark() {
        java.util.Random randGen = new java.util.Random();

        oxPrice = (randGen.nextInt(PURCHASE_RANGE)+3) * 100;
        foodPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        clothesPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        ammoPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        partsPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
    }

    /**
     * Enters the game into shop mode, where users can purchase supplies
     * @param wagon the wagon holding the family and goods
     */
    public void openShop(Wagon wagon, Scanner keyboard) {
        System.out.println("Welcome to the Oregon Trail store.");
        System.out.println("Current Ox: " + wagon.getSpeed() + ", Current Ammo: " + wagon.getAmmo());
        System.out.println("Current Parts: " + wagon.getParts() + ", Current Food: " + wagon.getFood());

        char ans = 'Z';

        do {

            int currentFunds = wagon.getMoney();

            if (currentFunds == 0) {
                System.out.println("You're out of money, so no more shopping.");
                break;
            }

            System.out.println("---------------");
            System.out.println("You currently have " + currentFunds + " dollars.");
            System.out.println("Prices:");
            System.out.println("Ox (+1): " + oxPrice + ", Ammo (+10): " + ammoPrice);
            System.out.println("Parts (+1): " + partsPrice + ", Food (+6): " + foodPrice);
            System.out.println("Clothes (+1): " + clothesPrice);
            System.out.println("What would you like to purchase?");
            System.out.println("(O)x, (A)mmo, (P)arts, (F)ood, (C)lothes or (Q)uit shopping");

            String answer = keyboard.nextLine();

            if (answer.isBlank()) {
                ans = 'Z';
            } else {
                ans = answer.toUpperCase(Locale.ROOT).charAt(0);
            }

            try {
                switch (ans) {
                    case 'O':
                        if (currentFunds >= oxPrice) {
                            wagon.addOx(1);
                            wagon.setMoney(wagon.getMoney() - oxPrice);
                        } else {
                            throw new Exception();
                        }
                        break;
                    case 'A':
                        if (currentFunds >= ammoPrice) {
                            wagon.addAmmo(10);
                            wagon.setMoney(wagon.getMoney() - ammoPrice);
                        } else {
                            throw new Exception();
                        }
                        break;
                    case 'P':
                        if (currentFunds >= partsPrice) {
                            wagon.addParts(1);
                            wagon.setMoney(wagon.getMoney() - partsPrice);
                        } else {
                            throw new Exception();
                        }
                        break;
                    case 'F':
                        if (currentFunds >= foodPrice) {
                            wagon.addFood(6);
                            wagon.setMoney(wagon.getMoney() - foodPrice);
                        } else {
                            throw new Exception();
                        }
                        break;
                    case 'C':
                        if (currentFunds >= clothesPrice) {
                            Character[] tempFamily = wagon.getFamily();
                            int person = 100;
                            System.out.println("Who would you like to assign the clothes to?");
                            for (int i = 0; i < tempFamily.length; i++) {
                                System.out.println("" + (i+1) + ") " + tempFamily[i].getName() + " - clothes: " + tempFamily[i].getClothing());
                            }

                            do {
                                System.out.print("Enter the number for the person to add clothes to. >> ");
                                try {
                                    person = keyboard.nextInt() - 1;
                                } catch (Exception ex) {
                                    person = 100;
                                    keyboard.nextLine();
                                }
                            } while (person > tempFamily.length-1 || person < 0);

                            tempFamily[person].setClothing(tempFamily[person].getClothing() + 1);
                            wagon.setFamily(tempFamily);
                            wagon.setMoney(wagon.getMoney() - clothesPrice);
                        } else {
                            throw new Exception();
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("You don't have enough money for that!");
            }

        } while (ans != 'Q');
    }
}
