package model;


/**
 * <b>Action est la classe qui présente l'action effectuée par un individu via une liste</b>
 * @see VieAble#actionlist
 */
public class Action {
	private String direction;
	private Individu attaque;
	private Objet mange;

	/**
	 * Methode permettant de savoir l'action d'un individu
	 * @param direction La direction de l'individu
	 * @param attaque L'individu attaque un adversaire
	 * @param mange L'individu mange un objet
	 */
	public Action(String direction, Individu attaque, Objet mange) {
		this.direction = direction;
		this.attaque = attaque;
		this.mange = mange;
	}
	
	public String getDirection() {
		return direction;
	}
	public Individu getAttaque() {
		return attaque;
	}
	public Objet getMange() {
		return mange;
	}
}
