package game;

public class Potion extends Items {
	private int staminaIndex;
  
  
  //constructor
  
  public Potion (String name, String description, int staminaIndex) {
	  super (name, description);
	  this.staminaIndex = staminaIndex;
  }
  
  //getter method
  public int getStaminaIndex() {
	  return staminaIndex;
  }
}
