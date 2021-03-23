//*******************************************************************
// Character
//
// Represents one individual character within the family travelling
// on the Oregon Trail wagon
//
// Date Last Updated: 3.23.21
// Author(s): Dominic Hupp
//*******************************************************************

public class Character {

    private String name;
    private int age;
    private String gender;
    private int morale;
    private PlayerStatuses status;
    private int clothing;

    /**
     * Default constructor for character class; prompts for character information
     */
    public Character() {
        this.name = "unknown";
        this.age = -1;
        this.gender = "unknown";
        this.morale = 100;
        this.status = PlayerStatuses.HEALTHY;
        this.clothing = 1;
    }

    /**
     * Preferred constructor for character class
     * @param name string representing the name of the character
     * @param age integer representing the characters age, 0-100
     * @param gender string representing the chosen gender of each character
     */
    public Character(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.morale = 100;
        this.status = PlayerStatuses.HEALTHY;
        this.clothing = 1;
    }

    /**
     * Method for other objects to request the name of the character
     * @return string representation of the characters chosen name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for other objects to request the age of the character
     * @return integer representation of the characters chosen age, 0-100
     */
    public int getAge() {
        return age;
    }

    /**
     * Method for other objects to request the morale of the character
     * @return integer representation of the characters chosen morale, 0-100
     */
    public int getMorale() {
        return morale;
    }

    /**
     * Method for external objects to request statuses
     * @return PlayerStatus representation of the current player state
     */
    public PlayerStatuses getStatus() {
        return status;
    }

    /**
     * Allows for the morale of the character object to be edited
     * @param morale integer representation 0-100 of the new player morale
     */
    public void setMorale(int morale) {
        this.morale = morale;
    }

    /**
     * Allows for the status of the character object to be edited
     * @param status PlayerStatuses representation of the new character status
     */
    public void setStatus(PlayerStatuses status) {
        this.status = status;
    }

    /**
     * Allows for the clothing amount of the character object to be edited
     * @param clothing integer representation of number of clothing articles a character has
     */
    public void setClothing(int clothing) {
        this.clothing = clothing;
    }

    /**
     * Increments the player clothing to be added on to (for example, at a shop)
     * @param clothingIncrease the number of clothing articles to add
     */
    public void incrementClothic(int clothingIncrease) {
        this.clothing += clothingIncrease;
    }

}
