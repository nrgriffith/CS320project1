package snhu.cs320.module.five;

import java.util.Date;

public class Appointment {
	
	// required fields
	private String apptID;
	private Date apptDate;
	private String description;
	
	// Maximum character allowance per the rubric
	private final int MAX_CHAR_DE = 50;
	
	// Iterator to create unique contact IDs
	private static int idIterator = 0;

	Appointment(Date date, String descript){
		apptID = String.valueOf(idIterator);
		idIterator++;
		apptDate = date;
		description = descript;
	}
	
	Appointment(Date date){
		apptID = String.valueOf(idIterator);
		idIterator++;
		apptDate = date;
		description = "change me";
	}
	
	Appointment(String descript){
		apptID = String.valueOf(idIterator);
		idIterator++;
		apptDate = new Date();
		description = descript;
	}
	
	Appointment(){
		apptID = String.valueOf(idIterator);
		idIterator++;
		apptDate = new Date();
		description = "changeme";
	}

	// Setters methods
	public Boolean setDescription(String description) {
		if(description == null) {
			return false;
		}
		else if(!description.isBlank() && description.length() <= MAX_CHAR_DE) {
			this.description = description;
			return true;
		}
		return false;
	}
	
	public Boolean setDate(Date date) {
		Date curDate = new Date();
		if(date == null) {
			return false;
		}
		else if(date.before(curDate)) {
			return false;
		}
		else {
			this.apptDate = date;
			return true;
		}
	}
	
	// Getter methods
	public String getID() {
		return apptID;
	}

	public String getDescription() {
		return description;
	}
	
	public Date getDate() {
		return apptDate;
	}
}