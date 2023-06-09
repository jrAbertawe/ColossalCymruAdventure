/**
 * This class describes an Actor: a character in the game.
 * @author jackroberts
 *
 */
public abstract class Actor {

    private int level;
    private String name;
    private int armourClass;
    private int health;

    private final int MINIMUM_LEVEL = 0;
    private final int MAXIMUM_LEVEL = 100;
    private final int MINIMUM_ARMORCLASS_LEVEL = 0;
    private final int MAXIMUM_ARMORCLASS_LEVEL = level / 2;
    private final int MAXIMUM_HEALTH = 100;
    public Actor(int level, String name, int armourClass, int health){

        if (level > MINIMUM_LEVEL && level < MAXIMUM_LEVEL){
            this.level = level;
        } else {
            throw new IllegalArgumentException("Level must be between 0" +
                    " and 100. Level must also start at 0.");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is invalid. Please try" +
                    "again.");
        } else {
            this.name = name;
        }

        if (armourClass < MINIMUM_ARMORCLASS_LEVEL ||
                armourClass > MAXIMUM_ARMORCLASS_LEVEL){
            this.armourClass = armourClass;
            throw new IllegalArgumentException("Armour level must be above 0" +
                    "and below the actor level divided by 2.");
        } else {
            this.armourClass = armourClass;
        }

        if (health != MAXIMUM_HEALTH){
            throw new IllegalArgumentException("Health must start at 100.");
        } else {
            health = MAXIMUM_HEALTH;
            // Initiates health as 100 when an actor is created.
        }
    }
}
