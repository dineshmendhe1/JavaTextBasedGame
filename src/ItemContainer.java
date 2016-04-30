
public class ItemContainer {
	public Item item;
	//public int price;
	public ItemContainer(int price, String name){
		this.item.setPrice(price);
		this.item.setName(name);
		
	}
	
	@Override
	public String toString() {
	
		return "price: $"+this.item.getPrice()+" Item: "+this.item.getName();
	}

}
