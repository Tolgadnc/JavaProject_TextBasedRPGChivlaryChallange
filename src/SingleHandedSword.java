package game;

public class SingleHandedSword extends Sword {
	private int sliceDamage;
	
	//constructor
	public SingleHandedSword (String name, String description, int damage, int blockPower, int sliceDamage) {
		super (name, description ,damage, blockPower);
		this.sliceDamage = sliceDamage;
		}
	
	public int getSliceDamage() {
		return sliceDamage;
	}
	public int getBlockPower() {
		return blockPower;
	}
		public int getStaminaIndex() {
			return damage *2;
	
	}
	
}