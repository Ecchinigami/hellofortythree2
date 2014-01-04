package model;

import java.util.Vector;

/**
 * <b>Carte est la classe repr�sentant la Carte du vivarium.</b>
 * <p>La carte est l'�l�ment cl� du vivarium car elle contient les objets et individus pr�sents, et la vie de ceux-ci.
 * 
 */
public class Carte {

	
	public CaseDale[][] plateau;
	
	public void Carte() {
		plateau = null;
	}
	
	/**
	 * initialise la carte en pla�ant les diff�rents objets et individus sur les diff�rentes cases de la carte.
	 * @param carte La carte du Vivarium
	 */
	public void initCarte(String[][][] carte) {
		
		plateau = new CaseDale[carte[0].length][carte[1].length];
		
		for (int i = 0; i < carte[0].length; i++) {
			for (int j = 0; j < carte[1].length; j++) {
				String decor = carte[i][j][0];
				String individu = carte[i][j][1];
				String objet = carte[i][j][2];
				
				plateau[i][j].setIndividu(individu);
				plateau[i][j].setObjet(objet);
				
				if(decor=="stone") {
					plateau[i][j].setAccessible(false);
				}
				else {
					plateau[i][j].setAccessible(true);
				}
			}
		}
	}

}