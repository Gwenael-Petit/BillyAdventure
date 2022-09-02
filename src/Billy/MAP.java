package Billy;

import java.util.ArrayList;
import java.util.Random;

public class MAP {
    //Longueur de la map : 30 char
    ArrayList <ArrayList <String>> map = new ArrayList <ArrayList <String>>();
    
    

public ArrayList <String> Generation_Mur(){
	ArrayList <String> mur = new ArrayList <String>();
	
	Random random = new Random();
	int value;
	
	for (int i =0; i<30; i+=1) {
		value = random.nextInt(100);
		
		if (value>30) {
			mur.add("-");
		}
		
		else {
		mur.add(".");
		}
	}
	return mur;
}
    
    
public ArrayList <ArrayList <String>> Generation_Map(){
    
	ArrayList <String> Billy = new ArrayList <String>();
	Billy.add("B");
	
	for (int i =0; i<29; i+=1) {
		Billy.add(" ");
	}
	
	this.map.add(Generation_Mur());
	this.map.add(Billy);
	this.map.add(Generation_Mur());
	
	return this.map;
}



/*public static void main(String[] args){
	
	MAP map = new MAP();
	
	map.Generation_Map();
	
	String l0 = "";
	for(int i = 0; i < map.map.get(0).size(); i++) {
		l0 += map.map.get(0).get(i);
	}
	
	String l1 = "";
	for(int i = 0; i < map.map.get(1).size(); i++) {
		l1 += map.map.get(1).get(i);
	}
	
	String l2 = "";
	for(int i = 0; i < map.map.get(2).size(); i++) {
		l2 += map.map.get(2).get(i);
	}
	
	System.out.println(l0);
	System.out.println(l1);
	System.out.println(l2);
	
}*/

}

