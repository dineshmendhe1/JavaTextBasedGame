import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*class room definition.*/
public class Room {

	/*class variable for description of room.*/
	private String description;
	
	private ItemContainer itemContainer;
	
	/*Map to store room map for game.*/
	private Map<String, Room> mapDirections = new HashMap<String, Room>();
	
	/*initializing inventory for perticular room.*/
	private Inventory room = new Inventory();

	/*constructor for class.*/
	public Room(String description) {
		this.description = description;
	}
	

	/*Getters and setters for member varible.*/
	
	public String getDescription() {
		return description;
	}

	// method to check items present in the room.
	public Room containsItem(Item... items) {
		for (Item item : items) {
			room.putItem(item);
		}
		return this;
	}

	
	// Collection of item present in room. 
	public Collection<String> ItemsInRoom() {
		return room.namesOfItems();
	}
	

	//method to get item present in the room. 
	public Item getItem(String name) {
		return room.getItem(name);
	}

	// method to take item in the room. 
	public Item takeItem(String name) {
		return room.takeItem(name);
	}

	// methods to put rooms in specified direction. 
	
	public Room eastTo(Room rm) {
		rm.mapDirections.put("east", this);
		this.mapDirections.put("west", rm);
		return this;
	}

	public Room southTo(Room rm) {
		rm.mapDirections.put("south", this);
		this.mapDirections.put("north", rm);
		return this;
	}
	public Room northTo(Room rm) {
		rm.mapDirections.put("north", this);
		this.mapDirections.put("south", rm);
		return this;
	}

	public Room westTo(Room rm) {
		rm.mapDirections.put("west", this);
		this.mapDirections.put("east", rm);
		return this;
	}
	public Collection<String> possibleDirections() {
		return mapDirections.keySet();
	}

	public Room roomTo(String direction) {
		Room rm1 = mapDirections.get(direction);
		return rm1;
	}
}
