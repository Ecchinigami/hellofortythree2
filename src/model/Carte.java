package model;

import java.util.Vector;

public class Carte {

	public CaseDale[][] plateau;
    
    public void Carte() {
            plateau = null;
    }
    
    public void initCarte(String[][][] carte) {
            
            plateau = new CaseDale[carte[0].length][carte[1].length];
            
            for (int i = 0; i < carte[0].length; i++) {
                    for (int j = 0; j < carte[1].length; j++) {
                            String decor = carte[i][j][0];
                            String individu = carte[i][j][1];
                            String objet = carte[i][j][2];
                            
                            plateau[i][j].setIndividu(individu);
                            plateau[i][j].setObjet(objet);
                            
                            if(decor.equals("stone")) {
                                    plateau[i][j].setAccessible(false);
                            }
                            else {
                                    plateau[i][j].setAccessible(true);
                            }
                    }
            }
    }

}