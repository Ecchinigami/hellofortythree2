package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BuilderXML;
import model.Carte;

import view.FenetreJeu;


/*
 * Cette classe contient les différentes actions des boutons 
 */
public class BtnListener implements ActionListener {

    private String lien; 
    private FenetreJeu fenetre;
    
    public BtnListener(String lien) {
        this.lien=lien;
    }
    
    public BtnListener(String lien, FenetreJeu fenetre) {
        this.lien=lien;
        this.fenetre=fenetre;
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
    	   FenetreJeu.displayMenu();
       }
       else if(lien.equals("jouer")) {    	   
    	   FenetreJeu.displayMapMenu();
       }
       else if(lien.equals("ouvrirFichier")) {
           JFileChooser chooser = new JFileChooser();
           FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
           chooser.setFileFilter(filter);
           chooser.showOpenDialog(null);
           
           if(chooser.getSelectedFile() != null){
        	   BuilderXML b = new BuilderXML();
        	   Carte c = new Carte();
        	   c.initCarte(b.chargmentXML(chooser.getSelectedFile().getPath()));
        	   FenetreJeu.displayGame(c);
           }
       }
       else if(lien.equals("a propos")) {
           //fenetre.initApropos();
       }
       else if(lien.equals("quitter")) {
           fenetre.dispose();
       }
    }
}
