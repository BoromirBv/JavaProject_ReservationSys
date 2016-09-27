/**
 * 
 */
package dw317.lib;

/**
 * @author Andreea Draghicescu
 *
 */
public class Person {
	
	private Name name;
	private Address address;

	public Person(String firstName, String lastName){
		firstName = name.getFirstName();
		lastName = name.getLastName();
	}
	
	public Person(String firstName, String lastName, 
			Address address){
		firstName = name.getFirstName();
		lastName = name.getLastName();
		
		address = new Address();
	}
	
	public String getAddress() {
		if(address.getCivicNumber().isEmpty()){
			throw new IllegalArgumentException(
					address.getAddress() + "is empty");
		}
		else {
			String copy = address.getAddress();
			return copy;
		}
	}
	
	public String getName(){
		String copy = name.getFullName();
		return copy;
	}
	
	public void setName(String firstName, String lastName) {
		firstName = name.getFirstName();
		lastName = name.getLastName();
	}
	
	public void setAddress(Address address){
		address = new Address();
	}
	
	@Override
	public String toString() {
	             
	    return name.toString() + "*" + 
	    (address == null ? ""  : address.toString());                      
	}
}
