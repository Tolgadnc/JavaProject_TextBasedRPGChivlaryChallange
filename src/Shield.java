package game;

public class Shield extends Items{
	public int parryPower;
	public int blockPower;
	
	//constructor
	public Shield (String name, String description, int blockPower, int parryPower) {
		super (name, description);
		this.parryPower = parryPower;
		this.blockPower = blockPower;
	}
	
	//getter methods
	
	public int getBlockPower() {
		return blockPower;
		}
	public int getParryPower() {
		return parryPower;
	}

}
