import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Main.java
 *
 * Contains the main method and puts all the classes together so the game actually runs.
 *
 * @author Wyatt Fisher, Dominic Hupp
 * @since 3.24.21
 *
 */
public class Main {

    private static String userInputStr1;
    private static String userInputStr2;
    private static int userInputInt;
    private static boolean inputFlag = true;
    private static int numberOfFamily;

    private static Wagon wagon;
    private static Trail trail;

    public static void main(String[] args) {

        // generate a random number of family members
        Random rand = new Random();
        numberOfFamily = rand.nextInt(5) + 1;

        //Create new wagon & trail
        wagon = new Wagon(new Character[0], 800*numberOfFamily,10*numberOfFamily, 1, 1, 0, 100);
        trail = new Trail();

        // display welcome messages and allow the user to start the game
        System.out.println("Welcome to the Oregon Trail simulation game!");
        Scanner keyboard = new Scanner(System.in);

        // try and catch to avoid program crashing
        do {
            System.out.print("Press 1 to begin the game: ");

            try {
                userInputInt = keyboard.nextInt();
                inputFlag = false;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number...");
                System.out.print("Press 1 to begin the game: ");
                keyboard.nextLine();
                inputFlag = true;
            }
        } while(inputFlag);

        // get the player's name
        keyboard.nextLine();
        System.out.print("Please enter your name: ");
        userInputStr1 = keyboard.nextLine();

        // get player's age and use try and catch to avoid program crashing
        do {
            System.out.print("Please enter your age: ");

            try {
                userInputInt = keyboard.nextInt();
                inputFlag = false;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number...");
                keyboard.nextLine();
                inputFlag = true;
            }
        } while(inputFlag);

        // get player's gender
        keyboard.nextLine();
        System.out.print("Please enter your gender: ");
        userInputStr2 = keyboard.nextLine();

        // create a character for the player
        Character[] family = new Character[numberOfFamily];
        family[0] = new Character(userInputStr1, userInputInt, userInputStr2);

        // generate array of family members
        for(int i = 1; i < numberOfFamily; i++) {
            // get the player's name
            keyboard.nextLine();
            System.out.print("Please enter a new family members name: ");
            userInputStr1 = keyboard.nextLine();

            // get player's age and use try and catch to avoid program crashing
            do {
                System.out.print("Please enter their age: ");

                try {
                    userInputInt = keyboard.nextInt();
                    inputFlag = false;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number...");
                    keyboard.nextLine();
                    inputFlag = true;
                }
            } while(inputFlag);

            // get player's gender
            keyboard.nextLine();
            System.out.print("Please enter their gender: ");
            userInputStr2 = keyboard.nextLine();

            family[numberOfFamily] = new Character(userInputStr1, userInputInt, userInputStr2);
        }

        wagon.setFamily(family);

        // display details of the player's family members

        // begin the game


    }
}
