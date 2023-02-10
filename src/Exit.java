/**Class: Exit
 * @author Muketoi Celestino
 * @version 1.0
 * Course: ITEC 3860 Spring 2023
 * Written: February 10, 2023
 *
 * This class – a blueprint for all the exits that a room will have. And which directiion they will be in.
 */

public class Exit {
    private String direction;
    private int destRoomId;

    public Exit(String direction, int destRoomId) {
        this.direction = direction;
        this.destRoomId = destRoomId;
    }

    public String getDirection() {
        return direction;
    }

    public int getDestRoomId() {
        return destRoomId;
    }

    @Override
    public String toString() {
        return "(Exit " +
                "direction='" + direction + '\'' +
                ", destRoomId=" + destRoomId + ")";
    }
}
