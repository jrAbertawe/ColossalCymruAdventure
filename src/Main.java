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

	/**
	 * Runs from the Java terminal to initiate the game.
	 * @param args Arguments with which the program can be called (null).
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to " + GAME_NAME + "!");
		
		boolean menuDecision = true;
		
		//Game Loop until decision is reached to quit the game.
		while (menuDecision) {
			System.out.println("Do you want to:");
			System.out.println("make a (new) game");
			System.out.println("(load) a saved game");
			System.out.println("(quit) to desktop");
			System.out.println("\nWhat will it be?\t");
		
			Scanner menuScanner = new Scanner(System.in);
			String menuChoice = menuScanner.nextLine();
			switch (menuChoice) {
				case "load":
					//TODO: Build Load Function
					System.out.println("⊕ WARNING - Feature Unimplemented");
					break;
				case "new":
					//runChapter();
					break;
				case "quit":
					System.out.println("Thank you for playing " + GAME_NAME + ". Hwyl fawr!");
					menuDecision = false;
					break;
				default:
					System.out.println("I'm not sure what you're asking. Please rephrase.");
			}
		}
	}
}
