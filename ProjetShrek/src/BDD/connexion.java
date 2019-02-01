package BDD;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class connexion {
	
	private Connection connect;
	
	public connexion() {      
	    try {
	      Class.forName("org.postgresql.Driver");
	      System.out.println("Driver O.K.");

	      String url = "";
	      String user = "postgres";
	      String passwd = "postgres";

	      setConnect(DriverManager.getConnection(url, user, passwd));
	      System.out.println("Connexion à la base effectuée");         
	         
	    } catch (Exception e) {
	    	System.out.println("Impossible de se connecter a la base de données");
	    	e.printStackTrace();
	    }      
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
}
