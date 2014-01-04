package model;

/**
 * <b>CaseDale est la classe repr�sentant les cases de la Carte</b>
 */
public abstract class CaseDale {

	/**
	 * Accessible est un bool�en qui permet de savoir si la case est ou non occup�e 
	 */
    private boolean accessible;
    
    /**
     * L'objet (Poison, nourriture, pi�ge, obstacle)
     */
    private Objet objet;
    
    /**
     * L'individu (Poule, renard, vip�re)
     */
    private Individu individu;
    
    /**
     * Rend la case accessible en enlevant les objet et individu �ventuellement pr�sents sur la case
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
	 * @param type Le type de l'objet � placer
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
     * @param type Le type de l'individu � placer
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
     * V�rifie si la case est ou non accessible
     * @return L'�tat de la case
     */
    public boolean getAccessible() {
		return accessible;
	}
    
    /**
     * Cherche � savoir quel objet est pr�sent
     * @return L'objet pr�sent sur la case de la carte
     */
    public Objet getObjet() {
		return objet;    	
    }
    
    /**
     * Cherche � savoir quel individu est pr�sent
     * @return L'individu pr�sent sur la case de la carte.
     */
    public Individu getIndividu() {
		return individu;    	
    }
}