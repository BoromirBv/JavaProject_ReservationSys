/**
 * 
 */
package dw317.lib.creditcard;

/**
 * @author 1534132
 *
 */
public abstract class AbstractCreditCard implements CreditCard {

	private static final long serialVersionUID = 42031768871L;
	private final CardType cardType;
	private final String number;

	public AbstractCreditCard(CardType cardType, String number) throws IllegalArgumentException {
		this.cardType = cardType;
		this.number = number;
	}

	@Override
	public boolean equals(Object object) {

		if (object == null) { // empty
			return false;
		}
		if (object instanceof AbstractCreditCard) {
			AbstractCreditCard a = (AbstractCreditCard) object;
			if (a.getType() == this.cardType && a.getNumber() == this.number) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public CardType getType() {
		return cardType;
	}

	@Override
	public String toString() {
		return (cardType + "*" + number);

	}

	private static String validateLuhnAlgorithm(String number) throws IllegalArgumentException {

		try {
			int total = 0, index = 0;

			for (char c : number.toCharArray()) {
				int currDigit = c - '0';
				
				if (index % 2 == 1) {
					
					currDigit *= 2;

					if (currDigit > 9)
						currDigit -= 9;
				}
				index++;

				total += currDigit;
			}

			if (total % 10 == 0)
				return number;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return "Invalid Card Number";

	}

}
