package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.FenetreJeu;


/**
 * <b>Cette classe contient les différentes actions des boutons</b> 
 */
public class BtnListener implements ActionListener {

	/**
	 * Les différents liens présents dans la fenêtre du vivarium
	 */
    private String lien; 
    
    /**
     * Fenêtre du jeu
     */
    private FenetreJeu fenetre;

    /**
     * Méthode permettant de savoir quel lien a été cliqué et sur quelle fenêtre du jeu
     * @param lien Le lien cliqué
     * @param fenetre La fenêtre sur lequel se trouve le lien
     */
    public BtnListener(String lien, FenetreJeu fenetre) {
        this.lien=lien;
        this.fenetre=fenetre;
    }

    /**
     * Méthode exécutée à chaque fois que l'on cliquera sur un lien
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
           //fenetre.initComponents();
       }
       else if(lien.equals("jouer")) {
           fenetre.displayGame();
       }
       else if(lien.equals("a propos")) {
           //fenetre.initApropos();
       }
       else if(lien.equals("quitter")) {
           fenetre.dispose();
       }
    }
}
