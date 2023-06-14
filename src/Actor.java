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
  protected int armourClass;
  protected int currentHealth;
  protected int currentLevel;

  public Actor(String name, int armourClass){

      this.name = name;
      currentHealth = 100;
      currentLevel = 0;
      if (this.armourClass < 0 ){
        this.armourClass = 0;


      }
      else if (this.armourClass > currentLevel/2 ) {
        System.out.println("Incorrect Armour Class, please rectify before continuing");
        return;
      }
      else {
        this.armourClass = armourClass;

      }
  }

  public void setActorLevel (int newActorLevel){

    newActorLevel = currentLevel;


  }

  public int currentActorLevel (){

    return this.currentLevel;
  
  }

  public void setActorHealth (int newActorHealth){

    newActorHealth = currentHealth;
  }

  public int currentActorHealth(){
    return currentHealth;

  }

  public void newArmourClass (int newArmourLevel){

    if (newArmourLevel < 0 ){
      newArmourLevel = 0;


    }
    else if (this.armourClass > (currentLevel/2) ) {
      System.out.println("Incorrect Armour Class, please rectify before continuing");
      return;
    }
    else {
      newArmourLevel = armourClass;

    }
  }










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
