/**
 * The Item file represents an item with a specific type.
 */
/**
 * The Item class represents an item with a specific type.
 * 
 * @author Zac Healy
 *
 * @modifiedBy Zac Healy
 * 
 * @version 1.0
 * @modified 2023-06-17
 */
public class Item {
  private ItemType type; // The item type of the item.

  /**
   * Constructs a new Item object with the specified type.
   * 
   * <p>Side-effect sets the item type.
   * 
   * @param type the type of the item
   */
  public Item(ItemType type) {
    this.type = type;
  }

  /**
   * Returns the type of the item.
   * 
   * <p>Side-effect free. Not referentially transparent.
   * 
   * @return the type of the item
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Sets the type of the item.
   * 
   * <p>Side-effect sets the item type.
   * 
   * @param type the type of the item
   */
  public void setType(ItemType type) {
    this.type = type;
  }
}