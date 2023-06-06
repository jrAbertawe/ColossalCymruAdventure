/**
 * This class describes a 10 by 10 map of areas.
 * @author jackroberts
 *
 */
public class Map {
	
	private Area[][] grid;
	private final int MAX_MAP_SIZE = 5;
	
	
	
	public Map() {
		generateBlankMap();
	}
	
	public String getDescription(int playerX, int playerY) {
		return grid[playerX][playerY].getDescription();
	}
	
	/**
	 * Initialises this to a blank map.
	 */
	private void generateBlankMap() {
		
		grid = new Area[MAX_MAP_SIZE][MAX_MAP_SIZE];
		
		//Iterate through map, adding new Area to each cell.
		for (int i = 0; i < MAX_MAP_SIZE; i++) {
			for (int j = 0; j < MAX_MAP_SIZE; j++) {
				Area blankArea = new Area("You look around. There's nothing here.", 0, null);
				grid[i][j] = blankArea;
			}
		}
	}

	public Actor getMonsterAt(int playerX, int playerY) {
		return grid[playerX][playerY].getMonster();
	}

}
