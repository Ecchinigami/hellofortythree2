package model;

public class CaseDale {

    private boolean accessible;
    
    private Objet objet;
    private Individu individu;
    
    public CaseDale() {
    	this.setAccessible(true);    	
    	this.objet = null;
    	this.individu = null;
    }
    
    public CaseDale(boolean accessible) {
    	this.setAccessible(accessible);
    	
    	this.objet = null;
    	this.individu = null;
    }

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public boolean getAccessible() {
		return accessible;
	}

	public void initObjet(String type) {
		switch (type) {
	        case "pomme":	objet = new Nourriture(type);
	        	break;
	        default: objet=null;
	        	break;
		}
	}

	public void setObjet(Objet objet) {
		this.objet = objet;    	
    }
    
    public Objet getObjet() {
		return objet;    	
	}

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

	public void setIndividu(Individu individu) {	
		this.individu = individu; 
    }
    
    public Individu getIndividu() {
		return individu;    	
    }
}