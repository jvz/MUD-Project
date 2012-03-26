/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mazeGame;

/**
 *
 * @author mruth
 */
public class Player  {





    /**
     * Create a new Player with the given attributes:
     * @param name  of the player
     * @param shortDescription of the player
     * @param longDescription of the player
     */



    public Player(String name, String shortDesc, String longDesc) {
        this.name = name;
        this.longDesc = longDesc;
        this.shortDesc = shortDesc;
        this.done = false;
    
      }

    /**
     * Create a new default player!
     */

    public Player() {

        this.name = "Default Player";
        this.shortDesc = "is the default player";
        this.longDesc = "This is the default player";
        this.done = false;
    }

    public String getDescription() {
        return this.longDesc;
    }
   
    public String getTitle() {
        return this.shortDesc;
    }
    
    public void setDescription(String desc) {
        this.longDesc = desc;
    }
    
    public void setTitle(String title) {
        this.shortDesc = title;
    }

    @Override
    public String toString() {

        return name +  " " + shortDesc;
        
    }

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    

    private String name;
    private String longDesc;
    private String shortDesc;
    
   



}
