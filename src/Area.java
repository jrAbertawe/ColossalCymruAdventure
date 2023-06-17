/**
 * This file describes a 'node' of the map.
 */

/**
 * This class describes a 'node' of the map.
 * 
 * @author jackroberts
 * 
 * @modifiedBy Zac Healy
 * 
 * @version 1.1
 * @modified 2023-06-16
 */
public class Area {

  /** Maximum length of description. */
  public static final int DESCRIPTION_MAX = 300;
  /** Minimum length of description. */
  public static final int DESCRIPTION_MIN = 0;
  /** Maximum size of level. */
  public static final int LEVLEL_MAX = 100;
  /** Minimum size of level. */
  public static final int LEVLEL_MIN = 0;
  /** Maximum length of monster name. */
  public static final int MONSTER_NAME_MAX = 100;
  /** Minimum length of monster name. */
  public static final int MONSTER_NAME_MIN = 0;

  private int areaLevel; // Level of difficulty.
  private Monster monster; // Monster if monster is present in area.
  private String description; // Description of area.

  /**
   * Creates a new area with the given attributes.
   * 
   * <p>Side-effect initialises the level, monster, and description.
   *
   * @param description String description of any area.
   * 
   * @param areaLevel   Difficulty level of an area, 0 to 100.
   * 
   * @param monster     Actor of any monster if present in area. Null if no
   *                    monster is present.
   */
  public Area(String description, int areaLevel, Monster monster) {
    setAreaLevel(areaLevel);
    setMonster(monster);
    setDescription(description);
  }

  /**
   * Provides the difficulty level of the area.
   * 
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return Difficulty level of area.
   */
  public int getAreaLevel() {
    return areaLevel;
  }

  /**
   * Allows update of Area difficulty and validates new area difficulty.
   * 
   * <p>Side-effect changes the difficulty.
   *
   * @param areaLevel New difficulty level of area.
   * 
   * @throws IllegalArgumentException if level is invalid.
   */
  public void setAreaLevel(int areaLevel) {
    if (areaLevel <= LEVLEL_MAX && areaLevel >= LEVLEL_MIN) {
      this.areaLevel = areaLevel;
    } else {
      throw new IllegalArgumentException("Level invalid!");
    }
  }

  /**
   * Provides Actor of monster in area
   * 
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return Actor of monster in area, null if no monster is present.
   */
  public Monster getMonster() {
    return monster;
  }

  /**
   * Allows update of monster in area and validates new monster's description.
   * 
   * <p>Side-effect changes the monster.
   *
   * @param monster Actor of new monster, null if no monster desired.
   * 
   * @throws IllegalArgumentException if monster name is invalid.
   */
  public void setMonster(Monster monster) {
    if (monster == null) {
      this.monster = null;
    } else if (monster.getName().length() <= MONSTER_NAME_MAX
        && monster.getName().length() >= MONSTER_NAME_MIN) {
      this.monster = monster;
    } else {
      throw new IllegalArgumentException("Monster name invalid!");
    }
  }

  /**
   * Provides description of area.
   * 
   * <p>Side-effect free. Not referentially transparent.
   *
   * @return Lengthy description of area.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Allows update of area's description and validates new area description.
   * 
   * <p>Side-effect changes the area description.
   *
   * @param description Lengthy String description of Area.
   * 
   * @throws IllegalArgumentException if description is invalid.
   */
  public void setDescription(String description) {
    if (description.length() <= DESCRIPTION_MAX
        && description.length() >= DESCRIPTION_MIN) {
      this.description = description;
    } else {
      throw new IllegalArgumentException("Description invalid!");
    }
  }
}
