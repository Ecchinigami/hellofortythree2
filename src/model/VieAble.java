package model;

import java.util.ArrayList;
import java.util.Vector;

import controller.BtnCarte;


public class VieAble extends Thread {
	
	public ArrayList<Action> actionlist;

	
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
        		if (tab[i][j].getIndividu() != null){
        			System.out.println(tab[i][j].getIndividu().toString());
        			try{
        				actionlist.add(tab[i][j].getIndividu().live(i,j));
        			}catch(NullPointerException e){
        				
        			}
        			
        		}
    		}
    	}
    }
	
    public void perform(){
    	
    	int i;
    	CaseDale tab[][] = BtnCarte.map.getPlateau();
    	for (i = 0 ; i < actionlist.size() ; i++){
    		
    		Action uneAction = actionlist.get(i);
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