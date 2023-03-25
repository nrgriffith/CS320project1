/**
 * 
 */
package snhu.cs320.module.three;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Nichole Griffith
 *
 */
public class ContactTest {
	
	// new contact to test
	Contact contact = new Contact();

	@Test
	void testFirstName() {
		// too long name
		Assert.assertFalse(contact.setFirstName("Abcdefghijk"));
		// cannot be empty/null
		Assert.assertFalse(contact.setFirstName(""));
		Assert.assertFalse(contact.setFirstName(null));
		// good name
		Assert.assertTrue(contact.setFirstName("George"));

	}
	
	@Test
	void testLastName() {
		// too long name
		Assert.assertFalse(contact.setLastName("Abcdefghijk"));
		// cannot be empty/null
		Assert.assertFalse(contact.setLastName(""));
		Assert.assertFalse(contact.setLastName(null));
		// good name
		Assert.assertTrue(contact.setLastName("Sarah"));

	}
	
	@Test
	void testAddress() {
		// too long name
		Assert.assertFalse(contact.setAddress("1600 Pennsylvania Ave, Washington DC, 12345"));
		// cannot be empty/null
		Assert.assertFalse(contact.setAddress(""));
		Assert.assertFalse(contact.setAddress(null));
		// good name
		Assert.assertTrue(contact.setAddress("1 2nd st,place,oh,12345"));

	}
	
	@Test
	void testPhone() {
		// too long
		Assert.assertFalse(contact.setPhone("12345678910"));
		// cannot be empty/null
		Assert.assertFalse(contact.setPhone(""));
		Assert.assertFalse(contact.setPhone(null));
		// too small
		Assert.assertFalse(contact.setPhone("123"));	
	}
	
	@Test
	void testContactID() {
		// cannot be null
		Assert.assertNotNull(contact.getContactID());
		// cannot be updated
		Assert.assertThrows(NoSuchFieldException.class, ()->{contact.getClass().getField("contactID");});
	}
}
