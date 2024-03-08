import java.util.*;

public class Hero {
	//Initialize
    private static final int heroMaxHealth = 20;
    private static final int heroMaxStamina = 20;
    private Random heroDice;
    private int xCoordinate = 2;
    private int yCoordinate = 2;
    private Vector<Items> inventory;
    private Area currentArea;
    private int itemsCount;
    private int healthPoints;
    private int staminaPoints;
    private Villain currentVillain;

    //const
    public Hero(int itemsCount, int healthPoints, int staminaPoints, Area currentArea) {

        this.inventory = new Vector<Items>();
        this.currentArea = currentArea;
        this.itemsCount = itemsCount;
        this.healthPoints = healthPoints;
        this.staminaPoints = staminaPoints;
        this.heroDice = new Random();
        this.currentVillain = new Villain("*","*",0,0,0,0,0,0);
    }
    
    //get and set methods for CurrentVillain
    public Villain getCurrentVillain() {
        return currentVillain;
    }
    
    public void setCurrentVillain(Villain villain) {
        this.currentVillain = villain;
    }

    //Method to roll dice
    public int heroRollDice() {
        //bound is 6 because it is a 6 sided dice.
        int roll = heroDice.nextInt(6) + 1;
        System.out.println("You rolled:" + roll);
        return roll;
    }
    
    //Method to get items count
    public int getItemsCount() {
        return itemsCount;
    }

    //Method to show items
    public void showItemsInArea() {
        System.out.println(currentArea.getItemsInArea());
    }
    
    //Method to get an item
    public void getItem(Items item) {
        //Add items to inventory
        inventory.add(item);
        itemsCount++;
    }
    
    //Method to use Item
    public void useItem(Items item) {

    }
    
