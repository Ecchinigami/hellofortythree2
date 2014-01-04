package model;

public class Action {
	private String direction;
	private Individu attaque;
	private Objet mange;
	
	public Action(String direction, Individu attaque, Objet mange) {
		this.direction = direction;
		this.attaque = attaque;
		this.mange = mange;
	}
}
