import java.util.Random;


public class Monster extends Actor {

  private Item monsterItem;

  public Monster(String name) {
    
    super(name,0,0,0);
    

           
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
