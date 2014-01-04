package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
    public void actionPerformed(ActionEvent e) {    // cette m�thode sera execut�e chaque fois que l'on actionne un bouton

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
