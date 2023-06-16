import java.util.Random;

public class Monster extends Actor {
	private Item monsterItem;

	public Monster(String name) {
		super(name, 100, 0, 0);
		setMonsterItem(randomItem());
	}

	public Monster(String name, int level, int armourClass) {
		super(name, 100, level, armourClass);
		setMonsterItem(randomItem());
	}

	public Item randomItem() {
		ItemType[] itemValues = ItemType.values();
		int randomIndex = new Random().nextInt(itemValues.length);
		return new Item(itemValues[randomIndex]);
	}
	
	public Item getMonsterItem() {
		return monsterItem;
	}

	public void setMonsterItem(Item monsterItem) {
		this.monsterItem = monsterItem;
	}
}
