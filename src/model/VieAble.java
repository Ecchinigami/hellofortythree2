package model;

import java.util.Vector;


/**
 * <b>VieAble est en fait la classe permettant de faire vivre le vivarium</b>
 * 
 */
public class VieAble implements Runnable {

	public Vector<Action> actionlist;
	public Carte carte;

	public VieAble(Carte c) {
		carte = c;
		actionlist = new Vector<Action>();
	}

	public void run() {
		synchronized (ThreadUtil.class) {
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

					actionlist.add(carte.getPlateau()[i][j].getIndividu().live());

				}
			}
		}
	}
	/**
	 * Gère les conflits qu'il y aurait pu avoir lors des déplacements
	 */
	public void perform(){
		System.out.println("Perform");
		int individu = 0;
		for (int i = 0; i < carte.getPlateau()[0].length; i++) {
			for (int j = 0; j < carte.getPlateau()[1].length; j++) {
				if(carte.getPlateau()[i][j].getIndividu() != null) {
					switch (actionlist.get(individu).getDirection()) {
						case "bas":	
							if(i<carte.getPlateau()[0].length-1) {
								if(carte.getPlateau()[i+1][j].getIndividu()==null) {
									carte.getPlateau()[i+1][j].setIndividu(carte.getPlateau()[i][j].getIndividu());
									carte.getPlateau()[i][j].setIndividu(null);
								}
							}
						break;
					}
					
					individu++;
				}
			}
		}
	}

}