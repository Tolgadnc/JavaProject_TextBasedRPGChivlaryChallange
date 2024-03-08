package game;

import java.util.List;

public class VillainBoss extends Villain {
	public VillainBoss ( int xCoordinate, int yCoordinate, int healthPoints,  List<Items> villainItems, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		
		super(xCoordinate,yCoordinate,healthPoints,villainItems,parryDenyCapacity,damageCapacity,blockCapacity);

}
}