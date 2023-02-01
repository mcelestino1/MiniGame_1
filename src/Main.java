import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Rooms.txt");
        try (PrintWriter outputFile = new PrintWriter(file)) {
            // Room 1
            outputFile.println("1");
            outputFile.println("Start Point");
            outputFile.println("This is the Beginning of the Demo Game... You are in a Room with two doors." +
                    " One on the North with a bird on it, Another on the West with a Dog on it." +
                    " You look around and see a ladder leading to a room upwards which can be pulled down");
            outputFile.println("You can either go North, West, or Up the ladder.");
            outputFile.println("NORTH 3");
            outputFile.println("WEST 2");
            outputFile.println("UP 6");

            // Room 2
            outputFile.println("2");
            outputFile.println("Crafts Room");
            outputFile.println("You go through the door with a Dog painting on it and enter a dark room. You turn on the light." +
                    " The room is filled with paintings and different old crafts which are all dusty..." +
                    " The room has no windows and only one door (with a Cat Painting on it)");
            outputFile.println("You can only go EAST.");
            outputFile.println("EAST 1");

            // Room 3
            outputFile.println("3");
            outputFile.println("Thorny Room");
            outputFile.println("You find yourself in a room whose walls are covered with thorns growing from every corner. " +
                    "There's a ladder hanging from the ceiling and one door with a Fish painting on it as the only exits. ");
            outputFile.println("You can either go UP the ladder or SOUTH to the door.");
            outputFile.println("SOUTH 1");
            outputFile.println("UP 4");

            // Room 4
            outputFile.println("4");
            outputFile.println("Conservatory");
            outputFile.println("This is Conservatory... The view is beautiful, you sit in awe for a couple of minutes and Relax. " +
                    "There are three exits in this room. A ladder going down, A door with a cat Painting which leads to the East " +
                    ", and A door with a Fish Painting on it leading to the South");
            outputFile.println("You can either go SOUTH, EAST, or DOWN the ladder.");
            outputFile.println("SOUTH 6");
            outputFile.println("EAST 5");
            outputFile.println("DOWN 3");

            // Room 5
            outputFile.println("5");
            outputFile.println("Attic");
            outputFile.println("You just entered a cramped up room. It must be the ATTIC... " +
                    "The room is not conducive for human life, so you decide to leave the room." +
                    "There is only one door (with a Dog painting on it.)");
            outputFile.println("You can only go WEST.");
            outputFile.println("WEST 4");

            // Room 6
            outputFile.println("6");
            outputFile.println("Storage Room");
            outputFile.println("You are currently in the Storage room... You see a bunch of miscellaneous tools and items." +
                    " There is one door (With a bird on it) going North and a ladder going down");
            outputFile.println("You can either go North, or Down the ladder.");
            outputFile.println("NORTH 4");
            outputFile.println("DOWN 1");
        } catch (Exception ex) {
            System.out.println("Exception caught");
            ex.printStackTrace();
        }
        ArrayList<String> roomList new ArrayList<>();

        ArrayList<Room> rooms = new ArrayList<>();
        boolean cont = false;
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String id = scan.nextLine();
            int roomID = Integer.parseInt(id);
            String roomName = scan.nextLine();
            String description = scan.nextLine();
            String directions = scan.nextLine();
            Room room = new Room(roomID, roomName, description, directions);
            System.out.println(room);
            //add each room object to the ArrayList rooms.

            //create an Exit type ArrayList to point to multiple Exits.
            //Then each exit object will have two attributes which is direction and destination.
            //The loop will iterate to retrieve each Exit object data until it reaches out to the next room number.
            //In this case, each room data must only two attributes. So once it reaches up to two data, then it will identify
            //as the next room.
            //do not use hashmap.  but think about what type of data structure you can use. List or Arrays or something else.
            //
            while (scan.hasNextLine()) {
                Exit exit;
                String direction = null;

//                    System.out.println("Nope, that's not it!");
                direction = scan.next();
                int destRoomId = Integer.parseInt(scan.next());
                exit = new Exit(direction, destRoomId);
                System.out.println(exit);
            }
//                try {
//                    direction = scan.next();
//                } catch (NumberFormatException e) {
//                    cont = true;
//                    System.out.println("Errrrrrooooorrrr");
//                }


        }
        System.out.println("Welcome to THE EXPLORER GAME....");
    }

    // START THE GAME

}
