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
 * @modifiedBy Zac Healy
 * @modifiedBy Sarah Ramsey
 * 
 * @version 1.1
 * @modified 2023-06-16
 */
public class GameManager {

  /** Starting position for player on x axis. */
  public static final int PLAYER_STARTING_POS_X = 0;
  /** Starting position for player on y axis. */
  public static final int PLAYER_STARTING_POS_Y = 0;
  /** Health increase after drinking a potion. */
  public static final int HEALTH_INCREASE_POTION = 20;
  /** Health increase after eating bara brith. */
  public static final int HEALTH_INCREASE_BARA_BRITH = 50;
  /** Experience increase after reading a text book. */
  public static final int XP_INCREASE_TEXT_BOOK = 75;
  /** Experience increase after using a phone. */
  public static final int XP_INCREASE_PHONE = 100;
  /** Gold decrease after using a phone. */
  public static final int GOLD_DECREASE_PHONE = 10;

  private Map gameMap; // Create new map for entire game.
  private Player player; // The player in the game.
  private int playerX; // Tracks x coord of player. player starts in top left
  private int playerY; // Tracks y coord of player. player starts in top left

  /**
   * Creates a new game manager.
   * 
   * <p>Side-effect initialises the map and the player starting position.
   *
   * @throws FileNotFoundException if file is not found.
   */
  public GameManager(Player player) throws FileNotFoundException {
    setGameMap(new Map());
    this.setPlayerX(PLAYER_STARTING_POS_X);
    this.setPlayerY(PLAYER_STARTING_POS_Y);
    this.setPlayer(player); 
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
          System.out.println(getGameMap().getDescription(getPlayerX(), getPlayerY()));
          // Get whether or not there is a monster at current location.
          Actor monsterAtLocation = getGameMap().getMonsterAt(getPlayerX(),
                  getPlayerY());
          // If monster present, inform the player as to what the monster is called.
          if (monsterAtLocation != null) {
              System.out.println("There is a monster here. The monster is named: "
                      + monsterAtLocation.getName());
          } else {

          }

          System.out.println("What now?\n"); // Prompt for user input.
          System.out.println("Please type the direction you'd like to travel indicated in brackets below: ");
          System.out.println("Move North? (n)");
          System.out.println("Move East?  (e)");
          System.out.println("Move South? (s)");
          System.out.println("Move West?  (w)\n");

          String actionChoice = actionScanner.nextLine();

          // Switches based on user choice.
          switch (actionChoice.toLowerCase()) {
              case "n":
                  // Moves north and updates player location if valid move.
                  if ((0 < playerY) && (5 >= playerY)) {
                      playerY--;
                  } else {
                      System.out.println("Can't go North!");
                  }
                  break;
              case "e":
                  // Moves east and updates player location if valid move.
                  if ((0 <= playerX) && (4 > playerX)) {
                      playerX++;
                      System.out.println("You've moved a little bit East!");
                  } else {
                      System.out.println("Can't go East!");
                  }
                  break;
              case "s":
                  // Moves south and updates player location if valid move.
                  if ((0 <= playerY) && (4 > playerY)) {
                      playerY++;
                      System.out.println("You've moved a little bit South!");
                  } else {
                      System.out.println("Can't go South!");
                  }
                  break;
              case "w":
                  // Moves west and updates player location if valid move.
                  if (0 < playerX && 5 >= playerX) {
                      playerX--;
                      System.out.println("You've moved a little bit West!");
                  } else {
                      System.out.println("Can't go West!");
                  }
                  break;
              case "use":
                  // Handle player using an item.
                  beginUse();
                  break;
              case "attack":
                  // Handle player attacking a monster.
                  beginBattle();
                  if (player.getCurrentHealth() == 0) {
                      returnToMainMenu = true;
                  }
                  break;
              case "health":
                  //view current health
                  viewCurrentHealth();
                  break;
              case "quit":
                  // Allow a user to return to main menu.
                  returnToMainMenu = true;
                  break;
              default:
                  // Handle unexpected inputs.
                  System.out.println("I'm not sure what you're asking. Please rephrase.");
          }
      }
      actionScanner.close();
  }

  /**
   * Begins a battle if a monster is present.
   * 
   * <p>Side-effect free.
   */
  private void beginBattle() {
    if (gameMap.getMonsterAt(getPlayerX(), getPlayerY()) != null) {
      BattleManager battleManager = new BattleManager(player, gameMap.getMonsterAt(getPlayerX(), getPlayerY()));
      battleManager.engageBattle();
    } else {
      System.out.println("There's no monster to battle!");
    }
  }

  /**
   * Begins option to use items.
   * 
   * <p>Side-effect free.
   */
  private void beginUse() {
    Scanner itemScanner = new Scanner(System.in);
    System.out.println("Enter item to use: ");
    String item = itemScanner.nextLine();
    ItemType selectedItem = ItemType.stringToItem(item);
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
	private void processItem(ItemType selectedItem) {
		// Process the item the player is using.
		if (selectedItem.equals(ItemType.SWORD) || selectedItem.equals(ItemType.SPEAR)) {
			// Process a sword or spear item.
			System.out.println("Can't use that here!");

		} else if (selectedItem.equals(ItemType.POTION)) {
			// Process a potion item.
			player.setCurrentHealth(player.getCurrentHealth() + HEALTH_INCREASE_POTION);
			System.out.println("You take a swig of potion.");

		} else if (selectedItem.equals(ItemType.BARA_BRITH)) {
			// Process a bara brith item.
			player.setCurrentHealth(player.getCurrentHealth() + HEALTH_INCREASE_BARA_BRITH);
			System.out.println("The taste of childhood rejuvenates you.");

		} else if (selectedItem.equals(ItemType.TEXT_BOOK)) {
			// Process a text book item.
			player.setExperience(player.getExperience() + XP_INCREASE_TEXT_BOOK);
			System.out.println("Our new found knowledge of Discrete Maths\n" + "emboldens you.");

		} else if (selectedItem.equals(ItemType.PHONE)) {
			// Process a phone item.
			System.out.println("You can call in some help.");
			player.setExperience(player.getExperience() + XP_INCREASE_PHONE);
			player.setGold(player.getGold() - GOLD_DECREASE_PHONE);

		} else {
			// Process unknown item.
			System.out.println("I'm not sure what you're asking. Please rephrase.");
		}
	}

    /**
     * Prints the player's current health to the screen
     *
     * <p>Side-effect free.
     */
    private void viewCurrentHealth(){
        System.out.println("Your current health is: " + player.getCurrentHealth());
    }
  
  /**
   * Sets the game player.
   * 
   * <p>Side-effect changes the game player.
   *
   * @param player the new game player.
   */
  public void setPlayer(Player player) {
	  this.player = player;
  }
  
  /**
   * Retrieves the game player.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the game player.
   */
  public Player getPlayer() {
	  return player;
  }
  
  /**
   * Retrieves the game map.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the game map.
   */
  public Map getGameMap() {
    return gameMap;
  }

  /**
   * Sets the game map.
   * 
   * <p>Side-effect changes the game map.
   *
   * @param gameMap the new game map.
   */
  public void setGameMap(Map gameMap) {
    this.gameMap = gameMap;
  }

  /**
   * Retrieves the X-coordinate of the player's position.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the X-coordinate of the player's position.
   */
  public int getPlayerX() {
    return playerX;
  }

  /**
   * Sets the X-coordinate of the player's position.
   *
   * <p>Side-effect changes the location of player on x axis.
   *
   * @param playerX the new X-coordinate of the player's position.
   */
  public void setPlayerX(int playerX) {
    this.playerX = playerX;
  }

  /**
   * Retrieves the Y-coordinate of the player's position.
   *
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the Y-coordinate of the player's position.
   */
  public int getPlayerY() {
    return playerY;
  }

  /**
   * Sets the Y-coordinate of the player's position.
   * 
   * <p>Side-effect changes the location of player on y axis.
   *
   * @param playerY the new Y-coordinate of the player's position.
   */
  public void setPlayerY(int playerY) {
    this.playerY = playerY;
  }
}


