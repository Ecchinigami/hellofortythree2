	package controller;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.BuilderXML;

import model.Carte;
import model.CaseDale;
import model.Individu;
import model.VieAble;

import model.CaseDale;
import view.ChoixCarte;

	
	public class BtnCarte implements ActionListener {
		
		public static Carte map;
	    private String lien; 
	    private ChoixCarte carte;

	    public BtnCarte(String lien, ChoixCarte c) {
	        this.lien=lien;
	        this.carte=c;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {    // cette méthode sera executée chaque fois que l'on actionne un bouton

	       if(lien.equals("acceuil")) {
	           
	            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?", "La partie en cours sera perdue !", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
	            if(option == JOptionPane.OK_OPTION) {
	                
	                //fenetre.initComponents();
	            }           
	       } 
	       else if(lien.equals("retour")) {
	           //fenetre.initComponents();
	       }

	       else if(lien.equals("Parcourir")) {
	    	   // Objet BuilderXML
	    	   BuilderXML b = new BuilderXML();
	    	   map = new Carte();
	    	   
	    	   // création de la boîte de dialogue
               JFileChooser dialogue = new JFileChooser();

               // affichage
               dialogue.showOpenDialog(null);

               // récupération du fichier sélectionné
               System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
               
               
               b.chargmentXML(dialogue.getSelectedFile().toString());


               
               map.initCarte(b.chargmentXML(dialogue.getSelectedFile().toString()));
       		
	    	   carte.displayGame(map);

	    	   //carte.displayGame(plateau);
	    	   //carte.displayParcourir();
	    	   
	    	   VieAble thread = new VieAble();
	    	   thread.start();    	   
	       }
	    }
}
