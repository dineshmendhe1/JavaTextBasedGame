import java.io.IOException;
import java.net.MalformedURLException;

/*interface providing command behaviour implemented by game.*/

public interface Commands {

	/*method to move player in Game world.*/
	String move(String direction);

   //method to pick up the item.
	String takeItem(String item);
	
   //method to drop the item.
	String dropItem(String item);
	
	// method to print map
	void map();

	//method to get help
	void help();
	
	//method to buy item
	void buy(String item);
	
	//method to use help
	String use(String item);
	
	// Method to make player dance.
	void dance();
	
	//Method to skip.
	void skip();
}