    //Method to InitiateCombat
    public void initiateCombat(Villain villain, Sword sword, Shield shield, Hero hero, Area area) {
        //Set hero's current villain.
        setCurrentVillain(villain);

        //Flags
        //To check if the combat can still continue
        boolean combatInProgress = true;
        //To check if the attempted parry was successful.
        boolean successfulParry = false;
        //To indicate the phase inside the combat
        boolean defendInProgress = false;
        //While both villains and heroes healths are above 0 and the flag is true, the combat continues.
        while (combatInProgress && currentVillain.getHealthPoints() > 0 && healthPoints > 0) {




            System.out.println("Choose your attack type: Enter \"slice\" or \"stab\" ");
            Scanner scanner = new Scanner(System.in);
            String userAttack = scanner.nextLine();




            switch (userAttack.toLowerCase(Locale.ROOT)) {
                case "slice":

                    if (staminaPoints > 0 && hero.currentVillain.getHealthPoints() > 0){
                        sword.slice(villain, hero);
                        //Check whether villain still has health after the strike.
                        if (currentVillain.getHealthPoints() <= 0) {
                            System.out.println("You defeated " + villain.getVillainName());
                            //Decrement villain count.
                            area.heroKillEnemy();
                        }else {

                            villain.villainAttack();
                            villain.displayVillainStats();
                            System.out.println("You are under attack! You must respond. Enter \"block\" or \"parry\"");
                            //After the attack, defense process starts.
                            defendInProgress = true;
                        }










                        //If the opponent attempted to parry and succeeded, turn the stats of the weapon back to normal after a strike.
                        if (successfulParry == true) {
                            sword.damageTurnBackToNormal();
                            System.out.println("Slice damage: " + sword.getSliceDamage());
                            System.out.println("Stab damage: " + sword.getStabDamage());
                            successfulParry = false;  // Reset the flag

                        }

                    //Prevent stamina points going below zero.
                    } else if (staminaPoints < 0) {
                        staminaPoints = 0;
                    //If the villain dies, combat stops.
                    } else if (currentVillain.getHealthPoints() <= 0){
                        combatInProgress = false;
                    } else {
                        //ıf the stamina is 0, the game grants 1 SP to the player.
                        System.out.println("You are too tired to attack. You back away from your opponent a bit and catch your breath (SP +1)");
                        staminaPoints++;
                    }


                    while (defendInProgress) {
                        String userDefend = scanner.nextLine();

                        switch (userDefend.toLowerCase(Locale.ROOT)) {
                            case "block":
                                if (staminaPoints > 0){
                                    block(sword, shield, villain);
                                    displayStats();
                                } else if (staminaPoints < 0) {
                                    staminaPoints = 0;
                                //Check if hero is still alive after an attack.
                                } else if (hero.currentVillain.getHealthPoints() <= 0) {
                                    combatInProgress = false;
                                //Hero gets damage automatically if he can not defend because of lack of stamina.
                                } else{
                                    System.out.println("Because of your lack of stamina, the opponent breaches your defenses and lands a perfect blow!");
                                    healthPoints -= villain.getDamagecapacity();
                                }

                                defendInProgress = false;  // Exit defend loop
                                break;
                            case "parry":
                                successfulParry = parry(shield, villain, sword);
                                displayStats();
                                defendInProgress = false;  // Exit defend loop
                                break;
                        }
                    }

                    // Check if successful parry flag is set and reset sword stats

                    break;
                //Same principles for stab attack.
                case "stab":
                    if (staminaPoints > 0 && hero.currentVillain.getHealthPoints() > 0){
                        sword.stab(villain, hero);

                        if (currentVillain.getHealthPoints() <= 0) {
                            System.out.println("You defeated " + villain.getVillainName());
                            area.heroKillEnemy();
                        }else {

                            villain.villainAttack();
                            villain.displayVillainStats();
                            System.out.println("You are under attack! You must respond. Enter \"block\" or \"parry\"");
                            defendInProgress = true;
                        }
                        if (successfulParry == true) {
                            sword.damageTurnBackToNormal();
                            System.out.println("Slice damage: " + sword.getSliceDamage());
                            System.out.println("Stab damage: " + sword.getStabDamage());
                            successfulParry = false;  // Reset the flag

                        }

                    } else if (staminaPoints < 0) {
                        staminaPoints = 0;

                    } else if (hero.currentVillain.getHealthPoints() <= 0) {
                        combatInProgress = false;

                    } else {
                        System.out.println("You are too tired to attack. You back away from your opponent a bit and catch your breath (SP +1)");
                        staminaPoints++;
                    }



                    while (defendInProgress) {
                        String userDefend = scanner.nextLine();

                        switch (userDefend.toLowerCase(Locale.ROOT)) {
                            case "block":
                                if (staminaPoints > 0){
                                    block(sword, shield, villain);
                                    displayStats();

                                }else if (staminaPoints < 0){
                                    staminaPoints = 0;
                                } else {
                                    System.out.println("Because of your lack of stamina, the opponent breaches your defenses and lands a perfect blow!");
                                    healthPoints -= villain.getDamagecapacity();
                                }

                                defendInProgress = false;  // Exit defend loop
                                break;
                            case "parry":
                                successfulParry = parry(shield, villain, sword);
                                displayStats();
                                defendInProgress = false;  // Exit defend loop
                                break;
                        }
                    }

                //Player is able to quit the combat whenever they want.
                    break;
                case "quit":
                    System.out.println("Do you want to quit? All progress for this particular fight will be lost. Enter yes or no");
                    while (true){
                        String quitDecision = scanner.nextLine();
                        switch (quitDecision.toLowerCase(Locale.ROOT)){
                            case "yes":
                                //If player wants to quit, stats of the villain are restored.
                                currentVillain.restoreHealth();
                                //Combat stops
                                combatInProgress = false;
                                break;
                            case "no":

                                break;
                            default:
                                System.out.println("Please enter a valid command (yes or no)");

                        }
                        if (quitDecision.equalsIgnoreCase("yes") || quitDecision.equalsIgnoreCase("no")) {//For this line we had help from chatGPT. We were unable to find the reason for unreachable statement.
                            break;
                        }
                    }


                    break;




                default:
                    System.out.println("Other commands are not available during combat");
            }


            //If hero's health hits 0, exit the program.
            if (healthPoints <= 0) {
                System.out.println("Game over");
                System.exit(0);

            }


        }

    }









