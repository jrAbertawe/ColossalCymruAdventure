/**
 * This file describes a 10 by 10 map of areas.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class describes a 10 by 10 map of areas.
 *
 * @author jackroberts
 *
 * @version 1.1
 * @modified 2023-06-10
 */

public class Map {

  /** File path for the game map. */
  public static final String GAME_MAP_PATH = "world.txt";
  /** File for the game map. */
  public static final File GAME_MAP_FILE = new File(GAME_MAP_PATH);
  /** Maximum allowed horiz size of map. */
  public static final int MAX_MAP_SIZE_HOR = 5;
  /** Maximum allowed vert size of map. */
  public static final int MAX_MAP_SIZE_VER = 5;
  
  private Area[][] grid; // 2D array representing 2D grid of cells.

  /**
   * Constructor for Map(). Initialises a blank map, or a map loaded from file.
   * 
   * <p>Side-effect free.
   *
   * @throws FileNotFoundException if file is not found.
   */
  public Map() throws FileNotFoundException {
    generateBlankMap();
  }

  /**
   * Provides a description of the area at given coordinates.
   *
   * @param x The x coordinate of the desired area.
   *
   * @param y The y coordinate of the desired area.
   * @return String description of specified area.
   */
  public String getDescription(int x, int y) {
    return grid[x][y].getDescription();
  }

  /**
   * Initialises the map.
   * 
   * <p>Side-effect changes the grid.
   * 
   * @param gameMap the file that holds the map.
   * @throws FileNotFoundException if file is not found.
   */
  private void generateBlankMap() throws FileNotFoundException {
    Scanner mapReader = new Scanner(GAME_MAP_FILE);
    mapReader.useDelimiter("/");
    // Map grid becomes 2D array of Areas.
    grid = new Area[MAX_MAP_SIZE_HOR][MAX_MAP_SIZE_VER]; 
    int lineNo = 0;
    // Iterate through map, adding new Area to each cell.
    while (mapReader.hasNext()) {
      String description = mapReader.next(); // Reads the maps description.
      int level = Integer.parseInt(mapReader.next()); // Reads the maps level.
      // Reads the maps actor.
      Actor actor = new Monster(mapReader.nextLine().replace("/", "")); 
      Area area = new Area(description, level, actor); // Creates new area.
      int row = lineNo % MAX_MAP_SIZE_HOR; // Calculation for map row.
      int col = lineNo / MAX_MAP_SIZE_VER; // Calculation for map column.
      grid[row][col] = area; // Adds the area to the grid.
      lineNo++;
    }
    mapReader.close(); // Closes the scanner.
  }

  /**
   * Provides any Monster currently in specified area.
   * 
   * <p>Side-effect free. Not referentially transparent.
   *
   * @param x The x coordinate of the desired area.
   * 
   * @param y The y coordinate of the desired area.
   * @return Actor that is at the specified area. If no Actor is found, returns
   *         null.
   */
  public Actor getMonsterAt(int x, int y) {
    return grid[x][y].getMonster();
  }
}
