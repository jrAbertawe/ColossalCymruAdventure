import java.util.Scanner;

public class GameManager {
	
	public final static Map GAME_MAP = new Map();
	private static int playerX = 0; //player starts in top left
	private static int playerY = 0; //player starts in top left
	
	public static void beginGame() {
		
		boolean returnToMainMenu = false;
		
		Scanner actionScanner = new Scanner(System.in);
		
		//Game Loop until decision is reached to quit the game.
		while (!returnToMainMenu) {
			
			System.out.println(GAME_MAP.getDescription(playerX, playerY));
			
			Actor monsterAtLocation = GAME_MAP.getMonsterAt(playerX, playerY);
			if (monsterAtLocation != null) {
				System.out.println("There is a monster here."
						+ " I'd output its name if my code were finished.");
			}
			
			System.out.println("What now?\n");
		
			String actionChoice = actionScanner.nextLine();
			
			
			switch (actionChoice) {
				case "n":
					//TODO move north and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "e":
					//TODO move east and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "s":
					//TODO move south and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "w":
					//TODO move west and update player location if valid move.
					System.out.println("WARNING - Feature Unimplemented");
					break;
				case "use":
					beginUse();
					break;
				case "attack":
					beginBattle();
					break;
				case "quit":
					returnToMainMenu = true;
					break;
				default:
					System.out.println("I'm not sure what you're asking. Please rephrase.");
			}
		}
		actionScanner.close();
	}
	
	private static void beginBattle() {
		
		if (GAME_MAP.getMonsterAt(playerX, playerY) != null) {
			//TODO call BattleManager.
			System.out.println("WARNING - Feature Unimplemented");
			
		} else {
			System.out.println("There's no monster to battle!");
			System.out.println("WARNING - Feature Unimplemented");
		}
	}
	
	private static void beginUse() {
		System.out.println("WARNING - Feature Unimplemented");
		//TODO Handle using items if the player has them.
	}
	

}
