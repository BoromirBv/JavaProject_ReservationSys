package dw317.lib;

import java.io.Serializable;

/**
 * @author Nicolas Fontaine
 *
 */
public class Email implements Serializable, Comparable<Email> {

	private final static long serialVersionUID = 42031768871L;
	private final String address;
	
	/* @param cardType, number
	 * 
	 */
	public Email(String address) {
		this.address = validateEmail(address);
	}

	@Override
	public int compareTo(Email arg0) {
		return 0;
	}
	
	/* @author Nicolas Fontaine
	 * @return boolean if the emails are equal. Two emails are equal if
	 * they have the same reference, are the same object, have the same class,
	 * have the same address, or have the same hash code.
	 */
	@Override
	public final boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (this == object) {
			return true;
		}
		if (this.getClass() == object.getClass()) {
			return true;
		}
		if (this.getAddress() == ((Email) object).getAddress()) {
			return true;
		}
		if (this.hashCode() == object.hashCode()) {
			return true;
		}
		return false;
	}

	/* @author Nicolas Fontaine
	 * @return tmp, a copy of the address
	 */
	public String getAddress() {
		String tmp = address;
		return tmp;
	}
	
	/* @author Nicolas Fontaine
	 * @return hostname from the email address.
	 */
	public String getHost() {
		String s = "";
		int count = 0;
		for (int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if (c == '@') {
				count = address.charAt(i);
				return address.substring(count + 1, address.length() - 1);
			}
		}
		return s;
	}

	/* @author Nicolas Fontaine
	 * @return user id from the email address.
	 */
	public String getUserId() {
		String s = "";
		for (int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if (c != '@') {
				s += c;
			} else
				return s;
		}
		return s;
	}

	public final int hashCode() {
		
		return this.hashCode();
	}

	@Override
	public String toString() {
		return address;
	}
	
	/* @author Nicolas Fontaine
	 * @return email, the email address
	 * @param email
	 */
	private static String validateEmail(String email) throws IllegalArgumentException {
		/*if (email != null) {
			Email e = new Email(email);
			if (e.getUserId().length() < 1 || e.getUserId().length() > 32) {
				throw new IllegalArgumentException("Email length isn't valid.");
			}
			if (!e.getUserId().matches("^[A-Za-z0-9_.-]+$") || e.getUserId().matches("^[.].+")
					|| e.getUserId().matches(".+[.]$") || e.getUserId().matches("^[.]$")
					|| e.getUserId().matches(".*[.][.].*")) {
				throw new IllegalArgumentException("Email is invalid.");
			}
			if (validateDomainName(e.getHost())) {
				return e.toString();
			}
			throw new IllegalArgumentException("Invalid Email.");
		} else {
			throw new IllegalArgumentException("Invalid Email - email is empty");
		}*/
		return email;
	}

	public static boolean validateDomainName(String s) {
		int lastDot = -1;
		String segment = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (c == '.') {
				segment = s.substring(s.charAt(lastDot + 1), s.charAt(i - 1));
				if (segment.length() > 32 || segment.length() < 1) {
					return false;
				}
				if (segment.matches("^[-].+") || segment.matches(".+[-]$") || segment.matches("^[-]$")) {
					return false;
				}
				if (segment.matches("^[A-Za-z0-9-]+$")) {
					return true;
				}
				lastDot = i;
			}
		}
		return false;
	}
}