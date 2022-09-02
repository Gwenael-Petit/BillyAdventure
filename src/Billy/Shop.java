package Billy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shop {
	public ArrayList<String> rayon = new ArrayList<String>();
	public Random rand = new Random() ;
	
	public void getItem(Billy billy) {
		
		Scanner sc = new Scanner (System.in);
		
		int choixItem = 0;
		choixItem = sc.nextInt();
		
		while(choixItem!=4) {
			choixItem = sc.nextInt();
		
			if (choixItem==1) {
				if (billy.getBourse()>=35) {
					billy.setBourse(billy.getBourse()-35);
					billy.setLife(billy.getLife()+1);
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...)");
				} else {
					System.out.println("La fée c'est une Queen, elle vaut plus cher que ça en fait, brow !! (ง'̀-'́)ง ");
				}
			} else if (choixItem==2) {
				if (billy.getBourse()>=25) {
					billy.getItems().addItemsInInventory(Powerup.ARC);
					billy.setBourse(billy.getBourse()-25);
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...)");
				}else {
					System.out.println("Hé brow t'as pas de thune là, te fou pas d'moi !! (Ծ‸ Ծ) ");
				}
			} else if (choixItem==3) {
				if (billy.getBourse()>=25) {
					billy.getItems().addItemsInInventory(Powerup.PIOCHE);
					billy.setBourse(billy.getBourse()-25);
					System.out.println("Merci bien jeune voyageur talentueux du nom de Billy! (Billy le bougre devrai-je direeeee...)");
				}else {
					System.out.println("T'es complètement marteau !! Cet engin vaut plus cher que ça, brow. (Ծ‸ Ծ)");
				}
			}else if (choixItem == 4) {
				System.out.println("Merci d'et' passé, BROW !! (☞ﾟヮﾟ)☞ ");
			}
		}
	}
	
	
	public void setShop() {
		rayon.add("Fée, 35 gems.");
		rayon.add("Arc, 25 gems.");
		rayon.add("Pioche, 25 gems.");
	}
	
	public void displayShop() {
		System.out.println("Bonjour mon jeune ami ! Bienvenu dans mon humble Shop, AKA demeure, boutique personelle et professionnelle ! ԅ(≖‿≖ԅ)");
		String res = "" ; 
		for (int i = 0; i<rayon.size() ; i++) {
			res = res + (i+1) + ". "  + rayon.get(i)+ ", \n";
		}
		System.out.println(res);
		System.out.println("4. Quitter le shop");
		
		
		
	}
	
	public static void main(String[] args) {
		Shop shop = new Shop();
		Inventory inventaire = new Inventory();
		Billy billy = new Billy(3,inventaire,0,0);
		
		shop.setShop();
		shop.displayShop();
		shop.getItem(billy);
		
	}

}