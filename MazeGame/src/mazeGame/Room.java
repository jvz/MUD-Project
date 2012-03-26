/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeGame;

/**
 *
 * @author mruth
 */
public class Room  {

    public Room(String title, String description) {
        this.title = title;
        this.description = description;
    }

    private String title;
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    private Room east;
    private Room west;
    private Room north;
    private Room south;


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    

    @Override
    public String toString() {
        String returnString = "";
        returnString = returnString + this.getTitle() + "\n";
        returnString = returnString + this.getDescription() + "\n";
        
        //exits?
        returnString = returnString + "Exits: ";
        //need to know if no exits were found
        boolean noexits = true;

        //is there a room to the east?
        if (this.isRoomToEast()) {
            //if so, we found an exit
            noexits = false;
            //display the room
            returnString = returnString + "east";
        }
        //is there a room to the north
        if (this.isRoomToNorth()) {
            //need to see if we already saw a room
            //for nice, neat comma seperated lists!
            if (noexits) {
                //if so, we found an exit
                noexits = false;
                //display room
                returnString = returnString + "north";
            } else {
                //not the first room, so use comma
                //and display the room
                returnString = returnString + ", north";
            }
        }
        //is there a room to the west?
        if (this.isRoomToWest()) {
           //need to see if we already saw a room
            //for nice, neat comma seperated lists!
            if (noexits) {
                //if so, we found an exit
                noexits = false;
                //display the room
                returnString = returnString + "west";
            } else {
                 //not the first room, so use comma
                //and display the room
                returnString = returnString + ", west";
            }
        }
        //is there a room to the south?
        if (this.isRoomToSouth()) {
            //need to see if we already saw a room
            //for nice, neat comma seperated lists!
            if (noexits) {
                //if so, we found an exit
                noexits = false;
                //display room
                returnString = returnString + "south";
            } else {
                 //not the first room, so use comma
                //and display the room
                returnString = returnString + ", south";
            }
        }


        //did we find any exits?
        if (noexits) {
            //if not, display none
            returnString = returnString + "none";
        }

        
        return returnString;



    }

    public Room getEastRoom() {
        return this.east;
    }

    public Room getWestRoom() {
        return this.west;
    }

    public Room getNorthRoom() {
        return this.north;
    }

    public Room getSouthRoom() {
        return this.south;
    }

    public void setEastRoom(Room room) {
        this.east = room;
    }

    public void setWestRoom(Room room) {
        this.west = room;
    }

    public void setNorthRoom(Room room) {
        this.north = room;
    }

    public void setSouthRoom(Room room) {
        this.south = room;
    }

    public boolean isRoomToEast() {
        return (this.east != null);
    }

    public boolean isRoomToWest() {
        return (this.west != null);
    }

    public boolean isRoomToNorth() {
        return (this.north != null);
    }

    public boolean isRoomToSouth() {
        return (this.south != null);
    }


}
