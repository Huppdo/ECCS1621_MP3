/**
 * This class represents the player's wagon.
 *
 * @author Will Klepinger
 * @since 03/23/21 1:45PM
 */
public class Wagon {
    private Character[] family;
    private int money;
    private int food;
    private int oxAmount;
    private int spareParts;
    private int ammo;
    private int health = 100;

    /**
     * Constructor for Wagon class
     */
    // constructor
    public Wagon(Character[] family, int money, int food, int oxAmount, int spareParts, int ammo, int health){
        this.family = family;
        this.money = money;
        this.food = food;
        this.oxAmount = oxAmount;
        this.spareParts = spareParts;
        this.ammo = ammo;

    }

    /**
     * Subtracts food inventory
     */
    private void updateFood(){
        for (Character character : family) {
            if (character.getStatus() != PlayerStatuses.DEAD) {
                food--;
            }
        }
    }

    /**
     * Check if game is over
     * @return true if the game is over, either morale is zero, everyone is dead or wagon's health is zero
     * false otherwise
     */
    private Boolean checkEnd(){
        // sum family morale
        int moraleSum = 0;
        for (Character character : family) {
            moraleSum += character.getMorale();
        }

        boolean allDead = true;
        for (Character character : family) {
            if (character.getStatus() != PlayerStatuses.DEAD) {
                allDead = false;
                break;
            }
        }
        // check morale, wagon health, or if everyone is dead
        return moraleSum == 0 || health == 0 || allDead;
    }

    /**
     * gets amount of money
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets players money
     * @param money amount of money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * adds food to player's wagon
     * @param food amount of food to append
     */
    public void addFood(int food){
        this.food += food;
    }

    /**
     *
     * @return speed of wagon in relation to how many oxen they have
     */
    public int getSpeed(){
        // how is speed calculated?
        return 0;
    }

    /**
     * repairs wagon by setting health to 100
     */
    public void repairWagon(){
        // if you have spare parts, subtract a part
        if(spareParts != 0){
            spareParts--;
            health = 100;
        }
        // otherwise, tell player they don't have any parts
        else {
            System.out.println("You don't have any parts to fix the wagon");
        }
    }

    /**
     * Adds ammo to wagon
     * @param ammo - amount of ammo to be added to player's current ammo
     */
    public void addAmmo(int ammo){
        this.ammo += ammo;
    }

    /**
     * removes ammo from wagon
     * @param ammo - amount of ammo to be removed to player's current ammo
     */
    public void removeAmmo(int ammo){
        this.ammo -= ammo;
    }

    /**
     * retrieve ammo in wagon
     * @return wagon's current ammo
     */
    public int getAmmo() {
        return ammo;
    }

    public void setFamily(Character[] characters) {
        family = characters;
    }
}
