package fr.renater.idegest.util;


public class UtilHtml {
	
	 /** retourne une représentation HTML d'un tableau...
	* @param tab
	* le tableau
	* @param maxRows
	* le nombre maximum de lignes souhaité (doit être >= 0)
	* @return Si le tableau est vide, la méthode retourne la chaine "(vide)"
	* si le tableau contient moins de maxRows lignes, le deuxième
	* paramètre). Il y a autant de <tr>
	* que d'éléments dans le tableau à concurrence de maxRows lignes,
	* s'il le nombre d'éléments dans le tableau est supérieur à maxRows,
	* la dernière ligne sera définie par "..."
	*/
	public String toHtmlTab(Object[] tab, int maxRows) {
		maxRows = (int) maxRows;
		String chaineRetour = null;
		if (tab.length==0){
			chaineRetour = "(vide)";
		}else{
			chaineRetour = "<table>";
			for (int i=0; i < tab.length && i < maxRows; i++){
				chaineRetour += "<tr><td>"+tab[i]+"</td></tr>";
			}
			if (tab.length > maxRows && maxRows !=0){
				chaineRetour += "<tr><td>...</td></tr>";
			}		
			
			chaineRetour += "</table>";
		}
		
		return chaineRetour;
	}

}
