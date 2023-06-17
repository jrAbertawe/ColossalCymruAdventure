import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

	private int experience;
	private int gold;
	private List<Item> inventory;
	private Weapon currentWeapon;

	public Player(String name, int level, int armourClass) {
		super(name, 100, level, armourClass);
		this.experience = 0;
		this.gold = 0;
		this.inventory = new ArrayList<>();
		this.currentWeapon = new Weapon(ItemType.SWORD, 20); //assign a weapon to start with
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

	public void addToInventory(Item item) {
		inventory.add(item);
		System.out.println("Added " + item.getType().toString() + " to your inventory.");
	}

	public void removeFromInventory(Item item) {
		inventory.remove(item);
		System.out.println("Removed " + item.getType().toString() + " from your inventory.");
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

	public void addGold(int gold) {

		if (this.gold >= 9999999) {
			System.out.println("You are already at max gold, sorry you cannot carry anymore.");
			this.gold = 9999999;
		} else {
			this.gold += gold;
			System.out.println("You gained " + gold + " gold!");
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

	public void equipWeapon(Weapon weapon) {
		currentWeapon = weapon;
		System.out.println("Equipped " + weapon.getType() + " as your current weapon.");
	}

	public Weapon getCurrentWeapon(){
		return this.currentWeapon;
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
