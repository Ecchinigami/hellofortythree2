package model;

import java.util.Vector;

import controller.BtnCarte;


public class VieAble extends Thread {
	
	public Action actionlist[];
	
	public void run(){
		while (true){
			upDate();
			perform();
		}
	}
	public void upDate(){
		int i, j, compteur;
		compteur = 0;
		CaseDale tab[][] = BtnCarte.map.getPlateau();
    	int taille = tab.length;
 
    	for(i = 0 ; i < taille ; i++){
    		for(j = 0 ; j < taille ; j++){
        		if (tab[i][j].getIndividu().toString() != "vide"){
        			actionlist[compteur] =  tab[i][j].getIndividu().live(i,j);
        			compteur++;
        		}
    		}
    	}
    }
    public void perform(){
            
    }

}