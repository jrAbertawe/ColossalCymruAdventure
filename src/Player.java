import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    
  protected int level;
  protected int experience;
  protected int gold;
  private List<Item> inventory;
  private Item currentWeapon;
    
    public Player(String name) {

      super(name,0,0,0);
      this.level = 0;
      this.experience = 0;
      this.gold = 0;
      this.inventory = new ArrayList<>();
      this.currentWeapon = null;
      }

    
    public void levelUp() {
        if (level < 100 && experience > 3 * (level * 0.1) + 10) {
            level++;
            System.out.println("Congratulations! You leveled up to level " + level);
        } else if (level == 100) {
            gold += 100;
            System.out.println("Congratulations! You reached the maximum level. You received 100 gold.");
        }
    }

     public void getExperience(int gainedXP) {
        if (level < 100) {
            experience += gainedXP;
            System.out.println("You gained " + gainedXP + " experience points.");

            if (experience > 3 * (level * 0.1) + 10) {
                levelUp();
            }
        } else {
            System.out.println("You are already at the maximum level.");
        }
    }
     
    public void addToInventory(String itemName) {
    Item convertedItem = Item.stringToItem(itemName);

    if (convertedItem != Item.INVALID) {
        inventory.add(convertedItem);
        System.out.println("Added " + itemName + " to your inventory.");
    } else {
        System.out.println("Invalid item: " + itemName);
    }
}

public void removeFromInventory(String itemName) {
    Item convertedItem = Item.stringToItem(itemName);

    if (convertedItem != Item.INVALID) {
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
        Item convertedItem = Item.stringToItem(itemName);

        if (convertedItem != Item.INVALID) {
            System.out.println(itemName);
        } else {
            System.out.println("Invalid item: " + itemName);
        }
    }
}

public void addGold(int Gold){

  if (this.gold <= 9999999){
    System.out.println("You are already at max gold, sorry you cannot carry anymore.");
    this.gold = 9999999;
  }
  else {
    this.gold = this.gold + Gold;

  }



}

public void removeGold(int Gold){

  if (this.gold <= 0){
    System.out.println("You dont have any gold left!");
    this.gold = 0;
  }
  else {
    this.gold = this.gold - Gold;

  }



}

   public void equipWeapon(String itemName) {
        Item convertedItem = Item.stringToItem(itemName);

        if (convertedItem != Item.INVALID && inventory.contains(convertedItem)) {
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

      
}
