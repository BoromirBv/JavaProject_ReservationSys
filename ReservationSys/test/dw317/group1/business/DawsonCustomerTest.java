package group1.hotel.business;

import dw317.hotel.business.interfaces.Customer;

/**
 * @author Andreea Draghicescu
 *
 */
public class DawsonCustomerTest {
	public static void main(String[] args) {
		testDawsonCustomer();
	}
	
	/** 
	 * @author Andreea Draghicescu 
	 * Tests the DawsonCustomer class for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testDawsonCustomer() {
		//Customer instances
		Customer customer1 = 
				new DawsonCustomer("Andreea", "Galchenyuk", "super_woman669@hotmail.com");
		
		Customer customer2 = 
				new DawsonCustomer("Hillary", "Trump", "huffypuffyduffy@gmail.ca");

		//Constructor test - Valid
		testDawsonCustomerConstructor( "Case 1 - Valid data – valid DawsonCustomer", 
				"Andreea", "Galchenyuk", "super_woman669@hotmail.com", true);
		testDawsonCustomerConstructor( "Case 3 - Valid data – valid DawsonCustomer", 
				"Hillary", "Trump", "huffypuffyduffy@gmail.ca", true);
		
		//Constructor test - Invalid
				testDawsonCustomerConstructor( "Case 4 - Invalid data – Invalid name", 
						"1Andreea", "Galchenyuk", "super_woman669@hotmail.com", false);
				testDawsonCustomerConstructor( "Case 6 - Invalid data – Invalid name", 
						"Hillary", "T5rump", "huffypuffyduffy@gmail.ca", false);
				testDawsonCustomerConstructor( "Case 5 - Invalid data – Invalid email", 
						"Andreea", "Galchenyuk", ".super_woman669@hotmail.com", false);
						
				testDawsonCustomerConstructor( "Case 6 - Invalid data – Invalid email", 
						"Hillary", "Trump", "huffypu..ffyduffy@gmail.ca", false);
				testDawsonCustomerConstructor( "Case 6 - Invalid data – Invalid email", 
						"Hillary", "Trump", "huffypuffyduffy@.gmail.ca", false);
				testDawsonCustomerConstructor( "Case 5 - Invalid data – Invalid email", 
						"Andreea", "Galchenyuk", "super_woman669@hot..mail.com", false);
				
		
		
		//equals test
		System.out.println("Case 3 - equals data - True "
			    + "\n\t" + customer1.equals(customer1));
		System.out.println("Case 4 - equals data - False "
				+ "\n\t" + customer1.equals(customer2));
		System.out.println("Case 5 - equals data - False "
				+ "\n\t" + customer2.equals(customer1));
		
		//compareTo
		System.out.println("Case 6 - equals data - Same "
			    + "\n\t" + customer1.getEmail().compareTo(customer1.getEmail()));
		System.out.println("Case 7 - equals data - Lower"
			    + "\n\t" + customer2.getEmail().compareTo(customer1.getEmail()));
		System.out.println("Case 8 - equals data - Upper "
			    + "\n\t" + customer1.getEmail().compareTo(customer2.getEmail()));

	}

	/** 
	 * @author Andreea Draghicescu.
	 * @param testCase, firstName, lastName, email, expectValid
	 * Creates an instance of DawsonCustomer if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testDawsonCustomerConstructor(String testCase, String firstName, 
			String lastName, String email, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			Customer customer = new DawsonCustomer(firstName, lastName, email);
			System.out.print("\tThe DawsonCustomer instance was created: " + customer);

			if (!expectValid)
				System.out.print("Error! Expected Invalid. ==== FAILED TEST ====");
		} catch (IllegalArgumentException iae) {
			System.out.print("\t" + iae.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		} catch (NullPointerException npe) {
			System.out.print("\t" + npe.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		}/* catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() 
					+ " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}*/
		System.out.println("\n");
	}
}
