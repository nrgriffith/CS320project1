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
public class ContactServiceTest {

	ContactService contacts = new ContactService();
	
	ContactServiceTest() {
		// initialize with some contacts
		contacts.addContact();
		contacts.addContact();
		contacts.addContact();
		contacts.addContact("deleteme");
	}
	
	@Test
	void testAdd() {
		String testID = "myid";
		String test = contacts.addContact(testID);
		Assert.assertTrue(test.equals(testID));
	}

	@Test
	void testSearch() {
		Assert.assertEquals(contacts.searchContact("deleteme").getContactID(), "deleteme");
	}
	

	
	@Test
	void testDelete() {
		// delete the contact associated with contactID deleteme
		Assert.assertTrue(contacts.deleteContact("deleteme"));
		// ensure the contact is deleted
		Contact testContact = contacts.searchContact("deleteme");
		// contact not found
		Assert.assertNull(testContact);	
		}
	
	}
