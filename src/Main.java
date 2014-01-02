import model.BuilderXML;
import model.Carte;
import view.FenetreJeu;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FenetreJeu f = new FenetreJeu();
		BuilderXML b = new BuilderXML();
		
		Carte c = new Carte();
		c.initCarte(b.chargmentXML("./res/xml/exemple4x4.xml"));
		
		f.displayGame(c);
	}

}
