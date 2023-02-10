import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**Class: Main
 * @author Muketoi Celestino
 * @version 1.0
 * Course: ITEC 3860 Spring 2023
 * Written: February 10, 2023
 *
 * This class – It writes Rooms into a text file "Rooms.txt" then reads them and prints the out to the console.
 *              And then prompts the User to start the game.
 *
 *              allows a user to play a Text based game, the player enters their name when starting. The player has to navigate
 *              through the game by entering either just the first letter or the full word of a direction. If the exit direction
 *              is not available for that room. The player is informed and requested to enter another direction.
 *              The player has limit of 7 rooms to visit or total moves before GAME OVER.
 *              To win, The player has to reach a Specific Room (The Attic)
 *
 *
*/
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String breaker = "+++++++++++++++++++++++++++++++++++++++++++++++++++++";
        File file = new File("Rooms.txt");
        try (PrintWriter outputFile = new PrintWriter(file)) {
            // Room 1
            outputFile.println("1");
            outputFile.println("Start Point");
            outputFile.println("This is the Beginning of the Demo Game... You are in a Room with two doors." +
                    " One on the North with a bird on it, Another on the West with a Dog on it." +
                    " You look around and see a ladder leading to a room upwards which can be pulled down");
            outputFile.println("You can either go NORTH, WEST, or UP the ladder.");
            outputFile.println("NORTH 3");
            outputFile.println("WEST 2");
            outputFile.println("UP 6");
            outputFile.println(breaker);
            // Room 2
            outputFile.println("2");
            outputFile.println("Crafts Room");
            outputFile.println("You go through the door with a Dog painting on it and enter a dark room. You turn on the light." +
                    " The room is filled with paintings and different old crafts which are all dusty..." +
                    " The room has no windows and only one door (with a Cat Painting on it)");
            outputFile.println("You can only go EAST.");
            outputFile.println("EAST 1");
            outputFile.println(breaker);

            // Room 3
            outputFile.println("3");
            outputFile.println("Thorny Room");
            outputFile.println("You find yourself in a room whose walls are covered with thorns growing from every corner. " +
                    "There's a ladder hanging from the ceiling and one door with a Fish painting on it as the only exits. ");
            outputFile.println("You can either go UP the ladder or SOUTH to the door.");
            outputFile.println("SOUTH 1");
            outputFile.println("UP 4");
            outputFile.println(breaker);

            // Room 4
            outputFile.println("4");
            outputFile.println("Conservatory");
            outputFile.println("This is the Conservatory... The view is beautiful, you sit in awe for a couple of minutes and Relax. " +
                    "There are three exits in this room. A ladder going down, A door with a cat Painting which leads to the East " +
                    ", and A door with a Fish Painting on it leading to the South");
            outputFile.println("You can either go SOUTH, EAST, or DOWN the ladder.");
            outputFile.println("SOUTH 6");
            outputFile.println("EAST 5");
            outputFile.println("DOWN 3");
            outputFile.println(breaker);

            // Room 5
            outputFile.println("5");
            outputFile.println("Attic");
            outputFile.println("You just entered a cramped up room. It must be the ATTIC... " +
                            "You crawl into the room and you see the room is actually bigger than it seemed..." +
                            "CONGRATULATIONS!!!! You reached the last room of the Game you get a Reward of 'CHIEF EXPLORER'"

            );
            outputFile.println("You can only go WEST.");
            outputFile.println("WEST 4");
            outputFile.println(breaker);

            // Room 6
            outputFile.println("6");
            outputFile.println("Storage Room");
            outputFile.println("You are currently in the Storage room... You see a bunch of miscellaneous tools and items." +
                    " There is one door (With a bird on it) going North and a ladder going down");
            outputFile.println("You can either go NORTH, or DOWN the ladder.");
            outputFile.println("NORTH 4");
            outputFile.println("DOWN 1");
            outputFile.println(breaker);

        } catch (IOException ex) {
            System.out.println("IOException caught");
            ex.printStackTrace();
        }

        // Reading file "Rooms.txt" and creating room objects being added to an ArrayList of Rooms "rooms"
        ArrayList<Room> rooms = new ArrayList<>();
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String id = scan.nextLine();
            int roomID = Integer.parseInt(id);
            String roomName = scan.nextLine();
            String description = scan.nextLine();
            String directions = scan.nextLine();

            // Creating an arrayList of exits to be added to the Room object
            ArrayList<Exit> exits = new ArrayList<>();
            while (scan.hasNextLine()) {
                Exit exit;

                String direction = scan.next();
                if (direction.equals(breaker)) {
                    Room room = new Room(roomID, roomName, description, directions, exits);

                    //add each room object to the ArrayList rooms.
                    rooms.add(room);
                    scan.nextLine();
                    break;
                }

                int destRoomId = Integer.parseInt(scan.next());
                exit = new Exit(direction, destRoomId);
                exits.add(exit);
            }
        }

        // Printing out the rooms of the game
        for (Room r : rooms) {
            System.out.println(r);
        }

        // START THE GAME
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease Enter your name: ");
        Player player = new Player(input.nextLine(), 0, 1);

        System.out.println("\nHello " + player.getName() + "!");
        System.out.println("Welcome to THE EXPLORER GAME....");
        System.out.println("To navigate through this game, You have to enter the first letter or full direction.");
        System.out.println("The goal is to reach the Final Room. However, you have a limit of 7 rooms to visit.");
        System.out.println("And you have to try to find the Final room before your moves run out. \nGood Luck!!!!");

        // get room by using roomId
        final int LIMIT = 7;
        int n = player.getNumberOfRoomsVisited();

        // loops while player has not depleted their number of moves
        while (n <= LIMIT) {

            Room r = rooms.get((player.getLocationID() - 1));
            if (r.isVisited()){
                System.out.println("\nThis "+ r.getRoomName() + " has already been visited");
            } else {
                System.out.println("\nThis " + r.getRoomName() + " has not been visited yet");
            }
            r.setVisited(true);
            System.out.println(r.getDescription());
            if (player.getLocationID() == 5) {
                System.out.println("********** WELL DONE **********");
                break;
            }
            System.out.println(r.getDirections());
            System.out.print("Which direction would you like to go in? ");
            String dir = input.nextLine();

            int count = 0;      // counter to tally as the program checks if input is an exit in the arrayList

            // Loop through ArrayList of exits of the player's current location
            for (Exit e : r.getExits()) {
                count++;

                // Checks if input dir == exit e in ArrayList or just the first letter
                if (dir.equalsIgnoreCase(e.getDirection()) || dir.equalsIgnoreCase((e.getDirection().substring(0, 1)))) {
                    n++;
                    player.setNumberOfRoomsVisited(n);      // tally for number of rooms visited

                    // Move player into new room
                    player.setLocationID(e.getDestRoomId());
                    break;
                }

                // if direction input is not a valid exit in ArrayList of Exits of the room
                if (count == r.getExits().size()) {
                    System.out.println("Invalid Exit");
                    System.out.println("Please Enter a valid exit");
                }
            }
        }

        if (n == 8) {
            System.out.println("GAME OVER !!! \nYou ran out of Time and didn't reached the final room");
        }
    }

}

