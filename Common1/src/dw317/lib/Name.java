/**
 * 
 */
package dw317.lib;

/**
 * @author
 *
 */
public class Name {
	private static final long serialVersionUID = 42031768871L;
	private String firstName;
	private String lastName;

	public Name() {
	}

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}

	@Override
	public String toString() {
		return (firstName + "*" + lastName);
	}

}
