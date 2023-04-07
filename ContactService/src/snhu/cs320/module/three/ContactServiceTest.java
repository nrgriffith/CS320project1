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
	void testUpdate() {
		String contactID = "deleteme";
		String testFName = "Jennifer";
		String testLName = "Brooks";
		String testAddress = "321 Elm St";
		String testPhone = "3138675309";
		
		// update the fields
		Assert.assertTrue(contacts.updateContact(contactID, 1, testFName));
		Assert.assertTrue(contacts.updateContact(contactID, 2, testLName));
		Assert.assertTrue(contacts.updateContact(contactID, 3, testAddress));
		Assert.assertTrue(contacts.updateContact(contactID, 4, testPhone));
		Assert.assertFalse(contacts.updateContact(contactID, 8, testPhone));
		
		// make sure the fields match the test data
		Contact testContact = contacts.searchContact(contactID);
		Assert.assertEquals(testContact.getFirstName(), testFName);
		Assert.assertEquals(testContact.getLastName(), testLName);
		Assert.assertEquals(testContact.getAddress(), testAddress);


	}
	
	@Test
	void testDelete() {
		// delete the contact associated with contactID deleteme
		Assert.assertTrue(contacts.deleteContact("deleteme"));
		// ensure the contact is deleted
		Contact testContact = contacts.searchContact("deleteme");
		// contact not found
		Assert.assertNull(testContact);
		Assert.assertFalse(contacts.deleteContact("deleteme"));
		}
	}
