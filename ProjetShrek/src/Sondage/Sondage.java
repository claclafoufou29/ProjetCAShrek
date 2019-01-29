package Sondage;
import java.sql.Date;
import java.util.ArrayList;

import Sondes.Sonde;

public class Sondage {

	public static int num = 0;
	private boolean actif;
	private int id;
	private String titre;
	private String description;
	private Categorie cat;
	private Date dateDebut;
	private Date dateFin;
	private ArrayList<Sonde> sondes;
	private ArrayList<Question> questions;
	
	{
		num++;
	}

	public Sondage(String titre, String description, Categorie cat, Date dateDebut, Date dateFin) {
		this.setId(num);
		this.setTitre(titre);
		this.setDescription(description);
		this.setCat(cat);
		this.setDateDebut(dateDebut);
		this.setActif(false);
		this.setDateFin(dateFin);
		sondes = new ArrayList<Sonde>();
		questions = new ArrayList<Question>();
	}
	
	/** Ajoute un sondé dans la liste des sondés de ce sondage si il n'y existe pas déjà	
	 * appelle la méthode ajoutSondage du sondé pour ajouter ce sondage dans sa liste de sondages
	 * @param s sondé a ajouter **/
	public void addSonde(Sonde s) {
		if(!this.sondes.contains(s)) {
			this.sondes.add(s);
			s.addSondage(this);
		}else {
			System.out.println("Insertion impossible, ce sondé est déjà affecter a ce sondage");
		}
	}
	
	/** Supprime un sondé dans la liste des sondés de ce sondage si celui-ci appartient bien a ce sondage
	 * appelle la méthode removeSondage du sondé pour supprimer ce sondage dans sa liste de sondages 
	 * @param s sondé a supprimer **/
	public void removeSonde(Sonde s) {
		if(this.sondes.contains(s)) {
			this.sondes.remove(s);
			s.removeSondage(this);
		}else {
			System.out.println("Suppression impossible, ce sondé n'est pas affecter a ce sondage");
		}
	}
	
	/** Ajoute une question a ce sondage si celle-ci n'est pas déjà présente
	 * @param q question à ajouter **/
	public void addQuestion(Question q) {
		if(!this.questions.contains(q)) {
			this.questions.add(q);
		}else {
			System.out.println("Ajout impossible, cette question appartient déjà a ce sondage");
		}
	}
	
	/** Supprime une question a ce sondage si celle-ci appartient bien à ce sondage
	 * @param q question à supprimer **/
	public void removeQuestion(Question q) {
		if(this.questions.contains(q)) {
			this.questions.remove(q);
		}else {
			System.out.println("Suppression impossible, cette question n'appartient pas à ce sondage");
		}
	}
	
	/** Active le sondage (change la valeur du boolean actif et envoi un mail au sondés) **/
	public void activateSondage() {
		if(this.actif == false) {
			this.actif = true;
			this.SendMailToSondes("activate");
		}else {
			System.out.println("Ce sondage est déjà actif");
		}
	}
	
	/** Désactive le sondage (change la valeur du boolean actif et envoi un mail au sondés) **/
	public void desactivateSondage() {
		if(this.actif == true) {
			this.actif = false;
			this.SendMailToSondes("desactivate");
		}else {
			System.out.println("Ce sondage n'est pas actif");
		}
	}
	
	/** Envoi un mail à tous les sondés contenant le lien du sondage **/
	public void SendMailToSondes(String type) {
		
	}
	
	/** Envoi un mail a un sondé si celui-ci n'a pas répondu au sondage de la semaine **/
	public void SendReminderToSonde(Sonde s) {

	}
	
	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public ArrayList<Sonde> getSondes() {
		return sondes;
	}
	public void setSondes(ArrayList<Sonde> sondes) {
		this.sondes = sondes;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
}
