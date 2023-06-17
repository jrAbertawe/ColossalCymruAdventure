import java.util.ArrayList;
import java.util.List;

public class Player extends Actor{

    final int MIN_GOLD = 0;
    final int MAX_GOLD = 9999999;
    final int MIN_EXPERIENCE = 0;

        int experience = 0;
        int gold = 0;
        int gainedXP;
        ArrayList<Item> inventory = new ArrayList<Item>();
        Item currentWeapon;

    /**
     * Constructor for Player
     *
     */
    public Player(String name, int level, int armour, int health, int experience, List<Item> inventory, int gold, Item currentWeapon) {
        super(name, level, armour, health);
        this.experience = experience;
        this.inventory = (ArrayList<Item>) inventory;
        this.gold = gold;
        this.currentWeapon = currentWeapon;
    }

    // Getters and Setters

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    void setGold(int newGold) {
        this.gold = newGold;
    }

    /**
     * Returns the gold of this Player
     *
     * @return the gold of the Player
     */

    int getGold() {
        return gold;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }



    //This does not happen for monsters.
    static int getExperience(int level, int experience, int gainedXP) {
        if (level >= 0 && level <= 100) {
            experience += gainedXP;

            //When the player gathers enough Experience, their Level increases by 1.
            if (experience > 3 * (level * 0.1) + 10) {
                level++;
            }

            //Once the Level has reached its maximum, the player gets 100 gold instead of experience.
            if (level > 100) {
                this.gold + 100;
            }

}


//getter and setter for all attributes
//Current Weapon TBC
