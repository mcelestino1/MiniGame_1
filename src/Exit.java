public class Exit {
    private String direction;
    private int destRoomId;

    public Exit(String direction, int destRoomId) {
        this.direction = direction;
        this.destRoomId = destRoomId;
    }



    @Override
    public String toString() {
        return "Exit " +
                "direction='" + direction + '\'' +
                ", destRoomId=" + destRoomId;
    }
}
