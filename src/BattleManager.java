import java.util.Random;

/**
 * A class decribing BattleManager - a class to handle Battle gameplay.
 * @author jackroberts
 * @modifiedBy Owain Greener
 * @modified 2023-06-15
 *
 */
public class BattleManager {
    private final int MONSTER_MAX_DAMAGE = 20;
    private final int MIN_DAMAGE = 0;
    private int playerMaxDamage; //not a final variable as it can change depending on player's weapon
    private Actor player;
    private Actor monster;
    private boolean isPlayerTurn = true; //player always starts first

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
     */
    public void engageBattle(){
        while(player.currentHealth != 0 && monster.currentHealth != 0){
            if(isPlayerTurn) {
                playerTurn();
            } else {
                monsterTurn();
            }
        }

        if (player.currentHealth != 0) {
            printBattleEndingMessage(player, monster);

            //TODO - Add loot and gold to player's inventory
        }else {
            printBattleEndingMessage(monster, player);
        }
    }

    private void playerTurn(){
        //TODO - player damage value is hardcoded for now until items/inventory system is implemented
        int damageValue = generateDamageValue(this.playerMaxDamage);
        attackPhase(player, monster, damageValue);

        //player turn has ended so set to false
        isPlayerTurn = false;
    }

    private void monsterTurn(){
        //work out damage for monster
        int damageValue = generateDamageValue(MONSTER_MAX_DAMAGE);
        attackPhase(monster, player, damageValue);

        //monster turn has ended so set to false
        isPlayerTurn = true;
    }

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
     * @param attacker The actor engaging the attack
     * @param defender The actor being attacked
     * @param damage The damage dealt by the actor's weapon
     */
    public void attackPhase(Actor attacker, Actor defender, int damage){
        if (damage == 0) {
            System.out.println(attacker.getName() + " missed!");
        }
        else if(damage < defender.armourClass) {
            System.out.println(attacker.getName() + " struck a glancing blow!");
        }
        else if(damage > defender.armourClass) {
            int damageDone = damage - defender.armourClass;

            //check to make sure health never drops below 0
            if(damageDone > defender.currentHealth) {
                defender.currentHealth = 0;
            } else{
                defender.currentHealth -= damageDone;
            }

            System.out.println(attacker.getName() + " landed a hit for " + damageDone + " HP!");
        }
    }

    private void printBattleEndingMessage(Actor winner, Actor loser){
        System.out.println();
        System.out.println(winner.name + " wins!");
        System.out.println(loser.name + " has been defeated.");
    }
}
