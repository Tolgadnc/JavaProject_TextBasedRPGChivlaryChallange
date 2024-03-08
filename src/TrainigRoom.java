import java.util.ArrayList;

public class TrainigRoom extends Area {
    public TrainigRoom(String title, String description, int villainCount, ArrayList<Item> itemsInArea, ArrayList<Exits> exits, ArrayList<Coordinates> coordinates, ArrayList<Villains> villains){
        super(villainCount, coordinates, itemsInArea, title, description, exits, villains);
    }

}
