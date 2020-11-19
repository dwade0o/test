
public class Item {
	
	private int itemId;
	private int length;
	private int quantity;
	private double itemWeight;
	
	public Item(int itemId, int length, double itemWeight)
	{
		this.itemId = itemId;
		this.length = length;
		this.itemWeight = itemWeight;
	}
	
	public String toString() {
		return "Item id: " + this.itemId + 
				", length: " + this.length +
				", weight: " + this.itemWeight;
	}
	
	public int getItemId() {
		return this.itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getItemWeight() {
		return this.itemWeight;
	}
	
	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}
	
	public boolean equals(Item other) {
		return this.itemId == other.itemId;
	}
}

