package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */
public class CreditCardTest {

	public static void main (String[] args){
		
		testTheTwoParameterConstructor();
	}
	
	private static void testTheTwoParameterConstructor() {
		CreditCard.CardType typeVisa = CreditCard.CardType.VISA;
		CreditCard.CardType typeAmex = CreditCard.CardType.AMEX;
		CreditCard.CardType typeMasterCard = CreditCard.CardType.MASTERCARD;
		
		testTheTwoParameterConstructor(
				"Case 1 - Valid data – valid card MasterCard", typeMasterCard, "5388941127716138", true);
		testTheTwoParameterConstructor(
				"Case 2 - Invalid data – invalid card MasterCard", typeMasterCard, "5556052127344191", false);
		testTheTwoParameterConstructor(
				"Case 3 - Valid data – valid card Visa", typeVisa, "4556737586899855", true);
		testTheTwoParameterConstructor(
				"Case 4 - Invalid data – invalid card Visa", typeVisa, "4556252127344191", false);
		testTheTwoParameterConstructor(
				"Case 5 - Valid data – valid card Visa", typeAmex, "375654375837649", true);
		
		testTheTwoParameterConstructor(
				"Case 6 - Invalid data – invalid card Visa", typeAmex, "376584756473833", false);
		testTheTwoParameterConstructor(
				"Case 7 - Invalid data – invalid card Visa", typeAmex, "375346673833", false);
	}
	
	private static void testTheTwoParameterConstructor(String testCase, CreditCard.CardType type, String number,
			boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			CreditCard.getInstance(type, number);
			System.out.print("\tThe Credit Card instance was created: " + type + "*" + number);
			
			if (!expectValid)
				System.out.print("Error! Expected Invalid. ==== FAILED TEST ====");
		}
		catch (IllegalArgumentException iae)	{
			System.out.print("\t"+ iae.getMessage());
			if (expectValid)
				System.out.print("ILL Error! Expected Valid. ==== FAILED TEST ====");
		}
		catch (NullPointerException npe)	{
			System.out.print("\t "+ npe.getMessage());
			if (expectValid)
				System.out.print(" NULL Error! Expected Valid. ==== FAILED TEST ====");
		}
		
		catch (Exception e) {
			System.out.print("\tUNEXPECTED EXCEPTION TYPE! " 
					+ e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print(" EX Expected Valid.");
		}

		System.out.println("\n");
	}
}