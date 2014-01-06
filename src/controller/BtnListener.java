package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BuilderXML;
import model.Carte;

import view.FenetreJeu;

/**
 * <b>Cette classe contient les diff�rentes actions des boutons</b> 
 */
public class BtnListener implements ActionListener {

	/**
	 * Les diff�rents liens pr�sents dans la fen�tre du vivarium
	 */
    private String lien; 
    
    /**
     * Fen�tre du jeu
     */
    private FenetreJeu fenetre;

	/**
	 * M�thode permettant de savoir quel lien a �t� cliqu�
	 * @param lien Le lien cliqu�
	 */
    public BtnListener(String lien) {
        this.lien=lien;
    }
   
    /**
     * M�thode permettant de savoir quel lien a �t� cliqu� et sur quelle fen�tre du jeu
     * @param lien Le lien cliqu�
     * @param fenetre La fen�tre sur lequel se trouve le lien
     */
    public BtnListener(String lien, FenetreJeu fenetre) {
        this.lien=lien;
        this.fenetre=fenetre;
    }
    /**
     * M�thode ex�cut�e � chaque fois que l'on cliquera sur un lien
     */
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

    		   try {
    			   Carte c;
    			   InputStream s = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
    			   c = new Carte(b.chargmentXML(s));
    			   FenetreJeu.displayGame(c);
    			   c.startLife();
    		   } catch (FileNotFoundException e1) {
    			   e1.printStackTrace();
    		   }
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
