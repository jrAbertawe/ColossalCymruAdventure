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

  /**
   * Constructs an Actor object with the given name.
   * 
   * <p>Side-effect changes the actor's name.
   *
   * @param name the name of the actor
   */
  public Actor(String name) {
    this.name = name;
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
