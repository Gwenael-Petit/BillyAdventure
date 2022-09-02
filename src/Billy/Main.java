package Billy;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args ) {
		
		MAP map = new MAP();
		Inventory inventaire = new Inventory();
		Billy billy = new Billy(3,inventaire,0,0);
		billy.getItems().addItemsInInventory(Powerup.ARC);
		while (!billy.isDead()) {
			Display d = new Display(map);
			System.out.println(d);
			
			String saisieUtilisateur = sc.nextLine();
			Move bouger = new Move () ;
			
			if (saisieUtilisateur.equals("") ){
				
				clear();
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
				
			}else if (saisieUtilisateur.charAt(0)=='d' || saisieUtilisateur.charAt(0)==' ') {
				clear();
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
			} else if (saisieUtilisateur.charAt(0) == 's' || saisieUtilisateur.charAt(0) == 'z') {
				clear();
				
				if(!billy.getItems().getInventory().isEmpty()) {
					boolean value = false;
					int i =0;
					while(!value && i<billy.getItems().getInventory().size()) {
						if(billy.getItems().getInventory().get(i).equals(Powerup.PIOCHE)) {
							clear();
							i+=1;
							billy.getItems().removeItemsInInventory(Powerup.PIOCHE);
							bouger.moveVertically(map);
							value = true;
							
						}
						else {
							i+=1;
						}
					}
					
					if (!value) {
						System.out.println("Barbare que vous êtes, vous n'avez que des armes, vous pouvez toujours essayer de tirer à l'arc sur le mur...");
					}
				
				}
				
				else {
					System.out.println("Vous n'avez pas d'outils dans votre inventaire, bon courage pour casser le mur à la main.");
					bouger.detect(map, billy);
					bouger.moveMap(map);
					bouger.moveRight(map);
				}
			}
				
			else if (saisieUtilisateur.charAt(0) == 'i') {
			
				System.out.println(billy.getItems().toStringInventory());
			}
			int s = billy.getScore();
			if(billy.isDead()) {
				System.out.println("Buuuuuuuuuuuuuuuurg !!!!!!! \nVous êtes décéday (c triste ¯\\_(ツ)_/¯ ).");
			}
			System.out.println("Score: "+s);
			billy.setScore(s + 1);
			
		}
			
	}
	
	public static void clear () {
		for (int i = 0; i<25; i++) {
			System.out.println("\n");
		}
	}
}
