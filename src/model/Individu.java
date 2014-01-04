package model;

import view.Plateau;
import controller.BtnCarte;
import controller.BtnListener;

public abstract class Individu extends Comportement{

	protected int vie;
	protected int attaque;
    
    // A FAIRE
    public Action live(int posx, int posy){
    	
    	Action val = new Action();
    	String mouvement = "";
    	CaseDale tab[][] = BtnCarte.map.getPlateau();
    	int taille = tab.length;
    	// Varibale servant à faire tourner sur lui même l'individu jusqu'à trouver une case libre devant lui
    	int tentative = 0;
    	// On regarde ce qui se trouve autour de l'individu courrant
		String[][] aire = this.perception(tab, posx, posy);
		// L'individu décide du mouvement à effectuer
		mouvement = tab[posx][posy].getIndividu().decision(aire, tab[posx][posy].getIndividu().toString());
		// Cas particulier, si l'individu décide de chercher de la nourriture (Pas d'individu aux alentours)
		if (mouvement == "manger"){
			mouvement = chercheNourriture(tab, posx, posy, taille);
		}
		// Mouvement de base, si rien est intéressant aux alentours, on se dirige à droite du plateau
		if(mouvement == ""){
			mouvement = "droite";
		}
		
        while((this.CaseLibre(tab, mouvement, posx, posy) == false) && (tentative < 4)){
        	switch(mouvement){
	        	case "haut" :
	        		mouvement = "gauche";
	    			break;
	    		case "bas" :
	    			mouvement = "droite";
	    			break;
	    		case "gauche" :
	    			mouvement = "bas";
	    			break;
	    		case "droite" :
	    			mouvement = "haut";
	    			break;
	       	}
	        tentative++;
        }
        if (tentative == 4){
        	val.direction = "aucune";
        	val.attaque = null;
        	val.mange = null;
        	if (tab[posx][posy].getObjet().toString() != "pomme"){
        		val.mange = tab[posx][posy].getObjet();
        		this.ajouteVie(3);
        		System.out.println("Youhou ! L'individu : "+tab[posx][posy].getIndividu().toString()+" a mangé "+tab[posx][posy].getObjet().toString()+" ! Miamm !");
        	}
        	if (tab[posx][posy].getObjet().toString() != "posion"){
        		val.mange = tab[posx][posy].getObjet();
        		this.retireVie(3);
        		System.out.println("Mince ! L'individu : "+tab[posx][posy].getIndividu().toString()+" a mangé "+tab[posx][posy].getObjet().toString()+" ! Blurp !");
        	}
        }else{
        	if (this.CaseLibre(tab, mouvement, posx, posy) == false){
        		Individu victime = getVictime(tab, mouvement, posx, posy);
        		val.direction = "";
        		val.attaque = this.getVictime(tab, mouvement, posx, posy);
        		System.out.println("Et un combat commence entre "+tab[posx][posy].getIndividu().toString()+" et "+this.getVictime(tab, mouvement, posx, posy).toString()+" !");
        		val.mange = null;
        		this.getVictime(tab, mouvement, posx, posy).retireVie(this.getAttaque());
        		if (this.getVictime(tab, mouvement, posx, posy).getVie() <= 0){
        			System.out.println(" Et Paf, son opposant est mort !");
        		}
        	}
        	val.direction = mouvement;
        	val.attaque = null;
        	val.mange = null;
        	
        }
        
        return val;
    }
    
    private Individu getVictime(CaseDale[][] tab, String  mouvement, int posx, int posy){
    	
    	int newposx, newposy;
    	newposx = posx;
    	newposy = posy;
    	switch(mouvement){
    		case "haut" :
    			newposy = newposy - 1;
    			break;
    		case "bas" :
    			newposy = newposy + 1;
    			break;
    		case "gauche" :
    			newposx = newposx - 1;
    			break;
    		case "droite" :
    			newposx = newposx + 1;
    			break;
    	}
    	
    	return tab[newposx][newposy].getIndividu();
    }
    
    private boolean CaseLibre(CaseDale[][] c, String direction, int posx, int posy){
    	boolean libre = false;
    	boolean mur = false;
    	int newposx, newposy;
    	newposx = posx;
    	newposy = posy;
    	switch(direction){
    		case "haut" :
    			newposy = newposy - 1;
    			break;
    		case "bas" :
    			newposy = newposy + 1;
    			break;
    		case "gauche" :
    			newposx = newposx - 1;
    			break;
    		case "droite" :
    			newposx = newposx + 1;
    			break;
    	}
    	if(newposx >= c.length|| newposx < 0 || newposy >= c.length || newposy < 0 ){
    		mur = true;
    	}
    	if (mur == false){
	    	if (c[posx][posy].getIndividu().toString() != c[newposx][newposy].getIndividu().toString() && c[posx][posy].getAccessible() == true){
	    		libre = true;
	    	}
    	}
    	if(direction == "aucune"){
    		libre = true;
    	}
    	return libre;
    }
    
