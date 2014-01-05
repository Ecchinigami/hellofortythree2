package model;


/**
 * <b>Carte est la classe representant la Carte du vivarium.</b>
 * <p>La carte est l'element cle du vivarium car elle contient les objets et individus presents, et la vie de ceux-ci.
 * 
 */
public class Carte {

	private CaseDale[][] plateau;
	private String[][] decor;
	private VieAble life;
	
	/**
	 * Initialise la carte en placant le decor et les differents objets et individus sur les differentes cases de la carte.
	 * @param carte La carte du Vivarium
	 */
	public Carte(String[][][] carte) {
		
		this.plateau = new CaseDale[carte[0].length][carte[1].length];
		this.decor = new String[carte[0].length][carte[1].length];
		
		for (int i = 0; i < carte[0].length; i++) {
			for (int j = 0; j < carte[1].length; j++) {
				
				this.plateau[i][j] = new CaseDale();
				
				String decor = carte[i][j][0];
				String individu = carte[i][j][1];
				String objet = carte[i][j][2];
				
				this.plateau[i][j].initIndividu(individu);
				this.plateau[i][j].initObjet(objet);				
				if(decor.equals("stone")) {
					this.plateau[i][j].setAccessible(false);
				}
				else {
					this.plateau[i][j].setAccessible(true);
				}
				
				this.decor[i][j] = decor;
			}
		}
	}
	
	/**
	 * Methode permettant de demarrer la vie sur la carte (lancement du thread)
	 */
	public void startLife() {
		life = new VieAble(this);
		ThreadUtil.execute(life);
	}
	/**
	 * Methode permettant de stopper la vie sur la carte (arret du thread)
	 */
	public void stopLife() {
		life.stop();
	}
	
	/**
	 * Permet de retourner le plateau
	 * @return Le plateau
	 */
	public CaseDale[][] getPlateau() {
		return plateau;
	}
	
	/**
	 * Permet de retourner le d�cor
	 * @return Le d�cor
	 */
	public String[][] getDecor() {
		return decor;
	}
}