package game;

	public class HealthPotion extends Potion{
	private int healingPower;

//const
public HealthPotion(String name, String description, int staminaIndex, int healingPower) {
	super(name, description, staminaIndex);
	this.healingPower = healingPower;
}
	
	public int getHealingPower() {
		return healingPower;
	}

	
	public int getStaminaIndex() {
	  return healingPower/2;      // gets half of the power
	}
}