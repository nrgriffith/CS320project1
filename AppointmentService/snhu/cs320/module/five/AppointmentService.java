package snhu.cs320.module.five;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

	private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	private void addAppt(Appointment appt) { // add appointment to list
		appointmentList.add(appt);
	}
	
	private Appointment searchAppt(String id) { // search for an appointment ID
		for (Appointment appt : appointmentList) {
			if(appt.getID().equals(id)) {
				return appt;
			}
		}
		return null;
	}
	
	public void createAppt() { // new blank appointment
		Appointment appt = new Appointment();
		addAppt(appt);
	}
	
	public void createAppt(Date date) { // new appointment with date
		Appointment appt = new Appointment(date);
		addAppt(appt);
	}
	
	public void createAppt(Date date, String description) { // new appointment with date and description
		Appointment appt = new Appointment(date, description);
		addAppt(appt);
	}
	
	public void deleteAppt(String id) { // delete appointment from list
		Appointment appt = searchAppt(id);
		if(appt != null) {
			appointmentList.remove(appt);
		}

	}
	
	public ArrayList<Appointment> getAppointments(Date date) { // return appointments on specified date
		ArrayList<Appointment> returnList = new ArrayList<Appointment>();
		for(Appointment appointment : appointmentList) {
			if(appointment.getDate().equals(date)) {
				returnList.add(appointment);
			}
		}

		return returnList;
	}
	
	public int size() {	
		return appointmentList.size();
	}
}
