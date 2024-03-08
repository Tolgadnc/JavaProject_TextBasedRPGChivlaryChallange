public class Sword extends Items{ // extends the other class "Items" 
	private int sliceDamage;
	private int stabDamage;
	private int blockPower;
	
	//constructor
	public Sword(String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super (name, description);
		this.sliceDamage = sliceDamage;
		this.stabDamage = stabDamage;
		this.blockPower = blockPower;
	}

	//Method to slice attack the villain
	public void slice(Villain villain, Hero hero){
		System.out.println("You unleash a masterful stroke with your sword, cutting through the air like a swift and deadly tempest, aimed directly at your enemy.");

		//Dice roll
		if (hero.heroRollDice() < villain.villainRollDice()){
			if(getSliceDamage() < villain.getBlockCapacity()){
				System.out.println("Unfortunately your opponent completely blocked your attack");
				hero.staminaUseUp(3);


			}else {
				System.out.println("Your opponent was partially able to block your attack");
				int newHPVillain = villain.getHealthPoints() - (sliceDamage-villain.getBlockCapacity());
				villain.setHealthPoints(newHPVillain);
				hero.staminaUseUp(2);
			}
		}else {
			System.out.println("Attack successful!");
			int newHPVillain = villain.getHealthPoints() - sliceDamage;
			villain.setHealthPoints(newHPVillain);
			hero.staminaUseUp(2);

		}


	}
	//Method to stab attack the villain
	public void stab(Villain villain, Hero hero){
		System.out.println("With a deft move, you thrust your sword forward in an attempt to pierce through your opponent's defenses.");
		if (hero.heroRollDice() < villain.villainRollDice()){
			if(stabDamage < villain.getBlockCapacity()){
				System.out.println("Unfortunately your opponent completely blocked your attack");
				hero.staminaUseUp(2);

			}else {
				System.out.println("Your opponent was partially able to block your attack");
				int newHPVillain = villain.getHealthPoints() - (stabDamage-villain.getBlockCapacity());
				villain.setHealthPoints(newHPVillain);
				hero.staminaUseUp(1);
			}
		}else{
			System.out.println("Attack successful!");
			int newHPVillain = villain.getHealthPoints() - stabDamage;
			villain.setHealthPoints(newHPVillain);
			hero.staminaUseUp(1);

		}
	}

	//Method to increase the sword stats.
	public void tempDamageIncreaseWithParry(){
		sliceDamage++;
		stabDamage++;
	}
	
	//Method to turn back to normal stats of the sword
	public void damageTurnBackToNormal(){
		sliceDamage--;
		stabDamage--;
	}
	
	// getter methods
	
	public int getSliceDamage() {
		return sliceDamage;
	}

	public int getStabDamage() {
		return stabDamage;
	}
	
	public int getBlockPower() {
		return blockPower;
	}
	
	
}
