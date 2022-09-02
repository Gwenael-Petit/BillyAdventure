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
			liste.add("_");
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
		 
		 int value = random.nextInt(26) + 'a';
		 liste.add("" + (char) value);
		 
		 
		 return liste;
	 }
	 
	 ArrayList<String> moveVertically (ArrayList<String> liste) {
		 //prend le premier caractère de la chaine
		 String chaine = liste.remove(0);
		 
		 //initialise une nouvelle map (à faire) et ajoute
		 liste.set(0, chaine);
		 return liste;
	 }
	 
	 
	 
	
	public static void main(String[] args) {
		Move move = new Move();
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("b");
		liste.add("b");
		liste.add("c");
		liste.add("d");
		System.out.println(liste);
		int i = 0;
		while(i < 10) {
			move.moveRight(liste);
			System.out.println(liste);
			i ++;
		}
		
		
	}
}
