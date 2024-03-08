import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Area {
    private int villainCount;

    private ArrayList<Items> itemsInArea;
    private ArrayList<Villain> villains;
    private String title;
    private String description;






    public Area(String title, String description, int villainCount){
        this.title = title;
        this.description = description;
        this.villainCount = villainCount;
        this.itemsInArea = new ArrayList<Items>();
        this.villains = new ArrayList<Villain>() ;


    }


    //Add items to the area
    public void addItems(Items item){
        itemsInArea.add(item);
    }
    //Remove items from the area
    public void removeItems(Items item){
        itemsInArea.remove(item);
    }
    //add a villain to the area
    public void addVillain(Villain villain){
        villains.add(villain);
        villainCount++;
    }
    // Remove a villain from the area
    public void removeVillain(Villain villain){
        villains.remove(villain);
        villainCount--;
    }



    public int getVillainCount(){
        return villainCount;
    }

    public ArrayList<Items> getItemsInArea(){
        return itemsInArea;
    }

    public String getTitle(){
        return title;
    }

    public void setVillainCount(int villainCount){
        this.villainCount = villainCount;
    }
    //Decrement the count of the villains when one of them dies.
    public void heroKillEnemy(){
        villainCount--;


    }



}