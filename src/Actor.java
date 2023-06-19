/**
 * This class describes an Actor: a character in the game.
 *
 * @author jackroberts
 *
 * @version 1.5
 *
 * @modifiedBy Matthew Lane, Zac Healy & Owain Greener
 * @modified 2023-06-19
 */
public abstract class Actor {
  private String name; // Name of actor.
  private int armourClass; // Initial armour class/rating.
  private int currentHealth; // Current health updated throughout the game.
  protected int currentLevel; // Name player level updated throught the game.
  protected int maxHealth = 100; // Maximum health any actor can have.
  protected int maxGold = 9999999; // Maximum gold any player can have at one time.

  /**
   * Constructor for the Actor Class.
   *
   * @param name sets the name of the Actor.
   * @param maxHealth sets the max health of the Actor
   * @param currentLevel sets the level of the actor.
   * @param armourClass sets the armour class of the actor.
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   */

  public Actor(final String name, final int maxHealth, final int currentLevel, final int armourClass) {
    this.name = name;
    this.currentHealth = maxHealth;
    this.currentLevel = currentLevel;
    setArmourClass(armourClass);
  }

  /**
   * Sets the actor level.
   *
   * @param newActorLevel new level to be set for the actor.
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   *
   */

  public final void setActorLevel(final int newActorLevel) {
    this.currentLevel = newActorLevel;
  }

  /**
   * Retrieves the current level of an actor.
   *
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   * @return the current level of an actor.
   */

  public final int currentActorLevel() {
    return this.currentLevel;
  }

  /**
   * Sets the health of a actor.
   *
   * @param currentHealth int that will be set for actor.
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   *
   */

  public final void setCurrentHealth(final int currentHealth) {
    if (currentHealth > maxHealth){
      System.out.println("Sorry that amount of health is too high, setting health to 100!");
      this.currentHealth = maxHealth;
    } else {
    this.currentHealth = currentHealth;
    }
  }

  /**
   * Retrieves the current health of a actor.
   *
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   * @return the current health of an actor.
   */

  public final int getCurrentHealth() {
    return currentHealth;
  }

  /**
   * Retrieves the level of the current armourClass for a actor.
   *
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   * @return armourClass for the actor.
   */

  public final int getArmourClass() {
    return armourClass;
  }

  /**
   * Sets the level of the armour class for a actor.
   *
   * @param armourClass new rating of the armour class for the player.
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   *
   */

  public final void setArmourClass(final int armourClass) {
    if (armourClass < 0) {
      this.armourClass = 0;
    } else if (this.armourClass > (armourClass / 2)) {
      throw new IllegalArgumentException("Armour Level Invalid!");
    } else {
      this.armourClass = armourClass;
    }
  }

  /**
   * Increases the level of the player.
   *
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   *
   */
  public final void increaseLevel() {
    currentLevel++;
  }

  /**
   * Retrieves the name of the actor.
   *
   * <p>
   * Side-effect free. Not referentially transparent.
   *
   * @return the name of the actor
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the actor.
   *
   * <p>
   * Side-effect changes the actor's name.
   *
   * @param name the new name of the actor
   */
  public void setName(final String name) {
    this.name = name;
  }
}
