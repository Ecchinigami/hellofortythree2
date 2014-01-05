package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
        	   Carte c = new Carte(b.chargmentXML(chooser.getSelectedFile().getPath()));
        	   FenetreJeu.displayGame(c);
        	   c.startLife();
           }
       }
       else if(lien.equals("ajouterFichier")) {
           JFileChooser chooser = new JFileChooser();
           FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files", "xml");
           chooser.setFileFilter(filter);
           chooser.showOpenDialog(null);
           
           if(chooser.getSelectedFile() != null){
        	   try{
        		   // Declaration et ouverture des flux
        		   java.io.FileInputStream sourceFile = new java.io.FileInputStream(chooser.getSelectedFile());

        		   try{
        			   java.io.FileOutputStream destinationFile = null;

        			   try{
        				   destinationFile = new FileOutputStream(new File("./res/xml/"+chooser.getSelectedFile().getName()));

        				   // Lecture par segment de 0.5Mo 
        				   byte buffer[] = new byte[512 * 1024];
        				   int nbLecture;

        				   while ((nbLecture = sourceFile.read(buffer)) != -1){
        					   destinationFile.write(buffer, 0, nbLecture);
        				   }
        			   } finally {
        				   destinationFile.close();
        			   }
        		   } finally {
        			   sourceFile.close();
        		   }
        	   } catch (IOException ioe){
        		   ioe.printStackTrace();
        	   }
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
