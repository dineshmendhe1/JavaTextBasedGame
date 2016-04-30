import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	/**
	 * @author Simoni Handoo, Zahid Mudaqiq, Henry Catchpole, Phaelan Koock
	 * @version - Assignment 4
	 * @throws IOException
	 */
	
/*	IMPORTANT: 1. As per new requirement user can track his path in both forward and backword direction, move to any direction and check your path using these commands.
		  2. Enter sortedArray command to check sorted items in magic shop.
		  3. when player pick up the item score increases by 1.
		  4. For this game move south by using 's' command, the player will enter in Magic Shop. To see the description of magic shop enter: 'des' and to see items
		  present in room enter: 'show' */

	

	public static void addItemInList() throws IOException {

	}

	/* main class to run game */
	public static void main(String[] args) throws IOException {

		// reading file and adding item and its price to linkedList;
		int num = 0;
		Item itemsFromFile;
		List<Item> listItems = new LinkedList<Item>();
		try {
			// reading the textfile of items.
			FileInputStream fs = new FileInputStream("magicitems");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			Random rn = new Random();
			String readLine;
			while ((readLine = br.readLine()) != null) {
				num++;
				// putting them in container with price.
				itemsFromFile = new Item(rn.nextInt(20), readLine);
				listItems.add(itemsFromFile);

			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Declaring the fixed length array and sorting the items alphabetically.
		String[] itemList = new String[171];
		for (int i=0; i<itemList.length; i++) {
			itemList[i] = listItems.get(i).getName();
			//System.out.println(itemList[i].toString());
 
		}
	
	//	Game.printSortedArray(itemList);
	
		/* creating new instances for Item class. */
		Item diamond = new Item(5, "diamond");
		Item sword = new Item(6, "sword");
		Item handkerchief = new Item(3, "handkerchief");
		Item fuel = new Item(8, "fuel");
		Item magicStick = new Item(11, "magicStick");
		Item binocular = new Item(12, "binocular");
		Item map = new Item(1,
				"\t              North " + "\t\n|################################################|"
						+ "\t\n|###################### Lab    ##################|"
						+ "\t\n|######################        ##################|"
						+ "\t\n|######################        ##################|"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|Ice-Cream Shop ##### Magic Shop  ####Watch-Tower|"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|#######    #############     ##########       ##|"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|Great Hall           Barracks            Armory |"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|               #####             ####           |"
						+ "\t\n|#######    #####################################|"
						+ "\t\n|               #####             ###############|"
						+ "\t\n|               #####             ###############|"
						+ "\t\n|Graveyard            Gas Station ###############|"
						+ "\t\n|               #####             ###############|"
						+ "\t\n|               #####             ###############|"
						+ "\t\n|################################################|" + "\t\n                     South");
		Item bag = new BagOfItems();

		/* creating new instances for room class. */
		Room lab = new Room(
				"A dimmly lit room with a flickering fluorescent light swinging in the middle. You can see one table under the light with a large"
						+ " with a large chest underneath it. The floor is covered by a light layer of some sort of liquid chemicals and it creeks when it is walked on. "
						+ "An old chemistry set is seen in the Northeast corner that is somehow still bubbling and reacting. You notice a rat scurrying around the room as if "
						+ "something or someone has frightened it. ").containsItem(diamond, map);

		Room magicShop = new Room(
				"Welcome to magic shop, there are 171 item from which you can choose. You need to pay equal amount of money as per mentioned prise")
						.containsItem(sword, map).southTo(lab);

		Room barracks = new Room(
				"A large room that is filled from end to end with Bunk Beds, but no one is inside. There are no windows and the only light is "
						+ "coming from four lights equally spaced apart from every corner. There are four dressers at the West Wall but they are each locked by a key. The room has a "
						+ "faint musk of gasoline in it as if someone wanted to make this place disappear.")
								.containsItem(bag, map).southTo(magicShop);

		Room armory = new Room(
				"Its just for entertainment for player.When you walk in you see nothing. Then the lights flick on revealing the rows of weapons in cages."
						+ " On the right wall are the hand guns, you make out boxes of .22's beneath. On the left you see throwing-stars and long "
						+ "swords, a strange combination. In the center of the room sits an old man the plaque on his desk says /i the Librarian. /i "
						+ "He looks asleep or dead but you do not know. As you chance a glance downward you notice there is no floor, and the man seems "
						+ "to be floating out in the middle of space, with no obvious support. You question whether you should step into such a place. "
						+ "The ceiling is full of ropes, maybe one could swing across. But what would one land on? You hear a deep growl from the relative"
						+ " darkness. The room seems to have an endless depth but is not very big otherwise. Aside from the two main cages you see various "
						+ "other weapons strewn up in the rafters, some entangled on the ropes others just precariously balanced on support beams. You see "
						+ "what could be a switch peeking out from under the Librarian's hand. Just then you hear s noise behind you, You know you cannot "
						+ "go back...").eastTo(barracks);

		// Adding items to magicShop;
		int size = listItems.size();
		System.out.println("TEST: number of items present in magicShop- " + size);
		// magicShop.containsItem(listItems);
		for (int i = 0; i < size; i++) {
			magicShop.containsItem(listItems.get(i));
			// System.out.println(listItems.get(i).getName());
		}
		System.out.println("TEST: to select item- " + magicShop.getItem("Hive Dart").getName());
		// magicShop.containsItem("Long Staff");

		Room watchTower = new Room(
				"Watch tower is 30 fit high. Player can look at all location using watch Tower. Its like BirdEye view for player.")
						.containsItem(binocular).northTo(magicShop);

		Room greatHall = new Room(
				"Great Hall big and scarry. It has some useful items like utensils, Knife, water, food etc. ")
						.westTo(barracks);

		Room iceCreamShop = new Room("Ice cream shop is full of ice creams which player can eat to get energy.")
				.containsItem(handkerchief).northTo(greatHall);

		Room graveYard = new Room("Graveyard is very dark and scary. Zombies are waiting to kill you.")
				.southTo(greatHall);

		Room gasStation = new Room("Gas station is dusty and very old. Here player can put fuel in his vehical.")
				.containsItem(fuel).eastTo(graveYard);

		/* intializing game object. */
		Game game = new Game(lab, new GameEndIfCollectedAllItems(), 10);

		// queue to store the player movement
		Queue playerMovementQueue = new LinkedList<String>();

		// Stack to store the backword movement of player
		Stack<String> playerMovementStack = new Stack<String>();

		String name;
		System.out.println("********************************************************");
		System.out.println("              @ DUNGEON KEEPER V2.0 @.");
		System.out.println("********************************************************");
		System.out.println(" ");
		System.out.println("Current Location:- Lab ");
		System.out.println("Description:- " + game.descriptionOfCurrentRoom());

		showItemList("Room has ", game.itemsInRoom());
		showItemList("Exit is toward", game.possibleDirections());
		showItemList("You have", game.carryingItems());

		System.out.print("Enter player Name:- ");
		Scanner input = new Scanner(System.in);
		name = input.next();
		Player p1 = new Player(name);

		System.out.println(" ");
		System.out.println("*************Welcome To Dungeon Keeper " + p1.getPlayerName() + "****************");
		System.out.println(" ");
		System.out.println("           ***Loading Game.***");

		/* game loading effect. */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}

		System.out.println(" ");
		System.out.println("********************************************************");
		System.out.println("Map of Game:");
		System.out.println(map.getName());
		System.out.println(" ");

		System.out.println("********************************************************");

		/* List of commands. */
		System.out.println("Choose a command: " // Command List
				+ "\t\n  des - description of Current Room" + "\t\n  show - show the items you're carrying."
				+ "\t\n  skip - To skip." + "\t\n  dance - Dance." + "\t\n  n - Move South" + "\t\n  s - Move South"
				+ "\t\n  e - Move East" + "\t\n  w - Move West" + "\t\n  t - Take Item" + "\t\n  d - Drop Item"
				+ "\t\n buy- to buy item"
				+ "\t\n sortedArray- enter to see sorted Array."
				+ "\t\n forward- to see the action forward. " + "\t\n backward- to see the action backwarddin. " + "\t\n  h - Help"
				+ "\t\n  m - Use Map" + "\t\n  Quit - Quit Game"
				+ "\t\n IMPORTANT: 1. As per new requirement user can track his path in both forward and backword direction, move to any direction and check your path using these commands."
				+ "\t\n \t 2. Enter sortedArray command to check sorted items in magic shop."
				+ "\t\n \t 3. when player pick up the item score increases by 1."
				+ "\t \n 4. For this game move south by using 's' command, the player will enter in Magic Shop. To see the description of magic shop enter: 'des' and to see items "
				+ "present in room enter: 'show' ");

		while (!game.hasEnded()) {

			/* Scanner class to take input from user. */
			Scanner in = new Scanner(System.in);
			// playerMovementQueue.add("Begin");

			// System.out.println(game.descriptionOfCurrentRoom());
			System.out.print("Command : ");
			String cmd = in.next().toString();
			// System.out.println(cmd);
			if (cmd.equals("des") || cmd.equals("description") || cmd.equals("DESCRIPTION")) {
				System.out.println(game.descriptionOfCurrentRoom());
				// to see the items present in the class
			} else if (cmd.equals("show") || cmd.equals("SHOW")) {
				Room rm1 = game.getCurrentRoom();
				Collection<String> items = rm1.ItemsInRoom();

				/* Collection<String> items = game.carryingItems(); */

				for (String item : items) {
					System.out.println("Room contains item - " + item + ".");
				}
				// to move north 
			} else if (cmd.equals("n") || cmd.equals("N")) {
				game.move("north");
				playerMovementQueue.add("North");
				playerMovementStack.push("North");
				System.out.println("You have this much of score/ammount: " + game.getScore());
				System.out.println("You moved in north direction.");
				System.out.println("To see the items present in room enter command: show and to see the description of room enter command: des");
			}// for extra credit, enter to dance 
			else if (cmd.equals("dance") || cmd.equals("Dance") || cmd.equals("DANCE")) {
				game.dance();

			}// for extra credit, to skip the game levels 
			else if (cmd.equals("skip") || cmd.equals("Skip") || cmd.equals("SKIP")) {
				game.skip();
			} else if (cmd.equals("help") || cmd.equals("h") || cmd.equals("H")) {
				game.help();
				// System.out.println("I'm in help method");
			} 
			else if (cmd.equals("sortedArray") || cmd.equals("SORTEDARRAY") || cmd.equals("SortedArray")) {
				Game.printSortedArray(itemList);
			}else if (cmd.equals("s") || cmd.equals("S")) {
				game.move("south");
				playerMovementQueue.add("South");
				playerMovementStack.push("South");

				System.out.println("You moved in Magic shop.");
				System.out.println("You have this much of score/ammount: " + game.getScore());
				System.out.println(
						"To see the items present in Magic shop enter: 'show' & to see the description of magic shop enter: 'des'");
				/*
				 * Scanner i = new Scanner(System.in); System.out.println(
				 * "Enter name of item to pick-up:");
				 * System.out.println(i.next());
				 * 
				 * while (i.hasNext()) { String item = i.next();
				 * game.getPlayer().takeItem(item);
				 * 
				 * } i.close(); System.out.println("You have picked up " +
				 * game.getCurrentRoom().getItem(i.next())); System.out.println(
				 * "You have this much of score/ammount: " + game.getScore());
				 */

			} else if (cmd.equals("e") || cmd.equals("e")) {
				game.move("east");
				playerMovementQueue.add("East");
				playerMovementStack.push("East");
				System.out.println("You moved in east direction.");
				System.out.println("To see the items present in room enter command: show and to see the description of room enter command: des");
				System.out.println("You have this much of score/ammount: " + game.getScore());
			} else if (cmd.equals("w") || cmd.equals("w")) {
				game.move("west");
				playerMovementQueue.add("West");
				System.out.println("You moved to in west direction.");
				System.out.println("To see the items present in room enter command: show and to see the description of room enter command: des");
				System.out.println("You have this much of score/ammount: " + game.getScore());
			} else if (cmd.equals("buy") || cmd.equals("Buy") || cmd.equals("BUY")) {
				System.out.print("Enter item name you want to buy:");
				Scanner it = new Scanner(System.in);
				if (it.hasNext() == game.itemsInRoom().contains(it.toString())) {
					game.buy(it.toString());
					//game.buy(it.toString());
				} else {
					System.out.println("no such item present in the room;");
				}
				//to pick up the item
			} else if (cmd.equals("t") || cmd.equals("take") || cmd.equals("Take")) {

				game.takeItem(game.getCurrentRoom().ItemsInRoom().iterator().next());
				System.out.println("You Picked up the item.");
			} else if (cmd.equals("forward") || cmd.equals("Forward") || cmd.equals("FORWARD")) {
				System.out.print("your forward movement path is:");
				System.out.println(playerMovementQueue.toString());

			} else if (cmd.equals("backward") || cmd.equals("Backward") || cmd.equals("BACKWARD")) {
				System.out.print("your backward movement path is: ");
				// System.out.println(playerMovementStack.peek());
				int siz = playerMovementStack.size();
				for (int i = 0; i < siz; i++) {
					System.out.print( playerMovementStack.peek() + "\t");
					playerMovementStack.pop();

					// playerMovementStack.remove(playerMovementStack.size()-1);
				}
				
			} // to drop the item
			else if (cmd.equals("d") || cmd.equals("Drop")) {
				Scanner drp = new Scanner(System.in);
				System.out.println("Enter the name of item to Drop");

				if (drp.next() != null) {
					String itm = drp.next();
					game.dropItem(itm);
					System.out.println("You dropped the item.");

				} else {
					System.out.println("Enter correct item name to drop.");
				}

			}
			// to see the map of game
			else if (cmd.equals("m") || cmd.equals("map")) {
				game.map();
			} else if (cmd.equals("help")) {
				game.help();

				// System.out.println("calling help method");
			} else if (cmd.equals("quit") || cmd.equals("Quit")) {
				break;
			} else {
				System.out.println("Invalid Command. Please enter command from the list provided. ");
			}

			System.out.println();
		}

		System.out.println("#### Game End ####");
	}

	private static void showItemList(String title, Collection<String> items) {
		if (!items.isEmpty()) {
			System.out.print(title + ": ");
			boolean first = true;
			for (String item : items) {
				if (!first) {
					System.out.print(", ");
				} else {
					first = false;
				}
				System.out.print(item);
			}
			System.out.println();
		}
	}
}
