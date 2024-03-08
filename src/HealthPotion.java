

public class HealthPotion extends Potion{




//const
	public HealthPotion(String name, String description) {
		super(name, description);

	}
	


	public String toString(){
			return getName();
		}

	//Method to Consume potion
	public void consume(Hero hero){
		System.out.println("Your health is full now!");
		//Tops the HP
		hero.setHealthPoints(hero.getHeroMaxHealth());

	}
}