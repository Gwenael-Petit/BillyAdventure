package Billy;

import java.util.ArrayList;

public class Inventory {
	private ArrayList <Powerup> inventory = new ArrayList<Powerup>();
	private boolean inventoryFull;
	
	public boolean isFull() {
		if(!this.inventory.isEmpty()) {
			return this.inventoryFull = true;
		}else {
			return this.inventoryFull = false;
		}
	}
	
	public Inventory() {
		this.inventory = new ArrayList<Powerup>();
		this.inventoryFull = false;
	}
	
	public String toStringInventory() {
		return inventory.toString();
	}
}

