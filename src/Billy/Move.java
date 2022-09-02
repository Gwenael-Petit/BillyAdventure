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
	 
	 MAP moveVertically (MAP map) {
		 
		 //MAP map = new MAP();
		 
		 map.Generation_Map();
		 
		 for (int i =0; i<29; i+=1) {
			 Move move = new Move();
			 move.moveRight(map); 
			 
			 		 
		}
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
