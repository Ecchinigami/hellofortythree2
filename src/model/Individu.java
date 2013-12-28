package model;


public abstract class Individu{

	protected int vie;
	protected int attaque;
    
    // A FAIRE
    public Action live(){
            
            Action val = new Action();
            
            return val;
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

}