package Billy;
import java.util.ArrayList;
import java.util.Random;

public class Billy {
	static final char name = 'B' ;
	static int life = 3 ;
	static Inventory items ; 
	static int score = 0 ;
	static int bourse = 0 ;
	
	public static void main (String [] args ) {
		
	}
	
	public Billy (char name, int life, Inventory items, int score, int bourse) {
		this.name= name; 
		this.life= life;
		this.items=items;
		this.score = score ;
		this.bourse = bourse ;
	}

	public String toString() {
		return "Billy a " + this.life + " vies." ;
	}
	
	public int looseOneLife() {
		this.life = this.life-1 ; 
		return this.life;
	}
	
	public int winOneLife() {
		if (this.life < 4 ) {
			this.life = this.life+1 ; 
		} 
		return this.life ;
	}
	
	public int winScore (){
		this.score = this.score + 1 ;
		return this.score ;
	}
	
	public int winBourse () {
		Random rand = new Random() ;
		this.bourse=this.bourse + rand.nextInt(11) ;
		return this.bourse;
	}
	
	
	
	

}
