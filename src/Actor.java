/**
 * This class describes an Actor: a character in the game.
 * @author jackroberts
 *
 */
public abstract class Actor {

    final int MIN_LEVEL = 0;
    final int MAX_LEVEL = 100;
    final int MIN_ARMOUR = 0;
    final int MAX_HEALTH = 100;

    int level = MIN_LEVEL;
    String name;
    int armour = 0;
    int health = MAX_HEALTH;

    /**
     * Constructor for Actor
     */

    public Actor(String name, int level, int armour, int health) {
        this.name = name;
        this.level = level;
        this.armour = armour;
        this.health = health;
    }

    void setLevel(int newLevel) {
        this.level = newLevel;
    }

    /**
     * Returns the level of this Actor
     *
     * @return the level of the Actor
     */
    int getLevel() {
        return level;
    }

    void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns the name of this Actor
     *
     * @return the name of the Actor
     */

    String getName() {
        return name;
    }

    void setArmour(int newArmour) {
        this.armour = newArmour;
    }

    /**
     * Returns the armour of this Actor
     *
     * @return the armour of the Actor
     */

    int getArmour() {
        return armour;
    }

    void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Returns the health of this Actor
     *
     * @return the health of the Actor
     */

    int getHealth() {
        return health;
    }

    static int calculateArmour(int level){
        int armour = level/2;
        return armour;
        }

    }



