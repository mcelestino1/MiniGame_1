import java.util.ArrayList;
/**Class: Room
 * @author Muketoi Celestino
 * @version 1.0
 * Course: ITEC 3860 Spring 2023
 * Written: February 10, 2023
 *
 * This class – a blueprint for all the rooms and what they should have.
 *              It has the methods that the rooms will need to access
*/
public class Room {
    private int roomId;
    private String roomName;
    private String description;
    private String directions;
    private boolean visited;
    private ArrayList<Exit> exits;

    public Room(int roomId, String roomName, String description, String directions, ArrayList<Exit> exits) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.description = description;
        this.directions = directions;
        this.exits = exits;
        this.visited = false;
    }


    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public String getDirections() {
        return directions;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "\nRoom " + roomId +
                "\nRoom name = " + roomName  +
                "\ndescription='" + description +
                "\ndirections='" + directions +
                "\nexits='" + exits + '\'';
    }
}

