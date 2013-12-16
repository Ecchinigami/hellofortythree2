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

public class Plateau extends JPanel {

	public Plateau() {		
		setBackground(Color.DARK_GRAY);
	}

	public void paint(Graphics g) {
		super.paint(g);

		/*RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHints(rh);*/

		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		int squareSize = 30;
		boolean color = true;
		g.setColor(Color.DARK_GRAY);
		int marginWidth = (int) ((w%squareSize)/2);
		if(marginWidth==0)
			marginWidth=(int) squareSize/2;
		int marginHeight = (int) ((h%squareSize)/2);
		if(marginHeight==0)
			marginHeight=(int) squareSize/2;
		
		Image grass = new ImageIcon("./res/image/block/grass.png").getImage();
		Image stone = new ImageIcon("./res/image/block/stone.png").getImage();
		
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
		}
	}
}
