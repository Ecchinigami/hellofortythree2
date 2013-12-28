package model;

public class Nourriture extends Objet {

	private int valeurSoin;
	
	public Nourriture(String nom) {
		this.nom = nom;
	}

	public int getValeurSoin(){
		return this.valeurSoin;
	}
}
