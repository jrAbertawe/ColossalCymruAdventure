import java.util.Random;
import Item;

public class Monster extends Actor {
  private Item monsterItem;
  public Monster(String name) {
    
    super(name,100,0,0);
           
      Item[] itemValues = Item.values();
      int randomIndex = new Random().nextInt(itemValues.length);
      monsterItem = itemValues[randomIndex];
  }

  public Monster(String name, int level, int armourClass) {

    super(name,100, level, armourClass);

    Item[] itemValues = Item.values();
    int randomIndex = new Random().nextInt(itemValues.length);
    monsterItem = itemValues[randomIndex];
  }

  public void setMonsterHealth (int newMonsterHealth) {

    this.currentHealth = newMonsterHealth;

  }
  public int getMonsterHealth (int newMonsterHealth) {

    return this.currentHealth;

  }
}
