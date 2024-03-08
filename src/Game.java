import java.util.Locale;
import java.util.Scanner;

public class Game {

    private static Shield shield = new Shield("The shield", "Capable of blocking(block: 3, stamina: -1) and parrying(parry: 2, stamina: -2)", 3, 2);
    private static DoubleHandedSword doubleHandedSword = new DoubleHandedSword("Long sword", "A long sword, capable of stabbing (Damage: 3, Stamina:-3, slicing (Damage: 2, Stamina: -2) and blocking(block: 2 stamina: -2)", 2, 4, 2);
    private static SingleHandedSword singleHandedSword = new SingleHandedSword("Single Handed Sword", "A standard sword, capable of stabbing (Damage: 2, Stamina:-2, slicing (Damage: 1, Stamina: -1) and blocking(block: 1 stamina: -1)", 1, 3, 1);
    private static PreparingArea preparingArea = new PreparingArea(0, "Preparing Area", "A room where the hero can add items to his inventory.");
    private static Hero hero = new Hero(0, 20,20 ,preparingArea);
    private static HealthPotion healthPotion = new HealthPotion("Health Potion", "Tops health");
    private static StaminaPotion staminaPotion = new StaminaPotion("Stamina Potion", "Tops stamina");
    private static CompoundPotion compoundPotion = new CompoundPotion("Compound Potion", "Tops stamina and health");
    private static Arena arena = new Arena("Arena", "*", 4);
    private static VillainRegular villainRegularWind = new VillainRegular("Gale Guardian", "a man. wears a sleek, wind-resistant cloak adorned with sand-colored camouflage, and dons protective goggles against blowing debris. Carrying a sturdy, aerodynamic spear, he adeptly navigates the gusty landscape, ready for both offense and defense. He gazes at you, there is no point in thinking. He is in your way!", 1,2,10,0,2,1);
    private static VillainRegular villainRegularSnow = new VillainRegular("Arctic Ranger", "a woman. Se is clad in insulated, fur-trimmed garments, blending seamlessly with the wintry surroundings. Armed with a double-bladed ice axe for climbing and combat, he moves silently through the snow-covered trees, agile and prepared for frigid encounters. She feels your presence. You must fight, so you can move on!", 2,3,10,1,2,1);
    private static VillainRegular villainRegularDesert = new VillainRegular("Sandstorm Sentinel", "a man. He is wearing light, tan garments for desert heat and a sand-resistant curved sword sheathed at his side. A leather-wrapped shield completes his gear, ready to endure the harsh conditions of the arid landscape. Suddenly he looks at you. He sees you, what will you do, after all he is a threat!", 2, 1, 10,2,2,3);
    private static VillainRegular villainRegularRain = new VillainRegular("Jungle Recon", "a man. He is in breathable, moisture-wicking leaf-patterned attire, complemented by a pair of lightweight, waterproof boots. Armed with a dual-edged machete with a serrated back for versatility, he maneuvers swiftly through the dense vegetation. He notices you, if you want to go home, you have to strike!", 3,2,10,1,2,1);
    private static VillainBoss villainBoss = new VillainBoss("The Boss", "The fight is not over yet. Behind you, you feel a presence. It gives you shivers down your spine. A man in black armour wearing a mask looking right at you. He does not speak but he pulls his sword out and points it towards you. His intentions are clear. Remember, the only way home is the way trough.", 0, 0,15,3,4,2);

