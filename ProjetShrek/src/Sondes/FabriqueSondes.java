package Sondes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import BDD.connexion;
import Sondage.Categorie;
import Sondage.Sondage;

public class FabriqueSondes extends connexion {
	
	private Connection conn;
	private ListSondes listDesSondes;
	
	public FabriqueSondes() {
		super();
		conn = this.getConnect();
		listDesSondes = new ListSondes();
	}

	public void createSonde(String nom, String prenom, int age, Categorie categorie, String email) {
		if(!findSonde(nom, prenom)) {
			Sonde s = new Sonde(nom, prenom, age, categorie, email);
			listDesSondes.getListSondes().add(s);
			try {
			    PreparedStatement prepare = conn.prepareStatement("INSERT INTO snd_sonde_t VALUES ( ? , ? , ? , ? , ?);");
			    prepare.setString(1, nom);
			    prepare.setString(2, prenom);
			    prepare.setInt(3, age);
			    prepare.setInt(4, categorie.getId());
			    prepare.setString(5, email);
			    prepare.executeQuery();
			} catch (SQLException e) {
				System.out.println("Problème d'insertion dans la base \n");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ce sondé éxiste déjà \n");
		}
	}
	
	public void deleteSonde(Sonde s) {
		if(findSonde(s.getNom(), s.getPrenom())) {
			listDesSondes.getListSondes().remove(s);
			listDesSondes.getListSondes().add(s);
			try {
			    PreparedStatement prepare = conn.prepareStatement("DELETE FROM snd_sonde_t WHERE snd_nom = ? AND snd_prenom = ?;");
			    prepare.setString(1, s.getNom());
			    prepare.setString(2, s.getPrenom());
			    prepare.executeQuery();
			} catch (SQLException e) {
				System.out.println("Problème de suppression dans la base \n");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ce sondé n'éxiste pas");
		}
	}
	
	public boolean findSonde(String nom, String prenom) {
		boolean res = false;
		Iterator<Sonde> it = listDesSondes.getListSondes().iterator();
		while(it.hasNext()) {
			Sonde current = it.next();
			if(current.getNom() == nom && current.getPrenom() == prenom) {
				res = true;
			}
		}
		return res;
	}
	
	public void addSondage(Sonde s, Sondage sd) {
		if(!s.getSondages().contains(sd)) {
			s.addSondage(sd);
			try {
			    PreparedStatement prepare = conn.prepareStatement("INSERT INTO par_participant_t VALUES ( ? , ? );");
			    prepare.setInt(1, s.getId());
			    prepare.setInt(2, sd.getId());
			    prepare.executeQuery();
			} catch (SQLException e) {
				System.out.println("Problème d'insertion dans la base \n");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ce sondé est déjà abonné a ce sondage \n");
		}
	}
	
	public void removeSondage(Sonde s, Sondage sd) {
		if(s.getSondages().contains(sd)) {
			s.removeSondage(sd);
			try {
			    PreparedStatement prepare = conn.prepareStatement("DELETE FROM par_participant_t WHERE sdg_sondage_id = ? AND snd_sonde_id = ? ;");
			    prepare.setInt(1, s.getId());
			    prepare.setInt(2, sd.getId());
			    prepare.executeQuery();
			} catch (SQLException e) {
				System.out.println("Problème de suppression dans la base \n");
				e.printStackTrace();
			}
		}else {
			System.out.println("Ce sondé n'est pas abonné a ce sondage \n");
		}
	}
	
	
	 
}
