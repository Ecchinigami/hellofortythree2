package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.BtnListener;

public class FenetreJeu extends JFrame {
	
	Container pane;
	CardLayout cl;
	
	public FenetreJeu() {
		
		super();	
		
		setTitle("Hellofortythree !");

		//initVars();               // appelle la m�thode initVars pour initialiser les variables
		//initComponents();         // appelle la m�thode initComponents pour initialiser les composants

		setPreferredSize(new Dimension(500, 500)); // indique la taille de la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE); // l'application s'arr�te quand la fen�tre est ferm�e

		init();
		
		pack(); // lance le calcul de la fen�tre
		setLocationRelativeTo(null); // place la fen�tre au centre de l'�cran
		setVisible(true); // affiche la fen�tre
	}
	
	private void init() {
		pane = getContentPane(); // r�cup�re le panel principal
		
		cl = new CardLayout();		
		pane.setLayout(cl);
		
		pane.add(initMenu(), "Menu");
		pane.add(initGame(), "Game");
		
		cl.show(pane, "Menu");
		
		this.setJMenuBar(createMenuBar());
	}
	
	public void displayMenu() {
		cl.show(pane, "Menu");
	}
	public void displayGame() {
		cl.show(pane, "Game");
	}
	
	private JPanel initMenu() {
		
		JPanel menu = new JPanel();
        
        menu.setBackground(Color.LIGHT_GRAY);
        
        // Cr�ation d'un gridbaglayout pour le menu
        menu.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();        
        c.fill = GridBagConstraints.BOTH; 
        c.insets = new Insets(10,10,70,10);
        
        // Titre
        c.gridy = 0; 
        JLabel titre = new JLabel("Small World\n");
        titre.setFont(new Font("Courrier", Font.BOLD, 50));
        titre.setForeground(Color.BLACK);
        menu.add(titre, c);
        
        c.insets = new Insets(10,10,10,10);
        // Bouton Jouer
        c.gridy = 1;    
        Bouton jouer = new Bouton("Jouer");
        menu.add(jouer, c);
        
        // Bouton A propos
        c.gridy = 2;        
        Bouton apropos = new Bouton("A propos"); 
        menu.add(apropos, c);
        
        // Bouton Quitter
        c.gridy = 3;
        Bouton quitter = new Bouton("Quitter");   
        menu.add(quitter, c);        
        
        jouer.addActionListener(new BtnListener("jouer", this));
        apropos.addActionListener(new BtnListener("a propos", this));
        quitter.addActionListener(new BtnListener("quitter", this));
        
        return menu;
	}
	
	public JPanel initGame() {
		
		JPanel game = new JPanel();
		
		game.setLayout(new BorderLayout());
		
		final Plateau p = new Plateau();
		p.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e)
		    {
		        p.repaint();
		    }
		});
		
		Action doNothing = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		        displayMenu();
		        System.out.println("pqsdqsd");
		    }
		};
		//game.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "doNothing");
		//game.getActionMap().put("doNothing", doNothing);
		
		p.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), doNothing);
		
		game.add(p);
		
		return game;
	}
	
	private JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
        
		// Cr�ation du menu Fichier
        JMenu fichierMenu = new JMenu("File");
        
        JMenuItem item = new JMenuItem("Open");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        fichierMenu.add(item);        
        
        item = new JMenuItem("Save As");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        fichierMenu.add(item);
        
        item = new JMenuItem("Quit");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        fichierMenu.add(item); 
        
        fichierMenu.insertSeparator(2);

        // Cr�ation du menu Editer
        JMenu editerMenu = new JMenu("Edit");
        
        item = new JMenuItem("Copy");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        editerMenu.add(item);
        
        item = new JMenuItem("Cut");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        editerMenu.add(item);
       
        item = new JMenuItem("Paste");
        item.addActionListener(afficherMenuListener);
        item.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        editerMenu.add(item);
        
        // ajout des menus � la barre de menu
        menuBar.add(fichierMenu);
        menuBar.add(editerMenu);
        
        return menuBar;
	}
	ActionListener afficherMenuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            //System.out.println("El�ment de menu [" + event.getActionCommand()+ "] utilis�.");
            if ("Quit".equals(event.getActionCommand())) {
            	System.exit(0);
            }
            else if ("Open".equals(event.getActionCommand())) {
                // cr�ation de la bo�te de dialogue
                JFileChooser dialogue = new JFileChooser();

                // affichage
                dialogue.showOpenDialog(null);

                // r�cup�ration du fichier s�lectionn�
                System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
                
                if(dialogue.getSelectedFile() != null){
                }
            }
        }
    };
}