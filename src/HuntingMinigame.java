import java.util.Scanner;
import java.util.Random;
/**
 * Class for the minigame where the player can attempt to hunt for supplementary food
 * @author Will Klepinger
 * @since 03/24/21 11:45AM
 */
public class HuntingMinigame {

    // Variables
    private int animalsRemaining;

    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    /**
     * Constructor for HuntingMinigame class
     */
    public HuntingMinigame(){
        // initialize animals remaining
        this.animalsRemaining = 15;
    }

    /**
     * Function to simulate hunting minigame
     * @return true if player hits an animal
     * false otherwise
     */
    public Boolean playGame(){

        if (animalsRemaining == 0) {
            System.out.println("Animals are scarce! Come back later!");
            animalsRemaining++;
            return false;
        }
        // array of possible outcomes
        char outcomes[] = {'W', 'S','A', 'D'};
        // pick one direction randomly
        int randIndex = random.nextInt(3);
        char animalLocation = outcomes[randIndex];
        System.out.println("Pick a direction with W,S,A,D to shoot.");

        char input = sc.next().charAt(0);
        input = java.lang.Character.toUpperCase(input);
        // if user input matches direction, return true and subtract animalsRemaining
        if(input == animalLocation){
            animalsRemaining--;
            System.out.println("You got one!");
            return true;
        }
        else{
            // return false otherwise
            return false;
        }
    }
}
