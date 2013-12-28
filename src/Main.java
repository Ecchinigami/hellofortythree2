import model.BuilderXML;
import view.FenetreJeu;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BuilderXML b = new BuilderXML();
		b.chargmentXML("./res/xml/exemple2.xml");
		FenetreJeu fp = new FenetreJeu();
	}

}
