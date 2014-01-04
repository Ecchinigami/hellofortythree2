package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class BuilderXML {

    
    public BuilderXML() {
    }
    

	
	public String[][][] chargmentXML(String path) {
		
		String tab[][][] = null;
		
		/*
	     * Etape 1 : récupération d'une instance de la classe "DocumentBuilderFactory"
	     */
	    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        	
	    try {
	        /*
	         * Etape 2 : création d'un parseur
	         */
	        final DocumentBuilder builder = factory.newDocumentBuilder();
				
		    /*
		     * Etape 3 : Ouverture d'un Document
		     */
		    final Document document= builder.parse(new File(path));
		    
		    /*
		     * Etape 4 : récupération de l'Element racine
		     */
		    final Element racine = document.getDocumentElement();
			
		    // Affichage de l'élément racine
		    System.out.println("\n*************Carte************");
		    System.out.println("taille : " + racine.getAttribute("hauteur") + "x" + racine.getAttribute("largeur"));
			
		    int hauteur = Integer.parseInt(racine.getAttribute("hauteur"));
			int largeur = Integer.parseInt(racine.getAttribute("largeur"));
		    
		    // Initialisation du tableau
			tab = new String[hauteur][largeur][3];
		    
		    /*
		     * Etape 5 : récupération des cases
		     */
		    final Node racineNoeuds = (Node) racine.getChildNodes();
		    final int nbRacineNoeuds = ((NodeList) racineNoeuds).getLength();
			
		    int i = 0;
		    int j = 0;
		    
		    for (int l = 0; l<nbRacineNoeuds; l++) {		    	
		        if(((NodeList) racineNoeuds).item(l).getNodeType() == Node.ELEMENT_NODE) {
		            final Element caseDale = (Element) ((NodeList) racineNoeuds).item(l);
					
				    //Affichage des cases
				    System.out.println("\n*************Case "+j+"x"+i%largeur+"************");
				    System.out.println("décor : " + caseDale.getAttribute("decor"));
				    System.out.println("individu : " + caseDale.getAttribute("individu"));
				    System.out.println("objet : " + caseDale.getAttribute("objet"));
				    
				    // Ajout au tableau
				    tab[j][i%largeur][0] = caseDale.getAttribute("decor");
				    tab[j][i%largeur][1] = caseDale.getAttribute("individu");
				    tab[j][i%largeur][2] = caseDale.getAttribute("objet");
				    
			        i++;
			        if(i!=0 && i%largeur==0) {
			        	j++;
			        }
		        }
		    }			
	    }
	    catch (final ParserConfigurationException e) {
	        e.printStackTrace();
	    }
	    catch (final SAXException e) {
	        e.printStackTrace();
	    }
	    catch (final IOException e) {
	        e.printStackTrace();
	    }
	    
		return tab;
	}

}
