package Billy;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args ) {
		
		MAP map = new MAP();
		Inventory inventaire = new Inventory();
		Billy billy = new Billy(3,inventaire,0,0) ;
		
		while (true) {
			
			clear();
			
			Display d = new Display(map);
			System.out.println(d);
			
			String saisieUtilisateur = sc.nextLine();
			Move bouger = new Move () ;
			
			if (saisieUtilisateur.equals("") ){
				bouger.moveRight(map);
				bouger.moveMap(map);
			}else if (saisieUtilisateur.charAt(0)=='d' || saisieUtilisateur.charAt(0)==' ') {
				bouger.moveRight(map);
				bouger.moveMap(map);
			} else if (saisieUtilisateur.charAt(0) == 's' || saisieUtilisateur.charAt(0) == 'z') {
				bouger.moveVertically(map) ;
			}
			
		}
			
	}
	
	public static void clear () {
		for (int i = 0; i<25; i++) {
			System.out.println("\n");
		}
	}
}
