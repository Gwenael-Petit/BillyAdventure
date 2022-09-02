package Billy;
import java.util.*;

public class Move {
	int monsterSpawnRate = 10;
	int gemSpawnRate = 10;
	int powerupSpawnRate = 10;
	int shopkeeperSpawnRate = 10;
	
	MAP moveMap (MAP map) {
		//mur du haut
		Random random = new Random();
		int value = random.nextInt(100);
		if(value < 30) {
			map.map.get(0).remove(0);
			map.map.get(0).add("-");
		} else {
			map.map.get(0).remove(0);
			map.map.get(0).add(".");
		}
		
		//mur du bas
		
		value = random.nextInt(100);
		if(value < 30) {
			map.map.get(2).remove(0);
			map.map.get(2).add("-");
		} else {
			map.map.get(2).remove(0);
			map.map.get(2).add(".");
		}
		return map;
	}
	MAP moveRight (MAP map) {
		 //récupère la première valeur 
		 String chaine = map.map.get(1).remove(0);
		 //change le nouveau caractère par la valeur sauvegarder
		 if(!map.map.get(1).isEmpty()) {
			 map.map.get(1).set(0, chaine);
		 } else {
			 map.map.get(1).add(chaine);
		 }
		 
		 //ajout d'un caractère aléatoire à la fin de la liste
		 Random random = new Random();
		 
		 int value = random.nextInt(100);
		 //spawn monstre
		 if(value > 100 - monsterSpawnRate) {
			 map.map.get(1).add("M");
		//spawn gem
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate) {
			 map.map.get(1).add("G");
		//spawn power up
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate) {
			 map.map.get(1).add("P");
		//spawn boutique
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate - shopkeeperSpawnRate) {
			 map.map.get(1).add("S");
	     //spawn caractère vide
		 } else {
			 map.map.get(1).add(" ");
		 }
		
		 return map;
	 }
	
	void detect (MAP map, Billy billy) {
		if(map.map.get(1).get(1).charAt(0) == 'M') {
			if(!billy.getItems().getInventory().isEmpty()) {
				int i = 0;
				boolean foundItem = false;
				while(i < billy.getItems().getInventory().size() && foundItem != true) {
					if(billy.getItems().getInventory().get(i).equals(Powerup.ARC)) {
						System.out.println("Vous avez tué le monstre avec un arc, par manque de flèches vous lui avez lancé dessus.");
						billy.getItems().removeItemsInInventory(Powerup.ARC);
						foundItem = true;
					} else {
						if(billy.getLife() != 1) {
							billy.looseOneLife();
							System.out.println("Vous avez perdu une vie. Il vous reste "+billy.getLife()+" vie(s). Courage Billy!!");
						} else {
							billy.looseOneLife();
						}
					}
					i ++;
				}
			} else {
				if(billy.getLife() != 1) {
					billy.looseOneLife();
					System.out.println("Vous avez perdu une vie. Il vous reste "+billy.getLife()+" vie(s). Courage Billy!!");
				} else {
					billy.looseOneLife();
				}
			}
			
			
		} else if (map.map.get(1).get(1).charAt(0) == 'G') {
			System.out.println("gem");
		} else if (map.map.get(1).get(1).charAt(0) == 'P') {
			System.out.println("power up");
		}else if (map.map.get(1).get(1).charAt(0) == 'S') {
			System.out.println("boutique");
		} 
	}
	 
	 MAP moveVertically (MAP map) {
		 
		 //MAP map = new MAP();
		 
		 map.Generation_Map();
		 
		 
		 for (int i =0; i<29; i+=1) {
			 Move move = new Move();
			 move.moveRight(map); 
			 
			 		 
		}
		map.map.get(1).set(1, " ");
		map.map.get(1).set(2, " ");
		map.map.get(1).set(3, "P");
		map.map.get(1).set(4, " ");
		map.map.get(1).set(5, " ");
		 return map;
	 	}
	 
	 
	 
	
	public static void main(String[] args) {
		Move move = new Move();
		MAP map = new MAP();
		map.Generation_Map();
		int i = 0;
		while(i < 10) {
			move.moveRight(map);
			move.moveMap(map);
			System.out.println(map.map.get(0));
			System.out.println(map.map.get(1));
			System.out.println(map.map.get(2));
			i ++;
		}
		move.moveVertically(map);
		System.out.println(map.map.get(0));
		System.out.println(map.map.get(1));
		System.out.println(map.map.get(2));
		
		
	}
}
