package game;

import java.util.List;

public class Villain {
	private int xCoordinate;
	private int yCoordinate;
	private int healthPoints;
	private List <Items> villainItems;
	private int parryDenyCapacity;
	private int damageCapacity;
	private int blockCapacity;
	
	//constructor
	
	public Villain ( int xCoordinate, int yCoordinate, int healthPoints, List<Items> villainItems, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate =yCoordinate;
		this.healthPoints = healthPoints;
		this.villainItems = villainItems;
		this.parryDenyCapacity = parryDenyCapacity;
		this.damageCapacity = damageCapacity;
		this.blockCapacity = blockCapacity;
	}
		//get & set methods for coordinates x and y
	
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	//getter and setter methods for health points 
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	//getter and setter for villainItems
	
	public List <Items> getVillainItems () {
		return villainItems;
	}
	
	public void setVillainItems(List <Items> villainItems) {
		this.villainItems = villainItems;
	}
	
	//getter and setter for parryDefense 
	
	public int getParryDenyCapacity() {
		return parryDenyCapacity;
	}
	
	public void setParryDenyCapacity(int parryDenyCapacity) {
		this.parryDenyCapacity = parryDenyCapacity;
	}
	
	//getter and setter for damage capacity
	
	public int getDamagecapacity() {
		return damageCapacity;
	}
	
	public void setDamageCapacity(int damageCapacity) {
		this.damageCapacity = damageCapacity;
	}
	
	//getter and setter methods for 
	
	public int getBlockCapacity() {
		return blockCapacity;
	}
	
	public void setBlockCapacity(int blockCapacity) {
		this.blockCapacity = blockCapacity;
	}
	// after creaating the classes this methods will be edited.
	public void villainAttack() {
		
		
	}
	
	public void villainBlock() {
		
	}
	
	public void villainParry() {
		
	}
	
	public void dealDamage() {
		
	}
		
	public void blockHeroattack() {
		
	}
	
}

	


