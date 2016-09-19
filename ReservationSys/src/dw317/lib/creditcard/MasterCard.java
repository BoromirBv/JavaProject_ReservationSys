package dw317.lib.creditcard;

public class MasterCard extends AbstractCreditCard {
	private static final long serialVersionUID = 42031768871L;

	public MasterCard(String number) {
		super(CardType.MASTERCARD, validateNumber(number));
	}

	private static String validateNumber(String number) throws IllegalArgumentException {
		return null;
	}
}