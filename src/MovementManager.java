/**
 * Class to manage the movement of the player within the game
 * <br>
 * Methods included are:
 * <pre>To be defined</pre>
 * 
 * @author Stuart Gadd
 * @version 0.1 - Initial draft of Movement method
 * @version 0.2 - Added error checking, constant variables and renamed class to be in-line with project naming convention
 * @version 0.3 - Changed movePlayer and constant variables to static as there is no need to create a MovementManager object.
 * @since 2023/06/16
 * 
 */
public class MovementManager {

	private static final int MIN_COORDINATE = 0;
	private static final int MAX_COORDINATE = 4;
	
    //Default constructor
	public MovementManager() {
	}
	
	//Method declaration
	public static int movePlayer(int coordinate, String direction) {
			
		switch (direction) {
			case "n":	
				if (coordinate <= MIN_COORDINATE) {
					System.out.println("Can't go north!");
				} else if (coordinate > MAX_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING NORTH ACTION: Player is outside boundary of game!!! PlayerY coordinate is " + coordinate);
					System.exit(0);
				} else {
					System.out.println("You have travelled north.");
					coordinate--;
				}
				break;
			case "s":
				if (coordinate >= MAX_COORDINATE) {
					System.out.println("Can't go south!");
				} else if (coordinate < MIN_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING SOUTH ACTION: Player is outside boundary of game!!! PlayerY coordinate is " + coordinate);
					System.exit(0);
				} else {
					System.out.println("You have travelled south.");
					coordinate++;
				}
				break;
			case "w":
				if (coordinate <= MIN_COORDINATE) {
					System.out.println("Can't go west!");
				} else if (coordinate > MAX_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING WEST ACTION: Player is outside boundary of game!!! PlayerX coordinate is " + coordinate);
					System.exit(0);
				} else {
					System.out.println("You have travelled west.");
					coordinate--;
				}
				break;
			case "e":
				if (coordinate >= MAX_COORDINATE) {
					System.out.println("Can't go east!");
				} else if (coordinate < MIN_COORDINATE){
					System.out.println("FATAL ERROR DURING MOVING EAST ACTION: Player is outside boundary of game!!! PlayerX coordinate is " + coordinate);
					System.exit(0);
				} else {
					System.out.println("You have travelled east.");
					coordinate++;
				}
				break;
			default:
		}
	
		return coordinate;
	}	
}
