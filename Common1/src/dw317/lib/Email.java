/**
 * 
 */
package dw317.lib;

import java.io.Serializable;

/**
 * @author
 *
 */
public class Email implements Serializable, Comparable<Email> {

	private final long serialVersionUID = 42031768871L;
	private final String address;

	public Email(String address) {
		this.address = address;
	}

	/* @return returns the email address.
	 * 
	 */
	public String getAddress() {
		return address;
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
	 * @return boolean if the emails are equal
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
		return false;
	}

	@Override
	public int compareTo(Email arg0) {

		return 0;
	}

	//Not necessary for now
	/*@Override
	public String getNumber() {
		return null;
	}

	@Override
	public Scheme getType() {
		return null;
	}*/

	@Override
	public String toString() {
		return address;
	}

	private static String validateEmail(String email) 
			throws IllegalArgumentException {

		return null;
	}

}