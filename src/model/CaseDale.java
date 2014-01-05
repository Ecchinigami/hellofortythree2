package model;


/**
 * <b>CaseDale est la classe représentant les cases de la Carte</b>
 */
public class CaseDale {

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
	 * Constructeur de CaseDale en précisant que la case est accessible
	 */
    public CaseDale() {
    	this.setAccessible(true);    	
    	this.objet = null;
    	this.individu = null;
    }
    
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
     * Vérifie si la case est ou non accessible
     * @return L'état de la case
     */
	public boolean getAccessible() {
		return accessible;
	}

	/**
	 * initialise le type de l'objet
	 * @param type Le type de l'objet à placer
	 */
	public void initObjet(String type) {
		switch (type) {
	        case "pomme":	objet = new Nourriture(type);
	        	break;
	        default: objet=null;
	        	break;
		}
	}

	/**
	 * Permet de placer un objet sur la case
	 * @param objet L'objet à placer
	 */
	public void setObjet(Objet objet) {
		this.objet = objet;    	
    }
    
	/**
     * Cherche à savoir quel objet est présent
     * @return L'objet présent sur la case de la carte
     */
    public Objet getObjet() {
		return objet;    	
	}

    /**
	 * initialise le type de l'individu
	 * @param type Le type de l'individu à placer
	 */
	public void initIndividu(String type) {
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
	 * Permet de placer un individu sur la case
	 * @param individu L'individu à placer
	 */
	public void setIndividu(Individu individu) {	
		this.individu = individu; 
    }
    
    /**
     * Cherche à savoir quel individu est présent
     * @return L'individu présent sur la case de la carte.
     */
    public Individu getIndividu() {
		return individu;    	
    }
}