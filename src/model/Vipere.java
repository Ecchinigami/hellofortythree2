package model;

public class Vipere extends Individu {

	public Vipere() {
        this.vie = 10;
        this.attaque = 2;
	}
	
	public Vipere(int vie, int attaque) {
        this.vie = vie;
        this.attaque = attaque;
	}
	
	public String toString() {
		return "vipere";
	}
}
