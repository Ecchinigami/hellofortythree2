package model;

public class Renard extends Individu {

	public Renard() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	public Renard(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	public String toString() {
		return "renard";
	}
	
	public void perception() {
	}
	public void decision() {
	}
	public Action action(String direction, Individu attaque, Objet mange) {
		return new Action(direction, attaque, mange);
	}
}
