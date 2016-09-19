package dw317.lib.creditcard;

public class Visa extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	public Visa(String number) {
		super(CardType.VISA, validateNumber(number));
	}

	private static String validateNumber(String number) throws IllegalArgumentException {
		return null;
	}
}