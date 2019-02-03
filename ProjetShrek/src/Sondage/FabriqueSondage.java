package Sondage;

import java.sql.Connection;

import BDD.connexion;

public class FabriqueSondage extends connexion {
	private Connection conn;
	private ListSondage listDesSondages;

	public FabriqueSondage () {
		super();
		conn = this.getConnect();
		this.listDesSondages = new ListSondage();
	}
	
	
}
