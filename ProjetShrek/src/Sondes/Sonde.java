package Sondes;
import java.util.*;

import Sondage.Categorie;
import Sondage.Sondage;
/**
@author Groupe Shrek
**/
public class Sonde {

	static int num = 0;
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private Categorie categorie;
	private String mail;
	private ArrayList<Sondage> sondages;
	
	public Sonde(String nom,String prenom, int age, Categorie categorie, String mail ){
		num ++;
		this.setId(num);
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.categorie=categorie;
		this.mail=mail;
		this.sondages = new ArrayList<Sondage>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getMail() {
		return mail;
	}
	
	/**
	 * 
	 * @param mail
	 * @return resultat de l'opération
	 * Vérifie si l'adresse mail est valide (contient un '@' et un'.').
	 * La met Ã  jour si elle est valide.
	 * Retourne -1 si elle n'a pas pu Ãªtre mise Ã  jour.
	 */
	public boolean setMail(String mail) {
		boolean res;
		if(mail.contains("@") && mail.contains(".")){
			this.mail = mail;
			res = true;
		} else {
			res = false;
		}
		return res;
	}
	
	public void addSondage(Sondage sond){
		this.sondages.add(sond);
	}
	
	public ArrayList<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(ArrayList<Sondage> sondages) {
		this.sondages = sondages;
	}

	public void removeSondage(Sondage sond){
		this.sondages.remove(sond);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
