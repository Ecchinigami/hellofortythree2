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
	
	String tab[][];
	
	public BuilderXML() {
		tab=null;
	}
	
	public void chargmentXML(String path) {
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
		    //tab = String[2][2];
		    
		    /*
		     * Etape 5 : récupération des cases
		     */
		    final Node racineNoeuds = (Node) racine.getChildNodes();
		    final int nbRacineNoeuds = ((NodeList) racineNoeuds).getLength();
				
		    for (int i = 0; i<nbRacineNoeuds; i++) {
		        if(((NodeList) racineNoeuds).item(i).getNodeType() == Node.ELEMENT_NODE) {
		            final Element caseDale = (Element) ((NodeList) racineNoeuds).item(i);
					
				    //Affichage des cases
				    System.out.println("\n*************Case************");
				    System.out.println("décor : " + caseDale.getAttribute("decor"));
				    System.out.println("individu : " + caseDale.getAttribute("individu"));
				    System.out.println("objet : " + caseDale.getAttribute("objet"));
				    
				    // Ajout au tableau
				    tab[0][0] = caseDale.getAttribute("decor") + caseDale.getAttribute("individu") + caseDale.getAttribute("objet");
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
	}
}