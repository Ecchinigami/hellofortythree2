package model;

import java.util.Vector;

public class Objet extends CaseDale {

    public Carte myCarte;
    public Vector  myCase_dale;

    private String nom;
    
    public String getName(){
    	return this.nom;
    }
}