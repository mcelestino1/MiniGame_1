import java.util.ArrayList;

public class Room {
    private int roomId;
    private String roomName;
    private String description;
    private String directions;
    private ArrayList<Exit> exits;

    public Room(int roomId, String roomName, String description, String directions, ArrayList<Exit> exits) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.description = description;
        this.directions = directions;
        this.exits = exits;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    @Override
    public String toString() {
        return "Room " + roomId +
                "\n" + roomName  +
                "\ndescription='" + description +
                "\ndirections='" + directions +
                "\nexits='" + exits + '\'' +
                '}';
    }
}

