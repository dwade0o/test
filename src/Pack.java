import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Pack {
	private int packId;
	private ArrayList<Item> items;
	private Map<String, ArrayList<Item>> itemMap;
	
	public Pack(int packId, ArrayList<Item> itemList) {
		this.packId = packId;
		this.items = itemList;
	}
	
	public Pack(int packId, HashMap<String, ArrayList<Item>> itemMap) {
		this.packId = packId;
		this.itemMap = itemMap;
	}
	
	public int getPackId() {
		return this.packId;
	}
	
	public void setPackId(int packId) {
		this.packId = packId;
	}
	
	public ArrayList<Item> getItemList() {
		return this.items;
	}
	
	public void setItemList(ArrayList<Item> items) {
		this.items = items; 
	}
	
	public void printPackInfo() {
		ArrayList<Item> items = getUniqueItem();
		System.out.println("Pack Number: " + this.packId);
		for (Item item : items) {
			System.out.println(item.getItemId() + "," + item.getLength() + "," + getItemCount(item.getItemId()) + "," + item.getItemWeight());
		}
	}
	
	private ArrayList<Item> getUniqueItem() {
		ArrayList<Item> items = new ArrayList<>();
		Item previous = null;
		for (Item item : this.items) {
			if(items.isEmpty()) {
				previous = item;
				items.add(item);
			}
			if(!previous.equals(item)) {
				previous = item;
				items.add(item);
			}
		}
		return items;
	}
	
	private int getItemCount(int id) {
		return (int) this.items.stream().filter(item -> id == item.getItemId()).count();
	}
	public enum SortOrder {
		NATURAL, SHORT_TO_LONG, LONG_TO_SHORT
	}
}
