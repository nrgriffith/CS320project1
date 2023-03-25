/**
 * 
 */
package snhu.cs320.module.three;

/**
 * @author Nichole Griffith
 *
 */
public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Maximum character allowance per the rubric
	//private final int MAX_CHAR_ID = 10;
	private final int MAX_CHAR_FN = 10;
	private final int MAX_CHAR_LN = 10;
	private final int MAX_CHAR_PH = 10;
	private final int MAX_CHAR_AD = 30;
	
	// Iterator to create unique contact IDs
	private static int idIterator = 0;
	
	Contact(){
		contactID = String.valueOf(idIterator);
		idIterator++;
		firstName = "John";
		lastName = "Doe";
		phone = "5558675309";
		address = "12 Elm St,Springfield,IL,12345";
		
	}
	
	// Getter & Setter methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getContactID() {
		return contactID;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Boolean setFirstName(String name) {
		if(name == null) {
			return false;
		}
		if(!name.isBlank() && name.length() <= MAX_CHAR_FN) {
			this.firstName = name;
			return true;
		}
		return false;
	}
	
	public Boolean setLastName(String name) {
		if(name == null) {
			return false;
		}
		if(name.length() <= MAX_CHAR_LN && !name.isBlank()) {
			this.lastName = name;
			return true;
		}
		return false;
	}
	
	public Boolean setPhone(String phone) {
		if(phone.length() != MAX_CHAR_PH) {
			this.phone = phone;
			return true;
		}
		return false;
	}
	
	public Boolean setAddress(String newAddress) {
		if (newAddress == null) {
			return false;
		}
		if(newAddress.length() <= 30 && !newAddress.isBlank()) {
			this.address = newAddress;
			return true;
		}
		return false;
	}

}
