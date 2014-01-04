package model;

public interface Comportement {
	
	void perception();
    
    void decision();
    
    Action action(String direction, Individu attaque, Objet mange);
}
