import java.util.ArrayList;

public class Area {
    private int villainCount;
    private ArrayList<Coordianates> coordinates;
    private ArrayList<Item> itemsInArea;
    private ArrayList<Villain> villains;
    private String title;
    private String description;
    private ArrayList<Exit> exits;

    public Area(String title, String description, int villainCount, ArrayList<Item> itemsInArea, ArrayList<Exits> exits, ArrayList<Coordinates> coordinates, ArrayList<Villains> villains){
        this.title = title;
        this.description = description;
        this.villainCount = villainCount;
        this.itemsInArea = itemsInArea;
        this.exits = exits;
        this.coordinates = coordinates;
        this.villains = villains;

    }
    public void addItems(Item item){
        itemsInArea.add(item);
    }
    public void removeItems(Item item){
        itemsInArea.remove(item);
    }
    public void addVillain(Villain villain){
        villains.add(villain);
        villainCount++;
    }
    public void removeVillain(Villain villain){
        villains.remove(villain);
        villainCount--;
    }
    public void addExits(Exits exit){
        exits.add(exit);

    }
    public void useExit(Exits exit){
        //will be implemented when exit class is available.
        }
    }
    public int getVillainCount(){
        return villainCount;
    }
    public String promptDescription(){
        String titleOfArea = "You are in " + title + "\n";
        String descOfArea = description;
        String wholePrompt = titleOfArea + descOfArea;
        return wholePrompt;

    }
    public ArrayList<Item> getItemsInArea(){
        return itemsInArea;
    }
}
