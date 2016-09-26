package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 */

public class Amex extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	 /**
	  * @param number
	  */
	public Amex(String number) {
		super(CardType.AMEX, validateNumber(number));
	}

	/** 
	 * @author Andreea Draghicescu
	 * @return the number if it is 15 digits long and the first two digits are
	 * 34 or 37.
	 * @param number
	 * @throws IllegalArgumentException if string is empty, has invalid characters, is too long
	 * 				or first two digits are invalid.
	 * 	  	   NullPointerException if null
	 */
	private static String validateNumber(String number) throws IllegalArgumentException {
		// Test if the number is null and throws and exception if true.
		if (number != null) {
			if (number.isEmpty()) { // empty
				throw new IllegalArgumentException
					("Credit card Amex error: " + number + "is empty.");
			}

			// See if the number has anything else than numbers.
			if (!number.matches("[0-9]+")) {
				throw new IllegalArgumentException
					("Credit card Amex error: " + number + " has an invalid character.");
			}

			if (number.length() != 15) { // length
				throw new IllegalArgumentException
					("Credit card Amex error: " + number + " is not 15 digits long.");
			}

			// Converts the two first digits to an integer
			int startingDigits = Integer.parseInt
						(number.substring(0, 2));

			if (startingDigits == 34 || startingDigits == 37) {
				return number;
			} else {
				throw new IllegalArgumentException
					("Credit card Amex error: " + number + " first two digits are invalid.");
			}
		} else {
			throw new NullPointerException
				("Credit card Amex error: is " + number);
		}
	}
}