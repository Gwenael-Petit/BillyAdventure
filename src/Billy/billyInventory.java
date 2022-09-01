package Billy;

import java.util.ArrayList;

public class billyInventory {
	public ArrayList <Powerup> inventory = new ArrayList<Powerup>();
	public boolean inventoryFull;
	
	public boolean isFull() {
		if(!this.inventory.isEmpty()) {
			return this.inventoryFull = true;
		}else {
			return this.inventoryFull = false;
		}
	}
	
	public billyInventory() {
		this.inventory = new ArrayList<Powerup>();
		this.inventoryFull = false;
	}
	
	public String toStringInventory() {
		return inventory.toString();
	}
}

