package Billy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestBilly {

	private static final ArrayList<Powerup> listevide = new ArrayList <Powerup>();

	@Test
	public void testBilly() {
		
		assertEquals(Main.billy.getBourse(), 0); 
		assertEquals (Main.billy.getLife(), 3); 
		assertEquals(Main.billy.getName(), 'B'); 
		assertEquals(Main.billy.getScore(), 0);
		assertEquals(Main.billy.getItems().getInventory(), listevide) ;
		
		Main.billy.setBourse(15);
		assertEquals(Main.billy.getBourse(),15);
		
		Main.billy.setLife(1);
		assertEquals(Main.billy.getLife(), 1) ;
		assertEquals(Main.billy.isDead(), false);
		
		Main.billy.setScore(200);
		assertEquals(Main.billy.getScore(),200);
		
		assertEquals(Main.billy.toString(), "Billy a 1 vies.");
		
//		Main.billy.setItems(Powerup.ARC);
		
		Main.billy.looseOneLife(); 
		assertEquals(Main.billy.isDead(), true); 
		
		Main.billy.winOneLife(); 
		assertEquals(Main.billy.getLife(),1);
		
		Main.billy.winScore(); 
		assertEquals(Main.billy.getScore(),201);
		
		Main.billy.winBourse(); 
		assertTrue(Main.billy.getBourse()>15 || Main.billy.getBourse()<26);
		
	}
	
	public void testMove() {
		
	}

}
