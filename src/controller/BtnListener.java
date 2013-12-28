package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.FenetreJeu;

/*
 * Cette classe contient les différentes actions des boutons 
 */
public class BtnListener implements ActionListener {

    private String lien; 
    private FenetreJeu fenetre;
    
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
