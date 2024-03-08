import java.util.ArrayList;

public class Arena extends Area{
    public Area(String title, String description, int villainCount, ArrayList<Item> itemsInArea, ArrayList<Exits> exits, ArrayList<Coordinates> coordinates, ArrayList<Villains> villains){
        super(villainCount, coordinates, itemsInArea, title, description, exits, villains);
    }
    public void initiateBossFight(){
        if (getVillainCount() == 0){
            //coordiantes of the BossVillain will be equal to the Heros coordiantes
            String bossFightPrompt = "Just when the hero thinks that the " +
                    "challange is over, the final challange was yet to begin. A heavy armored mysterios man was " +
                    "standing right before him. He had a grin on his face. He look at him and said \"There is no escape!\""+
                    "Our hero knew that the statement was true. The only way trough was defeating him!";

            System.out.println(bossFightPrompt);

        }
        //Here there should be a code like the following:
        //if the user input includes "attack" he attacks else, print("there is no escape!")
    }
}
