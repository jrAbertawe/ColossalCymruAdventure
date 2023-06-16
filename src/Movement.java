/**
 * Class to manage the movement of the player within the game
 * <br>
 * Methods included are:
 * <pre>To be defined</pre>
 * 
 * @author Stuart Gadd
 * @version 0.1
 * @since 2023/06/15
 * 
 */
public class Movement {

    // Default constructor
	public Movement() {
	}
	
	public int movePlayer(int coordinate, char direction) {
		
		switch (direction) {
			case 'n':	
				if (coordinate <= 0) {
					System.out.println("Can't go north!");
				} else {
					System.out.println("You have gone north.");
					coordinate--;
				}
				break;
			case 's':
				if (coordinate >= 4) {
					System.out.println("Can't go south!");
				} else {
					System.out.println("You have gone south.");
					coordinate++;
				}
				break;
			case 'w':
				if (coordinate <= 0) {
					System.out.println("Can't go west!");
				} else {
					System.out.println("You have gone west.");
					coordinate--;
				}
				break;
			case 'e':
				if (coordinate >= 4) {
					System.out.println("Can't go east!");
				} else {
					System.out.println("You have gone east.");
					coordinate++;
				}
				break;
			default:
		}
	
		return coordinate;
	}	
}
