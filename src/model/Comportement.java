package model;

/**
 * <b>Comportement est la classe caractérisant le comportement des individus</b>
 * <p>Cette classe se traduit donc par :
 * <ul>
 * <li>La perception de l'individu</li>
 * <li>Sa décision par rapport à ce qu'il a perçu</li>
 * <li>et enfin, l'action que l'individu effectuera</li>
 * </ul></p>
 */
public interface Comportement {
	
	/**
	 * L'individu prend conscience de l'environnement qui l'entoure
	 */
	void perception();
    
	/**
	 * L'individu prend une décision
	 */
    void decision();
    
    /**
     * L'individu réalsie l'action dont il a décidé
     */
    Action action(String direction, Individu attaque, Objet mange);
}
