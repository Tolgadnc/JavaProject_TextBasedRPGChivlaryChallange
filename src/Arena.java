public class Arena extends Area {
	//class extends main
    public Arena(String title, String description, int villainCount) {
        super(title, description, villainCount);
    }

    //Method to initiate the boss fight
    public void initiateBossFight(VillainBoss boss, Hero hero){
        //Bosses and hero's coordinates become equal, that is how the combat starts.
        boss.teleportToHero(hero);
        //Get the description for boss.
        System.out.println(boss.getDescription());



    }
}
