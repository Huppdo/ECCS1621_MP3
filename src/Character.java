/**
 * Character.java
 *
 * This represents the person who is actually playing the game along with their family (if they have any).
 *
 * @author Wyatt Fisher
 * @since 3.23.21
 *
 */
public class Character {

    private String name;
    private int age;
    private String gender;
    private int morale;
    private PlayerStatuses status;
    private int clothing;

    /**
     * Constructor of the Character class. This initializes the characters with their names, ages and genders.
     * @param name The name of the character.
     * @param age The age of the character.
     * @param gender The gender of the character
     */
    public Character(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * Returns the name of the character.
     * @return The name of the character as a string.
     */
    public String getName() { return name; }

    /**
     * Returns the age of the character.
     * @return The age of the character as an int.
     */
    public int getAge() { return age; }

    /**
     * Returns the morale of the character.
     * @return The morale of the character as an int.
     */
    public int getMorale() { return morale; }

    /**
     * Returns the current status of the character.
     * @return The current status of the character as an int.
     */
    public PlayerStatuses getStatus() { return status; }

    /**
     * Sets the name of the character.
     * @param name The string name that the character should be given.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets the age of the character.
     * @param age The int age that the character should be given.
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Sets the morale of the character
     * @param morale The int morale that the character should be given.
     */
    public void setMorale(int morale) { this.morale = morale; }

    /**
     * Sets the status of the player.
     * @param status The enum status that the character should be given.
     */
    public void setStatus(PlayerStatuses status) { this.status = status; }

    /**
     * Sets the amount of clothing on the player.
     * @param clothing The int amount of clothing on the player.
     */
    public void setClothing(int clothing) { this.clothing = clothing; }

    /**
     * This method will be called when the player wants to put more clothing items on a character.
     * The int clothing amount for that character will be incremented accordingly.
     */
    public void incrementClothing() {
        clothing++;
    }
}
