/**
 * Created on 30 jan. 2006
 * Review 15 juillet 2012
 * @author kpu
 */
package fr.renater.idegest.tu;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppUsersGUI {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(AppUsersGUI.class);
	
	/**
	 * nom du fichier XML contenant les utilisateurs
	 */
	private String fileNameUsers;


	public AppUsersGUI(String fileNameUsers){
		this.fileNameUsers = fileNameUsers;
	}
	
	/**
	 * Entrée principale de l'application
	 * 
	 * @throws IOException
	 * 
	 */
	public void run() throws IOException {
		GestAjoutUsers gestAjoutUsers = new GestAjoutUsers(fileNameUsers);		
		java.util.Date today = new java.util.Date();
		logger.info("Debut exécution : " + today.toString());	
		String choix;
		String menu = "0 : Quitter\n1 : Ajouter un utilisateur\n2 : Lister les utilisateurs\nVotre choix SVP :";
		do {			
			choix = JOptionPane.showInputDialog(null, menu, "Ajout utilisateur", JOptionPane.QUESTION_MESSAGE);
			
			if ("1".equals(choix)) {
				String prenom = JOptionPane.showInputDialog("Entrez un prénom");
				String nom = JOptionPane.showInputDialog("Entrez un nom");
				if (prenom != null && !"".equals(prenom) && nom != null
						&& !"".equals(nom)) {
					gestAjoutUsers.addUser(prenom, nom);
					gestAjoutUsers.saveToFile();
				}
			} else if ("2".equals(choix)) {
				JOptionPane.showMessageDialog(null, gestAjoutUsers);
			} 
		} while (!"0".equals(choix) && choix != null);
		today = new java.util.Date();
		logger.info("Fin exécution : " + today.toString());
	}
	
}