package snhu.cs320.module.five;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class AppointmentServiceTest {
	
	AppointmentService appointments = new AppointmentService();

	// yes, this constructor is deprecated but the rubric tells us to use this class
	// and this is easier than using the Calendar class along with the Date class
	@SuppressWarnings("deprecation")
	private Date exDate = new Date(2123-1900, 1-1, 1);
	@SuppressWarnings("deprecation")
	private Date exDate2 = new Date(2123-1900, 5-1, 8);
	
	public AppointmentServiceTest() { // create some appointments
		appointments.createAppt(exDate);
		appointments.createAppt(exDate2, "this is another test");
	}
	
	@Test
	public void testAdd() { // add an appointment
		int baseVal = appointments.size();
		appointments.createAppt();
		Assert.assertEquals(baseVal+1, appointments.size());
	}
	
	@Test
	public void testDelete() {
		// find all appointments with a bad date, should return empty
		@SuppressWarnings("deprecation")
		Date pastDate = new Date(2000-1900, 6-1, 6);
		ArrayList<Appointment> apptOnDate = appointments.getAppointments(pastDate);
		Assert.assertEquals(0,apptOnDate.size());
		
		// find all appointments with date exDate, should return 1
		apptOnDate = appointments.getAppointments(exDate);
		Assert.assertEquals(1, apptOnDate.size());
		
		// delete all appointments with date exDate
		for(int i = 0; i < apptOnDate.size(); ++i) {
			appointments.deleteAppt(apptOnDate.get(i).getID());
		}
		
		// find all appointments with date exDate, should return 0
		apptOnDate = appointments.getAppointments(exDate);
		int numAppts = apptOnDate.size();
		Assert.assertEquals(0, numAppts);
	}
	
}
