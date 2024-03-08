package game;

import java.util.List;

public class VillainRegular extends Villain{
	public VillainRegular ( int xCoordinate, int yCoordinate, int healthPoints, List<Items> villainItems, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		
		super(xCoordinate, yCoordinate, healthPoints, villainItems, parryDenyCapacity, damageCapacity, blockCapacity);
}
}