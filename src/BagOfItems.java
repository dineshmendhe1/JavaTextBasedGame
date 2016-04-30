//class for bag of items
public class BagOfItems extends Item {

	public BagOfItems() {
		super(0,"Bag of Items");
	}

	// Overriding tryitem method.
	@Override
	public String tryItem(Inventory player) {
		try {
			Item[] bag = { requireItem("diamond", player), requireItem("sword", player),
					requireItem("handkerchief", player), };
			Item bg = fillBagUsing(bag, player);
			return "You filled " + this.getName() + " your bag with " + bg.getName() + " this items.";

		} catch (Exception e) {
			return "First you need bag to put items.";
		}
	}

	//signature of require item method.
	private static Item requireItem(String name, Inventory player) throws Exception{
		Item item = player.getItem(name);
		if (item == null) {
			throw new Exception();
		}
		return item;
	}

	//Signature of fillBagUsing method.
	private static Item fillBagUsing(Item[] bag, Inventory player) {
		for (Item item : bag) {
			player.removeItem(item);
		}
		Item bg = new Item(2,"bg");
		player.putItem(bg);
		return bg;
	}

}
