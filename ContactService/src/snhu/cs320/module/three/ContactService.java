/**

 * 
 */
package snhu.cs320.module.three;

import java.util.ArrayList;

/**
 * @author Nichole Griffith
 *
 */
public class ContactService {

	private ArrayList<Contact> contactsList = new ArrayList();

	public String addContact() {
		// add a new contact
		Contact contact = new Contact();
		contactsList.add(contact);
		return contact.getContactID();
	}
	
	private Contact searchContact(String id) {
		// search for a contact
		// iterate through contactsList to find the matching contactID
		for(Contact contact : contactsList) {
			if(contact.getContactID().equals(id)) {
				return contact;
			}
		}
		return null;
	}
	
	private Boolean deleteContact(String id) {
		// delete a contact
		Contact contact = searchContact(id);
		if(contact == null) {
			return false;
		}
		return true;
	}
	
	private Boolean updateContact(String id, int item, String value) {
		// update the contact's first name
		Contact contact = searchContact(id);
		if(contact == null) {
			return false;
		}
		switch(item) {
			case 1: // update first name
				return contact.setFirstName(value);
			case 2: // update last name
				return contact.setLastName(value);
			case 3: // update address
				return contact.setAddress(value);
			case 4: // update phone
				return contact.setPhone(value);
			default:
				return false;
		}
	}
	
}
