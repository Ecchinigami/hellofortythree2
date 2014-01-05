package model;

public abstract class Individu implements Comportement{

	protected int vie;
	protected int attaque;

	public Action live(){

		System.out.println("-> Je suis un : "+this.toString());
		
//		perception();
//		decision();
//		return action(null, null, null);
		
		return new Action("bas",null,null);
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