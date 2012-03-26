/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mazeGame;

/**
 *
 * @author mruth
 */
public class MazePlayer extends Player {

    public MazePlayer(String name, String title, String desc) {
        super(name, title, desc);
        //this must be set externally!
        this.location = null;

    }


    public void setStartingLocation(Room room) {
        this.location = room;
    }

    public void move(Room room) {
        this.location = room;
    }

    public Room location() {
        return this.location;
    }

    //player's location in maze
    private Room location;


}
