package model;

/** <b>La Classe Objet repr�sente la classe-m�re des diff�rents objets qui peuvent �tre plac�s sur une case de la Carte.</b>
 * <p>Objet est donc la classe o� ne sont repr�sent�s que les �l�ments autres que les individus vivant dans le vivarium, tels que :
 * <ul>
 * <li>Les obstacles</li>
 * <li>Les pieges</li>
 * <li>La nourriture</li>
 * <li>Le Poison</li>
 * </ul>
 * </p>
 * <p>L'objet est caract�ris� par son nom.</p>
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