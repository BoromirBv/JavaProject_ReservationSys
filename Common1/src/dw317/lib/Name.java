/**
 * 
 */
package dw317.lib;

import java.io.Serializable;

/**
 * @author Nicolas Fontaine
 *
 */
public class Name implements Serializable {
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
	/*
	 * @author Nicolas Fontaine
	 * return first name and last name as a string.
	 * Validates the first and last name, to see if it is 
	 * shorter than 2 letters and if it has valid characters.
	 */

	public static String validateName(String first1, String last1) {
		String firstName = first1.toLowerCase();
		String lastName = last1.toLowerCase();
		if (firstName != null && lastName != null) {
			if (firstName.isEmpty() && lastName.isEmpty()) { // empty
				throw new IllegalArgumentException("The name field is empty.");
			}
			if (firstName.length() < 2 && lastName.length() < 2) {
				throw new IllegalArgumentException("The name field needs to contain for than 2 letters.");
			}
			if (!firstName.matches("[a-z]+") && !lastName.matches("[a-z]+")) {
				throw new IllegalArgumentException("The name field is invalid");
			}
			for (int i = 0; i < firstName.length(); i++) {
				char c = firstName.charAt(i);
				if (c == '-' || c == '\'' && firstName.matches("[a-z]+[-][a-z]+")
						|| firstName.matches("[a-z]+['][a-z]+")) {
				}
			}
			if (!validateHyphenApostrophe(firstName) || (!validateHyphenApostrophe(lastName))) {
				throw new IllegalArgumentException("The hyphen or apostrophy used arn't used correctly.");
			}
		} else {
			throw new NullPointerException("Your name isn't a valid name.");
		}

		return null;
	}

	public static boolean validateHyphenApostrophe(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-' || c == '\'' && s.matches("[a-z]+[-][a-z]+") || s.matches("[a-z]+['][a-z]+")) {
				return true;
			} else if (c != '-' || c != '\'' && s.matches("[a-z]")) {
				return true;
			} else if (c == '-' || c == '\'' && !s.matches("[a-z]+[-][a-z]+") || !s.matches("[a-z]+['][a-z]+")) {
				return false;
			}
		}
		return false;
	}
}