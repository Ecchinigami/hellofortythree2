package model;

public abstract class CaseDale {

    private boolean accessible;
    
    private Objet objet;
    private Individu individu;
    
    public CaseDale(boolean accessible) {
    	this.setAccessible(accessible);
    	
    	this.objet = null;
    	this.individu = null;
    }

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public void setObjet(String type) {
    	switch (type) {
	        case "nourriture":	objet = new Nourriture(type);
	        	break;
	        default: objet=null;
	        	break;
    	}
    }
    
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
    
    public boolean getAccessible() {
		return accessible;
	}
    
    public Objet getObjet() {
		return objet;    	
    }
    
    public Individu getIndividu() {
		return individu;    	
    }
}