import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//class definition for inventory.
public class Inventory {

	//Map to put items in collection with no duplicates.
    private Map<String, Item> inventory = new HashMap<String, Item>();

    // method to putItem in inventory
    public void putItem(Item item) {
        inventory.put(item.getName(), item);
    }
    
    // method to remove item from inventory
    public void removeItem(Item item) {
        boolean removed = inventory.values().remove(item);
        if (!removed) {
            throw new IllegalArgumentException("Doesn't contain the item.: " + item);
        }
    }

    //method to get item from inventory.
    public Item getItem(String name) {
        return inventory.get(name);
    }

    //method to take item from inventory.
    public Item takeItem(String name) {
        return inventory.remove(name);
    }

    // method to check whether it has perticular item.
    public boolean hasItemNamed(String name) {
        return inventory.containsKey(name);
    }

    // get the name of all itmes from collection.
    public Collection<String> namesOfItems() {
        return inventory.keySet();
    }
}
