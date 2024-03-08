package game;

public class CompoundPotion extends Potion {
	  private int superPower;
//const
	  public CompoundPotion(String name, String description,int staminaIndex, int superPower) {
		  super(name, description, staminaIndex);
		  this.superPower = superPower;
	  }
	  
	  public int getSuperPower() {
			return superPower;
	  }
	  
	  public int getStaminaIndex() {
		  return superPower/2;      // gets half of the power
		}
	}
