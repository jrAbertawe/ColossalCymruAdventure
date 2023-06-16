/**
 * A file describing the battle management.
 * A file to handle Battle gameplay.
 */
import java.util.Random;

/**
 * A class describing BattleManager - a class to handle Battle gameplay.
 * 
 * @author jackroberts
 * 
 * @modifiedBy Owain Greener
 * @modified 2023-06-15
 *
 */
public class BattleManager {
	/** A monsters maximum damage. */
    public static final int MONSTER_MAX_DAMAGE = 20;
    /** The minimum damage by player or monster. */
    public static final int MIN_DAMAGE = 0;
    
    private int playerMaxDamage; //not a final variable as it can change depending on player's weapon.
    private Actor player; // The player in the battle.
    private Actor monster; // The monster in the battle.
    private boolean isPlayerTurn = true; //player always starts first.

    /**
     * Creates a new battle manager.
     * 
     * <p>Side-effect sets the player and monster of the battle.
     * 
     * @param player The player in the game.
     * @param monster The monster in the game.
     */
    public BattleManager(Actor player, Actor monster){
        //set all values we need
        this.player = player;
        this.monster = monster;
        this.playerMaxDamage = 25; //TODO - hardcoded for now until items/inventory system is implemented
    }

    /**
     * Main loop for the battle. Simulates the player and monster
     * turns. If either the player or monster's health is reduced
     * to 0, the battle ends.
     * 
     * <p>Side-effect free. Referentially Transparent.
     */
    public void engageBattle(){
        while(player.getCurrentHealth() != 0 && monster.getCurrentHealth() != 0){
            if(isPlayerTurn) {
                playerTurn();
            } else {
                monsterTurn();
            }
        }
        // Checks if player health is not zero.
        if (player.getCurrentHealth() != 0) {
            printBattleEndingMessage(player, monster);
            //TODO - Add loot and gold to player's inventory
        } else {
            printBattleEndingMessage(monster, player);
        }
    }
    /**
     * Processes the players turn.
     * 
     * <p>Side-effect switches the player's turn.
     */
    private void playerTurn(){
        //TODO - player damage value is hardcoded for now until items/inventory system is implemented
        int damageValue = generateDamageValue(this.playerMaxDamage);
        attackPhase(player, monster, damageValue);
        // Player turn has ended so set to false.
        isPlayerTurn = false;
    }
    
    /**
     * Processes the monsters turn.
     * 
     * <p>Side-effect switches the player's turn.
     */
    private void monsterTurn(){
        // Work out damage for monster.
        int damageValue = generateDamageValue(MONSTER_MAX_DAMAGE);
        attackPhase(monster, player, damageValue);
        // Monster turn has ended so set to false.
        isPlayerTurn = true;
    }
    /**
     * Generates a random damage value.
     * 
     * <p>Side-effect free. Referentially Transparent.
     * 
     * @param maxVal The maximum damage value for the calculation. 
     * @return A random damage value.
     */
    private int generateDamageValue(int maxVal){
        Random randomDamage = new Random();
        return randomDamage.nextInt(maxVal) + MIN_DAMAGE;
    }

    /**
     * This method simulates the attack phase against a
     * defender.
     *
     * NOTE: This would be private however it needs to
     * be public for the sake of the testing phase of the
     * coursework :)
     * 
     * <p>Side-effect Changes the health of the player.
     *
     * @param attacker The actor engaging the attack.
     * 
     * @param defender The actor being attacked.
     * 
     * @param damage The damage dealt by the actor's weapon.
     */
    public void attackPhase(Actor attacker, Actor defender, int damage){
    	// Calculates the attackers blow to opponent. 
        if (damage == 0) {
        	// Checks if damage is zero.
            System.out.println(attacker.getName() + " missed!");
        }
        else if(damage < defender.getArmourClass()) {
        	// Checks if damage is below the defenders armour class.
            System.out.println(attacker.getName() + " struck a glancing blow!");
        }
        else if(damage > defender.getArmourClass()) {
        	// Checks if damage is above the defenders armour class.
            int damageDone = damage - defender.getArmourClass();
            
            if(damageDone > defender.getCurrentHealth()) {
                defender.setCurrentHealth(0);
             // Check to make sure health never drops below 0.
            } else {
            	// Sets the defenders health post attack. 
                defender.setCurrentHealth(defender.getCurrentHealth() - damageDone);
            }
            System.out.println(attacker.getName() + " landed a hit for " + damageDone + " HP!");
        }
    }
    
    /**
     * Prints the ending message of the battle.
     * 
     * <p>Side-effect free.
     * 
     * @param winner The battle winner.
     * 
     * @param loser The battle loser.
     */
    private void printBattleEndingMessage(Actor winner, Actor loser){
        System.out.println();
        System.out.println(winner.getName() + " wins!");
        System.out.println(loser.getName() + " has been defeated.");
    }
}
