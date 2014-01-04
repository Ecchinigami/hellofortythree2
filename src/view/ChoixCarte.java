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
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Carte;

import model.CaseDale;
import controller.BtnCarte;

public class ChoixCarte extends JFrame{
	Container pane;
	CardLayout cl;
	
	public ChoixCarte() {
			
		super();	
		
		setTitle("Hellofortythree !");

		setPreferredSize(new Dimension(500, 500)); // indique la taille de la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE); // l'application s'arrête quand la fenêtre est fermée

		init();
		
		pack(); // lance le calcul de la fenêtre
		setLocationRelativeTo(null); // place la fenêtre au centre de l'écran
		setVisible(true); // affiche la fenêtre
	}
	private void init(){
		pane = getContentPane(); // récupère le panel principal
		
		cl = new CardLayout();		
		pane.setLayout(cl);
		
		pane.add(initMenu(), "Menu");
		
		cl.show(pane, "Menu");
		
		//this.setJMenuBar(createMenuBar());
	}
	
	public void displayMenu() {
		cl.show(pane, "Menu");
	}
	public void displayGame(Carte c) {
		pane.add(initGame(c), "Game");
		cl.show(pane, "Game");
	}
	
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
        JLabel titre = new JLabel("Choix de la carte\n");
        titre.setFont(new Font("Courrier", Font.BOLD, 50));
        titre.setForeground(Color.BLACK);
        menu.add(titre, c);
        
        c.insets = new Insets(10,10,10,10);
        // Bouton Parcourir
        c.gridy = 1;    
        Bouton Parcourir = new Bouton("Parcourir");
        menu.add(Parcourir, c);
        
        Parcourir.addActionListener(new BtnCarte("Parcourir", this));
        
        return menu;
	}

	private static JPanel initGame(Carte c) {
	
		JPanel game = new JPanel();
		
		game.setLayout(new BorderLayout());

		Plateau p = new Plateau(c);

		game.add(p);
			
		return game;
		}
	}
