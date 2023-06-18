import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class PlayerMovement {

    /** Starting position for player on x axis. */
    public static final int PLAYER_STARTING_POS_X = 2;
    /** Starting position for player on y axis. */
    public static final int PLAYER_STARTING_POS_Y = 2;
    /** Minimum position for player on x or y axis */
    public static final int MIN_POS = 0;
    /** Maximum position for player moving North or West */
    public static final int MAX_POS_NW = 5;
    /** Maximum position for player moving South or East */
    public static final int MAX_POS_SE = 4;
    /** String printed if player moves too far North*/
    public static final String TOO_FAR_NORTH = "There is a cat as big as a house here. And it thinks you are "
	     + "a mouse! You need to sneak away from here";
    /** String printed if player moves too far East */
    public static final String TOO_FAR_EAST = "Careful! There is a cliff edge here. You'll need to find "
	     + "another way";
    /** String printed if player moves too far South */
    public static final String TOO_FAR_SOUTH = "The path is blocked by a sleeping giant. You cannot travel "
	     + "this way!";
    /** String printed if player moves too far West */
    public static final String TOO_FAR_WEST = "There's quicksand here. Turn around before you sink!";
	 
    /**
     * Moves the player north or west.
     * 
	 * <p>Side-effect free. Referentially Transparent.
	 * 
	 * @param playerPos the current position of the player
	 * 
	 * @param direction the direction to move (either "north" or "west")
	 * 
	 * @return the updated position of the player after moving
	 */
    private int moveNorthOrWest(int playerPos, String direction) {
	     // Checks if user is able to move to the desired position.
	     if ( playerPos > MIN_POS && playerPos <= MAX_POS_NW) {
	       // Activates if the user is able to move.
	       System.out.println("You've moved a little bit " + direction + "!");
	       playerPos--;
	     } else {
	      // Runs if player tries to move too far North or West.
	        switch (direction) {
	           case "North":
	             // Prints dialogue if player is trying to move too far North.
	             System.out.println(TOO_FAR_NORTH);
	             break;
	           case "West":
	             // Prints dialogue if player is trying to move too far West.
	             System.out.println(TOO_FAR_WEST);
	        }
	        return playerPos;
	     }
	    
    }

	     /**
	      * 
	      * Moves the player south or east.
	      * 
	      * <p>Side-effect free. Referentially Transparent.
	      * 
	      * @param playerPos the current position of the player
	      * 
	      * @param direction the direction to move (either "south" or "east")
	      * 
	      * @return the updated position of the player after moving
	      */
	     private int moveSouthOrEast(int playerPos, String direction) {
	       // Checks if user is able to move to the desire position.
	       if (playerPos >= MIN_POS && playerPos < MAX_POS_SE) {
	         System.out.println("You've moved a little bit " + direction + "!");
	         // Activates if the user is able to move.
	         playerPos++;
	       } else {
	        // Runs if player tries to move too far South or East.
	          switch (direction) {
	             case "South":
	               // Prints dialogue if player is trying to move too far South.
	               System.out.println(TOO_FAR_SOUTH);
	               break;
	             case "East":
	               // Prints dialogue if player is trying to move too far East.
	               System.out.println(TOO_FAR_EAST);
	          }
	       }
	       return playerPos;
	     }
	    
}

 