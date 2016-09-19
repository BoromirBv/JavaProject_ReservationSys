package group1.hotel.business;

import dw317.lib.Email;
import dw317.lib.Name;
import dw317.lib.creditcard.CreditCard;

public class DawsonCustomer {
	
	private Name name;
	private Email email;
	private CreditCard creditCard = null;
	private static final long serialVersionUID = 42031768871L;
	
	public DawsonCustomer(String name, String email, String creditCard){

	}
	
	public Name getName(){
		return null;
	}
	public Email getEmail(){
		return null;
	}
	
	@Override
	public boolean equals(Object obj){
		return false;
	}
	
	@Override
	public int hashCode(){
		return 0;
	}
	
	@Override
	public String toString(){
		return null;
	}
}
