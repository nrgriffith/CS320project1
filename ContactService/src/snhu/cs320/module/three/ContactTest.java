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
	Contact contact2 = new Contact("abcdef");

	@Test
	void testFirstName() {
		// too long name
		Assert.assertFalse(contact.setFirstName("Abcdefghijk"));
		// cannot be empty/null
		Assert.assertFalse(contact.setFirstName(""));
		Assert.assertFalse(contact.setFirstName(null));
		// good name
		Assert.assertTrue(contact.setFirstName("George"));
		Assert.assertEquals("George", contact.getFirstName());

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
		Assert.assertEquals("Sarah", contact.getLastName());

	}
	
	@Test
	void testAddress() {
		// too long name
		Assert.assertFalse(contact.setAddress("1600 Pennsylvania Ave, Washington DC, 12345"));
		// cannot be empty/null
		Assert.assertFalse(contact.setAddress(""));
		Assert.assertFalse(contact.setAddress(null));
		// good address
		Assert.assertTrue(contact.setAddress("1 2nd st,place,oh,12345"));
		Assert.assertEquals("1 2nd st,place,oh,12345", contact.getAddress());

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
		// good phone
		Assert.assertTrue(contact.setPhone("3048675309"));
		Assert.assertEquals("3048675309", contact.getPhone());
	}
	
	@Test
	void testContactID() {
		// cannot be null
		Assert.assertNotNull(contact.getContactID());
		// cannot be updated
		/* Note: I don't know what the best technique for this test was,
		 * because the field is private and there is no set method for it,
		 * so this checks for NoSuchFieldException when trying to access it.
		 * I hope that's sufficient to prove that it cannot be updated.
		*/
		Assert.assertThrows(NoSuchFieldException.class, ()->{contact.getClass().getField("contactID");});
	}
}
