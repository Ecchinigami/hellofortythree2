package model;

/**
 * <b>Individu est la classe repr�sentant un Individu dans le jeu</b>
 * <p>L'individu a un comportement sp�cifique � chaque esp�ce d'individu</p>
 * <p>Un individu est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un nom</li>
 * <li>Une certaine force d'attaque</p>
 * </ul></p>
 */
public abstract class Individu implements Comportement{

	/**
	 * Le nombre de points de vie de l'individu sous forme d'un entier.
	 * 
	 * @see Individu#getVie()
	 * @see Individu#ajouteVie(int)
	 * @see Individu#retireVie(int)
	 */
	protected int vie;
	
	 /**
     * La force d'attaque de l'individu en question, sous la forme d'un nombre entier.
     * 
     * @see Individu#getAttaque()
     * 
     */
	protected int attaque;

	/**
     * Pour faire vivre (manger, attaquer et d�placer) l'individu en fonction de son environnement
     * 
     * @return la valeur de l'action que l'individu fait sous la forme d'une Action.
     */
	public Action live(){

		System.out.println("-> Je suis un : "+this.toString());
		
//		perception();
//		decision();
//		return action(null, null, null);
		
		return new Action("bas",null,null);
	}

	/**
     * Retourne la vie de l'individu
     * @return Le nombre de points de vie de l'individu, sous la forme d'un entier.
     */
	public int getVie(){
		return this.vie;
	}

	/**
     * Retourne la valeur de la force d'attaque de l'individu
     * @return La force d'attaque de l'individu, sous la forme d'un entier.
     */
	public int getAttaque(){
		return this.attaque;
	}
	
	/**
     * Ajoute un certain nombre de points de vie � l'individu
     * @param soin La valeur ajout�e � la vie actuelle de l'individu
     */
	public void ajouteVie(int soin){
		this.vie += soin;            
	}

	/**
     * Retire un certain nombre de points de vie � l'individu
     * @param dommage La valeur retir�e � la vie actuelle de l'individu
     */
	public void retireVie(int dommage){
		this.vie = this.vie - dommage;
	}

	public abstract String toString();
}