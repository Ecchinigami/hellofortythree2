package model;


/**
 * <b>La classe Renard est h�rit�e de la Classe "Individu"</b>
 * <p>Elle d�taille ainsi les idividus "Renard" dans le vivarium</p>
 *
 *
 */
public class Renard extends Individu {

	/**
	 * Constructeur par d�faut du renard
	 */
	public Renard() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	/**
	 * Construction du renard en pr�cisant sa vie et sa force d'attaque
	 * @param vie La vie du renard
	 * @param attaque La force d'attaque du renard
	 */
	public Renard(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	/**
	 * Affiche le renard
	 */
	public String toString() {
		return "renard";
	}
	
	/**
	 * Gestion de la perception du renard
	 */
	public void perception() {
	}
	
	/**
	 * Gestion des d�cisions du renard
	 */
	public void decision() {
	}
	
	/**
	 * Action que le renard effectue
	 */
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
