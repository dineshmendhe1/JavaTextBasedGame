/*Item class blueprint.*/
public class Item {

	/*item name variable declaration.*/
    private String name;
    
    private int price;

    
    /*Getter and setter for name variable.*/
    
    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(int price, String name) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String tryItem(Inventory player) {
        return "Not Usable " + getName() + ".";
    }
    
    /*  Overriding equals and hashcode methods to remove duplicates from map.*/

    @Override
    public boolean equals(Object other) {
        Item that = (Item) other;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
