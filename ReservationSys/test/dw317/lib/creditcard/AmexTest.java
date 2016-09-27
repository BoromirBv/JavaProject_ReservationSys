package dw317.lib.creditcard;

/**
 * @author Andreea Draghicescu
 *
 */
public class AmexTest {
	public static void main(String[] args) {
		testAmexConstructor();
	}

	/**
	 * @author Andreea Draghicescu 
	 * Tests the credit card number for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testAmexConstructor() {
		testAmexConstructor(
				"Case 1 - Valid data – valid number (15 digits long and 34 or 37 as first digit)", "371125677342194",
				true);
		testAmexConstructor(
				"Case 2 - Valid data – valid number (15 digits long and 34 or 37 as first digit)", "344358488765451",
				true);
		testAmexConstructor("Case 3 - Invalid data – invalid first digit (not equal to 34 or 37)",
				"444358488765451", false);
		testAmexConstructor("Case 4 - Invalid data – number too short", "34435848876", false);
		testAmexConstructor("Case 5 - Invalid data – number too long", "344358488765451838", false);
		testAmexConstructor("Case 6 - Invalid data – empty number", "", false);
		testAmexConstructor("Case 7 - Invalid data – invalid character or characters", "344354tu8765451",
				false);
		testAmexConstructor("Case 8 - Invalid data – null number", null, false);

	}

	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, number, expectValid 
	 * Creates an instance of Amex if it is a valid credit card and the 
	 * case are successful or not.
	 */
	private static void testAmexConstructor(String testCase, String number, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			Amex amex = new Amex(number);
			System.out.print("\tThe Amex instance was created: " + amex);

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