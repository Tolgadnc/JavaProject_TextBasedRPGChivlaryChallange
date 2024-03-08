package game;
import java.util.List;


public class Exits {   		
	private String direction;
	private Area goesTo;  
	// Create a new class Area:  this represents the area destination...
	private List <Direction> allowedDirections;
	//Create a new class Direction: this represents the directions allowed for the exits...                                               */

	//Creating a Constructor and initializing 
	public Exits (String direction, Area goesTo, List<Direction> allowedDirections) {
		this.direction = direction;
		this.goesTo = goesTo;
		this.allowedDirections = allowedDirections;
}
	
	// getter and setter methods for 1) direction
	
	public String getDirection() {
		return direction;		
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	// getter and setter methods for 2) goesTo
	
	public Area getGoesTo() {
		return goesTo;
	}
	
	public void setGoesTo(Area goesTo) {
		this.goesTo = goesTo;
	}
	
	// getter and setter methods for 3) allowedDirections
	
	public List <Direction> getAllowedDirections() {
		return allowedDirections;
	}
	
	public void setAllowedDirections ( List<Direction> allowedDirections) {
		this.allowedDirections = allowedDirections;
	}
	
}
