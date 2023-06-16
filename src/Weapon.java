/**
 * The Weapon class represents a specific type of item that can inflict damage.
 */
/**
 * The Weapon class represents a specific type of item that can inflict damage.
 * It extends the Item class.
 */
public class Weapon extends Item {
  private int weaponDamage; // The damage the weapon serves.

  /**
   * Constructs a new Weapon object with the specified type and weapon damage.
   * 
   * <p>Side-effect sets the item type and sets weapon damage.
   * 
   * @param type         the type of the weapon
   * 
   * @param weaponDamage the damage value inflicted by the weapon
   */
  public Weapon(ItemType type, int weaponDamage) {
    super(type);
    this.weaponDamage = weaponDamage;
  }

  /**
   * Returns the damage value inflicted by the weapon.
   * 
   * <p>Side-effect free. Not referentially transparent.
   * 
   * @return the damage value inflicted by the weapon
   */
  public int getWeaponDamage() {
    return weaponDamage;
  }

  /**
   * Sets the damage value inflicted by the weapon.
   * 
   * <p>Side-effect changes weapon damage.
   * 
   * @param weaponDamage the damage value inflicted by the weapon
   */
  public void setWeaponDamage(int weaponDamage) {
    this.weaponDamage = weaponDamage;
  }
}
