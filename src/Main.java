import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map; 
public class Main  
{ 
    public static void main(String[] args) throws IOException  
    { 
        //Enter data using BufferReader 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
         
        // Reading data using readLine 
        String line = reader.readLine();
        String[] firstInput = line.split(",");
        String order = firstInput[0];
        int maxPiecesPerPack = Integer.parseInt(firstInput[1]);
        double maxWeightPerPack = Double.parseDouble(firstInput[2]);
        
        ArrayList<ArrayList<Item>> itemsById = new ArrayList<>();
        
        while (!line.equals("")) {
        	line = reader.readLine();
        	ArrayList<Item> items = createItems(line);
        	if (items != null) itemsById.add(items);
        }
        
        int currentQuantity = 0;
        double currentWeight = 0;
        ArrayList<ArrayList<Item>> newItemsList = new ArrayList<>();
        ArrayList<Item> _items = new ArrayList<>();
        for (ArrayList<Item> items : itemsById) {
        	for(Item item : items) {
        		currentQuantity++;
    			currentWeight += item.getItemWeight();
    			_items.add(item);
//    			System.out.println(item.toString() + ", currentQuantity: " + currentQuantity + ", currentWeight: " + currentWeight);
        		if(currentQuantity >= maxPiecesPerPack) {
        			// reach maxPiecesPerPack or maxWeightPerPack
        			System.out.println("Ever reach here?");
        			newItemsList.add(_items);
        			_items = new ArrayList<>();
        			currentQuantity = 0;
        			currentWeight = 0;
//        			newItemsList.add(_items);
        		}
        	}
        }
//        System.out.println("new list of item list size: " + newItemsList.size());
//        for (ArrayList<Item> items : newItemsList) {
//        	System.out.println("items list size" + items.size());
//        	
//        }
        
        ArrayList<Pack> packs = new ArrayList<>();
        int packId = 1;
        for (ArrayList<Item> items : newItemsList) {
        	packs.add(new Pack(packId++, items));
        }
        for (Pack pack : packs) {
        	pack.printPackInfo();
        }
        
//        ArrayList<Pack> packs = addToPacks(itemsById, maxPiecesPerPack, maxWeightPerPack);
//        for (Pack pack : packs) {
//        	System.out.println(pack.getPackId());
//        	System.out.println(pack.getItemList().size());
//        }
        System.out.println("End of the program");
    }
    
    private static ArrayList<Item> createItems(String input) {
    	String[] itemInput = input.split(",");
    	if (input.equals("")) return null;
    	ArrayList<Item> items = new ArrayList<>();
    	int quantity = Integer.parseInt(itemInput[2]);
    	System.out.println("CreateItems -> quantity: " + quantity);
    	for (int i = 0;i < quantity;i++) {
    		Item item = new Item(Integer.parseInt(itemInput[0]),
    				Integer.parseInt(itemInput[1]),
    				Double.parseDouble(itemInput[3]));
    		items.add(item);
    	}
    	return items;
    }
    
//    Item item = new Item(Integer.parseInt(itemInput[0]),
//			Integer.parseInt(itemInput[1]),
//			Double.parseDouble(itemInput[3]));
//    private static int getTotalItemQuantity(ArrayList<Item> items) {
//    	int totalQuantity = 0;
//    	for (Item i : items) {
//    		totalQuantity += i.getQuantity();
//    	}
//    	return totalQuantity;
//    }
    
    private static ArrayList<Pack> addToPacks(ArrayList<ArrayList<Item>> itemsById,
    		int maxPiecesPerPack,
    		double maxWeightPerPack) {
    	int currentId = 1;
    	int currentQuantity = 0;
    	double currentWeight = 0;
    	ArrayList<Pack> packs = new ArrayList<>();
    	Pack pack = new Pack(currentId, new ArrayList<Item>());
    	packs.add(pack);
    	for (ArrayList<Item> items : itemsById) {
    		for (Item i : items) {
    			currentQuantity++;
				currentWeight += i.getItemWeight();
    			if (currentQuantity < maxPiecesPerPack && currentWeight < maxWeightPerPack) {
    				pack.getItemList().add(i);
    				System.out.println("Current pack " + pack.getPackId() + ", item size: " + pack.getItemList().size());
    				continue;
    			}
    			System.out.println("============================");
    			System.out.println(pack.getPackId() + " " + pack.getItemList().size());
    			System.out.println("============================");
        		currentQuantity = 0;
        		currentWeight = 0;
        		pack = new Pack(++currentId, new ArrayList<Item>());
        		packs.add(pack);
    		}
    	}
//    	packs.get(packs.size()-1).getItemList().add(itemsById.get(itemsById.size()-1).get(itemsById.get(itemsById.size()-1).size()-1));
    	return packs;
    }
} 