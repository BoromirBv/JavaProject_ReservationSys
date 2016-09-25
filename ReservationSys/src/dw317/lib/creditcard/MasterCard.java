package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */

public class MasterCard extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	 /*
	  * @param number
	  */
	public MasterCard(String number) {
		super(CardType.MASTERCARD, validateNumber(number));
	}

	/*
	 * @author Andreea Draghicescu
	 * @return the number if it is 16 digits long and the first two digits are
	 * in the 51 to 55 range.
	 * @param number
	 */
	private static String validateNumber(String number) throws IllegalArgumentException {
		// Test if the number is null and throws and exception if true.
		if (number != null) {
			if (number.isEmpty()) { // empty
				throw new IllegalArgumentException
					("Credit card MasterCard error: " + number + "is empty.");
			}

			// See if the number has anything else than numbers.
			if (!number.matches("[0-9]+")) {
				throw new IllegalArgumentException
					("Credit card MasterCard error: " + number + " has an invalid character.");
			}

			if (number.length() != 16) { // length
				throw new IllegalArgumentException
					("Credit card MasterCard error: " + number + " is not 16 digits long.");
			}

			// Converts the two first digits to an integer
			int startingDigits = Integer.parseInt(number.substring(0, 2));

			if (startingDigits >= 51 && startingDigits <= 55) {
				return number;
			} else {
				throw new IllegalArgumentException
					("Credit card MasterCard error: " + number + " first two digits are invalid.");
			}
		} else {
			throw new NullPointerException
				("Credit card MasterCard error: is " + number);
		}
	}
}