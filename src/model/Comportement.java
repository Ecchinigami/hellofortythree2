package model;

/**
 * <b>Comportement est la classe caract�risant le comportement des individus</b>
 * <p>Cette classe se traduit donc par :
 * <ul>
 * <li>La perception de l'individu</li>
 * <li>Sa d�cision par rapport � ce qu'il a per�u</li>
 * <li>et enfin, l'action que l'individu effectuera</li>
 * </ul></p>
 */
public interface Comportement {
	
	/**
	 * L'individu prend conscience de l'environnement qui l'entoure
	 */
	void perception();
    
	/**
	 * L'individu prend une d�cision
	 */
    void decision();
    
    /**
     * L'individu r�alsie l'action dont il a d�cid�
     */
    Action action(String direction, Individu attaque, Objet mange);
}