    //Method to move the hero to the desired direction inside the 3x3 matrix.
    public Vector<Integer> move(Directions direction) {
        switch (direction) {
            case NORTH:
                //Increment the y coordinate
                yCoordinate++;
                //Don't let y coordinate go above 3.
                if (yCoordinate > 3) {
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case SOUTH:
                //Decrement the y coordinate
                yCoordinate--;
                //Don't let y coordinate go below 1.
                if (yCoordinate < 1) {
                    yCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case EAST:
                //Increment the x coordinate
                xCoordinate++;
                //Don't let x coordinate go above 3.
                if (xCoordinate > 3) {
                    xCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;

            case WEST:
                //Decrement the x coordinate
                xCoordinate--;
                //Don't let x coordinate go below 1.
                if (xCoordinate < 1) {
                    xCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case UP:
                yCoordinate++;
                if (yCoordinate > 3) {
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case DOWN:
                yCoordinate--;
                if (yCoordinate < 1) {
                    yCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            default:
                System.out.println("You can only go north, south, east or west.");
                break;
        }

        return getCurrentCoordinate();

    }
    
    //get and set method for current coordinates
    public Vector<Integer> getCurrentCoordinate(){
        //2x1 vector for storing each coordinate
        Vector<Integer> currentCoordinate = new Vector<>(2);
        int x = xCoordinate;
        int y = yCoordinate;

        currentCoordinate.add(x);
        currentCoordinate.add(y);
        return currentCoordinate;

    }

    ////get and set method for current area
    public void setCurrentArea(Area area) {
        this.currentArea = area;
    }

    //Method to get current area coordinates
    public Area getCurrentArea() {
        return currentArea;
    }

    ////Method to get inventory
    public Vector<Items> getInventory() {
        return inventory;
    }

    ////Method to display inventory
    public void displayInventory(){
        //String builder to generate a string of the inventory.
        StringBuilder inventoryString = new StringBuilder("Inventory: [");
        //Traverse through all items.
        for (int i = 0; i < getItemsCount(); i++) {
            //Unless i is the last element, add a coma in the end
            if (i < getItemsCount() - 1) {
                inventoryString.append(inventory.get(i).toString()).append(", ");
            }else{
                inventoryString.append(inventory.get(i).toString());

            }


        }
        inventoryString.append("]");
        //Type cast to string
        System.out.println(inventoryString.toString());
    }

    //Method to remove items
    public void removeItems() {
        //While inventory has items in it, traverse the inventory and remove each element.
        while (!inventory.isEmpty()) {
            inventory.remove(inventory.size() - 1);
            //Decrement items count.
            itemsCount--;
        }
    }

  //get and set method for health points
    public int getHealthPoints(){
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;

    }

  //Method to display health
    public void displayHealth(){
        System.out.println(healthPoints);
    }

  //get and set method for stamina points
    public int getStaminaPoints(){
        return staminaPoints;
    }
    public void setStaminaPoints(int staminaPoints){
        this.staminaPoints = staminaPoints;
    }

    //Method to display Stamina
    public void displayStamina(){
        System.out.println(staminaPoints);
    }
    
    //Method to display stats
    public void displayStats(){
        System.out.println("-----------------------------");
        System.out.println("Your HP: " + healthPoints + "\n" + "Your SP: " + staminaPoints);
        System.out.println("-----------------------------");
    }
    
    //Method to normal look round
    public void normalLook(){
        Vector currentCoordiante = getCurrentCoordinate();
        //Assign different cases fpr each coordinates and type cast to int all of the elements of the coordinates.

        if((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 1) {
            System.out.println("When you look around, towards north you see an open field and it seems very windy. When you look at east you see sunny and bright place all covered in sand, almost like a desert.");


        } else if ((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 3) {
            System.out.println("When you look around, towards south you see an open field and it seems very windy. When you look at east you see snowy trees all around, seems chilling.");
        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 3) {
            System.out.println("When you look around, towards west you see snowy trees all around, seems chilling. When you look at south you see large trees all around, it seems like there is a heavy rain over there.");
        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 1) {
            System.out.println("When you look around, towards north you see large trees all around, it seems like there is a heavy rain over there. When you look at west you see sunny and bright place all covered in sand, almost like a desert.");
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 2) {
            System.out.println("When you look around, towards north you see snowy trees all around, seems chilling.\n When you look at south you see sunny and bright place all covered in sand, almost like a desert.\n When you turn towards east, you see large trees all around, it seems like there is a heavy rain over there.\n And on your west you see an open field and it seems very windy.");

        }
    }
    //Additional method for look. Works if the coordinates pf the hero and villains are equal.
    public void villainLook(Villain villain){
        Vector currentCoordiante = getCurrentCoordinate();
        if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 3) {
            if (villain.getHealthPoints() > 0){
                System.out.println("While you are looking around, inside this snowy biome, you see a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the snow, the lifeless form of your enemy lay defeated.");

            }


        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 2){
            if (villain.getHealthPoints() > 0){
                System.out.println("Inside this humid and damp rainforest, while you are looking around you encounter a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the muddy soil, the lifeless form of your enemy lay defeated.");
            }
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 1){
            if (villain.getHealthPoints() > 0){
                System.out.println("The sand gets into your eye. It is hard to see in this excruciatingly hot desert like environment. However, all of a sudden you encounter a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the sand, the lifeless form of your enemy lay defeated.");
            }

        } else if ((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 2) {
            if (villain.getHealthPoints() > 0){
                System.out.println("It is almost impossible to open your eyes. The winds are so strong let alone seeing, standing is a hard task. Over there in the distance you see a " + villain.getDescription());//+ getVillainDescription()
            }else{
                System.out.println("On the plain field, the lifeless form of your enemy lay defeated.");
            }

        }
    }


    //Method to block the attacks
    public void block(Sword sword, Shield shield, Villain villain){
        //If hero has a shield and its block power is less than villains attack power
        if (inventory.contains(shield) && shield.getBlockPower() < villain.getDamagecapacity()){
            //If hero rolls less than villain
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                //Villain inflicts full damage
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack partially using your shield");
                //If the roll is equal to villains or higher, only a portion pf the full damage is inflicted.
                healthPoints -= (villain.getDamagecapacity() - shield.getBlockPower());


            }
        }else if (inventory.contains(shield) && shield.getBlockPower() >= villain.getDamagecapacity()){
            //Hero can fail even if he has higher stats by being unlucky with the dice.
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unlucky! Your defense was sloppy.");
                healthPoints--;



                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack completely using your shield!");

            }

        } else if ((!inventory.contains(shield)) && sword.getBlockPower() < villain.getDamagecapacity()) {
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack partially using your sword");
                healthPoints -= (villain.getDamagecapacity() - sword.getBlockPower());

            }

        } else if ((!inventory.contains(shield)) && sword.getBlockPower() >= villain.getDamagecapacity()){
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack completely using your sword!");
            }
        }
    }

    //Method to parry, returns boolean for the flag.
    public boolean parry(Shield shield, Villain villain, Sword sword){
        if (inventory.contains(shield) && shield.getParryPower() < villain.getParryDenyCapacity()){
            //If villains parry deny capacity is higher than  hero's parry power, the only way to parr the opponent is to roll a 6 while the villain does not.
            if(heroRollDice() == 6 && villain.villainRollDice() != 6){
                System.out.println("You got lucky! You parried your opponents attack successfully. Now your opponent is vulnerable, time to strike!");
                //Temporary stat increase for the sword
                sword.tempDamageIncreaseWithParry();
                System.out.println("Slice damage: " + sword.getSliceDamage());
                System.out.println("Stab damage: " + sword.getStabDamage());
                return true;
            }else{
                System.out.println("You were unable to parry your opponents attack");
                healthPoints -= villain.getDamagecapacity();

            }
        } else if (inventory.contains(shield) && shield.getParryPower() >= villain.getParryDenyCapacity()) {
            if(heroRollDice() < villain.villainRollDice()){
                System.out.println("You were not able to parry your opponent");
                healthPoints -= villain.getDamagecapacity();

            }else{
                System.out.println("You successfully parried your opponents attack! Now your opponent is vulnerable, time to strike!");
                sword.tempDamageIncreaseWithParry();
                System.out.println("Slice damage: " + sword.getSliceDamage());
                System.out.println("Stab damage: " + sword.getStabDamage());
                return true;
            }
        //If the player does not remember to get a shield for parrying, inflict damage as penalty.
        }else {
            System.out.println("You need a shield in order to parry your opponents attack. You will learn the hard way. Opponent was successful with their attack.");
            healthPoints -= villain.getDamagecapacity();
        }
        return false;
    }
    //Method to use stamina
    public void staminaUseUp(int usedStamina){
        staminaPoints -= usedStamina;

    }

    //Method to consume potion
    public void consumePotion(Potion potion, Hero hero){
        //Consume the potion only if the hero has it.
        if(inventory.contains(potion)){
            potion.consume(hero);

        }else{
            System.out.println("You do not posses " + potion.getName());
        }
    }
    //Method to remove a single item
    public void remove(Items item){
        if (inventory.contains(item)){
            inventory.remove(item);
        }

    }

    public int getHeroMaxHealth(){
        return heroMaxHealth;
    }

    public int getHeroMaxStamina() {
        return heroMaxStamina;
    }
}
