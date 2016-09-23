package group1.hotel.business;

import java.util.Optional;
import dw317.hotel.business.interfaces.Customer;
import dw317.lib.*;
import dw317.lib.creditcard.CreditCard;

/*
 * @author Jephthia Louis
 *
 */

public class DawsonCustomer implements Customer
{
    private static final long serialVersionUID = 42031768871L;
    private final Name name;
    private final Email email;
    private final Optional<CreditCard> creditCard;
    
    public DawsonCustomer(String firstName, String lastName, String email)
    {
        name = new Name(firstName, lastName);
        this.email = new Email(email);
        creditCard = null;
    }
    @Override public int compareTo(Customer customer)
    {
        return this.getEmail().compareTo(customer.getEmail());
    }
    @Override public Name getName()
    {
        return new Name(name.getFirstName(), name.getLastName());
    }
    @Override public Email getEmail()
    {
        return email;
    }
    @Override public Optional<CreditCard> getCreditCard()
    {
        return null;
    }
    @Override public void setCreditCard(Optional<CreditCard> card)
    {
    }
    @Override public boolean equals(Object object)
    {
        if(object == null)
            return false;
        
        if(this == object)
            return true;
        
        if(object instanceof DawsonCustomer)
        {
            DawsonCustomer customer = (DawsonCustomer)object;
            
            if(getEmail().equals(customer.getEmail()))
                return true;
        }
        
        return false;
    }
    @Override public int hashCode()
    {
        //TODO
        return 0;
    }
    @Override public String toString()
    {
        String card = "*";
        
        if(creditCard.isPresent())
            card = creditCard.get().getType().toString()+"*"+creditCard.get().getNumber();
        
        return getEmail().getAddress()+"*"+getName().getFirstName()+"*"+getName().getLastName()
                +"*"+card;
    }
}