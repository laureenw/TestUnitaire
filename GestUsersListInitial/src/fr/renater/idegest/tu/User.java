package fr.renater.idegest.tu;

public class User {

	private String prenom;
	private String nom;
	private String login;
	private String pw;

	public User() {
		super();
	}
 
	public User(String prenom, String nom, String login, String pw) {
		this.prenom=prenom;
		this.nom=nom;
		this.login=login;
		this.pw=pw;
	}
	
	public String toString(){
		StringBuffer res = new StringBuffer();
		res.append("<user>");
		res.append("<prenom>");
		res.append(this.prenom);
		res.append("</prenom>");
		res.append("<nom>");
		res.append(this.nom);
		res.append("</nom>");
		res.append("<uid>");
		res.append(this.login);
		res.append("</uid>");
		res.append("<pw>");
		res.append(this.pw);
		res.append("</pw>");
		res.append("</user>");
		return res.toString();		
	}

	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.pw;
	}
	
}