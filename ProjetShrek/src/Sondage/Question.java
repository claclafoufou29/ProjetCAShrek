package Sondage;
import java.util.ArrayList;

public class Question {
	static int num = 0;
	private int id;
	private String intitule;
	private ArrayList<Reponse> reponseList;
	
	/**
	* Les attributs :
	* 	- id permet d'identifier la question 
	* 	- num s'indent et permetl'auto-incrémentation de l'id 
	* 	- intitule comporte l'intitule de la question
	* 	- reponseList possède la liste des réponses presentent dans une question
	*/
	//test commit mdr
	public Question(String intitule) {
		num++;
		this.id = num;
		this.intitule = intitule;
		reponseList = new ArrayList<Reponse>();
	}

	public String getIntitule() {
		return intitule;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getId() {
		return id;
	}
	
	/**
	* La méthode addReponse permet de lier une réponse à une question en passant 
	* en parametre une réponse.
	**/
	public void addReponse(Reponse r) {
		if(r != null)
			reponseList.add(r);
		else
			System.out.println("Erreur : la réponse donné en argument est vide");
	}
	
	/**
	* La méthode removeRéponseFromQuestion permet de supprimer une réponse lié à une question en passant 
	* en parametre la réponse souhaitant être supprimé.
	**/
	
	public void removeReponseFromQuestion(Reponse r) {
		if(!reponseList.contains(r))
			System.out.println("Erreur : la réponse donné en argument n'est pas présent");
		else if (r != null)
			System.out.println("Erreur : la réponse donné en argument est vide");
		else
			reponseList.remove(r);
	}
	
}
