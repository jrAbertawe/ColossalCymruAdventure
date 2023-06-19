
/**
 * This file contains the main class for running ColossalCymruAdventure.
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class describes a runnable Java terminal application.
 *
 * @author jackroberts
 *
 * @version 1.1
 * @modifiedby Owain Greener
 * @modified 2023-07-17
 */
public class Main {

  /** Permanent store of game's title. */
  public static final String GAME_NAME = "Colossal Cymru Adventure";

  /**
   * Runs from the Java terminal to initiate the game.
   *
   * <p>Side-effect free.
   *
   * @param args Arguments with which the program can be called (null).
   * @throws FileNotFoundException if file is not found.
   */
  public static void main(final String[] args) throws FileNotFoundException {

    System.out.println("Welcome to " + GAME_NAME + "!");
   final String regex = "^[A-Za-z\\s]+$";
    System.out.println("What is your name Hero?");
    Scanner menuScanner = new Scanner(System.in); // Reads user input.
    String playerName = menuScanner.nextLine();
    if (playerName.matches(regex)){
    boolean menuDecision = true; // Establish game exit point.

    // Creates new player.
    Player player = new Player(playerName, 100, 0, 5);
    // Game Loop until decision is reached to quit the game.
    while (menuDecision && player.getCurrentHealth() != 0) {
      System.out.println("Welcome" + " " + playerName);
      System.out.println("Do you want to:");
      System.out.println("make a (new) game");
      System.out.println("(quit) to desktop");
      System.out.println("\nWhat will it be?\t");

      String menuChoice = menuScanner.nextLine();

      // Handles choice of menu input. Switch chosen to allow for expansion.
      switch (menuChoice) {
        case "new":
          // Hand control to GameManager.
          GameManager game = new GameManager(player);
          break;
        case "quit":
          System.out
              .println("Thank you for playing " + GAME_NAME + ". Hwyl fawr!");
          menuDecision = false; // Exit game loop
          break;
        default:
          // Default to handle undefined menu options from user.
          System.out
              .println("I'm not sure what you're asking. Please rephrase.");
      }
    }
    menuScanner.close();
  }
  else{
    System.out.println("Sorry that name is not permitted, please try again!");
    return;
  }
  }
}
