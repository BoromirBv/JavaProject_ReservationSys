package dw317.lib.creditcard;

/**
 * @author Jephthia Louis, Andreea Draghicescu, Nicolas Fontaine
 *
 */

public abstract class AbstractCreditCard implements CreditCard {
	private static final long serialVersionUID = 42031768871L;
	private final CardType cardType;
	private final String number;
	
	/*
	 *  @author Andreea Draghicescu
	 *  @param cardType, number
	 */
	public AbstractCreditCard(CardType cardType, String number) 
			throws IllegalArgumentException {
		this.cardType = cardType;
		this.number = validateLuhnAlgorithm(number);
	}

	@Override
	/* @author Jephthia Louis, Andreea Draghicescu, Nicolas Fontaine
	 * Two credit card objects are considered equal if they are of the same
	 * class and their type and number are equal.
	 * @return boolean
	 * @param object of type Object, that will be compare to an 
	 * 				 AbstractCreditCard instance.
	 */
	public boolean equals(Object object) {
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

	@Override
	/* @author Andreea Draghicescu
	 * @return the number
	 */
	public String getNumber() {
		return this.number;
	}
	
	/* @author Andreea Draghicescu
	 * @return the card type
	 */
	@Override
	public CardType getType() {
		return this.cardType;
	}

	@Override
	/* @author Andreea Draghicescu
	 * @return the card type and number in a string separated by a '*'.
	 */
	public String toString() {
		return (cardType + "*" + number);
	}

	/* @author Jephthia Louis
	 * @return the number (if valid)
	 * @param number This is the credit card number that will be validated
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
			System.out.println(reverseArray);
			for (int i = 0; i < reverseArray.length / 2; i++) { 
				//Reverse the array so it starts from the right
				int temp = reverseArray[i];
				reverseArray[i] = reverseArray[reverseArray.length - 1 - i];
				reverseArray[reverseArray.length - 1 - i] = (char) temp;
			}
			System.out.println(reverseArray);
			
			for (char c : reverseArray) {
				System.out.println("index: " + index);
				System.out.println("c: "+c);
				// Converts the String character to an integer.
				int currDigit = c - '0';
				if (index % 2 == 1) {
					currDigit *= 2;
				if (currDigit > 9)
					currDigit -= 9;
				}
				index++; // Next index
				total += currDigit;
				System.out.println("total: "+total);
			}
			if (total % 10 == 0) {
				return number; // If equal to  0, the card is valid.
			}
			else {
				throw new IllegalArgumentException ("Invalid Card Number: " + number + ".");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace(); //Prints the kind of error, and where it happened.
		}

		return number;
		
	}

}
