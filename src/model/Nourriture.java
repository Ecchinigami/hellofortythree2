package model;
/**
 * <b>La classe Nourriture est héritée de la Classe Objet</b>
 * <p>La nourriture est donc un objet que l'on pourra placer sur la carte du vivarium</p>
 * <p>La nourriture augmente la "vie" de l'individu qui la mangera</p>
 * 
 */
public class Nourriture extends Objet {

	/**
	 * La valeur "valeurSoin" permet à l'individu de bénéficier du "pouvoir" de la nourriture
	 */
	private int valeurSoin;
	
	/**
	 * Constructeur Nourriture
	 * @param nom Le nom de la nourriture
	 */
	public Nourriture(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne la valeur du soin apporté par la Nourriture consommé
	 * @return La valeur de soin, sous la forme d'un entier.
	 */
	public int getValeurSoin(){
		return this.valeurSoin;
	}
}