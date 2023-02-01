public class Room {
    private int roomId;
    private String roomName;
    private String description;
    private String directions;

    public Room(int roomId, String roomName, String description, String directions) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.description = description;
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", description='" + description + '\'' +
                ", directions='" + directions + '\'' +
                '}';
    }
}

