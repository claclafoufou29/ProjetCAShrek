package Utilisateurs;
import java.util.ArrayList;
import java.util.Scanner;

import Sondes.Sonde;

public class Admin {
	public static int num = 0;
	private int id;
	private String email;
	private String mdp;
	private ArrayList<Sondeur> listSondeur;
	
	{
		num++;
	}

	public Admin(String email, String mdp) {
		setEmail(email);
		setMdp(mdp);
		setId(num);
		this.listSondeur = new ArrayList<Sondeur>();
	}
	
	/** Cree un sondeur **/
	public void createSondeur() {
		System.out.println("Création nouveau sondeur");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom :");
		String nom = sc.nextLine();
		System.out.println("Prénom :");
		String prenom = sc.nextLine();
		System.out.println("Email :");
		String mail = sc.nextLine();
		System.out.println("Mot de passe :");
		String mdp = sc.nextLine();
		Sondeur sondeur = new Sondeur(nom, prenom, mail, mdp);
	}
	
	/** Supprime un sondeur 
	 * @param s Sondeur à supprimer **/
	public void supprimerSondeur(Sondeur s) {
		
	}
	
	/** Crée un sonde **/
	public void createSonde() {
		
	}
	
	/** Supprime un sonde
	 * @param s Sonde à supprimer **/
	public void supprimerSonde(Sonde s) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public ArrayList<Sondeur> getListSondeur() {
		return listSondeur;
	}

	public void setListSondeur(ArrayList<Sondeur> listSondeur) {
		this.listSondeur = listSondeur;
	}
}
