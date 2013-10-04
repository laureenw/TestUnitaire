package fr.renater.idegest.tu;

import java.io.IOException;
import java.text.Normalizer;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase {
	  /** l'OUT */
	//L'objet à tester est déclaré comme attribut de la classe de test
	  private GestAjoutUsers gau;      
	 
	  @Before
	  protected void setUp() throws Exception {
	    try {
	    	//La création de l'objet à tester est placée dans setUp
	      this.gau = new GestAjoutUsers("testusers.xml");   
	    } catch (IOException e) {
	      fail("Création de l'OUT impossible !");
	    }
	  }
	 	  
	  @Test
	  public void test2PremiersCarsGenUid() {
		  //Appel du service à tester
	    String uid = this.gau.genUid("Bob", "Martin");   
	    //Appel à une méthode d'assertion assertTrue afin d'éviter le if … fail
	    assertTrue("Les 2 premiers caractères sont valides", uid.startsWith("bm"));
	  }
	  
	  @Test
	  public void test2PremiersCarsGenUidBis() {
		  //On appel le service à tester, puis on récupère le résultat
	    String uid = this.gau.genUid("Bob", "Martin"); 
	    //Place les 2 premiers caractères dans une variable
	    String premscar = uid.substring(0, 2); 
	    //Appel de la methode assertEquals avec 3 arguments 
	    //(“bm” est la valeur attendue, premierscar la valeur obtenue)
	    assertEquals("Les 2 premiers caractères sont valides", "bm", premscar);
	  }
	  
	  public void testMinusculeUid(){
		  String uid = this.gau.genUid("Bob", "Martin");
		  String minuscule = uid.toLowerCase();
		  assertEquals("L'uid obtenu est tout en minuscule", "bmartin", minuscule);
	  }
	  
	  public void testCaracteresUid(){
		  String uid = this.gau.genUid("Bob", "Martin");
		  int caracteres = uid.length();
		  if (caracteres >= 5 && caracteres <= 9){
			  assertEquals("L'uid obtenu est bon ", "bmartin", uid);
		  } else {
			  assertEquals("L'uid obtenu n'est pas bon ", "bmartin", uid);
		  }
	  }
	  	 	  
	  public void testCaracteresIndeUid(){
		  String uid = this.gau.genUid("Bob", "Martin");
		  String inde = Normalizer.normalize(uid, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		  assertEquals("L'uid obtenu ne contient pas de caractères indésirables", "bmartin", inde);
	  }
	  
	  public void testAddUser(){
		  User user;
		  User user2;

		  user = gau.addUser("Bob", "Martin");
		  System.out.println(""+user);
		  user2 = gau.addUser("Bob", "Martin");
		  System.out.println(""+user2);
		  assertEquals("L'uid obtenu n'existe pas", "bmartin", user.getLogin());
		  assertEquals("L'uid obtenu existe déjà", "bmartin1", user2.getLogin());
	  }
	  
	  public void testSizePassword(){
		  assertEquals("Le mot de passe contient le bon nombre de caracteres", 8, gau.genPassword(8).length());
	  }
	  
	  //La méthode genPassword donne des valeurs différentes à chaque appel 
	  //(dans les limites des algorithmes déterministes utilisés et du nombre de caractères souhaités…)
	 
	  public void testDiffPassword(){
		  String pwd;
		  String pwd2;

		  pwd = gau.genPassword(8);
		  pwd2 = gau.genPassword(8);
		  
		  System.out.println("pwd : "+pwd);
		  System.out.println("pwd2 : "+pwd2);
		 
		  assertFalse("La méthode genPassword donne des valeurs différentes à chaque appel", pwd.equals(pwd2));
	  }
	}