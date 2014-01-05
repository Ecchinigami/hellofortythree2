package model;


/**
 * <b>Carte est la classe repr�sentant la Carte du vivarium.</b>
 * <p>La carte est l'�l�ment cl� du vivarium car elle contient les objets et individus pr�sents, et la vie de ceux-ci.
 * 
 */
public class Carte {

	private CaseDale[][] plateau;
	private String[][] decor;
	
	/**
	 * initialise la carte en pla�ant le d�cor et les diff�rents objets et individus sur les diff�rentes cases de la carte.
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
	 * M�thode permettant de d�marrer la vie sur la carte (lancement du thread)
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
	 * Permet de retourner le d�cor
	 * @return Le d�cor
	 */
	public String[][] getDecor() {
		return decor;
	}
}