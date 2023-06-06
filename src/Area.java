/**
 * This class describes a 'node' of the map.
 * @author jackroberts
 *
 */
public class Area {
	
	private int areaLevel = 0;
	private Actor monster = null;
	private String description = null;
	
	/**
	 * @param areaLevel
	 * @param monster
	 */
	public Area(String description, int areaLevel, Actor monster) {
		this.areaLevel = areaLevel;
		this.monster = monster;
		this.description = description;
	}
	public int getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(int areaLevel) {
		this.areaLevel = areaLevel;
	}
	public Actor getMonster() {
		return monster;
	}
	public void setMonster(Actor monster) {
		this.monster = monster;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
