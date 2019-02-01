package Sondes;

import java.sql.Connection;

import BDD.connexion;
import Sondage.Categorie;

public class FabriqueSondes extends connexion {
	
	private Connection conn;
	
	public FabriqueSondes() {
		super();
		conn = this.getConnect();
	}

	public void createSonde(String nom, String prenom, int age, Categorie categorie, String email) {
		
	}
	
	public void existSonde() {
		
	}
}
