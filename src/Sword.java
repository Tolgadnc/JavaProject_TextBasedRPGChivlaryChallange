package game;

public class Sword extends Items{
	public int damage;
	public int blockPower;
	
	//constructor
	public Sword(String name, String description, int blockPower, int damage) {
		super (name, description);
		this.damage = damage;
		this.blockPower = blockPower;
	}
	
	// getter methods
	
	public int getDamage() {
		return damage;
	}
	
	public int getBlockPower() {
		return blockPower;
	}
	
	
}
