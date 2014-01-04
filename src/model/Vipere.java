package model;

/**
 * <b>La classe Vipere est héritée de la Classe "Individu"</b>
 * <p>Elle détaille ainsi les idividus "Vipere" dans le vivarium</p>
 *
 */
public class Vipere extends Individu {

	/**
	 * Constructeur par défaut de la vipère
	 */
	public Vipere() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	/**
	 * Construction de la vipère en précisant sa vie et sa force d'attaque
	 * @param vie La vie de la vipère
	 * @param attaque La force d'attaque de la vipère
	 */
	public Vipere(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	/**
	 * Affiche la vipère
	 */
	public String toString() {
		return "vipere";
	}
	
	/**
	 * Gestion de la perception de la vipère
	 */
	public void perception() {
	}
	
	/**
	 * Gestion des décisions de la vipère
	 */
	public void decision() {
	}
	
	/**
	 * Action que la vipère effectue
	 */
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
