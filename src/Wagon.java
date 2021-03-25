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
    public void updateFood(){
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
    public Boolean checkEnd(){
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
        return moraleSum == 0 || health <= 0 || allDead || food <= 0;
    }

    /**
     * gets amount of money
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * increment parts for store
     * @param parts # to add
     */
    public void addParts(int parts) {
        spareParts += parts;
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
     * Returns the wagon health
     * @return health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     *
     */
    public void damageWagon(int damage) {
        this.health -= damage;
    }

    /**
     * Returns the family
     * @return players family
     */
    public Character[] getFamily() {
        return family;
    }

    /**
     * Returns the players food
     * @return wagon food
     */
    public int getFood() {
        return food;
    }

    /**
     *
     * @return speed of wagon in relation to how many oxen they have
     */
    public int getSpeed(){
        // how is speed calculated?
        return oxAmount;
    }

    /**
     * repairs wagon by setting health to 100
     */
    public void repairWagon(){
        // if you have spare parts, subtract a part
        if(spareParts != 0){
            spareParts--;
            health = 100;
            System.out.println("The wagon has been repaired!");
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

    /**
     * Number of ox to add
     * @param ox oxen to add
     */
    public void addOx(int ox) {
        oxAmount += ox;
    }

    /**
     * Current amount of spare parts
     * @return # of spare parts
     */
    public int getParts(){
        return spareParts;
    }

    public void updateMorale(int maxChange, boolean addMorale, java.util.Random rand) {
        for (int i = 0; i < family.length; i++) {
            family[i].setMorale(family[i].getMorale() - (rand.nextInt(maxChange) * (addMorale ? 1 : -1)));
        }
    }
}
