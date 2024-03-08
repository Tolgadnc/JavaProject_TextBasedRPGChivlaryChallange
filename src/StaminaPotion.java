

public class StaminaPotion extends Potion{


//const
	 public StaminaPotion (String name, String description) {
		 super(name, description);

	 }
	 



	public String toString(){
		return getName();
	}
	//Method to Consume potion
	public void consume(Hero hero){
		System.out.println("Your stamina is full now!");
		//Tops the SP of hero.
		 hero.setStaminaPoints(hero.getHeroMaxStamina());

	 }
}