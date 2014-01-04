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
		int i, j;
		CaseDale tab[][] = BtnCarte.map.getPlateau();
    	int taille = tab.length;
 
    	for(i = 0 ; i < taille ; i++){
    		for(j = 0 ; j < taille ; j++){
        		if (tab[i][j].getIndividu().toString() != "vide"){
        			System.out.println(tab[i][j].getIndividu().toString());
        			actionlist[actionlist.length] =  tab[i][j].getIndividu().live(i,j);
        		}
    		}
    	}
    }
	
    public void perform(){
    	
    	int i;
    	CaseDale tab[][] = BtnCarte.map.getPlateau();

    	for (i = 0 ; i < actionlist.length ; i++){
    		
    		Action uneAction = actionlist[i];
    		int newx, newy;
    		newx = uneAction.posx;
    		newy = uneAction.posy;
    		
    		switch(uneAction.direction){
	    		case "haut" :
	    			newy = uneAction.posy - 1;
	    			break;
	    		case "bas" :
	    			newy = uneAction.posy + 1;
	    			break;
	    		case "gauche" :
	    			newx = uneAction.posx - 1;
	    			break;
	    		case "droite" :
	    			newx = uneAction.posx + 1;
	    			break;
    		}
    		if(newx != uneAction.posx || newy != uneAction.posy){
    			tab[newx][newy].setIndividu(tab[uneAction.posx][uneAction.posy].getIndividu().toString());
    			tab[uneAction.posx][uneAction.posy].setIndividu("vide");
    		}
    		if(uneAction.mange != null){
    			tab[uneAction.posx][uneAction.posy].setObjet("vide");
    		}
    		System.out.println("On a fait une action !");
    	}

    }
}