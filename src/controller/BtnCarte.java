	package controller;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.BuilderXML;
import view.ChoixCarte;

	
	public class BtnCarte implements ActionListener {

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
	    	   
	    	   // création de la boîte de dialogue
               JFileChooser dialogue = new JFileChooser();

               // affichage
               dialogue.showOpenDialog(null);

               // récupération du fichier sélectionné
               System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
               
               
               b.chargmentXML(dialogue.getSelectedFile().toString());
               
	    	   carte.displayGame();
	    	   //carte.displayParcourir();
	       }
	    }
}
