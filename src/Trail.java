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
     * Adds between 3-28 blank tiles on the map
     * @param randGen an instance of the java.util.Random class
     */
    private void appendBlank(java.util.Random randGen) {
        for (int i = 0; i < randGen.nextInt(25) + 3; i++) {
            trailMap.add(Landmarks.NONE);
            if (randGen.nextInt(50) == 25) {
                trailMap.add(Landmarks.RIVER);
            }
        }
    }

    /**
     * Advances the current location on the map
     * @param wagon the wagon of the player
     * @return the amount of damage done to the wagon
     */
    public int move(Wagon wagon) {

        //Gets the number of ox
        int movement = wagon.getSpeed();

        //Stops the user at specific locations
        for (int i = 1; i <= movement; i++) {
            if (trailMap.get(currentLocation + i) != Landmarks.NONE) {
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

        //Returns the damage done (movement * 2)
        return movement * 2;
    }
}