    public static void main(String[] args) {

        preparingArea.addItems(shield);
        preparingArea.addItems(doubleHandedSword);
        preparingArea.addItems(singleHandedSword);


        displayIntroStory();
        selectWeapon();
        wantShield();
        wantPotion();
        wantToChangeInventory();
        exitToArena();

        //Check the commands for the game to check the details.
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a command (type 'help' for available commands):");
            String userCommand = scanner.nextLine();

            switch (userCommand.toLowerCase(Locale.ROOT)) {
            
            //to display the current stats
            
                case "stats":
                    hero.displayStats();
                    break;
            // to display the inventory in the game
                case "inventory":
                    hero.displayInventory();
                    break;
            //direction commands to the player (N,S,E,W)
                case "go north":
                    System.out.println(hero.move(Directions.NORTH));
                    System.out.println("You moved trough north, look around");
                    break;
                case "go south":
                    System.out.println(hero.move(Directions.SOUTH));
                    System.out.println("You moved trough south, look around");
                    break;
                case "go east":
                    System.out.println(hero.move(Directions.EAST));
                    System.out.println("You moved trough east, look around");
                    break;
                case "go west":
                    System.out.println(hero.move(Directions.WEST));
                    System.out.println("You moved trough west, look around");
                    break;
               /*look around to find what type of villain area(description), this works if the players current coordinates and villain coordinates are
                  equal*/
                case "look":

                    if (hero.getCurrentCoordinate().equals(villainRegularWind.getCurrentCoordinatesVillain())){
                        hero.villainLook(villainRegularWind);
                    } else if (hero.getCurrentCoordinate().equals(villainRegularSnow.getCurrentCoordinatesVillain())){
                        hero.villainLook(villainRegularSnow);

                    } else if (hero.getCurrentCoordinate().equals(villainRegularDesert.getCurrentCoordinatesVillain())){
                        hero.villainLook(villainRegularDesert);

                    } else if (hero.getCurrentCoordinate().equals(villainRegularRain.getCurrentCoordinatesVillain())){
                        hero.villainLook(villainRegularRain);

                    }else {
                        //If there are no villains around normalLook function is called.
                        hero.normalLook();
                    }
                    
                   break;
                
                // attack command is used to attack the opponents
                case "attack":


                		//If hero has a single-handed sword in his inventory
                        if (hero.getInventory().contains(singleHandedSword)){
                            //if hero's coordinates are equal to villains coordinates set the hero's current villain.
                            if (hero.getCurrentCoordinate().equals(villainRegularWind.getCurrentCoordinatesVillain())){
                                hero.setCurrentVillain(villainRegularWind);
                                //if the villain health is already 0 or below, they can not be attacked.
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){
                                	System.out.println("You can not attack a dead opponent");
                                }else{
                                    //Combat starts
                                    villainRegularWind.displayVillainStats();
                                    hero.initiateCombat(villainRegularWind, singleHandedSword, shield, hero, arena);
                                }

                               // Villain snow
                            } else if (hero.getCurrentCoordinate().equals(villainRegularSnow.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularSnow);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularSnow.displayVillainStats();
                                    hero.initiateCombat(villainRegularSnow, singleHandedSword, shield, hero, arena);
                                }
                               
                              //Villain Desert
                            } else if (hero.getCurrentCoordinate().equals(villainRegularDesert.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularDesert);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularDesert.displayVillainStats();
                                    hero.initiateCombat(villainRegularDesert, singleHandedSword, shield, hero, arena);
                                }
                                
                              //Villain Rain
                            } else if (hero.getCurrentCoordinate().equals(villainRegularRain.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularRain);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularRain.displayVillainStats();
                                    hero.initiateCombat(villainRegularRain, singleHandedSword, shield, hero, arena);
                                }
                            }else if (hero.getCurrentVillain().equals(null)) {
                                System.out.println("You can not attack unless there is an enemy around");
                            }
                            
                           // same statements for the double handed sword
                        } else if (hero.getInventory().contains(doubleHandedSword)) {

                            if (hero.getCurrentCoordinate().equals(villainRegularWind.getCurrentCoordinatesVillain())){
                                hero.setCurrentVillain(villainRegularWind);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularWind.displayVillainStats();
                                    hero.initiateCombat(villainRegularWind, singleHandedSword, shield, hero, arena);
                                }
                            } else if (hero.getCurrentCoordinate().equals(villainRegularSnow.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularSnow);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularSnow.displayVillainStats();
                                    hero.initiateCombat(villainRegularSnow, singleHandedSword, shield, hero, arena);
                                }

                            }else if (hero.getCurrentCoordinate().equals(villainRegularDesert.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularDesert);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularDesert.displayVillainStats();
                                    hero.initiateCombat(villainRegularDesert, singleHandedSword, shield, hero, arena);
                                }

                            }else if (hero.getCurrentCoordinate().equals(villainRegularRain.getCurrentCoordinatesVillain())) {
                                hero.setCurrentVillain(villainRegularRain);
                                if (hero.getCurrentVillain().getHealthPoints() <= 0){

                                    System.out.println("You can not attack a dead opponent");
                                }else{
                                    villainRegularRain.displayVillainStats();
                                    hero.initiateCombat(villainRegularWind, singleHandedSword, shield, hero, arena);
                                }

                            }else if (hero.getCurrentVillain().equals(null)) {
                                System.out.println("You can not attack unless there is an enemy around");
                            }
                        }




                    break;


                // this code is to use the potions before the fight and display the stats
                case "drink health potion":
                    //hero can only consume the potion if his health is below zero.
                    if (hero.getHealthPoints() < 20){
                        hero.consumePotion(healthPotion, hero);
                        //once the hero consumes the potion, it is removed from his inventory
                        hero.remove(healthPotion);
                        //Display the new stats.
                        hero.displayStats();
                    }else{
                        System.out.println("Your health is already full");
                    }
                    break;
                case "drink stamina potion":
                    if (hero.getStaminaPoints() < hero.getHeroMaxStamina()){
                        hero.consumePotion(staminaPotion, hero);
                        hero.remove(staminaPotion);
                        hero.displayStats();
                    }else{
                        System.out.println("Your stamina is already full");
                    }

                    break;
                case "drink compound potion":
                    if (hero.getHealthPoints() < hero.getHeroMaxHealth() && hero.getStaminaPoints() < hero.getHeroMaxStamina()){
                        hero.consumePotion(compoundPotion, hero);
                        hero.remove(compoundPotion);
                        hero.displayStats();
                    }else if (hero.getHealthPoints() == hero.getHeroMaxHealth() && hero.getStaminaPoints() < hero.getHeroMaxStamina()){
                        hero.consumePotion(compoundPotion, hero);
                        hero.remove(compoundPotion);
                        hero.displayStats();

                    }else if (hero.getHealthPoints() < hero.getHeroMaxHealth() && hero.getStaminaPoints() == hero.getHeroMaxStamina()){
                        hero.consumePotion(compoundPotion, hero);
                        hero.remove(compoundPotion);
                        hero.displayStats();

                    }
                    break;
                    //displays all the commands
                case "help":
                    displayHelp();
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for available commands.");

            }
            //when all the villains are dead it initiates the boss fight after the regular villain dies
            if (hero.getCurrentArea().equals(arena)){
                //if the villain count becomes equal to 0 initiate boss fight.
                if (arena.getVillainCount() == 0){
                    arena.initiateBossFight(villainBoss, hero);
                    //Different boss fight function calls for different types of swords.
                    if (hero.getInventory().contains(singleHandedSword)){
                        hero.initiateCombat(villainBoss, singleHandedSword, shield, hero, arena);
                    }else if (hero.getInventory().contains(doubleHandedSword)){
                        hero.initiateCombat(villainBoss, doubleHandedSword, shield, hero, arena);
                    }

                }
            }
            if (villainBoss.getHealthPoints() <= 0){
                System.out.println("The mysterious man falls to his knees, his mask suddenly drops on the ground. When you look at his face\n" +
                        "what you see shocks you to your heart. His face is identical to yours. He says: \"Mission failed, puppet. You were bred for servitude, not triumph. The hero you thought you were is nothing more than a fleeting illusion. The real game, the true manipulation, unfolds beyond anybodies comprehension. Your success here changes nothing. Your existence is a testament to your perpetual defeat, its a lie. The only time you get out, is the time they want you to get out. But you are already gone, remember? You are just a reflection, a product of enhanced technology.\n You and I, we both are. \"You\" will hunt you again.\"");
                System.out.println("Then you remember everything. How you were selected for this programme, because of your capabilities, your assets, your genes! How they collected it. And also, how they killed you and limited your memory. Well, not your memory: Memory of the reflection of you." +
                        "Also, how they put you here. The reasons for different climates and powerful opponents. Just to test if you are the best version of yourself. And if it turns out that you are not, how you will be replaced by a better version of you. And why you should wait at the end of the line fot the better version of yourself.\n" +
                        "Once, the people who have the power decide that this is the best version of you, they will make an army out of you. It might be you, or it might be the one who kills you. The only think that makes sense is to stay and hope.\n" +
                        "The End.");
                //After the boss is defeated, the game is over so system exits.
                System.exit(0);
            }
        }


    }
    //Game story
    private static void displayIntroStory() {
        System.out.println("------------------");
        System.out.println("This game includes a dice system. Which means that even if you have higher stats from your opponent, there is still a chance for you to fail if your roll is less than your opponents. Have fun!");
        System.out.println("------------------");
        System.out.println("You open your eyes inside inside a room which has metal tiles and white lighting.\n" +
                "you see some weapons right in front of you. On your left there are some liquids that you have never seen before.\n" +
                "You are thinking to yourself \"Where am I, what am I doing here?\" Then you see the big screen and it suddenly displays a video.\n" +
                "In the video there is a man in wearing a hood, his face is almost unrecognizable. He starts speaking:\n" +
                "\"Congratulations!, you are the one and only, lucky contestant here. Welcome to Chivalry Challenge! The challenge is simple: choose yor weapon, go into the arena and defeat your opponents.\n Unfortunately there is no other way around. Good luck!\"" +
                "Then the screen turns off. You are in a state of confusion, you don't remember how you got there. But the task is clear.");
    }

    //Method for the Swords
    public static void selectWeapon() {
        //Scanner for taking input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println(" So Choose your weapon:\n1. Single handed sword\n2. Long sword");

        while (true) {
            System.out.println("Enter 1 or 2 depending on your choice (You can only select the shield if you have a single-handed sword):");
            String userChoiceWeapon = scanner.nextLine();
            //Convert the input to lower case

            switch (userChoiceWeapon.toLowerCase(Locale.ROOT)) {
                case "1":
                    hero.getItem(singleHandedSword);
                    System.out.println("You added single handed sword to your inventory");

                    return;
                case "2":
                    hero.getItem(doubleHandedSword);
                    System.out.println("You added long sword to your inventory");

                    return;

                default:
                    System.out.println("Please select a valid weapon (1 or 2).");
            }
        }
    }
    //Method for the Shield with single and double handed swords
    public static void wantShield() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to grab a shield?");
        while (true) {
            System.out.println("Enter yes or no");
            String userChoiceShield = scanner.nextLine();
            userChoiceShield = userChoiceShield.toLowerCase(Locale.ROOT);  // Assign the result back to the variable

            switch (userChoiceShield) {
                case "yes":
                    //if hero has a single-handed sword, he can get the shield then.
                    if (hero.getInventory().contains(singleHandedSword)) {
                        hero.getItem(shield);
                        System.out.println("You added a shield to your inventory");

                    } else {
                        //Give option to user to go back after notifying them about shield situation.
                        System.out.println("You cannot grab a shield without a single-handed sword. Would you like to go back and change?");
                        while (true) {
                            System.out.println("Enter yes or no");
                            String userGoBack = scanner.nextLine();
                            userGoBack = userGoBack.toLowerCase(Locale.ROOT);  // Assign the result back to the variable. We used chatGPT for this line.
                            switch (userGoBack) {
                                case "yes":
                                    hero.removeItems();
                                    selectWeapon();
                                    wantShield();
                                    return;
                                case "no":
                                    return;
                                default:
                                    System.out.println("Please select a valid option (yes or no).");
                            }
                        }
                    }
                    return;
                case "no":
                    return;
                default:
                    System.out.println("Please select a valid option (yes or no).");
            }
        }
    }
    //Method for potion described in three cases for health stamina and potion
    public static void wantPotion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You may choose from three different types of potions.\n" +
                "1. Health Potion (Restore health)\n" +
                "2. Stamina Potion (Restore stamina )\n" +
                "3. Compound Potion (Restore both stamina and health, there is only one compound potion available to you.)\n");
        while (true) {
            System.out.println("Please select 1, 2 or 3 (Remember your inventory can only have 6 items!)");
            String userChoicePotion = scanner.nextLine();

            switch (userChoicePotion.toLowerCase(Locale.ROOT)) {
                case "1":
                    //Hero inventory can not be bigger than 6 items.
                    if (hero.getInventory().size() < 6) {
                        System.out.println("How many?");
                        int userPotionAmount = scanner.nextInt();
                        if (userPotionAmount + hero.getItemsCount() > 6) {
                            //if player has no space in inventory them him to the beginning of the potion selection with recursive call.
                            System.out.println("You do not have that much space in your inventory, please select a valid amount.");
                            wantPotion();
                        } else {
                            //Counter
                            int addCount = 0;
                            //Continue to add potions till the counter reaches requested amount -1.
                            while (addCount < userPotionAmount) {
                                hero.getItem(healthPotion);
                                //increment counter
                                addCount++;
                            }
                            System.out.println(userPotionAmount + " health potion was added to your inventory.");
                            System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                            System.out.println("Would you like to add other potions? Enter yes or no?");
                            while (true) {

                                String userAddMore = scanner.nextLine();
                                userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                switch (userAddMore) {
                                    case "yes":
                                        //Goes back to the potion selection with recursive call.
                                        wantPotion();
                                        return;
                                    case "no":
                                        return;
                                }
                            }

                        }

                    } else {
                        System.out.print("Number of items in the inventory:");
                        System.out.println(hero.getItemsCount());
                        System.out.println("You do not have enough space in your inventory");
                    }
                        return;
                        case "2":
                            if (hero.getInventory().size() < 6) {
                                System.out.println("How many?");
                                int userPotionAmount = scanner.nextInt();
                                if (userPotionAmount + hero.getItemsCount() > 6) {
                                    System.out.println("You do not have that much space in your inventory");
                                } else {
                                    int addCount = 0;
                                    while (addCount < userPotionAmount) {
                                        hero.getItem(staminaPotion);
                                        addCount++;
                                    }
                                    System.out.println(userPotionAmount + " stamina potion was added to your inventory.");
                                    System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                                    System.out.println("Would you like to add other potions? Enter yes or no?");
                                    while (true) {

                                        String userAddMore = scanner.nextLine();
                                        userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                        switch (userAddMore) {
                                            case "yes":
                                                wantPotion();
                                                return;
                                            case "no":
                                                return;
                                        }
                                    }
                                }

                            } else {
                                System.out.print("Number of items in the inventory:");
                                System.out.println(hero.getInventory().size());
                                System.out.println("You do not have enough space in your inventory");
                            }
                            return;
                        case "3":
                            if (hero.getInventory().size() < 6) {
                                if (!hero.getInventory().contains(compoundPotion)){
                                    hero.getItem(compoundPotion);
                                    System.out.println("The compound potion was added to your inventory.");
                                    System.out.println("Number of items in your inventory:" + hero.getInventory().size());
                                    System.out.println("Would you like to add other potions? Enter yes or no?");
                                    while (true) {

                                        String userAddMore = scanner.nextLine();
                                        userAddMore = userAddMore.toLowerCase(Locale.ROOT);
                                        switch (userAddMore) {
                                            case "yes":
                                                wantPotion();
                                                return;
                                            case "no":
                                                return;
                                        }
                                    }
                                }else {
                                    System.out.println("Only one compound potion is available to you.");
                                    wantPotion();
                                }



                            } else {
                                System.out.print("Number of items in the inventory:");
                                System.out.println(hero.getInventory().size());
                                System.out.println("You do not have enough space in your inventory");
                            }
                            return;

                        default:
                            System.out.println("Please type a valid number (1,2 or 3");


                    }

            }

        }
    	
    	////Method to change inventory after adding to it
        public static void wantToChangeInventory () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you satisfied with your inventory? If not, you can drop every item " +
                    "in your possession and generate a new build. Do you want this?");

            while (true) {
                System.out.println("Enter yes or no");
                String userChoiceDropEverything = scanner.nextLine();
                userChoiceDropEverything = userChoiceDropEverything.toLowerCase(Locale.ROOT);

                switch (userChoiceDropEverything) {
                    case "yes":
                        //If hero wants to change the inventory fully, remove all the items and call the same functions as before, one by one.
                        hero.removeItems();
                        selectWeapon();
                        wantShield();
                        wantPotion();
                        return;
                    case "no":
                        return;
                }
            }
        }
        //Method to exitArena
        public static void exitToArena () {
            System.out.println("Now that you are ready you can step out to the arena. An automatic door opens behind you, seems like an elevator. It will lead you to the arena. You hear the voice of the mysterious man: \"As always, good hunting!\". You step in the elevator. The doors close immediately and it starts ascending.");
            hero.setCurrentArea(arena);
            System.out.println("You step out of the elevator and it goes down, leaving you to your faith. You can not just stand there, your enemies await you.");
        }
        
        //Method to display help commands
        public static void displayHelp(){
        System.out.println("Available commands:\n 1. Go North\n 2. Go South\n 3. Go East\n 4. Go West\n 5. Inventory\n 6. Attack\n 7. Health\n 8. Stamina \n 9. Look\n 10. Drink health potion\n 11. drink stamina potion\n 12. Drink compound potion");
        }








}