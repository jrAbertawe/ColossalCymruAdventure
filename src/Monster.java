/**
 * This file creates and manages specific 'monster' values
 */

import java.util.Random;

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

public class Monster extends Actor {
	private Item monsterItem;

	/**
	 * Retrieves the player's current experience.
	 *
	 * @param name Monsters name.
	 * @param level Monster's leve upon creation.
	 * @param armourClass Monster's armour class upon creation.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 */

	public Monster(final String name, final int maxHealth, final int level, final int armourClass) {
		super(name, maxHealth, level, armourClass);
		setMonsterItem(randomItem());
	}

	/**
	 * Assigns a random item (ENUM) to the monster.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * @return returns the random item assigned to the monster.
	 */

	public Item randomItem() {
		ItemType[] itemValues = ItemType.values();
		// length - 1 as we don't want to add an Invalid item
		int randomIndex = new Random().nextInt(itemValues.length - 1);
		return new Item(itemValues[randomIndex]);
	}

	/**
	 * Retrieves the monster's current item.
	 *
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 * @return the item that the monster has.
	 */

	public Item getMonsterItem() {
		return monsterItem;
	}

	/**
	 * Sets the item that a monster has in its possession.
	 *
	 * @param monsterItem item to be added to the creation of the monster.
	 * <p>
	 * Side-effect free. Not referentially transparent.
	 *
	 *
	 */

	public void setMonsterItem(final Item monsterItem) {
		this.monsterItem = monsterItem;
	}
}
