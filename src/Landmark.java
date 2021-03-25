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
    private final static int PURCHASE_RANGE = 6;

    /**
     * Initializes the landmark object with random prices to begin
     */
    public Landmark() {
        java.util.Random randGen = new java.util.Random();

        oxPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        foodPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        clothesPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        ammoPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
        partsPrice = (randGen.nextInt(PURCHASE_RANGE)+1) * 100;
    }

    /**
     * Enters the game into shop mode, where users can purchase supplies
     * @param wagon the wagon holding the family and goods
     */
    public void openShop(Wagon wagon) {
        int currentFunds = wagon.getMoney();



    }
}
