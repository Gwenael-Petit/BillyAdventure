package Billy;
import java.util.*;

public class Move {
	int monsterSpawnRate = 10;
	int gemSpawnRate = 10;
	int powerupSpawnRate = 10;
	int shopkeeperSpawnRate = 10;
	
	ArrayList<String> moveMap (ArrayList<String> liste) {
		Random random = new Random();
		int value = random.nextInt(100);
		if(value < 30) {
			liste.remove(0);
			liste.add("-");
		} else {
			liste.remove(0);
			liste.add(".");
		}
		
		return liste;
	}
	 ArrayList<String> moveRight (ArrayList<String> liste) {
		 //récupère la première valeur 
		 String chaine = liste.remove(0);
		 //change le nouveau caractère par la valeur sauvegarder
		 if(!liste.isEmpty()) {
			 liste.set(0, chaine);
		 } else {
			 liste.add(chaine);
		 }
		 
		 //ajout d'un caractère aléatoire à la fin de la liste
		 Random random = new Random();
		 
		 int value = random.nextInt(100);
		 //spawn monstre
		 if(value > 100 - monsterSpawnRate) {
			 liste.add("M");
		//spawn gem
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate) {
			 liste.add("G");
		//spawn power up
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate) {
			 liste.add("P");
		//spawn boutique
		 } else if (value > 100 - monsterSpawnRate - gemSpawnRate - powerupSpawnRate - shopkeeperSpawnRate) {
			 liste.add("S");
	     //spawn caractère vide
		 } else {
			 liste.add(" ");
		 }
		
		 return liste;
	 }
	 
	 	ArrayList<ArrayList<String>> moveVertically () {
		 
		 MAP map = new MAP();
		 
		 ArrayList<ArrayList<String>> new_way = new ArrayList<ArrayList<String>>();
		 
		 new_way = map.Generation_Map();
		 
		 ArrayList<String> Billy = new ArrayList<String>();
		 
		 Billy = new_way.get(1);
		 
		 for (int i =0; i<29; i+=1) {
			 
			 Move move = new Move();
			 
			 Billy = move.moveRight(Billy); 
			 
			 		 
			}
		 
		 new_way.set(1, Billy);
		 
		 return new_way;
	 	}
	 
	 
	 
	
	public static void main(String[] args) {
		Move move = new Move();
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("b");
		liste.add(" ");
		liste.add(" ");
		liste.add(" ");
		System.out.println(liste);
		int i = 0;
		while(i < 10) {
			move.moveRight(liste);
			System.out.println(liste);
			i ++;
		}
		
		
	}
}
