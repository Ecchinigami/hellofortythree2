package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BuilderXML;
import model.Carte;
import controller.BtnListener;

public class MapMenu extends JPanel implements ListSelectionListener {
	
	private CardLayout clPreview;	
	private JPanel preview;	
	private JList list;

	private String defaultXMLPath = "./res/xml/";
	
	private Carte carte = null;

	public MapMenu() {
		
		this.setBackground(Color.LIGHT_GRAY);

		// Initialisation du Grid Bag Layout et de ses Contraintes		 
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH; // le composant prend toute la place disponible horizontalement et verticalement
		c.insets = new Insets(2,2,2,2); // marge entre composant (en pixel)       

		/* Liste  */        
		c.weightx = 0.3; // proportion du composant (entre 0 et 1)
		c.weighty = 0.7; 
		c.gridwidth = 1; // taille du composant (en nombre de case)
		c.gridheight = 2;
		c.gridx = 0; // position dans la grille
		c.gridy = 0;
		File repertoire = new File(defaultXMLPath);
		Vector listFile = new Vector();
		for (File file : repertoire.listFiles()) {
			if(file.getName().toLowerCase().endsWith(".xml"))
				listFile.add(file.getName());
		}
		list = new JList(listFile);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		list.addListSelectionListener(this);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension()); // Respect des contraintes, évite les problèmes de redimensionnement abusif   
		this.add(listScroller, c);

		/* Preview */
		c.weightx = 0.7;
		c.weighty = 0.7;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 0;
		preview = new JPanel(); 		
		clPreview = new CardLayout();		
		preview.setLayout(clPreview);
		preview.setPreferredSize(new Dimension()); // Respect des contraintes, évite les problèmes de redimensionnement abusif   
		this.add(preview, c);

		/* Option */
		c.weightx = 1;
		c.weighty = 0.3;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 2;
		JPanel option = new JPanel(new GridLayout(2,2));
		
		Bouton ouvrirFichier = new Bouton("Ouvrir un autre fichier");
		ouvrirFichier.addActionListener(new BtnListener("ouvrirFichier"));		
		option.add(ouvrirFichier);	
		
		Bouton ajouterFichier = new Bouton("Ajouter un fichier");
		ajouterFichier.addActionListener(new BtnListener("ajouterFichier"));		
		option.add(ajouterFichier);
		
		Bouton retour = new Bouton("Retour");
		retour.addActionListener(new BtnListener("retour"));
		option.add(retour);		
		
		Bouton jouer = new Bouton("Jouer");
		jouer.addActionListener(new JouerBtnListener());
		option.add(jouer);
		
		option.setPreferredSize(new Dimension()); // Respect des contraintes, évite les problèmes de redimensionnement abusif   
		this.add(option, c);
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (!lse.getValueIsAdjusting()) {  			
			BuilderXML b = new BuilderXML();
			carte = new Carte(b.chargmentXML(defaultXMLPath + list.getSelectedValue()));
			
			preview.add(new Plateau(carte));
			clPreview.next(preview);
		}
	}
	
	public class JouerBtnListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			if(carte!=null)
				FenetreJeu.displayGame(carte);
				carte.startLife();
		}
	}
}
