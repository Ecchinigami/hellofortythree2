package model;

/**
 * <b>Action est la classe qui pr�sente l'action effectu�e par un individu via une liste</b>
 * @see VieAble#actionlist
 */
public class Action {
	
	/**
	 * La direction que prendra l'individu
	 */
	private String direction;
	
	/**
	 * Si l'individu attaque un autre individus
	 */
	private Individu attaque;
	
	/**
	 * Si l'individu mange un objet
	 */
	private Objet mange;
}
