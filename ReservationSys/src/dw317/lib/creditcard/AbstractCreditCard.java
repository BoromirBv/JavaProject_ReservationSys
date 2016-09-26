package dw317.lib.creditcard;

/**
 * @author Jephthia Louis, Andreea Draghicescu, Nicolas Fontaine
 */

public abstract class AbstractCreditCard implements CreditCard {
	private static final long serialVersionUID = 42031768871L;
	private final CardType cardType;
	private final String number;
	
	/** 
	 * @author Andreea Draghicescu
	 * @param cardType, number
	 */
	public AbstractCreditCard(CardType cardType, String number) 
			throws IllegalArgumentException {
		this.cardType = cardType;
		this.number = validateLuhnAlgorithm(number);
	}

	/** 
	 * @author Jephthia Louis, Andreea Draghicescu, Nicolas Fontaine
	 * Two credit card objects are considered equal if they are of the same
	 * class and their type and number are equal.
	 * @return boolean
	 * @param object of type Object, that will be compare to an 
	 * 				 AbstractCreditCard instance.
	 */
	@Override
	public final boolean equals(Object object) {
		if (object == null) { // If empty, returns false.
			return false;
		}		
		/*
		 *  If the object is an instance of the AbstractCreditCard class,
		 *  create a new instance of AbstractCreditCard (which is the object 
		 *  casted) and check if the card type and the numbers are the same.
		 *  If they are both the same, they are equal.
		 */
		if (object instanceof AbstractCreditCard) {
			AbstractCreditCard a = (AbstractCreditCard) object;
			if (a.getType() == this.cardType && a.getNumber() == this.number) {
				return true;
			}
		}
		return false;
	}
	/** 
	 * @author Jephthia Louis
	 * @return hashCode
	 */
	@Override
	public final int hashCode(){
		return 37 + (this.getType() == null ? 0 : this.getType().hashCode());
	}

	/** 
	 * @author Andreea Draghicescu
	 * @return tmp, a copy of the number
	 */
	@Override
	public String getNumber() {
		String tmp = number;
		return tmp;
	}
	
	/** 
	 * @author Andreea Draghicescu
	 * @return tmp, a copy of CardType
	 */
	@Override
	public CardType getType() {
		CardType tmp = this.cardType;
		return tmp;
	}

	/** 
	 * @author Andreea Draghicescu
	 * @return the card type and number in a string separated by a '*'.
	 */
	@Override
	public String toString() {
		return (cardType + "*" + number);
	}

	/** 
	 * @author Jephthia Louis
	 * @return the number (if valid)
	 * @param number This is the credit card number that will be validated
	 * @throws IllegalArgumentException if the number is not valid.
	 */
	private static String validateLuhnAlgorithm(String number) 
			throws IllegalArgumentException { 
		/* 
		 * Throws an exception when if the string conversion to a numeric 
		 * type fails, if the string format is invalid.
 	     */
		try {
			int total = 0, index = 0;
			char [] reverseArray = number.toCharArray();
			for (int i = 0; i < reverseArray.length / 2; i++) { 
				//Reverse the array so it starts from the right
				int temp = reverseArray[i];
				reverseArray[i] = reverseArray[reverseArray.length - 1 - i];
				reverseArray[reverseArray.length - 1 - i] = (char) temp;
			}
			for (char c : reverseArray) {
				// Converts the String character to an integer.
				int currDigit = c - '0';
				if (index % 2 == 1) {
					currDigit *= 2;
				if (currDigit > 9)
					currDigit -= 9;
				}
				index++; // Next index
				total += currDigit;
			}
			if (total % 10 == 0) {
				return number; // If equal to  0, the card is valid.
			}
			else {
				throw new IllegalArgumentException (" LuhnAlgorith: Invalid Card Number: " + number + ".");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace(); //Prints the kind of error, and where it happened.
		}

		return number;
		
	}

}
