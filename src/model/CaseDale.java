package model;

public abstract class CaseDale {

    public boolean accessible;
    
    public Objet objet;
    public Individu individu;
    
    public CaseDale(boolean accessible) {
    	this.accessible = accessible;
    	
    	this.objet = null;
    	this.individu = null;
    }
    
    public void setObjet(String nom, String type) {
    	switch (type) {
	        case "nourriture":	objet = new Nourriture(nom);
	        	break;
    	}
    }
    
    public void setIndividu() {
    	
    }
    
    public Objet getObjet() {
		return objet;    	
    }
    
    public Individu getIndividu() {
		return individu;    	
    }
}