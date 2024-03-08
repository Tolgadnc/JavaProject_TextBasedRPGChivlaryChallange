

public class CompoundPotion extends Potion {
	//class extends the main class


//const
	  public CompoundPotion(String name, String description) {
		  super(name, description);

	  }



	public String toString(){
		return getName();
	}
//Method to Consume potion
	public void consume(Hero hero){
		System.out.println("Both our health and stamina are full now!");
		//Set the stats to their max values
		  hero.setHealthPoints(hero.getHeroMaxHealth());
		  hero.setStaminaPoints(hero.getHeroMaxStamina());
	}
}
