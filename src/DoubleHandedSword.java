package game;

public class DoubleHandedSword extends SingleHandedSword {
	private int sliceDamage;
	private int stabDamage;
	
	//constructor
	
	public DoubleHandedSword (String name, String description, int damage, int blockPower, int sliceDamage, int stabDamage) {
		super(name,description,damage,blockPower, sliceDamage);
		
		 this.stabDamage = stabDamage;
	}
	
	public int getSliceDamage() {
		return sliceDamage;
	}
	
	public int getStabDamage() {
		return stabDamage;
	}
	
	public int getBlockPower() {
		return blockPower;
	}
	public int getStaminaIndex() {
		return damage *2;

	
	}


}
