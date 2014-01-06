package model;

/**
 * <b>Comportement est la classe caract�risant le comportement des individus</b>
 * <p>Cette classe se traduit donc par :
 * <ul>
 * <li>La perception de l'individu</li>
 * <li>Sa d�cision par rapport � ce qu'il a per�u</li>
 * <li>et enfin, l'action que l'individu effectuera</li>
 * </ul>
 * </p>
 */
public interface Comportement {
	
	/**
	 * L'individu prend conscience de l'environnement qui l'entoure
	 */
	String[][] perception(Carte c, int posx, int posy);
    
	/**
	 * L'individu prend une décision
	 */
	String[] decision(String[][] portee);
    
    /**
     * L'individu réalsie l'action dont il a décidé
     */
    Action action(String[] direction, Carte c);
}
