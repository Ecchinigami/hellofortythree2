package model;

/**
 * <b>La classe Poule est héritée de la Classe "Individu"</b>
 * <p>Elle détaille ainsi les idividus "Poule" dans le vivarium</p>
 *
 */
public class Poule extends Individu {
	
	/**
	 * Constructeur par défaut de la poule
	 */
	public Poule() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	/**
	 * Construction de la poule en précisant sa vie et sa force d'attaque
	 * @param vie La vie de la poule
	 * @param attaque La force d'attaque de la poule
	 */
	public Poule(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	/**
	 * Affiche la poule
	 */
	public String toString() {
		return "poule";
	}
	
	/**
	 * Gestion de la perception de la poule
	 */
	public void perception() {
	}
	
	/**
	 * Gestion des décisions de la poule
	 */
	public void decision() {
	}
	
	/**
	 * Action que la poule effectue
	 */
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
