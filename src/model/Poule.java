package model;

import java.util.Random;


/**
 * <b>La classe Poule est héritée de la Classe "Individu"</b>
 * <p>Elle détaille ainsi les idividus "Poule" dans le vivarium</p>
 *
 */
public class Poule extends Individu {
	
	/**
	 * Constructeur par défaut de la poule
	 */
	public Poule() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	/**
	 * Construction de la poule en précisant sa vie et sa force d'attaque
	 * @param vie La vie de la poule
	 * @param attaque La force d'attaque de la poule
	 */
	public Poule(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	/**
	 * Affiche la poule
	 */
	public String toString() {
		return "poule";
	}
	
	/**
	 * Gestion de la perception de la poule
	 */
	public String[][] perception(Carte c, int posx, int posy) {
		
		CaseDale[][] plateau = c.getPlateau();
		String[][] aire = new String[3][3];
		
		System.out.println("x :"+posx+" et y :"+ posy);
		 
		
		// 1 Coin en haut à gauche
	    if(posx == 0 || posy == 0){
	    	aire[0][0] = "vide";
	    	System.out.println("1 "+aire[0][0]);
	    }else if(posx != 0 && posy != 0){
	    	if(plateau[posx-1][posy-1].getIndividu() != null){
	    		aire[0][0] = plateau[posx-1][posy-1].getIndividu().toString();
	    		System.out.println("1 "+aire[0][0]);
	    	}else{
	    		aire[0][0] = "vide";
		    	System.out.println("1 "+aire[0][0]);
	    	}
	    }

		// 2 Mur haut, longeur milieu
	    if(posx == 0){
	    	aire[0][1] = "vide";
	    	System.out.println("2 "+aire[0][1]);
	    }else{
	    	if(plateau[posx-1][posy].getIndividu() != null){
		    	aire[0][1] = plateau[posx-1][posy].getIndividu().toString();
		    	System.out.println("2 "+aire[0][1]);
	    	}else{
	    		aire[0][1] = "vide";
		    	System.out.println("2 "+aire[0][1]);
	    	}
	    }
	    
	    // 3 Coin en haut à droite
	    if(posx != 0 && posy != (plateau[1].length - 1)){
	    	if(plateau[posx-1][posy+1].getIndividu() != null){
	    		aire[0][2] = plateau[posx-1][posy+1].getIndividu().toString();
	    		System.out.println("3 "+aire[0][2]);
	    	}else{
	    		aire[0][2] = "vide";
		    	System.out.println("3 "+aire[0][2]);
	    	}
	    }
	    else{
	    	aire[0][2] = "vide";
	    	System.out.println("3 "+aire[0][2]);
	    }
	    
	    // 4 Mur gauche, hauteur milieu
	    if(posy == 0){
	    	aire[1][0] = "vide";
	    	System.out.println("4 "+aire[1][0]);
	    }else{
	    	if(plateau[posx][posy-1].getIndividu() != null){
		    	aire[1][0] = plateau[posx][posy-1].getIndividu().toString();
		    	System.out.println("4 "+aire[1][0]);
	    	}else{
	    		aire[1][0] = "vide";
		    	System.out.println("4 "+aire[1][0]);
	    	}
	    }
	    	    
	    // 5 Case du milieu
	    aire[1][1] = plateau[posx][posy].getIndividu().toString();
	    System.out.println("5 "+aire[1][1]);
	    
	    
	       // 6 Mur doite, hauteur milieu
	    if(posy != (plateau[1].length - 1)){
	    	if(plateau[posx][posy+1].getIndividu() != null){
		    	aire[1][2] = plateau[posx][posy+1].getIndividu().toString();
		    	System.out.println("6 "+aire[1][2]);
	    	}else{
	    		aire[1][2] = "vide";
		    	System.out.println("6 "+aire[1][2]);
	    	}
	    }else{
	    	aire[1][2] = "vide";
	    	System.out.println("6 "+aire[1][2]);
	    }
	    
	    // 7 Coin en bas à gauche
	    if(posx != (plateau[0].length - 1) && posy != 0){
	    	if(plateau[posx+1][posy-1].getIndividu() != null){
		    	aire[2][0] = plateau[posx+1][posy-1].getIndividu().toString();
		    	System.out.println("7 "+aire[2][0]);
	    	}else{
	    		aire[2][0] = "vide";
		    	System.out.println("7 "+aire[2][0]);
	    	}
	    }else{
	    	aire[2][0] = "vide";
	    	System.out.println("7 "+aire[2][0]);
	    }
	    
	    // 8 Mur bas, longueur milieu
	    if(posx != (plateau[0].length - 1)){
	    	if(plateau[posx+1][posy].getIndividu() != null){
		    	aire[2][1] = plateau[posx+1][posy].getIndividu().toString();
		    	System.out.println("8 "+aire[2][1]);
	    	}
	    	else{
	    		aire[2][1] = "vide";
		    	System.out.println("8 "+aire[2][1]);
	    	}
	    }else{
	    	aire[2][1] = "vide";
	    	System.out.println("8 "+aire[2][1]);
	    }
	       // 9 Coin en bas à droite
	    if(posy != (plateau[1].length - 1) && posx != (plateau[0].length - 1)){
	    	if(plateau[posx+1][posy+1].getIndividu() != null){
		    	aire[2][2] = plateau[posx+1][posy+1].getIndividu().toString();
		    	System.out.println("9 "+aire[2][2]);
	    	}else{
	    		aire[2][2] = "vide";
		    	System.out.println("9 "+aire[2][2]);
	    	}
	    }else{
	    	aire[2][2] = "vide";
	    	System.out.println("9 "+aire[2][2]);
	    }
	      
	    System.out.println("La, on a notre portée");
	    return aire;
	}
	
	/**
	 * Gestion des décisions de la poule
	 */
	public String[] decision(String[][] portee) {
		
		String[] decision = new String[4];
		int i, j, predateur, proie, posxPre, posyPre, posxProie, posyProie;
		int dimensionx = portee[0].length;
		int dimensiony = portee[1].length;
		String individu = portee[((dimensionx-1)/2)][((dimensiony-1)/2)];
		proie = 0;
		predateur = 0;
		posxPre = 0;
		posyPre = 0;
		posxProie = 0;
		posyProie = 0;
		for(i = 0 ; i < dimensionx ; i++){
			for(j = 0 ; j < dimensiony ; j++){
				if(i != ((dimensionx-1)/2) && j != ((dimensiony-1)/2)){
					switch(individu){
			            case "poule":
			              if (portee[i][j] == "renard"){
			            	System.out.println("Predateur++");
			                predateur++;
			                posxPre = i;
			                posyPre = j;
			              }
			              if (portee[i][j] == "vipere"){
			                proie++;
			                posxProie = i;
			                posyProie = j;
			                System.out.println("Proie++");
			              }
			            case "renard":
			              if (portee[i][j] == "vipere"){
			                predateur++;
			                posxPre = i;
			                posyPre = j;
			                System.out.println("Predateur++");
			              }
			              if (portee[i][j] == "poule"){
			                proie++;
			                posxProie = i;
			                posyProie = j;
			                System.out.println("Proie++");
			              }
			            case "vipere":
			              if (portee[i][j] == "poule"){
			                predateur++;
			                posxPre = i;
			                posyPre = j;
			                System.out.println("Predateur++");
			              }
			              if (portee[i][j] == "renard"){
			                proie++;
			                posxProie = i;
			                posyProie = j;
			                System.out.println("Proie++");
			              }
		          }
				}
			}
		}
		
		if(predateur != 0){
			decision[0] = "fuir";
			decision[1] = ""+posxPre;
			decision[2] = ""+posyPre;
		}
		if(proie != 0 && predateur == 0){
			decision[0] = "attaque";
			decision[1] = ""+posxProie;
			decision[2] = ""+posyProie;
		}
		if(proie == 0 && predateur == 0){
			decision[0] = "manger";
		}
		decision[3] = ""+dimensionx;
		System.out.println("La, on a notre décision : "+decision[0]);
		return decision;
	}
	
	/**
	 * Action que la poule effectue
	 */
	public Action action(String[] direction) {
		String sens = "aucun";
	      switch(direction[0]){
	        case "fuir":
	          if(Integer.parseInt(direction[1]) > 0 ){
	        	  sens = "gauche";
	          }else if (Integer.parseInt(direction[1]) < 0){
	        	  sens = "droite";
	          }else if (Integer.parseInt(direction[2]) > 0){
	        	  sens = "bas";
	          }else if (Integer.parseInt(direction[2]) < 0){
	        	  sens = "haut";
	          }
	        case "traquer":
	          if(Integer.parseInt(direction[1]) < 0 ){
	        	  sens = "gauche";
	          }else if (Integer.parseInt(direction[1]) > 0){
	        	  sens = "droite";
	          }else if (Integer.parseInt(direction[2]) < 0){
	        	  sens = "bas";
	          }else if (Integer.parseInt(direction[2]) > 0){
	        	  sens = "haut";
	          }
	        case "manger" :
	        	Random r = new Random();
	    		int rand = 1 + r.nextInt(4);
	    		switch (rand) {
	    		case 1:
	    			sens = "bas";
	    			break;
	    		case 2:
	    			sens = "haut";
	    			break;
	    		case 3:
	    			sens = "gauche";
	    			break;
	    		case 4:
	    			sens = "droite";
	    			break;
	    		}
	        	//String destination = "";
	        	//destination = perception(Integer.parseInt(direction[1]),Integer.parseInt(direction[2]));
	          
	      }
	      System.out.println("La, on a notre action : direction : " + sens);
	      return new Action(sens, null, null);
	}
}