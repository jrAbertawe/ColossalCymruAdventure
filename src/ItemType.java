/**
 * This file describes a collectible item rewarded after every battle.
 */
/**
 * This enum describes a collectible item rewarded after every battle.
 * 
 * @author jackroberts
 *
 * @version 1.1
 * @modified 2023-06-10
 */
public enum ItemType {
  /** The sword item type. */
  SWORD,
  /** The potion item type. */
  POTION,
  /** The bara brith item type. */
  BARA_BRITH,
  /** The text book item type. */
  TEXT_BOOK,
  /** The spear item type. */
  SPEAR,
  /** The phone item type. */
  PHONE,
  /** Invalid item. */
  INVALID;

  /**
   * Returns the corresponding item type based off of the input.
   * 
   * @param item the string representation of the item.
   * @return the item type based on the input.
   */
  public static ItemType stringToItem(String item) {
    // Checks the item type that corresponds to the input.
    if (item.equalsIgnoreCase("sword")) {
      // Process sword item.
      return SWORD;
    } else if (item.equalsIgnoreCase("potion")) {
      // Process potion item.
      return POTION;
    } else if (item.equalsIgnoreCase("bara brith")) {
      // Process bara brith item.
      return BARA_BRITH;
    } else if (item.equalsIgnoreCase("text book")) {
      // Process text book item.
      return TEXT_BOOK;
    } else if (item.equalsIgnoreCase("spear")) {
      // Process spear item.
      return SPEAR;
    } else if (item.equalsIgnoreCase("phone")) {
      // Process phone item.
      return PHONE;
    } else {
      // Process invalid item.
      return INVALID;
    }
  }
}
