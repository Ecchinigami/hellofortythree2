package view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 * <b>Cette classe personnalise l'aspect des boutons</b>
 */
public class Bouton extends JButton{

	/**
	 * Le nom du bouton
	 */
	private String name;

	/**
	 * Constructeur du bouton
	 * @param str Le nom associ� au bouton
	 */
	public Bouton(String str){
		super(str);

		this.name = str;  
	}
	
	/**
	 * Permet de personnaliser le bouton
	 */
	@Override
	public void paintComponent(Graphics g){

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Objet qui permet de connaître la taille d'une police
		FontMetrics fm = g.getFontMetrics();
		// Hauteur de la police d'écriture
		int height = fm.getHeight();
		// Largeur totale de la chaîne passée en paramètre
		int width = fm.stringWidth(this.name);

		g.setColor(Color.WHITE);
		// Calcul de la position du texte dans le bouton
		g.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
	}
}
