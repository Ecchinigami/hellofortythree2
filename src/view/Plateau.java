package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.Carte;
import model.CaseDale;
import model.Poule;
import model.Renard;
import model.ThreadUtil;
import model.VieAble;
import model.Vipere;


/**
 * <b>Plateau est la classe repr�sentant le plateau de jeu du vivarium</b>
 */
public class Plateau extends JPanel implements MouseWheelListener, ComponentListener {
	
	private CaseDale[][] plateau;
	private String[][] decor;
	
	private int squareSize;
	
	// Decor
	private Image wood;
	private Image stone;
	private Image grass;
	private Image dirt;
	// Objet
	private Image pomme;
	// Individu	
	private Image whiteDownStand;
	private Image redDownStand;
	private Image blackDownStand;

	public Plateau(Carte c) {
		
		this.plateau = c.getPlateau();
		this.decor = c.getDecor();
		
		addMouseWheelListener(this);
		keyBinding();

		// Init de caractéristiques internes
		setBackground(Color.DARK_GRAY);
		squareSize = 30;

		// Chargement des images
		wood = new ImageIcon("./res/image/block/wood.png").getImage();
		stone = new ImageIcon("./res/image/block/stone.png").getImage();
		grass = new ImageIcon("./res/image/block/grass.png").getImage();
		dirt = new ImageIcon("./res/image/block/dirt.png").getImage();

		pomme = new ImageIcon("./res/image/item/apple.png").getImage();

		whiteDownStand = new ImageIcon("./res/image/character/white/downStand.png").getImage();
		redDownStand = new ImageIcon("./res/image/character/red/downStand.png").getImage();
		blackDownStand = new ImageIcon("./res/image/character/black/downStand.png").getImage();
	}

	/**
	 * D�finition des textures pr�sentes sur le plateau
	 */
	public void paint(Graphics g) {
		super.paint(g);

		// Récupération de la taille du panel
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();

		// Init du nombre de blocks
		int nbBlockWidth = plateau[0].length;
		int nbBlockHeigh = plateau[1].length;

		// Calcul des marges
		int marginWidth = (int) ((w-(squareSize*nbBlockWidth))/2);
		int marginHeight = (int) ((h-(squareSize*nbBlockHeigh))/2);

		// Dessin des cases du Plateau
		int blockHeigh=0;
		int blockWidth=0;

		for(int i=marginWidth; i<w-marginWidth-1; i+=squareSize) {
			for(int j=marginHeight; j<h-marginHeight-1; j+=squareSize) {

				if(blockWidth<nbBlockWidth && blockHeigh<nbBlockHeigh) {
					// Dessin du decor
					if(decor[blockHeigh][blockWidth]!=null) {
						switch (decor[blockHeigh][blockWidth]) {
							case "wood":	g.drawImage(wood, i, j, squareSize, squareSize, null);
								break;
							case "stone":	g.drawImage(stone, i, j, squareSize, squareSize, null);
								break;
							case "grass":	g.drawImage(grass, i, j, squareSize, squareSize, null);
								break;
							case "dirt":	g.drawImage(dirt, i, j, squareSize, squareSize, null);
								break;
						}
					}
					// Dessin des objets
					if(plateau[blockHeigh][blockWidth].getObjet()!=null) {
						switch (plateau[blockHeigh][blockWidth].getObjet().getName()) {
							case "pomme":	g.drawImage(pomme, i, j, squareSize, squareSize, null);
								break;	
						}
					}
					// Dessin des individus
					if(plateau[blockHeigh][blockWidth].getIndividu()!=null) {
						switch (plateau[blockHeigh][blockWidth].getIndividu().toString()) {
							case "poule":	g.drawImage(whiteDownStand, i, j, squareSize, squareSize, null);
								break;
							case "renard":	g.drawImage(redDownStand, i, j, squareSize, squareSize, null);
								break;	
							case "vipere":	g.drawImage(blackDownStand, i, j, squareSize, squareSize, null);
					        	break;
						}
					}
				}
				blockHeigh++;
				if(blockHeigh==nbBlockHeigh) {
					blockHeigh=0;
				}
			}
			blockWidth++;
		}
	}
	
	public void keyBinding() {
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
		this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {			
            	int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter la partie ?", "Quitter partie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            	if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {
            		view.FenetreJeu.displayMenu();
            	}
            }
        });
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0) {
			squareSize+=5;
		} else {
			if (squareSize>30) {
				squareSize-=5;
			}
		}
		repaint();
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		repaint();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}
}
