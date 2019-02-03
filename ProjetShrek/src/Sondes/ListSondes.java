package Sondes;

import java.util.ArrayList;

public class ListSondes {
	
	private ArrayList<Sonde> listSondes;
	
	public ListSondes() {
		this.setListSondes(new ArrayList<Sonde>());
	}

	public ArrayList<Sonde> getListSondes() {
		return listSondes;
	}

	public void setListSondes(ArrayList<Sonde> listSondes) {
		this.listSondes = listSondes;
	}
}
