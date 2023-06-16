import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

	private int experience;
	private int gold;
	private List<Item> inventory;
	private Item currentWeapon;

	public Player(String name, int level, int armourClass) {
		super(name, 100, level, armourClass);
		this.experience = 0;
		this.gold = 0;
		this.inventory = new ArrayList<>();
		this.currentWeapon = null;
	}

	public void levelUp() {
		if (this.getCurrentHealth() < 100 && experience > 3 * (this.getCurrentHealth() * 0.1) + 10) {
			this.increaseLevel();
			System.out.println("Congratulations! You leveled up to level " + this.getCurrentHealth());
		} else if (this.getCurrentHealth() == 100) {
			gold += 100;
			System.out.println("Congratulations! You reached the maximum level. You received 100 gold.");
		}
	}
	/**
	 * Retrieves the player's current experience.
	 * 
	 * <p>Side-effect free. Not referentially transparent.
	 * 
	 * @return
	 */
	public int getExperience() {
		return experience;
	}

	public void setExperience(int gainedXP) {
		if (this.getCurrentHealth() < 100) {
			experience += gainedXP;
			System.out.println("You gained " + gainedXP + " experience points.");

			if (experience > 3 * (this.getCurrentHealth() * 0.1) + 10) {
				levelUp();
			}
		} else {
			System.out.println("You are already at the maximum level.");
		}
	}

	public void addToInventory(String itemName) {
		Item convertedItem = new Item(ItemType.stringToItem(itemName));

		if (convertedItem.getType() != ItemType.INVALID) {
			inventory.add(convertedItem);
			System.out.println("Added " + itemName + " to your inventory.");
		} else {
			System.out.println("Invalid item: " + itemName);
		}
	}

	public void removeFromInventory(String itemName) {
		Item convertedItem = new Item(ItemType.stringToItem(itemName));

		if (convertedItem.getType() != ItemType.INVALID) {
			if (inventory.remove(convertedItem)) {
				System.out.println("Removed " + itemName + " from your inventory.");
			} else {
				System.out.println(itemName + " is not in your inventory.");
			}
		} else {
			System.out.println("Invalid item: " + itemName);
		}
	}

	public void showInventory() {
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

	public void addGold(int Gold) {

		if (this.gold <= 9999999) {
			System.out.println("You are already at max gold, sorry you cannot carry anymore.");
			this.gold = 9999999;
		} else {
			this.gold = this.gold + Gold;

		}
	}

	public void removeGold(int Gold) {

		if (this.gold <= 0) {
			System.out.println("You dont have any gold left!");
			this.gold = 0;
		} else {
			this.gold = this.gold - Gold;

		}
	}

	public void equipWeapon(String itemName) {
		Item convertedItem = new Item(ItemType.stringToItem(itemName));

		if (convertedItem.getType() != ItemType.INVALID && inventory.contains(convertedItem)) {
			currentWeapon = convertedItem;
			System.out.println("Equipped " + itemName + " as your current weapon.");
		} else {
			System.out.println("Invalid item: " + itemName);
		}
	}

	public void showCurrentWeapon() {
		if (currentWeapon != null) {
			System.out.println("Current Weapon: " + currentWeapon.toString());
		} else {
			System.out.println("No weapon equipped.");
		}
	}

	/**
	 * Retrieves the player's current gold.
	 * 
	 * <p>Side-effect free. Not referentially transparent.
	 * 
	 * @return The player's current gold.
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * Sets the player's gold.
	 * 
	 * <p>Side-effect changes the player's gold.
	 * 
	 * @param gold The player's new gold.
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
}
