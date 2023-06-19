/**
 * This file describes an Actor: a character in the game.
 */
/**
 * This class describes an Actor: a character in the game.
 *
 * @author jackroberts
 * 
 * @version 1.1
 * @modified 2023-06-10
 */
public abstract class Actor {
  private String name; // Name of actor.
  private int armourClass;
  private int currentHealth;
  private int currentLevel;

  public Actor(String name, int currentHealth, int currentLevel,
      int armourClass) {
    this.name = name;
    this.currentHealth = currentHealth;
    this.currentLevel = currentLevel;
    setArmourClass(armourClass);
  }

  public void setActorLevel(int newActorLevel) {
    newActorLevel = currentLevel;
  }

  public int currentActorLevel() {
    return this.currentLevel;
  }

  public void setCurrentHealth(int currentHealth) {
    this.currentHealth = currentHealth;
  }

  public int getCurrentHealth() {
    return currentHealth;
  }

  public int getArmourClass() {
    return armourClass;
  }

  public void setArmourClass(int armourClass) {
    if (armourClass < 0) {
      this.armourClass = 0;
    } else if (this.armourClass > (armourClass / 2)) {
      throw new IllegalArgumentException("Armour Level Invalid!");
    } else {
      this.armourClass = armourClass;
    }
  }

  public void increaseLevel() {
    currentLevel++;
  }

  /**
   * Retrieves the name of the actor.
   * 
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return the name of the actor
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the actor.
   * 
   * <p>Side-effect changes the actor's name.
   *
   * @param name the new name of the actor
   */
  public void setName(String name) {
    this.name = name;
  }
}
