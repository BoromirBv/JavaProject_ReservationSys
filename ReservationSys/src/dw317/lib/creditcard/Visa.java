package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */

public class Visa extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	 /**
	  * @param number
	  */
	public Visa(String number) {
		super(CardType.VISA, validateNumber(number));
	}

	/**
	 * @author Andreea Draghicescu
	 * @return the number if it is 16 digits long and the first digit is 4.
	 * @param number
	 * @throws IllegalArgumentException if string is empty, has invalid characters, is too long
	 * 				or first digit is invalid.
	 * 	  	   NullPointerException if null
	 */
	private static String validateNumber(String number) throws IllegalArgumentException {
		// Test if the number is null and throws and exception if true.
		if (number != null) {
			if (number.isEmpty()) { // empty
				throw new IllegalArgumentException
					("Credit card Visa error: " + number + "is empty.");
			}

			// See if the number has anything else than numbers.
			if (!number.matches("[0-9]+")) {
				throw new IllegalArgumentException
					("Credit card MasterCard error: " + number + " has an invalid character.");
			}

			if (number.length() != 16) { // length
				throw new IllegalArgumentException
					("Credit card Visa error: " + number + " is not 16 digits long.");
			}

			// Converts the first digit to an integer
			int startingDigit = Integer.parseInt(number.substring(0, 1));

			if (startingDigit == 4) {
				return number;
			} else {
				throw new IllegalArgumentException
					("Credit card Visa error: " + number + " first digit is invalid.");
			}
		} else {
			throw new NullPointerException
				("Credit card Visa error: is " + number);
		}
	}
}