package Billy;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args ) {
		
		ecranTitre();
		
		MAP map = new MAP();
		Inventory inventaire = new Inventory();
		Billy billy = new Billy(3,inventaire,0,0);
		
		boolean outgame=false;
		
		billy.getItems().addItemsInInventory(Powerup.ARC);
		
		
		
		while (!billy.isDead() && !outgame) {
			Display d = new Display(map);
			System.out.println(d);
			
			System.out.println("[i]: inventaire. \n[d] [Espace] [Entrée]: avancer.\n[z] [s]: monter / descendre (nécessite et utilise une pioche). \n[q]: quitter\n");
			
			String saisieUtilisateur = sc.nextLine();
			Move bouger = new Move () ;
			
			if (saisieUtilisateur.equals("") ){
				
				clear();
				bouger.difficulty(billy.getScore());
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
				
			}else if (saisieUtilisateur.charAt(0)=='d' || saisieUtilisateur.charAt(0)==' ') {
				clear();
				bouger.detect(map, billy);
				bouger.moveRight(map);
				bouger.moveMap(map);
			} 
			
			else if (saisieUtilisateur.charAt(0)=='q') {
				clear();

			System.out.println("\n    _");
			System.out.println("   { )_");
			System.out.println("    /  >>   _");
			System.out.println("   / /\\°\\__/.°   Vous avez fait demi-tour!!");
			System.out.println("  °   //°--°    Et avez pris la fouite tel un lache!!");
			System.out.println("      \\\\       Votre score final est : "+billy.getScore()+".");
			System.out.println("      (/       Votre dernier score était de : " + Save.load() + ".");
			
			Save.save(billy.getScore());
			outgame=true;
			
			
			break;
			
			}
			
			
			else if (saisieUtilisateur.charAt(0) == 's' || saisieUtilisateur.charAt(0) == 'z') {
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
				clear();
				System.out.println(billy.getItems().toStringInventory());
				System.out.println("vous avez " + billy.getBourse()+ " gemmes.");
			}
			else {
				clear();
				bouger.detect(map, billy);
				bouger.moveMap(map);
				bouger.moveRight(map);
			}
			int s = billy.getScore();
			if(billy.isDead()) {
				System.out.println("Buuuuuuuuuuuuuuuurg !!!!!!! \nVous êtes décéday (c triste ¯\\_(ツ)_/¯ ).");
				System.out.println("Votre score final est de : " + billy.getScore() + ".");
				System.out.println("Votre dernier score était de : " + Save.load() + ".");
				Save.save(billy.getScore());
				break;
			}
			System.out.println("Score: "+s);
			for(int i = 0; i < billy.getLife(); i++) {
				System.out.print('❤');
			}
			System.out.println();
			billy.setScore(s + 1);
			bouger.difficulty(billy.getScore());
			
		}
			
	}
	
	public static void clear () {
		for (int i = 0; i<25; i++) {
			System.out.println("\n");
		}
	}
	
	public static void ecranTitre() {
		boolean continuer = false;
		while(!continuer) {
			System.out.println("HEYYY BILLYYY\n");
			System.out.println("Tu viens de tomber dans un trou qui t'as amené dans un donjon, too bad ¯\\_(ツ)_/¯. \n\nAu cours de ton échappé tu croiseras des Monstres (☠), \ndes Power-up (★) qui pourront t'aider à échapper aux monstres, \ndes Gemmes (♦) que tu pourras collecter afin d'acheter des objets à un Marchand (☖). \n\nBon courage pour survivre!");
			
			
			System.out.println("\nAppuyer sur une touche pour continuer.");
			Scanner sc = new Scanner (System.in);
			String suite = sc.nextLine();
			continuer = true;
			clear();
		}
	}
}
