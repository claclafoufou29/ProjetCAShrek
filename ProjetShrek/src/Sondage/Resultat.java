package Sondage;

import java.util.Date;

import Sondes.Sonde;

/**
@author Groupe Shrek
**/
public class Resultat {
	/**
	 * Un Resultat est composé d'une réponse, d'un sonde et de la date de la réponse 
	 */
	private Reponse rep;
	private Sonde sonde;
	private Date dateRep;
	/** 
	 * constructeur de Resultat, sert pour l'ajout d'un résultat
	 * **/
	public Resultat(Reponse rep, Sonde sonde, Date dateRep) {
		this.rep=rep;
		this.sonde=sonde;
		this.dateRep = dateRep;
	}
	/**
	 * Accès à la réponse correpondant à un résultat
	 * @return la réponse 
	 */
	public Reponse getRep() {
		return this.rep;
	}
	/**
	 * Modification d'une réponse correspondant à un résultat
	@param Reponse rep
	**/
	public void setRep(Reponse rep) {
		this.rep = rep;
	}
	/**
	 * Accès au sondé correpondant à un résultat
	 * @return sonde 
	 */
	public Sonde getSonde() {
		return this.sonde;
	}
	/**
	 * Modification d'un sondé correspondant à un résultat
	@param Sonde sonde
	**/
	public void setSonde(Sonde sonde) {
		this.sonde = sonde;
	}
	/**
	 * Accès a la date de réponse correpondant à un résultat
	 * @return dateRep
	 */
	public Date getDateRep() {
		return this.dateRep;
	}
	/**
	 * Modification d'une date de réponse correspondant à un résultat
	@param Date dateRep
	**/
	public void setDate(Date dateRep) {
		this.dateRep = dateRep;
	}
	
}

