public class VillainRegular extends Villain{


	private static final int regularVillainMaxHealth = 10;


	public VillainRegular (String name, String description, int xCoordinate, int yCoordinate, int healthPoints, int parryDenyCapacity, int damageCapacity, int blockCapacity) {

		
		super(name, description, xCoordinate, yCoordinate, healthPoints, parryDenyCapacity, damageCapacity, blockCapacity);



    }

	public void restoreHealth(){
		setHealthPoints(regularVillainMaxHealth);
	}

}