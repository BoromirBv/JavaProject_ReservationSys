package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */

public class MasterCardTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testTheOneParameterConstructor();
	}
	
	private static void testTheOneParameterConstructor() {
		testTheOneParameterConstructor(
				"Case 1 - Valid data – valid number (16 digits long and 51-55 range)",
						"5333802494710623", true);
		testTheOneParameterConstructor(
				"Case 2 - Invalid data – invalid first two digits (not in the 51-55 range)",
						"6033802494710623", false);
		testTheOneParameterConstructor(
				"Case 3 - Invalid data – number too short","53338024947106", false);
		testTheOneParameterConstructor(
				"Case 4 - Invalid data – number too long","53338024947106536", false);
		testTheOneParameterConstructor(
				"Case 5 - Invalid data – empty number","", false);
		testTheOneParameterConstructor(
				"Case 6 - Invalid data – invalid character or characters","53f38024947106536", false);
		testTheOneParameterConstructor(
				"Case 7 - Invalid data – null number", null, false);
		
	}
	
	private static void testTheOneParameterConstructor(String testCase, String number,
			boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			MasterCard mastercard = new MasterCard(number);
			System.out.print("\tThe MasterCard instance was created: " + mastercard);
			
			if (!expectValid)
				System.out.print("Error! Expected Invalid. ==== FAILED TEST ====");
		}
		catch (IllegalArgumentException iae)	{
			System.out.print("\t"+ iae.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		}
		catch (NullPointerException npe)	{
			System.out.print("\t "+ npe.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		}
		
		catch (Exception e) {
			System.out.print("\tUNEXPECTED EXCEPTION TYPE! " 
					+ e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}

		System.out.println("\n");
	}
}