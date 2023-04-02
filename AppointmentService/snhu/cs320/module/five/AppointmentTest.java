package snhu.cs320.module.five;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class AppointmentTest {
	
	// yes, this constructor is deprecated but the rubric tells us to use this class
	// and this is easier than using the Calendar class along with the Date class
	@SuppressWarnings("deprecation")
	private Date exDate = new Date(2123-1900, 1-1, 1);
	@SuppressWarnings("deprecation")
	private Date pastDate = new Date(2000-1900, 6-1, 6);
	
	// some example appointments
	private Appointment blankAppt = new Appointment();
	private Appointment dateAppt = new Appointment(exDate);
	private Appointment fullAppt = new Appointment(exDate, "An appointment");
	
	@Test
	void testApptID() {
		// cannot be updated
		Assert.assertThrows(NoSuchFieldException.class, ()->{fullAppt.getClass().getField("apptID");});
	}
	
	@Test
	void testDescription() {
		// too long
		Assert.assertFalse(blankAppt.setDescription("This sentence has over fifty characters and will throw an error when I go to test it."));
		// empty/null
		Assert.assertFalse(blankAppt.setDescription(null));
		Assert.assertFalse(blankAppt.setDescription(""));
		// just right
		Assert.assertTrue(blankAppt.setDescription("change oil"));
	}
	
	@Test
	void testDates() {
		// in the past
		Assert.assertFalse(dateAppt.setDate(pastDate));
		// future date
		Assert.assertTrue(dateAppt.setDate(exDate));
	}
}
