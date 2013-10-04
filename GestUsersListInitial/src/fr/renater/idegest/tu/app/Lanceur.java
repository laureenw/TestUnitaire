package fr.renater.idegest.tu.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.renater.idegest.tu.AppUsersGUI;

public class Lanceur {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(Lanceur.class);

	/**
	 * Lanceur
	 * 
	 * @param args
	 *            args[0] le nom du fichier XML des utilisateurs (defaut =
	 *            users.xml)
	 */
	static public void main(String[] args) {
		try {
			String fic = (args.length == 1 ? args[0] : "users.xml");
			AppUsersGUI app = new AppUsersGUI(fic);
			app.run();
		} catch (Exception e) {
			logger.fatal(e.getMessage());
		}
	}

}
