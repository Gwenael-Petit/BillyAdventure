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
			mur.add("_");
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

public static void main(String[] args){
	
	MAP map = new MAP();
	
	map.Generation_Map();
	
	System.out.println(map.map.get(0));
	System.out.println(map.map.get(1));
	System.out.println(map.map.get(2));
	
}

}