    private static String chercheNourriture(CaseDale[][] c, int posx, int posy, int taille){
    	
    	String[][] aire = new String[taille][taille];
    	String direction = "";
    	int i, j, xNourriture, yNourriture;
    	xNourriture = -1000;
    	yNourriture = -1000;
    	int distanceA;
    	for(i = 0 ; i < taille ; i++){
    		for(j = 0; j < taille ; j++){
    			if(c[i][j].getObjet().toString() != "vide"){
    				distanceA = (posx-xNourriture)+(posy-yNourriture);
    		    	if (distanceA < 0){
    		    		distanceA = -distanceA;
    		    	}
    				int distanceB = (i-xNourriture)+(j-yNourriture);
    				if (distanceB < 0){
    		    		distanceB = -distanceB;
    		    	}
    				if (distanceB < distanceA){
    					xNourriture = i;
    					yNourriture = j;
    				}
    			}
    		}
    	}
    	if(posx - xNourriture > 0 ){
    		direction = "gauche";
		}else if (posx - xNourriture < 0){
			direction = "droite";
		}else if (posy - yNourriture > 0){
			direction = "haut";
		}else if (posy - yNourriture < 0){
			direction = "bas";
		}else if(posy - yNourriture == 0 && posx - xNourriture == 0){
			direction = "aucune";
		}
    	
    	return direction;
    }
    
    String[][] perception(CaseDale[][] c, int x, int y){
    	
    	String[][] aire = new String[3][3];
    	aire[1][1] = "vide";
    	aire[0][0] = c[x-1][y-1].getIndividu().toString();
    	aire[0][1] = c[x][y-1].getIndividu().toString();
    	aire[0][2] = c[x+1][y-1].getIndividu().toString();
    	aire[1][0] = c[x-1][y].getIndividu().toString();
    	aire[1][2] = c[x+1][y].getIndividu().toString();
    	aire[2][0] = c[x-1][y+1].getIndividu().toString();
    	aire[2][1] = c[x][y+1].getIndividu().toString();
    	aire[2][2] = c[x+1][y+1].getIndividu().toString();
    	
    	return aire;
    }
   
	String decision(String[][] aire, String individu){
		int i,j, predateur, proie;
		int posxProie, posyProie, posxPre, posyPre;
		String ordre, mouvement;
		predateur = 0;
		proie = 0;
		posxProie = 10;
		posyProie = 10;
		posxPre = 10;
		posyPre = 10;
		ordre = "";
		for(i = 0 ; i < 3 ; i++){
    		for(j = 0 ; j < 3 ; j++){
				switch(individu){
					case "poule":
						if (aire[i][j] == "renard"){
							predateur++;
							posxPre = i-1;
							posyPre = j-1;
						}
						if (aire[i][j] == "vipere"){
							proie++;
							posxProie = i-1;
							posyProie = j-1;
						}
						break;
					case "renard":
						if (aire[i][j] == "vipere"){
							predateur++;
							posxPre = i-1;
							posyPre = j-1;
						}
						if (aire[i][j] == "poule"){
							proie++;
							posxProie = i-1;
							posyProie = j-1;
						}
						break;
					case "vipere":
						if (aire[i][j] == "poule"){
							predateur++;
							posxPre = i-1;
							posyPre = j-1;
						}
						if (aire[i][j] == "renard"){
							proie++;
							posxProie = i-1;
							posyProie = j-1;
						}
						break;
				}
    		}
    	}
		
	    if (predateur > 0){
	    	ordre = "fuir";
	    	mouvement = action(ordre, posxPre, posyPre);
	    }
	    else if(proie > 0 && predateur == 0){
	    	ordre = "traquer";
	    	mouvement = action(ordre, posxProie, posyProie);
	    }
	    else{
	       	ordre = "manger";
	    	mouvement = action(ordre, 0, 0);
	    }
	    return mouvement;
	}
	String action(String ordre, int posx, int posy){
		
		String choix = "";
		switch(ordre){
			case "fuir":
				if(posx > 0 ){
					choix = "gauche";
				}else if (posx < 0){
					choix = "droite";
				}else if (posy > 0){
					choix = "bas";
				}else if (posy < 0){
					choix = "haut";
				}
			case "traquer":
				if(posx < 0 ){
					choix = "gauche";
				}else if (posx > 0){
					choix = "droite";
				}else if (posy < 0){
					choix = "bas";
				}else if (posy > 0){
					choix = "haut";
				}
			case "manger" :
				choix = "manger";
		}
		return choix;
			 	
	}
    public int getVie(){
            return this.vie;
    }
    
    public int getAttaque(){
            return this.attaque;
    }
    
    public void ajouteVie(int soin){
            this.vie += soin;            
    }
    
    public void retireVie(int dommage){
            this.vie = this.vie - dommage;
    }
    
    public abstract String toString();

}
