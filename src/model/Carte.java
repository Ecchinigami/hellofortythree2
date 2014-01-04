package model;

import java.util.Vector;

public class Carte {

	public CaseDale[][] plateau;
	private String[][] decor;

	
    public void Carte() {
            plateau = null;
            decor = null;
    }
    
    public void initCarte(String[][][] carte) {
            
            this.plateau = new CaseDale[carte[0].length][carte[1].length];
            this.decor = new String[carte[0].length][carte[1].length];
            
            for (int i = 0; i < carte[0].length; i++) {
                    for (int j = 0; j < carte[1].length; j++) {

                    	this.plateau[i][j] = new CaseDale();
                        
                    	String decor = carte[i][j][0];
                        String individu = carte[i][j][1];
                        String objet = carte[i][j][2];
                        
                        this.plateau[i][j].setIndividu(individu);
                        this.plateau[i][j].setObjet(objet);
                        
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

	
	public CaseDale[][] getPlateau() {
		return plateau;
	}
	public String[][] getDecor() {
		return decor;
	}

}
