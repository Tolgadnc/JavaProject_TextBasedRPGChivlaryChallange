import java.util.Vector;

public class VillainBoss extends Villain {
	private static final int bossMaxHealth = 15;
	
	//const
	public VillainBoss (String name, String description, int xCoordinate, int yCoordinate, int healthPoints, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		
		super(name, description, xCoordinate, yCoordinate, healthPoints, parryDenyCapacity, damageCapacity, blockCapacity);

	}
	//Method to teleport to the hero after the regular villains are dead
	public void teleportToHero(Hero hero){
			Vector heroesCoordinate = hero.getCurrentCoordinate();
			setXCoordinate((int) heroesCoordinate.get(0));
			setYCoordinate((int) heroesCoordinate.get(1));
	}
	public void restoreHealth(){
		setHealthPoints(bossMaxHealth);
	}

}