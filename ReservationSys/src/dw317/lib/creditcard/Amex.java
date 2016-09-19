package dw317.lib.creditcard;

public class Amex extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	public Amex(String number) {
		super(CardType.AMEX, validateNumber(number));
	}

	private static String validateNumber(String number) throws IllegalArgumentException {
		return null;
	}
}