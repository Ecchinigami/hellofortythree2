package model;

public abstract class Comportement {

	abstract String[][] perception(CaseDale[][] c, int x, int y);
    
	abstract String decision(String[][] aire, String individu);
    
	abstract String action(String ordre, int posx, int posy);
}
