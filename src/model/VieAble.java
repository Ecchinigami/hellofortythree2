package model;

import java.util.Vector;

/**
 * <b>VieAble est en fait la classe permettant de faire vivre le vivarium</b>
 * 
 */
public class VieAble implements Runnable {

	public Action actionlist;
	public Carte carte;

	public VieAble(Carte c) {
		carte = c;
	}

	public void run() {
		synchronized (ThreadUtil.class) {
			while(true) {
				update();
				perform();
			}
		}
	}

	/**
	 * Fait la mise à jour des divers éléments sur la carte suivant les actions effectuées
	 */
	public void update(){
		System.out.println("Update");
		for (int i = 0; i < carte.getPlateau()[0].length; i++) {
			for (int j = 0; j < carte.getPlateau()[1].length; j++) {
				if(carte.getPlateau()[i][j].getIndividu() != null) {
					//carte.getPlateau()[i][j].getIndividu().live();
					if(i<carte.getPlateau()[0].length-1) {
						if(carte.getPlateau()[i][j].getIndividu()==null) {
							carte.getPlateau()[i++][j].setIndividu(carte.getPlateau()[i][j].getIndividu());
							carte.getPlateau()[i][j].setIndividu(null);
						}
					}
				}
			}
		}
	}
	/**
	 * Gère les conflits qu'il y aurait pu avoir lors des déplacements
	 */
	public void perform(){
		System.out.println("Perform");
	}

}