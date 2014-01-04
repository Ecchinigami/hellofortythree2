package model;

public class Piege extends Objet {

	private int dommage;
	
	public Piege(String nom) {

        this.nom = nom;
	}
	
	public int getDommage(){
		return this.dommage;
	}
}
