/**
 * This class describes a Monster.
 * @author lowriholborow
 *
 */

import java.util.List;

public class Monster extends Actor {

    Item loot;

    /**
     * Constructor for Monster
     */
    public Monster(String name, int health, int level, int armour) {
        super(name, level, armour, health);;
    }
        //Loot TBC

}
