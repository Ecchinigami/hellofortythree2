package model;

public class Poule extends Individu {
	
	public Poule() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	public Poule(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	public String toString() {
		return "poule";
	}
	
	public void perception() {
	}
	public void decision() {
	}
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
