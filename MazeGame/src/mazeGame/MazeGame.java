/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author mruth
 */
public class MazeGame {

    /**
     * @param args the command line arguments
     *
     */
    private Maze maze;
    private MazePlayer pawn;
    //simplifies System.out.x -> now just out.x
    private PrintStream out = System.out;
    //this is the input reader...!
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public boolean gameOver() {
        //game is over when pawn is dead OR exit is reached!
        return ((maze.isExit(this.pawn.location())) || (this.pawn.isDone()));

    }

    public void takeTurn() {


        //give a prompt!
        out.print(">");

        try {
            String input = in.readLine();

            Scanner scan = new Scanner(input);

            String command = scan.next();

            //look command!
            if ("look".startsWith(command.toLowerCase())) {
                //look command! (however, what kind of look do we have?
                //is there a second item?
                if (scan.hasNext()) {
                    //has second part... we need to look at something we
                    //need to figure out what the user wants to look at
                    String second = scan.next();

                    if ("self".startsWith(second.toLowerCase())) {

                        //look at self
                        out.println(this.pawn);
                        out.println("Description:");
                        out.println(this.pawn.getDescription());



                    } else {
                        //something is wrong!
                        out.println("There is no " + second + " to look at!");
                    }


                } else {
                    //look at the room again!
                    out.println(pawn.location());
                }


            } else if ("go".startsWith(command.toLowerCase())) {
                System.out.println("player wants to move!");
                //is there a second item? (we need a direction)
                if (scan.hasNext()) {
                    //has second part... we need to look at something we
                    //need to figure out what the user wants to look at
                    String second = scan.next();
                    //look for north
                    if ("north".startsWith(second.toLowerCase())) {
                        
                        //direction is north...
                        //is there a north room
                        if (this.pawn.location().isRoomToNorth()) {
                            //there is a room to the north
                            //so move there...
                            this.pawn.move(this.pawn.location().getNorthRoom());
                            //look at new room
                            out.println(pawn.location());
                            
                        } else {
                            out.println("There is no room to the north!");
                        }
                        
                        //look for east
                    } else if ("east".startsWith(second.toLowerCase())) {
                        //direction is east...
                        //is there a east room
                        if (this.pawn.location().isRoomToEast()) {
                            //there is a room to the east
                            //so move there...
                            this.pawn.move(this.pawn.location().getEastRoom());
                            //look at new room
                            out.println(pawn.location());
                        } else {
                            out.println("There is no room to the east!");
                        }
                       
                     //look for south   
                    } else if ("south".startsWith(second.toLowerCase())) {
                        //direction is south...
                        //is there a south room
                        if (this.pawn.location().isRoomToSouth()) {
                            //there is a room to the south
                            //so move there...
                            this.pawn.move(this.pawn.location().getSouthRoom());
                            //look at new room
                            out.println(pawn.location());
                        } else {
                            out.println("There is no room to the South!");
                        }
                        
                        
                        
                        
                        
                      //look for west
                    } else if ("west".startsWith(second.toLowerCase())) {
                        //look for invalid
                        //direction is west...
                        //is there a west room
                        if (this.pawn.location().isRoomToWest()) {
                            //there is a room to the south
                            //so move there...
                            this.pawn.move(this.pawn.location().getWestRoom());
                            //look at new room
                            out.println(pawn.location());
                        } else {
                            out.println("There is no room to the South!");
                        }
                        
                        
                        
                        
                    } else {
                        //something is wrong!
                        out.println(second + " is not a valid location!");
                    }
                  
                } else {
                    //something wrong... say can't move there...
                    System.out.println("player wants to move, but no direction given!");
                }
                
                

            } else if ("quit".startsWith(command.toLowerCase())) {
               //the player wants to quit... so quit!
               this.pawn.setDone(true);
               
                
            } else {
                System.out.println("Command " + command + " not understood!");
            }










        } catch (IOException ioe) {
            //see if you can make this happen!
            //and decide how to deal with it gracefully!
            //should never happen!
        }



    }

    public void play() {
        //until the game is over
        while (!gameOver()) {
            //take turns!
            takeTurn();
        }
        
    }

    public MazeGame(String filename) {

        //create a maze!
        try {
            this.maze = new Maze(filename);
        } catch (Exception e) {
            this.maze = new Maze();
        }

        //create a player!
        this.pawn = new MazePlayer("Machivelli!", "The Prince", "Silly Warmongerer");

        //put the player in the entrance!!!
        this.pawn.setStartingLocation(this.maze.getEntrance());
        //show starting position!
        this.out.println(this.pawn.location());

        //System.out.print("Starting game?");

    }

    public static void main(String[] args) {
        //start the game here!!!
        String fn;
        if (args.length == 0) {

            fn = "src/mazeGame/mike.txt";
        } else {
            fn = args[0];
        }

        MazeGame game = new MazeGame(fn);
        game.play();

    }
}
