package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */

public class MasterCardTest {
	public static void main(String[] args) {
		testMasterCardConstructor();
	}

	/* @author Andreea Draghicescu 
	 * Tests the credit card number for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testMasterCardConstructor() {
		testMasterCardConstructor("Case 1 - Valid data – valid number (16 digits long and 51-55 range)",
				"5333802494710623", true);
		testMasterCardConstructor("Case 2 - Invalid data – invalid first two digits (not in the 51-55 range)",
				"6033802494710623", false);
		testMasterCardConstructor("Case 3 - Invalid data – number too short", "53338024947106", false);
		testMasterCardConstructor("Case 4 - Invalid data – number too long", "53338024947106536", false);
		testMasterCardConstructor("Case 5 - Invalid data – empty number", "", false);
		testMasterCardConstructor("Case 6 - Invalid data – invalid character or characters", "53f38024947106536",
				false);
		testMasterCardConstructor("Case 7 - Invalid data – null number", null, false);

	}

	/* @author Andreea Draghicescu.
	 * @param testCase, number, expectValid 
	 * Creates an instance of MasterCard if it is a valid credit card and the 
	 * case are successful or not.
	 */
	private static void testMasterCardConstructor(String testCase, String number, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			MasterCard mastercard = new MasterCard(number);
			System.out.print("\tThe MasterCard instance was created: " + mastercard);

			if (!expectValid)
				System.out.print("Error! Expected Invalid. ==== FAILED TEST ====");
		} catch (IllegalArgumentException iae) {
			System.out.print("\t" + iae.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		} catch (NullPointerException npe) {
			System.out.print("\t " + npe.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		}

		catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}

		System.out.println("\n");
	}
}