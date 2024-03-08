package game;

public class StaminaPotion extends Potion{
	 private int staminaPower;
//const
	 public StaminaPotion (String name, String description,int staminaIndex, int staminaPower) {
		 super(name, description, staminaIndex);
		 this.staminaPower = staminaPower;
	 }
	 
	 public int getStaminaPower() {
			return staminaPower;
}
		public int getStaminaIndex() {
			  return staminaPower/2;      // gets half of the power
			}
		}