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

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Carte;
import model.ThreadUtil;
import controller.BtnListener;


/**
 * <b>FenetreJeu est la classe h�rit�e de la classe JFrame</b> 
 * 
 */
public class FenetreJeu extends JFrame {
	
	/**
	 * Contient les objets graphiques
	 */
	private static Container pane;
	
	/**
	 * Gestionnaire de placement des composants graphiques
	 */
	private static CardLayout cl;
	
	/**
	 * Permet de configurer la fen�tre de jeu
	 */
	public FenetreJeu() {
		
		super();	
		
		setTitle("Hellofortythree !");
		
		setPreferredSize(new Dimension(500, 500)); // indique la taille de la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE); // l'application s'arrête quand la fenêtre est fermée

		init();
		
		pack(); // lance le calcul de la fenêtre
		setLocationRelativeTo(null); // place la fenêtre au centre de l'écran
		setVisible(true); // affiche la fenêtre
	}
	
	/**
	 * Initialise la fen�tre de jeu en r�cup�rant le panel principal
	 */
	private void init() {
		pane = getContentPane(); // récupère le panel principal
		
		cl = new CardLayout();		
		pane.setLayout(cl);
		
		pane.add(initMenu(), "Menu");	
		cl.show(pane, "Menu");
		
		//this.setJMenuBar(createMenuBar());
	}
	
	/**
	 * Pour afficher le menu
	 */
	public static void displayMenu() {
		cl.show(pane, "Menu");
	}
	
	/**
	 * Pour afficher le jeu
	 */
	public static void displayGame(Carte c) {
		pane.add(initGame(c), "Game");
		cl.show(pane, "Game");
	}
	
	/**
	 * Pour afficher le menu lors du jeu
	 */
	public static void displayMapMenu() {
		pane.add(initMapMenu(), "MapMenu");
		cl.show(pane, "MapMenu");
	}

	/**
	 * Pour initialiser le menu
	 * @return Le menu mis en forme
	 */
	private JPanel initMenu() {
		
		JPanel menu = new JPanel();
        
        menu.setBackground(Color.LIGHT_GRAY);
        
        // Création d'un gridbaglayout pour le menu
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
	
	/**
	 * Initialise la fen�tre de jeu
	 * @return La fen�tre du jeu
	 */
	private static JPanel initGame(Carte c) {
		
		JPanel game = new JPanel();
		
		game.setLayout(new BorderLayout());
		
		Plateau p = new Plateau(c);
		
		game.add(p);
		
		return game;
	}
	
	/**
	 * Pour afficher le menu lors du jeu
	 * @return Le Menu pr�sent lors du jeu
	 */
	private static JPanel initMapMenu() {
		MapMenu mapMenu = new MapMenu();   
		return mapMenu;
	}
	
	/**
	 * Pour afficher la Barre des menus en haut
	 * @return La JMenubar
	 */
	private JMenuBar createMenuBar() {
        
        JMenuBar menuBar = new JMenuBar();
        
		// Création du menu Fichier
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

        // Création du menu Editer
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
        
        // ajout des menus à la barre de menu
        menuBar.add(fichierMenu);
        menuBar.add(editerMenu);
        
        return menuBar;
	}
	ActionListener afficherMenuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
        	if ("Quit".equals(event.getActionCommand())) {
            	System.exit(0);
            }
            else if ("Open".equals(event.getActionCommand())) {
                // création de la boîte de dialogue
                JFileChooser dialogue = new JFileChooser();

                // affichage
                dialogue.showOpenDialog(null);

                // récupération du fichier sélectionné
                System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
                
                if(dialogue.getSelectedFile() != null){
                }
            }
        }
    };
}