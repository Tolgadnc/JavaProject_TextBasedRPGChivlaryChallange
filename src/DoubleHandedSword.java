public class DoubleHandedSword extends Sword {
//class extends the main class
	
	//constructor
	
	public DoubleHandedSword (String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super(name,description, blockPower, sliceDamage, stabDamage);
		

	}
	


	public String toString(){
		return getName();
	}



}
