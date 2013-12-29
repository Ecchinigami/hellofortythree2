package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.CaseDale;
import model.Poule;
import model.Renard;
import model.Vipere;

public class Plateau extends JPanel {
	
	CaseDale[][] plateau;

	public Plateau(CaseDale[][] plateau) {
		this.plateau = plateau;
		
		setBackground(Color.DARK_GRAY);
	}

	public void paint(Graphics g) {
		super.paint(g);

		// Récupération de la taille du panel
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();

		// Calcul des dimensions des blocks
		int nbBlockWidth = plateau[0].length;
		int nbBlockHeigh = plateau[1].length;
		int squareSize = 30;

		// Calcul des marges
		int marginWidth = (int) ((w%squareSize)/2);
//		if(marginWidth==0)
//			marginWidth=(int) squareSize/2;
		int marginHeight = (int) ((h%squareSize)/2);
//		if(marginHeight==0)
//			marginHeight=(int) squareSize/2;

		// Chargement des images
		Image wood = new ImageIcon("./res/image/block/wood.png").getImage();
		Image stone = new ImageIcon("./res/image/block/stone.png").getImage();
		Image grass = new ImageIcon("./res/image/block/grass.png").getImage();
		Image dirt = new ImageIcon("./res/image/block/dirt.png").getImage();
		
		Image pomme = new ImageIcon("./res/image/item/apple.png").getImage();
		
		Image whiteDownStand = new ImageIcon("./res/image/white/downStand.png").getImage();

		// Dessin des cases du Plateau
		int blockHeigh=0;
		int blockWidth=0;
		
		for(int i=marginWidth; i<w-squareSize; i+=squareSize) {
			for(int j=marginHeight; j<h-squareSize; j+=squareSize) {
				
				if(blockWidth<nbBlockWidth && blockHeigh<nbBlockHeigh) {
					if(plateau[blockHeigh][blockWidth].getObjet()!=null) {
						switch (plateau[blockHeigh][blockWidth].getObjet().getName()) {
					        case "pomme":	g.drawImage(pomme, i, j, squareSize, squareSize, null);
					        	break;	
						}
					}
				}

				blockHeigh++;
			}
			blockWidth++;
		}
	}
}
