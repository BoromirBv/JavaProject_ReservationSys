package group1.hotel.business;

import java.util.Optional;
import dw317.hotel.business.interfaces.Customer;
import dw317.lib.*;
import dw317.lib.creditcard.CreditCard;

/**
 * @author Jephthia Louis
 *
 */

public class DawsonCustomer implements Customer {
	private static final long serialVersionUID = 42031768871L;
	private final Name name;
	private final Email email;
	private final Optional<CreditCard> creditCard;

	public DawsonCustomer(String firstName, String lastName, String email) {
		this.name = new Name(firstName, lastName);
		this.email = new Email(email);
		creditCard = null;
	}
	
	/* @author Jephthia Louis
	 * @return int
	 * @param customer
	 */
	@Override
	public int compareTo(Customer customer) {
		return this.getEmail().compareTo(customer.getEmail());
	}
	
	/* @author Jephthia Louis
	 * @return boolean if the objects are equal or not. Two Customer objects are 
	 * considered equal if they are instances of the same class and their 
	 * email attributes are equal.
	 * @param object
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;

		if (this == object)
			return true;

		if (object instanceof DawsonCustomer) {
			DawsonCustomer customer = (DawsonCustomer) object;

			if (getEmail().equals(customer.getEmail()))
				return true;
		}

		return false;
	}
	
	/* @author Jephthia Louis
	 * @return the credit card.
	 */
	@Override
	public Optional<CreditCard> getCreditCard() {
		return null;
	}
	
	/* @author Jephthia Louis
	 * @return the email address.
	 */
	@Override
	public Email getEmail() {
		return email;
	}
	
	/* @author Jephthia Louis
	 * @return the name.
	 */
	@Override
	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}

	@Override
	public int hashCode() {
		return 0;
	}
	
	/* @author Jephthia Louis
	 * @param card
	 */
	@Override
	public void setCreditCard(Optional<CreditCard> card) {
	}
	/* @author Jephthia Louis
	 * @return string of the parameters.
	 */
	@Override
	public String toString() {
		String card = "*";

		if (creditCard.isPresent())
			card = creditCard.get().getType().toString() + "*" + creditCard.get().getNumber();

		return getEmail().getAddress() + "*" + getName().getFirstName() + "*" + getName().getLastName() + "*" + card;
	}
}