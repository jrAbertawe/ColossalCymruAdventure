import java.util.ArrayList;
import java.util.Random;

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
    private final int MAXIMUM_HEALTH = 100;
    public Actor(int level, String name) {

        if (level > MINIMUM_LEVEL && level < MAXIMUM_LEVEL) {
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

        this.armourClass = calculateArmourClass(level);
        if (armourClass < MINIMUM_ARMORCLASS_LEVEL ||
                armourClass > calculateArmourClass(level)) {
            throw new IllegalArgumentException("Armour level must be above 0" +
                    "and below the actor level divided by 2.");
        }

        this.health = MAXIMUM_HEALTH;
        // Sets health at 100 (the max) when constructing an actor
    }
        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }

        public int getArmourClass() {
            return armourClass;
        }

        public int getHealth() {
            return health;
        }

        private int calculateArmourClass(int level) {
        return Math.min(level / 2, 100);
        }
}

    class Player extends Actor {
        private int experience;
        private ArrayList<Item> inventory;
        private int gold;
        private Item currentWeapon;
        private int gainedXP;
        private final int MINIMUM_EXP = 0;
        private final int MINIMUM_GOLD = 0;

        public Player(int level, String name) {
            super(level, name);
            this.experience = MINIMUM_EXP;

            this.inventory = new ArrayList<Item>();

            this.gold = MINIMUM_GOLD;

            this.currentWeapon = null;

            calculatePlayersLevel(level, experience, gainedXP);
        }

        // Getters and setters for player constructor
        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public ArrayList<Item> getInventory() {
            return inventory;
        }

        public void setInventory(ArrayList<Item> inventory) {
            this.inventory = inventory;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public Item getCurrentWeapon() {
            return currentWeapon;
        }

        public void setCurrentWeapon(Item currentWeapon) {
            this.currentWeapon = currentWeapon;
        }

        public void calculatePlayersLevel(int level, int experience,
                                                 int gainedXP) {
            final int MAX_LEVEL = 100;
            final int MINIMUM_EXP = 0;
            int requiredExp = (int) (3 * (level * 0.1) + 10);
            if (level < MAX_LEVEL) {
                experience += gainedXP;
                if (experience > requiredExp) {
                    level += 1;
                    System.out.println("You have leveled up! You are now level "
                            + level + ".");
                } else {
                    System.out.println("You gained " + gainedXP + " experience " +
                            "points.");
                }
            } else if (experience < MINIMUM_EXP) {
            throw new IllegalArgumentException("Experience cannot be " +
                    "below 0.");
            } else {
                System.out.println("You have reached the maximum level." +
                        "You have been awarded 100 gold.");
                setGold(gold + 100);
            }
        }
    }

    class Monster extends Actor {
    private Item loot;

    public Monster(int level, String name) {
        super(level, name);
        this.loot = generateRandomItem();
    }

    private Item generateRandomItem() {
        Random random = new Random();
        Item item = new Item("Item name will go here " +
                random.nextInt(100)); // This will need to be changed
        // Depending on how many items we get
        return item;
    }

    public Item getLoot() {
        return loot;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }
    @Override
    public String toString() {
        return "Monster - Name: " + getName() + ", Level: " + getLevel() +
                ", Loot: " + loot.getName();
    }
}

