package day22;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Journal {
	private ArrayList<StudentJournal> sjList;
	private String date;
	
	public Journal(ArrayList<StudentJournal> sjList, String date) {
		this.sjList = sjList;
		this.date = date;
	}

	public Journal(ArrayList<StudentJournal> sjList) {
		this.sjList = sjList;
	}
	
}
