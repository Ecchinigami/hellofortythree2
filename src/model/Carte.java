package model;


/**
 * <b>Carte est la classe représentant la Carte du vivarium.</b>
 * <p>La carte est l'élément clé du vivarium car elle contient les objets et individus présents, et la vie de ceux-ci.
 * 
 */
public class Carte {

	private CaseDale[][] plateau;
	private String[][] decor;
	
	/**
	 * initialise la carte en plaçant le décor et les différents objets et individus sur les différentes cases de la carte.
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
	 * Méthode permettant de démarrer la vie sur la carte (lancement du thread)
	 */
	public void startLife() {
		ThreadUtil.execute(new VieAble(this));
	}
	
	/**
	 * Permet de retourner le plateau
	 * @return Le plateau
	 */
	public CaseDale[][] getPlateau() {
		return plateau;
	}
	
	/**
	 * Permet de retourner le décor
	 * @return Le décor
	 */
	public String[][] getDecor() {
		return decor;
	}
}