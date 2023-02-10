/**Class: Player
 * @author Muketoi Celestino
 * @version 1.0
 * Course: ITEC 3860 Spring 2023
 * Written: February 10, 2023
 *
 * This class – a blueprint for what details of the player would be needed for the game.
 *              such as name of player, number of rooms Visited, current room they are in.
 */

public class Player {
    private String name;
    private int numberOfRoomsVisited;
    private int locationID;

    public Player(String name, int numberOfRoomsVisited, int locationID){
        this.name = name;
        this.numberOfRoomsVisited = numberOfRoomsVisited;
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfRoomsVisited() {
        return numberOfRoomsVisited;
    }

    public void setNumberOfRoomsVisited(int numberOfRoomsVisited) {
        this.numberOfRoomsVisited = numberOfRoomsVisited;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

}
