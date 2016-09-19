/**
 * 
 */
package dw317.lib;

import java.io.Serializable;

import dw317.lib.creditcard.CreditCard.CardType;

/**
 * @author
 *
 */
public class Email implements Serializable Comparable<Email>
{

	private final long serialVersionUID = 42031768871L;
	private final String address;

	public Email(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getUserId() {
		return null;
	}

	public String getHost() {
		return null;
	}

	@Override
	public boolean equals(Object object) {
		return false;
	}

	@Override
	public String getNumber() {
		return null;
	}

	@Override
	public Scheme getType() {
		return null;
	}

	@Override
	public String toString() {
		return address;
	}

	private static String validateEmail(String email) throws IllegalArgumentException {
		
	}
}
