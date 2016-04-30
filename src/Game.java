import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

/*Game class with implementation of all commands available in command interface.*/
public class Game implements Commands {

	/* incrementing score of player */
	private int score;

	/* creating room object */
	private Room currentRoom;

	/* creating game end condition */
	private GameEnd endCondition;

	// Getters and setters for the variables.

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public GameEnd getEndCondition() {
		return endCondition;
	}

	public void setEndCondition(GameEnd endCondition) {
		this.endCondition = endCondition;
	}

	public Inventory getPlayer() {
		return player;
	}

	public void setPlayer(Inventory player) {
		this.player = player;
	}

	/* initializing inventory for current player. */
	private Inventory player = new Inventory();

	/* Game class constructor */
	public Game(Room startingRoom, GameEnd endCondition, int score) {
		this.currentRoom = startingRoom;
		this.endCondition = endCondition;
		this.score = score;
	}

	/* get current room description */
	public String descriptionOfCurrentRoom() {
		return currentRoom.getDescription();
	}

	/* direction available from current room */
	public Collection<String> possibleDirections() {
		return currentRoom.possibleDirections();
	}

	@Override
	public String move(String direction) {
		int score1 = this.getScore();
		// System.out.println("I'm in move condi "+direction);
		Room next = currentRoom.roomTo(direction);
		if (next != null) {
			currentRoom = next;
			return "You moved in  " + currentRoom + ".";

			// System.out.println("Your Current Score is "+i);
		} else {
			return "There is blocker " + direction + " you can't move forward.";
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Collection<String> itemsInRoom() {
		return currentRoom.ItemsInRoom();
	}

	public Collection<String> carryingItems() {
		return player.namesOfItems();
	}

	@Override
	public String takeItem(String itemName) {
		Item pickedUp = currentRoom.takeItem(itemName);
		if (pickedUp != null) {
			this.score++;
			player.putItem(pickedUp);
			return "You picked-up " + itemName + ".";
		} else {
			return "There is no " + itemName + ".";
		}
	}

	public String dropItem(String itemName) {
		System.out.println("You dropped the item.");
		this.score--;
		return null;
	}

	@Override
	public void buy(String item) {
		if (this.score == currentRoom.getItem(item).getPrice()) {
			System.out.println("You can buy this item");
		} else {

			System.out.println("you don't have enough money to buy this item.");
		}

	}

	@Override
	public String use(String itemName) {
		Item item = currentRoom.getItem(itemName);
		if (item == null) {
			return "There is no item  " + itemName + ".";
		}
		return item.tryItem(player);
	}

	public boolean hasEnded() {
		return endCondition.gameEndCheck(player);
	}

	@Override
	public void map() {
		System.out.println("\t              North " + "\t\n|################################################|"
				+ "\t\n|###################### Lab    ##################|"
				+ "\t\n|######################        ##################|"
				+ "\t\n|######################        ##################|"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|Ice-Cream Shop #####   Armory    ####Watch-Tower|"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|#######    #############     ##########       ##|"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|Great Hall           Barracks         Magic Shop|"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|               #####             ####           |"
				+ "\t\n|#######    #####################################|"
				+ "\t\n|               #####             ###############|"
				+ "\t\n|               #####             ###############|"
				+ "\t\n|Graveyard            Gas Station ###############|"
				+ "\t\n|               #####             ###############|"
				+ "\t\n|               #####             ###############|"
				+ "\t\n|################################################|" + "\t\n                     South");
	}

	@Override
	public void help() {
		System.out.println(" To see map- Enter map" + "\n To move north direction - Enter 'n'"
				+ "\n To move south direction - Enter 's'" + "\n To move east direction - Enter 'e"
				+ "\n To move west direction - Enter 'w'" + "\n To pickup item - Enter take"
				+ "\n To See the items you're carrying - Enter show"
				+ "\n To See the all items in sorted order present in magic shop - Enter sortedArray"
				+ "\n To see what direction you moved in forward direction - forward"
				+ "\n To see what direction he moved in backward direction - backward"
				+ "\n To see the description of item you're in - Enter des" + "\n To use item - Enter use");
	}

	// this code is for extra credit
	@Override
	public void skip() {
		System.out.println(" To see map- Enter map" + "\n To move north direction - Enter 'n'"
				+ "\n To move south direction - Enter 's'" + "\n To move east direction - Enter 'e"
				+ "\n To move west direction - Enter 'w'" + "\n To pickup item - Enter take"
				+ "\n To See the items you're carrying - Enter show"
				+ "\n To see the description of item you're in - Enter des" + "\n To use item - Enter use");
	}

	// this code is for extra credit
	@Override
	public void dance() {
		System.out.println("                           					        "
				+ "\t\n                ^^^^^^      					    "
				+ "\t\n	              ########                          "
				+ "\t\n             ## @ ### @ ##       				"
				+ "\t\n  	      #############       					"
				+ "\t\n 		    #########       					"
				+ "\t\n                #####                            "
				+ "\t\n                #####              	            "
				+ "\t\n                #####                            "
				+ "\t\n                #####                            "
				+ "\t\n ############  #######  ###############          "
				+ "\t\n ###########   #######  ##############           "
				+ "\t\n               #######                           "
				+ "\t\n         #####       #####                       "
				+ "\t\n       #####         #####                      "
				+ "\t\n		  #####           #####                     "
				+ "\t\n      #####            ######                    "
				+ "\t\n     #####             #####                     "
				+ "\t\n    #####              #####                     "
				+ "\t\n   #####              #####                      "
				+ "\t\n################################################");

	}
	
	// to display sorted array:
	
	public static void printSortedArray(String[] ls){
		
		Arrays.sort(ls);
		for(String item: ls){
			System.out.println(item);
		}
		
	}
}
