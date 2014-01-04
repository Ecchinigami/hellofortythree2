package model;

/** <b>La Classe Objet représente la classe-mère des différents objets qui peuvent être placés sur une case de la Carte.</b>
 * <p>Objet est donc la classe où ne sont représentés que les éléments autres que les individus vivant dans le vivarium, tels que :
 * <ul>
 * <li>Les obstacles</li>
 * <li>Les pieges</li>
 * <li>La nourriture</li>
 * <li>Le Poison</li>
 * </ul>
 * </p>
 * <p>L'objet est caractérisé par son nom.</p>
 *
 */
public abstract class Objet {

	/**
 * Le nom de l'objet
 */	
    protected String nom;

    /**
 * Retourn la valeur du nom de l'objet
 * @return Le nom de l'objet sous forme de String
 */
	public String getName(){
            return this.nom;
    }
}