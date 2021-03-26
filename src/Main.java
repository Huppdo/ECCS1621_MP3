import java.util.*;
import java.io.*;

/**
 * Main.java
 *
 * Contains the main method and puts all the classes together so the game actually runs.
 *
 * @author Wyatt Fisher, Dominic Hupp, Will Klepinger
 * @since 3.24.21
 *
 */
public class Main {

    private static String userInputStr1;
    private static String userInputStr2;
    private static int userInputInt;
    private static boolean inputFlag = true;
    private static int numberOfFamily;
    private static ArrayList<String> factsAL;
    private static ArrayList<String> triviaQuestions;
    private static ArrayList<String[]> answerChoices;
    private static ArrayList<String> correctAnswers;

    // declare objects
    private static Wagon wagon;
    private static Trail trail;
    private static HuntingMinigame huntingMinigame;
    private static Landmark landmark;
    private static Scanner keyboard;
    private static File factsInFile;
    private static File triviaInFile;
    private static Scanner fileScanner;

    private static int day;

    public static void main(String[] args) {

        // generate a random number of family members
        Random rand = new Random();
        numberOfFamily = rand.nextInt(5) + 1;

        day = 0;

        // initialize objects
        wagon = new Wagon(new Character[0], 800*numberOfFamily,10*numberOfFamily, 1, 1, 1, 100);
        trail = new Trail();
        huntingMinigame = new HuntingMinigame();
        landmark = new Landmark();
        keyboard = new Scanner(System.in);
        factsInFile = new File("src\\Facts.txt");
        triviaInFile = new File("src\\Trivia.txt");

        // create a scanner to read from the Facts.txt file using try/catch
        try {
            fileScanner = new Scanner(factsInFile);
        } catch(FileNotFoundException e) {
            System.out.println("Facts file not found!");
        }

        // read in facts from list into an ArrayList
        factsAL = new ArrayList<>();
        while(fileScanner.hasNext()) {
            factsAL.add(fileScanner.nextLine());
        }

        // create a scanner to read from the Trivia.txt file using try/catch
        try {
            fileScanner = new Scanner(triviaInFile);
        } catch(FileNotFoundException e) {
            System.out.println("Trivia file not found!");
        }

        // read in trivia from list into an ArrayList
        triviaQuestions = new ArrayList<>();
        answerChoices = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        while(fileScanner.hasNext()) {
            String inputLine = fileScanner.nextLine();
            String[] inputTokens = inputLine.split("--");
            triviaQuestions.add(inputTokens[0]);
            answerChoices.add(new String[]{inputTokens[1], inputTokens[2], inputTokens[3], inputTokens[4]});
            correctAnswers.add(inputTokens[5]);
        }

        // display welcome messages and allow the user to start the game
        System.out.println("Welcome to the Oregon Trail simulation game!");
        System.out.println("------------------------------");

        // have the player begin the game
        System.out.print("Press any key to begin the game >> ");
        keyboard.nextLine();

        // get the player's name
        System.out.print("Please enter your name >> ");
        userInputStr1 = keyboard.nextLine();

        // get player's age and use try and catch to avoid program crashing
        do {
            System.out.print("Please enter your age >> ");

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
        System.out.print("Please enter your gender >> ");
        userInputStr2 = keyboard.nextLine();

        // create a character for the player
        Character[] family = new Character[numberOfFamily];
        family[0] = new Character(userInputStr1, userInputInt, userInputStr2);

        // generate array of family members
        for(int i = 1; i < numberOfFamily; i++) {
            // get the player's name
            System.out.print("Please enter a new family members name >> ");
            userInputStr1 = keyboard.nextLine();

            // get player's age and use try and catch to avoid program crashing
            do {
                System.out.print("Please enter their age >> ");

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
            System.out.print("Please enter their gender >> ");
            userInputStr2 = keyboard.nextLine();

            family[i] = new Character(userInputStr1, userInputInt, userInputStr2);
        }

        // add family to wagon
        wagon.setFamily(family);

        // begin the game
        while (!wagon.checkEnd()) {
            // get type of landmark
            Landmarks currentType = trail.getLocation();
            // display count of day and day's weather and display fact about Oregon Trail
            System.out.println("------------------------------");
            System.out.println("Day " + day + ": the weather is currently " + trail.getWeather().toString());
            trail.trailTidbit(factsAL);

            if (currentType == Landmarks.NONE) {

                // give user choice of action
                System.out.print("Would you like to go (H)unting, (S)ee your party's stats, (R)epair your wagon, or (C)ontinue? >> ");
                String ans = keyboard.nextLine();

                char dayAnswer;
                // make player continue if they leave a blank answer, otherwise use their input
                if (ans.isBlank()) {
                    dayAnswer = 'C';
                } else {
                    dayAnswer = ans.toUpperCase(Locale.ROOT).charAt(0);
                }
                // switch case to handle what user picked from menu
                switch (dayAnswer) {
                    case 'H':
                        if (wagon.getAmmo() > 0) {
                            // subtract ammo for every time they hunt
                            wagon.addAmmo(-1);
                            boolean success = huntingMinigame.playGame();
                            Character[] tempFamily = wagon.getFamily();
                            // if user kills an animal,
                            if (success) {
                                // give the family food and improve morale
                                wagon.addFood(3 * numberOfFamily);
                                wagon.updateMorale(10, true, rand);
                                System.out.println("You got one! " + (3 * numberOfFamily) + " food");
                            } else {
                                // if the user misses, decrease morale
                                wagon.updateMorale(10, false, rand);
                            }
                        } else {
                            System.out.println("Sorry, you don't have any ammo.");
                        }
                        break;
                    case 'R':
                        wagon.repairWagon();
                        break;
                    case 'S':
                        // display family and wagon stats
                        System.out.println("---------------");
                        for (Character person : wagon.getFamily()) {
                            System.out.println(person.getName() + " - status: " + person.getStatus().toString() + ", morale: " + person.getMorale() + ", clothes: " + person.getClothing());
                        }
                        System.out.println("Wagon - ammo: " + wagon.getAmmo() + ", food: " + wagon.getFood() + ", health: " + wagon.getHealth());
                        break;
                    default:
                        break;
                }

            } else if (currentType == Landmarks.RIVER) {
                // if the player reaches a river, give them an option to wait a day
                // or try to cross the river
                System.out.println("Oh no! You've reached a river.");
                System.out.print("Would you like to try and (F)ord the river or (W)ait for a ferry? >> ");
                String ans = keyboard.nextLine();

                char dayAnswer;

                // no input handling, force user to cross if blank
                if (ans.isBlank()) {
                    dayAnswer = 'F';
                } else {
                    dayAnswer = ans.toUpperCase(Locale.ROOT).charAt(0);
                }

                if (dayAnswer == 'F') {
                    // give user 50/50 chance of crossing successfully
                    boolean risk = rand.nextBoolean();
                    // if they fail,
                    if (risk) {
                        // randomly impose an unfortunate scenario:
                        int action = rand.nextInt(5);
                        switch (action) {
                            case 0:
                                // their wagon takes a random amount of damage
                                int wagonDamage = rand.nextInt(20) + 1;
                                wagon.damageWagon(wagonDamage);
                                System.out.println("You hit a rock and lost " + wagonDamage + " wagon health.");
                                break;
                            case 1:
                                // they lose a random amount of food
                                int foodLoss = rand.nextInt(6) + 1;
                                wagon.addFood(foodLoss * -1);
                                System.out.println("" + foodLoss + " items of food got waterlogged and had to be left behind.");
                                break;
                            case 2:
                                // they lose morale because of wet clothing
                                wagon.updateMorale(10, false, rand);
                                System.out.println("Your family is upset by their soaking wet clothes.");
                                break;
                            case 3:
                                // if they have more than 1 ox, drown an ox
                                if (wagon.getSpeed() > 1) {
                                    wagon.addOx(-1);
                                    System.out.println("One of your oxen drowned in the river.");
                                } else {
                                    System.out.println("You almost lost your only oxen to drowning. Don't try that again.");
                                }
                                break;
                            case 4:
                                // or a family member dies
                                Character[] tempFamily = wagon.getFamily();
                                for (int i = 1; i < tempFamily.length; i++) {
                                    int dieChance = rand.nextInt(3);
                                    if (dieChance == 1) {
                                        tempFamily[i].setStatus(PlayerStatuses.DEAD);
                                        System.out.println("" + tempFamily[i].getName() + " drowned in the river.");
                                    }
                                }
                                wagon.setFamily(tempFamily);
                        }
                    }
                    // otherwise they make it across the river successfully
                } else {
                    day += 1;
                    wagon.updateFood();
                    wagon.updateMorale(4,false,rand);
                }
                // display winning message that they have made it to the end of the trail
            } else if (currentType == Landmarks.OREGON_CITY) {
                System.out.println("Congrats! You've made it to " + currentType.toString() + ".");
                break;
            } else {
                // message when the player starts the game
                if (currentType == Landmarks.START) {
                    System.out.println("Welcome to " + currentType.toString() + "! You'll be leaving shortly.");
                } else {
                    // message when the player makes it to a new landmark
                    // and start a trivia game with player
                    System.out.println("You have made it to: " + currentType.toString() + ".");
                    landmark.trivia(wagon, keyboard, triviaQuestions, answerChoices, correctAnswers, rand);
                }

                wagon.updateMorale(14, true, rand);

                landmark.openShop(wagon, keyboard);
            }

            wagon.updateFood();
            wagon.endDay(rand, trail.getWeather());
            int damage = trail.move(wagon);
            wagon.damageWagon(damage);
            day += 1;
        }


    }
}
