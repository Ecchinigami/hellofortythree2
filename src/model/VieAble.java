package model;

import java.io.ObjectInputStream.GetField;
import java.util.Vector;


/**
 * <b>VieAble est en fait la classe permettant de faire vivre le vivarium</b>
 * 
 */
public class VieAble implements Runnable {

	public Vector<Action> actionlist;
	public Carte carte;
	private boolean running;

	public VieAble(Carte c) {
		carte = c;
		actionlist = new Vector<Action>();
		running = true;
	}

	public void run() {
		synchronized (ThreadUtil.class) {
			while(running) {
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

	public void stop() {
		this.running = false;
	}

	/**
	 * Fait la mise a jour des divers elements suivant les actions
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
	 * Effectue les actions des individus
	 */
	public void perform(){
		System.out.println("Perform");
		int individu = 0;
		for (int i = 0; i < carte.getPlateau()[0].length; i++) {
			for (int j = 0; j < carte.getPlateau()[1].length; j++) {
				if(carte.getPlateau()[i][j].getIndividu() != null) {
					
					if(individu < actionlist.size()) {
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
					}
					
					individu++;
				}
			}
		}
	}

}