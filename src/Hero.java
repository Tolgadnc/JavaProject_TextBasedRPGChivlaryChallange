import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Hero {
    private int xCoordinate;
    private int yCoordinate;
    private ArrayList<Item> inventory;
    private Area currentArea;
    private int itemsCount;


    public Hero(ArrayList<Item> inventory, Area currentArea, int itemsCount){

        this.inventory = inventory;
        this.currentArea = currentArea;
        this.itemsCount = itemsCount;
    }
    public int getItemsCount(){
        return itemsCount;
    }

    public void showItemsInArea(){
        System.out.println(currentArea.getItemsInArea());
    }
    public void getItem(Item item){
        inventory.add(item);
        itemsCount++;
        if (itemsCount > 5){
            System.out.println("You can't carry anymore items.");
        }
    }
    public abstract void useItem();
    //will be implemented once the item class is available.
    public void exitArea(Exit exit){
        if (currentArea == PreparingArea){
            //use the exit.
        }
        if(currentArea == TrainigRoom){
            //use the exit.
        }
        if(currentArea == Arena){
            System.out.println("There is no turning back from the arena.");
        }

    }
    public void attack(Sword sword){
        //will be implemented when sword class is available.
    }
    public Vector<Integer> move(Directions direction){
        switch (direction){
            case NORTH:
                yCoordinate++;
                break;
            case SOUTH:
                yCoordinate--;
                break;
            case EAST:
                xCoordinate++;
            case WEST:
                xCoordinate--;
                break;
            case UP:
                yCoordinate++;
                break;
            case DOWN:
                yCoordinate--;
                break;
            default:
                System.out.println("You can only go north, south, east or west.");
                break;
        }
        Vector<Integer> currentCoordinate = new Vector<>(2);
        int x = xCoordinate;
        int y = yCoordinate;
        currentCoordinate.add(x);
        currentCoordinate.add(y);
        return currentCoordinate;

    }

}
