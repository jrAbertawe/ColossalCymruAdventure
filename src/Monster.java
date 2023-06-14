import java.util.Random;


public class Monster extends Actor {

  private Item monsterItem;

  public Monster(String name) {
    
    super(name);
    

           
      Item[] itemValues = Item.values();
      
      int randomIndex = new Random().nextInt(itemValues.length);
      
      monsterItem = itemValues[randomIndex];
      
  }


 
}
