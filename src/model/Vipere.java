package model;

/**
 * <b>La classe Vipere est h�rit�e de la Classe "Individu"</b>
 * <p>Elle d�taille ainsi les idividus "Vipere" dans le vivarium</p>
 *
 */
public class Vipere extends Individu {

	/**
	 * Constructeur par d�faut de la vip�re
	 */
	public Vipere() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	/**
	 * Construction de la vip�re en pr�cisant sa vie et sa force d'attaque
	 * @param vie La vie de la vip�re
	 * @param attaque La force d'attaque de la vip�re
	 */
	public Vipere(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	/**
	 * Affiche la vip�re
	 */
	public String toString() {
		return "vipere";
	}
	
	/**
	 * Gestion de la perception de la vip�re
	 */
	public void perception() {
	}
	
	/**
	 * Gestion des d�cisions de la vip�re
	 */
	public void decision() {
	}
	
	/**
	 * Action que la vip�re effectue
	 */
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
