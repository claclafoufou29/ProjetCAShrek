package Sondage;

import java.util.ArrayList;

public class ListSondage {
	private ArrayList<Sondage> ListSondages;
	
	public ListSondage() {
		this.setListSondages(new ArrayList<Sondage>());
	}

	public ArrayList<Sondage> getListSondages() {
		return ListSondages;
	}

	public void setListSondages(ArrayList<Sondage> listSondages) {
		this.ListSondages = listSondages;
	}
}
