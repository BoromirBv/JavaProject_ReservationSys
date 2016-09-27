package dw317.hotel.business.interfaces;

import java.io.Serializable;
import java.util.Optional;
import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;

/**
 * @author Nicolas Fontaine
 */

public interface Customer extends Comparable<Customer>, Serializable{
	
	public Name getName();
	
	public Email getEmail();
	
	public Optional<CreditCard> getCreditCard();
	
	public void setCreditCard(Optional<CreditCard> card);
}
