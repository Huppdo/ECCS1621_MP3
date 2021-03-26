import java.util.ArrayList;

/**
 Holds the map for the game

 @since 3.24.21
 @author Dominic Hupp
 */

public class Trail {

    private java.util.ArrayList<Landmarks> trailMap;
    private Weather weather;
    private int currentLocation;
    private java.util.Random randGen;

    /**
     * Default constructor for trail; resets current location and generates a new map
     */
    public Trail() {
        //Get a random number generator
        randGen = new java.util.Random();
        trailMap = new java.util.ArrayList<>();
        weather = Weather.SUNNY;

        //Add start to map
        trailMap.add(Landmarks.START);

        //Generate map
        appendBlank(randGen);
        trailMap.add(Landmarks.FORT_BRIDGER);
        appendBlank(randGen);
        trailMap.add(Landmarks.FORT_BOISE);
        appendBlank(randGen);
        trailMap.add(Landmarks.INDEPENDENCE_ROCK);
        appendBlank(randGen);
        trailMap.add(Landmarks.FORT_HALL);
        appendBlank(randGen);
        trailMap.add(Landmarks.OREGON_CITY);
    }

    /**
     * Adds between 8-20 blank tiles on the map
     * @param randGen an instance of the java.util.Random class
     */
    private void appendBlank(java.util.Random randGen) {
        for (int i = 0; i < randGen.nextInt(12) + 8; i++) {
            trailMap.add(Landmarks.NONE);
            if (randGen.nextInt(12) == 6) {
                trailMap.add(Landmarks.RIVER);
            }
        }
    }

    /**
     * Gets the current location of the
     * @return a Landmarks enum that represents the current location
     */
    public Landmarks getLocation() {
        return trailMap.get(currentLocation);
    }

    /**
     * Advances the current location on the map
     * @param wagon the wagon of the player
     * @return the amount of damage done to the wagon
     */
    public int move(Wagon wagon) {

        //Gets the number of ox
        int movement = wagon.getSpeed();

        movement -= wagon.getFatigued();

        if (movement < 1) {
            movement = 1;
        }

        //Stops the user at specific locations
        for (int i = 1; i <= movement; i++) {
            int location = currentLocation + i;
            if (trailMap.get(location) != Landmarks.NONE) {
                movement = i;
                break;
            }
        }

        //Gets updated weather condition
        int newWeather = randGen.nextInt(12);
        switch (newWeather) {
            case 0:
                weather = Weather.CLOUDY;
                break;
            case 1:
                weather = Weather.DUSTY;
                break;
            case 2:
                weather = Weather.RAINING;
                break;
            case 3:
                weather = Weather.WINDY;
                break;
            case 4:
                weather = Weather.SNOWY;
                break;
            case 5:
                weather = Weather.SUNNY;
                break;
        }

        currentLocation += movement;

        int damageMultiplier = 2;
        switch (weather) {
            case DUSTY:
                damageMultiplier = 4;
                break;
            case SNOWY:
                damageMultiplier = 8;
                break;
            case RAINING:
                damageMultiplier = 6;
                break;
        }

        //Returns the damage done (movement * multiplier)
        return movement * damageMultiplier;
    }

    /**
     * gets the current weather conditions on the trail
     * @return current weather conditions
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Prints out a random trail fact to the console.
     * @param facts The ArrayList containing facts about the trail.
     */
    public void trailTidbit(ArrayList<String> facts) {
        if (facts.size() > 0) {
            System.out.print("Trail Tidbit! Did you know: ");
            System.out.println(facts.get(randGen.nextInt(facts.size())));
        } else {
            System.out.println("Sorry, we're all out of Trail Tidbits!");
        }

        System.out.println("------------------------------");
    }
}
