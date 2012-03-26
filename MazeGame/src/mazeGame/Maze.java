/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author mruth
 */
public class Maze {

    public Maze() {

        //default
        //three room maze
        rooms = new Room[3];
        //create three basic rooms...
        rooms[0] = new Room("Exit", "Tada! You have reached the exit!");
        rooms[1] = new Room("Entrance", "Welcome!");
        rooms[2] = new Room("Hallway!", "Welcome to my Hallway!");
        //set the exit...
        this.exit = rooms[0];
        //set the entrance entrance!
        this.entrance = rooms[1];
        //connect the rooms!
        rooms[1].setNorthRoom(rooms[2]);
        rooms[2].setSouthRoom(rooms[1]);
        rooms[2].setEastRoom(rooms[2]);
        rooms[2].setWestRoom(rooms[2]);
        rooms[2].setNorthRoom(rooms[0]);


    }

    public Maze(String filename) {

        //try to read it from file name, otherwise do default...
        try {

            //first we need to have the things we need to
            //Scanner or Filereader...
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);


            //first we need to know how many we need
            //how many rooms
            String line = in.readLine();

            int num = Integer.parseInt(line);
            rooms = new Room[num];
            for (int i = 0; i < num; i++) {
                rooms[i] = new Room("", "");
            }

            //now read in the rooms
            for (int i = 0; i < num; i++) {
                //read line set the name
                line = in.readLine();
                //set title
                rooms[i].setTitle(line);
                //read line set the desc
                line = in.readLine();
                //set desc
                rooms[i].setDescription(line);
                //read line for S E N W
                line = in.readLine();
                //user scanner to break into tokens...
                Scanner lineScanner = new Scanner(line);
                //read S
                int south = lineScanner.nextInt();
                //if -1, no south
                if (south >= 0) {
                    //set the south room!
                    rooms[i].setSouthRoom(rooms[south]);
                }
                //read E
                int east = lineScanner.nextInt();
                //if -1, no east room
                if (east >= 0) {
                    //set the east room!
                    rooms[i].setEastRoom(rooms[east]);
                }
                //read N
                int north = lineScanner.nextInt();
                //if -1, no north room
                if (north >= 0) {
                    //set the north room!
                    rooms[i].setNorthRoom(rooms[north]);
                }
                //finally, read W
                int west = lineScanner.nextInt();
                //if -1, no west room
                if (west >= 0) {
                    rooms[i].setWestRoom(rooms[west]);
                }
                //done with this room!
            }
           
            //set the exit...
            this.exit = rooms[rooms.length-1];
            //set the entrance entrance!
            this.entrance = rooms[0];

        } catch (Exception e) {
            //do default...
            //default
            //three room maze
            rooms = new Room[3];
            //create three basic rooms...
            rooms[0] = new Room("Exit", "Tada! You have reached the exit!");
            rooms[1] = new Room("Entrance", "Welcome!");
            rooms[2] = new Room("Hallway!", "Welcome to my Hallway!");
            //set the exit...
            this.exit = rooms[0];
            //set the entrance entrance!
            this.entrance = rooms[1];
            //connect the rooms!
            rooms[1].setNorthRoom(rooms[2]);
            rooms[2].setSouthRoom(rooms[1]);
            rooms[2].setEastRoom(rooms[2]);
            rooms[2].setWestRoom(rooms[2]);
            rooms[2].setNorthRoom(rooms[0]);

        }

    }

    public boolean isExit(Room room) {

        return (room == exit);
    }

    public Room getEntrance() {
        //
        return this.entrance;
    }
    private Room[] rooms;
    private Room exit;
    private Room entrance;
}
