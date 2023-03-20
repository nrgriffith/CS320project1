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
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	
}