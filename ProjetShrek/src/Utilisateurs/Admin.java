package Utilisateurs;
import java.util.Scanner;

public class Admin {
	public static int num = 0;
	private int id;
	private String email;
	private String mdp;
	
	{
		num++;
	}

	public Admin(String email, String mdp) {
		setEmail(email);
		setMdp(mdp);
		setId(num);
	}
	
	/** Cree un sondeur **/
	public void createSondeur() {
		System.out.println("Cr�ation nouveau sondeur");
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom :");
		String nom = sc.nextLine();
		System.out.println("Pr�nom :");
		String prenom = sc.nextLine();
		System.out.println("Email :");
		String mail = sc.nextLine();
		System.out.println("Mot de passe :");
		String mdp = sc.nextLine();
		Sondeur sondeur = new Sondeur(nom, prenom, mail, mdp);
	}
	
	/** Supprime un sondeur 
	 * @param s Sondeur � supprimer **/
	public void supprimerSondeur(Sondeur s) {
		
	}
	
	/** Cr�e un sonde **/
	public void createSonde() {
		
	}
	
	/** Supprime un sonde
	 * @param s Sonde � supprimer **/
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
}
