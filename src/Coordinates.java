import java.util.ArrayList;
import java.util.HashMap;

public class Coordinates {
    private HashMap<Integer, Integer> coordinates;

    public Coordinates(){
        this.coordinates = new HashMap<>();
    }
    public void addCoordinate(int x, int y){
        coordinates.put(x, y);

    }
}
