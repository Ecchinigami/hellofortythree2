import model.BuilderXML;
import view.FenetreJeu;

/**
 * <b>Classe principale du vivarium</b>
 */
public class Main {

	/**
	 * La méthode main permet de charger la carte sur laquelle on veut jouer
	 *
	 */
	public static void main(String[] args) {
		//FenetreJeu f = new FenetreJeu();
		BuilderXML b = new BuilderXML();
		b.chargmentXML("./res/xml/exemple2.xml");
	}

}
