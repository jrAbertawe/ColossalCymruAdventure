/**
 * This file describes the 'player' and manages certain player specific values
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The Item file represents an item with a specific type.
 */
/**
 * The Item class represents an item with a specific type.
 *
 * @author Matthew Lane
 *
 * @modifiedBy Matthew Lane, Zac Healy & Owain Greener
 *
 * @version 1.0
 * @modified 2023-06-17
 */



public class Player extends Actor {

    private int experience;
	private int gold;
	private List<Item> inventory;
	private Weapon currentWeapon;

	/**
	 * Constructor for the Player Class.
	 *
	 * @param name Players name used in game.
	 * @param maxHealth maximum health that a player can have - set to 100.
	 * @param level Players starting level.
	 * @param armourClass Players starting armour class used for battle.
	 *
	 *
	 *
	 */

	public Player(final String name, final int maxHealth, final int level, final int armourClass) {
		super(name, maxHealth, level, armourClass);
		this.experience = 0; // starting amount of experince to next level up
		this.gold = 0; // starting amount of gold
		this.inventory = new ArrayList<>(); // creates players inventory
		this.currentWeapon = new Weapon(ItemType.SWORD, 20); // assign a weapon to start with
		this.inventory.add(currentWeapon); // add starting weapon to inventory
	}

	/**
	 * Retrieves the player's current experience.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * 
	 */

	public final void levelUp() {
		if (this.getCurrentHealth() < maxHealth && experience > 3 * (this.getCurrentHealth() * 0.1) + 10) {
			this.increaseLevel();
			System.out.println("Congratulations! You leveled up to level " + currentLevel);
		} else if (this.getCurrentHealth() == maxHealth) {
			gold += maxHealth;
			System.out.println("Congratulations! You reached the maximum level. You received 100 gold.");
		}
	}

	/**
	 * Retrieves the player's current experience.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * @return The experience of the player.
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Calculates players XP gain and level up.
	 *
	 * @param gainedXP
	 */
	public void setExperience(final int gainedXP) {
		if (this.getCurrentHealth() < maxHealth) {
			experience += gainedXP;
			System.out.println("You gained " + gainedXP + " experience points.");

			if (experience > 3 * (this.getCurrentHealth() * 0.1) + 10) {
				levelUp();
			}
		} else {
			System.out.println("You are already at the maximum level.");
		}
	}

	/**
	 * Removes specified item from the players inventory.
	 *
	 * @param item item being added to players inventory.
	 */
	public void addToInventory(final Item item) {
		inventory.add(item);
		System.out.println("Added " + item.getType().toString() + " to your inventory.");
	}

	/**
	 * Removes specified item from the players inventory.
	 * @param item item in players inventory.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 */
	public final void removeFromInventory(final Item item) {
		inventory.remove(item);
		System.out.println("Removed " + item.getType().toString() + " from your inventory.");
	}

	/**
	 * Prints the inventory of the user.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 *
	 */

	public final void showInventory() {
		System.out.println("Inventory:");
		for (Item item : inventory) {
			String itemName = item.toString();
			Item convertedItem = new Item(ItemType.stringToItem(itemName));

			if (convertedItem.getType() != ItemType.INVALID) {
				System.out.println(itemName);
			} else {
				System.out.println("Invalid item: " + itemName);
			}
		}
	}

	/**
	 * Adds gold to a player upto the limit.
	 * @param gold Players current gold.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 */

	public final void addGold(final int gold) {

		if (this.gold >= maxGold) {
			System.out.println("You are already at max gold, sorry you cannot carry anymore.");
			this.gold = maxGold;
		} else {
			this.gold += gold;
			System.out.println("You gained " + gold + " gold!");
		}
	}

	/**
	 * Removes gold from the player.
	 * @param Gold Players current gold.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 */

	public final void removeGold(final int Gold) {

		if (this.gold <= 0) {
			System.out.println("You dont have any gold left!");
			this.gold = 0;
		} else {
			this.gold = this.gold - Gold;
		}
	}

	/**
	 * Equips the weapon from the inventory of the player.
	 *
	 *@param weapon weapon that is being equipped to the player.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 *
	 */

	public final void equipWeapon(final Weapon weapon) {
		currentWeapon = weapon;
		System.out.println("Equipped " + weapon.getType() + " as your current weapon.");
	}

	/**
	 * Returns the current weapon to the player
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * @return Current weapon of player.
	 */

	public final Weapon getCurrentWeapon() {
		return this.currentWeapon;
	}

	/**
	 * Prints the players current inventory to the screen
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 */

	public final void showCurrentWeapon() {
		if (currentWeapon != null) {
			System.out.println("Current Weapon: " + currentWeapon.toString());
		} else {
			System.out.println("No weapon equipped.");
		}
	}

	/**
	 * Retrieves the player's current gold.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * @return The player's current gold.
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Sets the player's gold.
	 *
	 * <p>
	 * Side-effect changes the player's gold.
	 *
	 * @param gold The player's new gold.
	 */
	public void setGold(final int gold) {
		this.gold = gold;
	}
}
