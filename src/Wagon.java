/**
 * Represents the players wagon.
 *
 * @author Will Klepinger, Dominic Hupp
 * Last Updated: 03/24/21
 */
public class Wagon {
    Character[] family;
    int money;
    int food;
    int oxAmount;
    int spareParts;
    int ammo;
    int health;

    /**
     * Constructor for Wagon class
     */
    // constructor
    public Wagon(){
        ;
    }

    /**
     * Updates food for player
     */
    private void updateFood(){
        ;
    }

    /**
     * Check if end of trail
     */
    private void checkEnd(){
        ;
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
        ;
    }

    /**
     *
     * @return speed of wagon in relation to how many oxen they have
     */
    public int getSpeed(){
        return 0;
    }

    /**
     * repairs wagon by setting health to 100
     */
    public void repairWagon(){
        health = 100;
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
