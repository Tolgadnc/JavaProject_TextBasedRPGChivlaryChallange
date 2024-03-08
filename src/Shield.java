public class Shield extends Items{ //class extends the mainClass
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

	public String toString(){
		return getName();
	}

}
