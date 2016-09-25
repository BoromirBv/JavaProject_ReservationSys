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
		this.firstName = validateName(firstName);
		this.lastName = validateName(lastName);
	}

	/* @return the firstName
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/* @return the lastName
	 * 
	 */
	public String getLastName() {
		return lastName;
	}

	/* @param firstName
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* @param lastName
	 * 
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
	/* @author Nicolas Fontaine
	 * @return first name as a string if true. Throw exception if not valid.
	 */
	public static String validateName(String firstOrLast) {
		String firstOrLastCopy = firstOrLast.toLowerCase();
		if (firstOrLastCopy != null) {
			if (firstOrLastCopy.length() < 2 || 
					!firstOrLastCopy.matches("[a-z]+")) {
				throw new IllegalArgumentException("The name field isn't valid.");
			}
			if (!validateHyphenApostrophe(firstOrLastCopy)) {
				throw new IllegalArgumentException("The hyphen or apostrophy used arn't used correctly.");
			}
		} else {
			throw new NullPointerException("Your name isn't a valid name.");
		}
		return firstOrLastCopy;
	}

	public static boolean validateHyphenApostrophe(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-' || c == '\'' && s.matches("[a-z]+[-][a-z]+") || s.matches("[a-z]+['][a-z]+")) {
				return true;
			} else if (c != '-' || c != '\'' && s.matches("[a-z]+")) {
				return true;
			}
		}
		return false;
	}
}