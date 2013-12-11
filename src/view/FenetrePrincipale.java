package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FenetrePrincipale extends JFrame {

	public Vector  compose;
	public Vector  myListener;



	// DECLARATION DES ATTRIBUTS DE LA FENETRE
	// il s'agit de variables qui ne concernent pas directement les composants


	// DECLARATION DES COMPOSANTS
	// les composants sont des attributs de la classe

	//private ZoneDessinable lbl;
	//private JButton btn;
	/*private JButton btnRectangle;
        private JButton btnRond;
        private JButton btnEllipse;*/
	
	public FenetrePrincipale() {
		
		super();	
		
		// initialisation de la fenêtre
		setTitle("Hellofortythree !"); // indique le titre de la fenêtre

		initVars();               // appelle la méthode initVars pour initialiser les variables
		initComponents();         // appelle la méthode initComponents pour initialiser les composants

		setPreferredSize(new Dimension(500, 500)); // indique la taille de la fenêtre
		//setResizable(true); // empeche le redimensionnement de la fenêtre par l'utilisateur
		setDefaultCloseOperation(EXIT_ON_CLOSE); // l'application s'arrête quand la fenêtre est fermée

		pack(); // lance le calcul de la fenêtre
		setLocationRelativeTo(null); // place la fenêtre au centre de l'écran
		setVisible(true); // affiche la fenêtre
	}


	// INITIALISATION DES VARIABLES
	// cette méthode n'est appelée qu'une fois
	// lors de la création de la fenêtre (cf. constructeur)
	private void initVars() {
	}


	// INITIALISATION DES COMPOSANTS
	// cette méthode n'est appelée qu'une fois
	// lors de la création de la fenêtre (cf. constructeur)
	private void initComponents() {		
		
		Container pane = getContentPane(); // récupère le panel principal
		
		// INITIALISATION
		// ici on initialise les composants
		this.setJMenuBar(createMenuBar());
		
		// POSITION
		// ici on indique la taille et la position des composants
		

		// EVENEMENTS
		// ici on lie les composants aux événements
		
	}
	
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
            //System.out.println("Elément de menu [" + event.getActionCommand()+ "] utilisé.");
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