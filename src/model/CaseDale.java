package model;

/**
 * <b>CaseDale est la classe représentant les cases de la Carte</b>
 */
public abstract class CaseDale {

	/**
	 * Accessible est un booléen qui permet de savoir si la case est ou non occupée 
	 */
    private boolean accessible;
    
    /**
     * L'objet (Poison, nourriture, piège, obstacle)
     */
    private Objet objet;
    
    /**
     * L'individu (Poule, renard, vipère)
     */
    private Individu individu;
    
    /**
     * Rend la case accessible en enlevant les objet et individu éventuellement présents sur la case
     * @param accessible La case est accessible
     */
    public CaseDale(boolean accessible) {
    	this.setAccessible(accessible);
    	
    	this.objet = null;
    	this.individu = null;
    }

    /**
     * Rend la case accessible
     * @param accessible Renvoie que la case est accessible
     */
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	/**
	 * Permet de placer un objet sur une case
	 * @param type Le type de l'objet à placer
	 */
	public void setObjet(String type) {
    	switch (type) {
	        case "nourriture":	objet = new Nourriture(type);
	        	break;
	        default: objet=null;
	        	break;
    	}
    }
    
    /**
     * Permet de placer un individu sur une case
     * @param type Le type de l'individu à placer
     */
	public void setIndividu(String type) {
    	switch (type) {
	        case "poule":	individu = new Poule();
	        	break;
	        case "renard":	individu = new Renard();
        		break;
	        case "vipere":	individu = new Vipere();
        		break;
	        default: individu=null;
        		break;
		}
    }
    
    /**
     * Vérifie si la case est ou non accessible
     * @return L'état de la case
     */
    public boolean getAccessible() {
		return accessible;
	}
    
    /**
     * Cherche à savoir quel objet est présent
     * @return L'objet présent sur la case de la carte
     */
    public Objet getObjet() {
		return objet;    	
    }
    
    /**
     * Cherche à savoir quel individu est présent
     * @return L'individu présent sur la case de la carte.
     */
    public Individu getIndividu() {
		return individu;    	
    }
}