package dw317.lib;

import java.io.Serializable;

/**
 * @author Nicolas Fontaine and Jephthia Louis
 */
public class Email implements Serializable, Comparable<Email> {

	private final static long serialVersionUID = 42031768871L;
	private final String address;
	
	/** 
	 * @param address
	 */
	public Email(String address) {
		this.address = validateEmail(address);
	}

	/** 
	 * @author Jephthia Louis
	 * @param email
	 * Compares 2 emails by the order of the host name followed by the user id, 
	 * all case-insensitive
	 */
	@Override
	public int compareTo(Email email) {
		String full = this.getHost() + this.getUserId();
		return full.compareToIgnoreCase(email.getHost() + email.getUserId());
	}
	
	/** 
	 * @author Nicolas Fontaine
	 * @return boolean if the emails are equal. Two emails are equal if
	 * they have the same reference, are the same object, have the same class,
	 * have the same address, or have the same hash code.
	 * @param object
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
			if (this.getAddress().equals(((Email) object).getAddress())) {
				return true;
			}
		}
		if(this.hashCode() == object.hashCode()) {
			return true;
		}
		return false;
	}

	/** 
	 * @author Nicolas Fontaine
	 * @return tmp, a copy of the address
	 */
	public String getAddress() {
		String tmp = address;
		return tmp;
	}
	
	/**
	 * @author Nicolas Fontaine
	 * @return hostname from the email address.
	 */
	public String getHost() {
		String s = "";
		for (int i = 0; i < address.length(); i++) {
			char c = address.charAt(i);
			if (c == '@') {
				return address.substring(i + 1, address.length() - 1);
			}
		}
		return s;
	}
	/**
	 * @author Nicolas Fontaine
	 * @return hostname from the email address.
	 * Used for validation.
	 */
	private static String getHost(String b) {
		String s = "";
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (c == '@') {
				return b.substring(i + 1, b.length() - 1);
			}
		}
		
		return s;
	}

	/** 
	 * @author Nicolas Fontaine
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
	
	/** 
	 * @author Nicolas Fontaine
	 * @return user id from the email address.
	 * Used for validation.
	 */
	private static String getUserId(String b) {
		String s = "";
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (c != '@') {
				s += c;
			} else
				return s;
		}
		return s;
	}
	
	/** 
	 * @author Jephthia Louis
	 * @return the hashcode generated
	 */
	@Override
	public final int hashCode() {
		return 37 + (getAddress() == null ? 0 : getAddress().hashCode());
	}

	@Override
	public String toString() {
		return address;
	}
	
	/** 
	 * @author Nicolas Fontaine
	 * @return email, the email address
	 * @param email
	 * @throws IllegalArgumentException if length, userId, domain, are invalid or email is empty.
	 */
	private static String validateEmail(String email) throws IllegalArgumentException {
		if (email != null) {
			if (getUserId(email).length() < 1 || getUserId(email).length() > 32) {
				throw new IllegalArgumentException("Email length isn't valid.");
			}
			if (!getUserId(email).matches("^[A-Za-z0-9_.-]+$") || getUserId(email).matches("^[.].+")
					|| getUserId(email).matches(".+[.]$") || getUserId(email).matches("^[.]$")
					|| getUserId(email).matches(".*[.][.].*")) {
				throw new IllegalArgumentException("Email is invalid - Invalid UserID");
			}
			if (validateDomainName(getHost(email))) {
				return email;
			}
			else {
				throw new IllegalArgumentException("Invalid Email - Invalid Domain.");
			}
		} else {
			throw new IllegalArgumentException("Invalid Email - email is empty");
		}
	}
	
	/** 
	 * @author Nicolas Fontaine
	 * @return boolean if the domain is valid
	 * @param string of the domain
	 */
	public static boolean validateDomainName(String s) {
		int lastDot = -1;
		String segment = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (c == '.') {
				segment = s.substring(lastDot + 1, i);
				if (segment.length() > 32 || segment.length() < 1) {
					return false;
				}
				if (segment.matches("^[-].+") || segment.matches("^.+[-]$") || segment.matches("^[-]$")) {
					return false;
				}
				if (segment.matches("^[A-Za-z0-9-]+$")) {
					return true;
				}
				System.out.println(lastDot);
				lastDot = i;
			}
		}
		return false;
	}
}
