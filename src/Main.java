/**
 * This file contains the main class for running ColossalCymruAdventure.
 */


import java.util.Scanner;


/**
 * @author jackroberts
 * This class describes a runnable Java terminal application.
 */
public class Main {
	
	public final static String GAME_NAME = "Colossal Cymru Adventure";
	public final static GameManager gameManager = new GameManager();

	/**
	 * Runs from the Java terminal to initiate the game.
	 * @param args Arguments with which the program can be called (null).
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to " + GAME_NAME + "!");
		
		boolean menuDecision = true;
		
		Scanner menuScanner = new Scanner(System.in);
		
		//Game Loop until decision is reached to quit the game.
		while (menuDecision) {
			System.out.println("Do you want to:");
			System.out.println("make a (new) game");
			System.out.println("(quit) to desktop");
			System.out.println("\nWhat will it be?\t");
		
			String menuChoice = menuScanner.nextLine();
			switch (menuChoice) {
				case "new":
					GameManager.beginGame();
					menuDecision = false; //Included to avoid small bug. Possible marks for spit and polish if fixed.
					break;
				case "quit":
					System.out.println("Thank you for playing " + GAME_NAME + ". Hwyl fawr!");
					menuDecision = false;
					break;
				default:
					System.out.println("I'm not sure what you're asking. Please rephrase.");
			}
		}
		menuScanner.close();
	}
}
