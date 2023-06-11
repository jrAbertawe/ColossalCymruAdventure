/**
 * This file contains classes relevant to managing the gameplay of the program.
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class describes a GameManager, the class responsible for dictating the
 * flow of gameplay. This class allows a player to navigate the map, initiate
 * battles, and use items.
 *
 * @author jackroberts
 *
 * @version 1.1
 * @modified 2023-06-10
 */
public class GameManager {

  /** Starting position for player on x axis. */
  public static final int PLAYER_STARTING_POS_X = 0;
  /** Starting position for player on y axis. */
  public static final int PLAYER_STARTING_POS_Y = 0;

  private Map gameMap; // Create new map for entire game.
  private int playerX; // Tracks x coord of player. player starts in top left
  private int playerY; // tracks y coord of player. player starts in top left

  /**
   * Creates a new game manager.
   * 
   * <p>Side-effect initialises the map and the player starting position.
   *
   * @throws FileNotFoundException if file is not found.
   */
  public GameManager() throws FileNotFoundException {
    setGameMap(new Map());
    this.setPlayerX(PLAYER_STARTING_POS_X);
    this.setPlayerY(PLAYER_STARTING_POS_Y);
    beginGame();
  }

  /**
   * Initialises a game and provides main gameplay loop.
   * 
   * <p>Side-effect free.
   *
   * @throws FileNotFoundException if file is not found.
   */
  public void beginGame() throws FileNotFoundException {

    boolean returnToMainMenu = false; // Allow exit of game loop.

    Scanner actionScanner = new Scanner(System.in);

    // Game Loop until decision is reached to return to main menu.
    while (!returnToMainMenu) {

      // First step is to describe where the player is.
      System.out
          .println(getGameMap().getDescription(getPlayerX(), getPlayerY()));

      // Get whether or not there is a monster at current location.
      Actor monsterAtLocation = getGameMap().getMonsterAt(getPlayerX(),
          getPlayerY());
      // If there is a monster present, inform the player as to what the monster
      // is
      // called.
      if (monsterAtLocation != null) {
        System.out.println("There is a monster here."
            + " I'd output its name if my code were finished.");
      }

      System.out.println("What now?\n"); // Prompt for user input.

      String actionChoice = actionScanner.nextLine();

      // Switches based on user choice.
      switch (actionChoice) {
        case "n":
          // TODO move north and update player location if valid move.
        	
          System.out.println("WARNING - Feature Unimplemented");
          break;
        case "e":
          // TODO move east and update player location if valid move.
        	
          System.out.println("WARNING - Feature Unimplemented");
          break;
        case "s":
          // TODO move south and update player location if valid move.
        	
          System.out.println("WARNING - Feature Unimplemented");
          break;
        case "w":
          // TODO move west and update player location if valid move.
        	
          System.out.println("WARNING - Feature Unimplemented");
          break;
        case "use":
          // Handle player using an item.
          beginUse();
          break;
        case "attack":
          // Handle player attacking a monster.
          beginBattle();
          break;
        case "quit":
          // Allow a user to return to main menu.
          returnToMainMenu = true;
          break;
        default:
          // Handle unexpected inputs.
          System.out
              .println("I'm not sure what you're asking. Please rephrase.");
      }
    }
    actionScanner.close();
  }

  /**
   * Begins a battle if a monster is present.
   * 
   * <p>Side-effect free.
   *
   * @param gameMap the map for the game.
   */
  private void beginBattle() {

    if (gameMap.getMonsterAt(getPlayerX(), getPlayerY()) != null) {
      // TODO call BattleManager.
      System.out.println("WARNING - Feature Unimplemented");

    } else {
      System.out.println("There's no monster to battle!");
      System.out.println("WARNING - Feature Unimplemented");
    }
  }

  /**
   * Begins option to use items.
   * 
   * <p>Side-effect free.
   */
  private static void beginUse() {
    Scanner itemScanner = new Scanner(System.in);
    System.out.println("Enter item to use: ");
    String item = itemScanner.nextLine();
    Item selectedItem = Item.stringToItem(item);
    processItem(selectedItem);
  }
  
  /**
   * Processes the item selected by the player.
   * 
   * <p>Side-effect Changes the players health, experience, or gold depending on
   * input.
   * 
   * @param selectedItem the item selected by the player.
   */
  public static void processItem(Item selectedItem) {
    if (selectedItem.equals(Item.SWORD) || selectedItem.equals(Item.SPEAR)) {
      System.out.println("Can't use that here!");
    } else if (selectedItem.equals(Item.POTION)) {
      // TODO increase player health by 20.
      System.out.println("You take a swig of potion.");
    } else if (selectedItem.equals(Item.BARA_BRITH)) {
      System.out.println("The taste of childhood rejuvenates you.");
      // TODO increase player health by 50.
    } else if (selectedItem.equals(Item.TEXT_BOOK)) {
      System.out.println(
          "Our new found knowledge of Discrete Maths\n" + "emboldens you.");
      // TODO increase player experience by 75
    } else if (selectedItem.equals(Item.PHONE)) {
      System.out.println("You can call in some help.");
      // TODO increase player experience by 100.
      // TODO decrease gold by 10 if gold is more than 10.
    } else {
      System.out.println("I'm not sure what you're asking. Please rephrase.");
    }
  }
  
  /**
   * Retrieves the game map.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the game map
   */
  public Map getGameMap() {
    return gameMap;
  }

  /**
   * Sets the game map.
   * 
   * <p>Side-effect changes the game map.
   *
   * @param gameMap the new game map
   */
  public void setGameMap(Map gameMap) {
    this.gameMap = gameMap;
  }

  /**
   * Retrieves the X-coordinate of the player's position.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the X-coordinate of the player's position
   */
  public int getPlayerX() {
    return playerX;
  }

  /**
   * Sets the X-coordinate of the player's position.
   *
   * <p>Side-effect changes the location of player on x axis.
   *
   * @param playerX the new X-coordinate of the player's position
   */
  public void setPlayerX(int playerX) {
    this.playerX = playerX;
  }

  /**
   * Retrieves the Y-coordinate of the player's position.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the Y-coordinate of the player's position
   */
  public int getPlayerY() {
    return playerY;
  }

  /**
   * Sets the Y-coordinate of the player's position.
   * 
   * <p>Side-effect changes the location of player on y axis.
   *
   * @param playerY the new Y-coordinate of the player's position
   */
  public void setPlayerY(int playerY) {
    this.playerY = playerY;
  }
}


