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
		num++;
		this.id = num;
		this.nom=nom;
		this.prenom=prenom;
		this.age=age;
		this.categorie=categorie;
		this.mail=mail;
		this.sondages = new ArrayList<Sondage>();
	}

	public int getId() {
		return id;
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
	
	/**
	 * @param categorie
	 * Vérifie si la catégorie donnée en argument n'est pas déjà la catégorie du Sondé. 
	 * Si ce n'est pas le cas, elle la met à jour.
	 */
	public void setCategorie(Categorie categorie) {
		if(!this.categorie.equals(categorie)){
			this.categorie = categorie;
		}
	}

	public String getMail() {
		return mail;
	}
	
	/**
	 * 
	 * @param mail
	 * @return resultat de l'opération
	 * Vérifie si l'adresse mail est valide (contient un '@' et un'.').
	 * La met à jour si elle est valide.
	 * Retourne -1 si elle n'a pas pu être mise à jour.
	 */
	public int setMail(String mail) {
		int res;
		if(mail.contains("@") && mail.contains(".")){
			this.mail = mail;
			res = 0;
		} else {
			res = -1;
		}
		return res;
	}
	
	/**
	 * @param Sondage "sond"
	 * Vérifie si le sondage fourni en argument ne fait pas déjà partie de le liste des sondages du sondé.
	 * Si ce n'est pas le cas, ajout du sondage à la liste.
	 */
	public void addSondage(Sondage sond){
		if(!this.sondages.contains(sond)){
			this.sondages.add(sond);
		}
	}
	
	/**
	 * @param Sondage "sond"
	 * Vérifie que le sondage soit dans la liste du sondé.
	 * Si c'est le cas, suppression du sondage de la liste.
	 */
	public void removeSondage(Sondage sond){
		if(this.sondages.contains(sond)){
			this.sondages.remove(sond);
		}
	}
	
}
