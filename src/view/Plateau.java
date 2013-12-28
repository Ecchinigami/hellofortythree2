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

import model.BuilderXML;

public class Plateau extends JPanel {
	
	public Plateau() {		
		setBackground(Color.DARK_GRAY);
	}

	public void paint(Graphics g) {
        super.paint(g);

        // Récupération de la taille du panel
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        //h = BuilderXML.hauteurTab;
        //w = BuilderXML.largeurTab;

        // Init de var en vrac'
        int squareSize = 30;
        boolean color = true;
        g.setColor(Color.DARK_GRAY);

        // Calcul des marges
        int marginWidth = (int) ((w%squareSize)/2);
        if(marginWidth==0)
                marginWidth=(int) squareSize/2;
        int marginHeight = (int) ((h%squareSize)/2);
        if(marginHeight==0)
                marginHeight=(int) squareSize/2;

        // Chargement des images
        Image grass = new ImageIcon("./res/image/block/stone.png").getImage();
        Image stone = new ImageIcon("./res/image/block/wood.png").getImage();

        // Dessin des cases du Plateau
        for(int i=marginWidth; i<w-squareSize; i+=squareSize) {
                for(int j=marginHeight; j<h-squareSize; j+=squareSize) {

                        if(color) {
                                g.drawImage(grass, i, j, 30, 30, null);
                                color = false;
                        }
                        else {
                                g.drawImage(stone, i, j, 30, 30, null);
                                color = true;
                        }
                }
                int nbBlockHeight = (int) (h/squareSize);
                if((nbBlockHeight)%2 == 0) {
                        if(color) {
                                color = false;
                        }
                        else {
                                color = true;
                        }
                }
        }
}
}
