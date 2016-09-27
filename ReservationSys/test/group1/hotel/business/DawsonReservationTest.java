package group1.hotel.business;

import java.time.DateTimeException;
import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Room;

/**
 * @author Andreea Draghicescu and Nicolas Fontaine
 *
 */
public class DawsonReservationTest {

	public static void main(String[] args) {
		testDawsonReservation();
	}
	
	/**
	 * @author Andreea Draghicescu and Nicolas Fontaine
	 * Tests the DawsonReservation class for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testDawsonReservation() {
		//Customers and Rooms Valid
		Customer customerValid1 = 
				new DawsonCustomer("Andreea", "Galchenyuk", "super_woman669@hotmail.com");
		Room roomValid1 = new DawsonRoom(108, RoomType.NORMAL);
		
		Customer customerValid2 = 
				new DawsonCustomer("Hillary", "Trump", "huffypuffyduffy@gmail.ca");
		Room roomValid2 = new DawsonRoom(603, RoomType.SUITE);
		
		//Instances
		DawsonReservation TestRes1= new DawsonReservation(customerValid1, roomValid1, 2016, 9, 24, 2016, 9, 26);
		DawsonReservation TestRes2 = new DawsonReservation(customerValid2, roomValid2, 2016, 9, 27, 2016, 10, 1);
		
		DawsonReservation TestRes3= new DawsonReservation(customerValid1, roomValid1, 2016, 5, 10, 2016, 5, 19);
		DawsonReservation TestRes4 = new DawsonReservation(customerValid2, roomValid1, 2016, 5, 15, 2016, 5, 20);
		
		//Constructor test - Valid
		testDawsonReservationConstructor( "Case 1 - Valid data – valid DawsonReservation", 
				customerValid1, roomValid1, 2016, 9, 24, 2016, 9, 26, true);
		
		testDawsonReservationConstructor( "Case 2 - Valid data – valid DawsonReservation", 
				customerValid2, roomValid2, 2016, 9, 27, 2016, 10, 1, true);
		
		//Constructor test - Invalid
		testDawsonReservationConstructor( "Case 3 - Invalid data – "
				+ "Invalid DawsonReservation: Checkin or checkout date invalid", 
				customerValid1, roomValid1, 2016, 5, 3, 2016, 1, 26, false);
		
		testDawsonReservationConstructor( "Case 4 - Invalid data – "
				+ "Invalid DawsonReservation: Checkin or checkout date invalid", 
				customerValid2, roomValid2, 2016, 3, 20, 2016, 3, 18, false);
		
		testDawsonReservationConstructor( "Case 5 - Invalid data – "
				+ "Invalid DawsonReservation: Invalid day.", 
				customerValid2, roomValid2, 2016, 4, 67, 2016, 4, 18, false);
		
		testDawsonReservationConstructor( "Case 6 - Invalid data – "
				+ "Invalid DawsonReservation: Invalid month.", 
				customerValid2, roomValid2, 2016, 66, 3, 2016, 6, 5, false);
		
		//Overlap test
		testDawsonReservationOverlap( "Case 7 - Overlap data - Valid", 
				TestRes1, TestRes2, true);
		testDawsonReservationOverlap( "Case 8 - Overlap data - Invalid", 
				TestRes3, TestRes4, false);
		
		//equals test
		System.out.println("Case 9 - equals data - Valid "
			    + "\n\t" + TestRes1.equals(TestRes1));
		System.out.println("Case 10 - equals data - Invalid "
				+ "\n\t" + TestRes1.equals(TestRes2));
		System.out.println("Case 11 - equals data - Valid "
				+ "\n\t" + TestRes3.equals(TestRes3));
		System.out.println("Case 12 - equals data - Invalid "
				+ "\n\t" + TestRes2.equals(TestRes4));
		
		//getNumberDays test
		System.out.println("Case 13 - getNumberDays data - Expeting 2"
				+  "\n\t" + TestRes1.getNumberDays());
		System.out.println("Case 14 - getNumberDays data - Expeting 4"
				+  "\n\t" + TestRes2.getNumberDays());
		System.out.println("Case 15 - getNumberDays data - Expeting 9"
				+  "\n\t" + TestRes3.getNumberDays());
		
		//compareTo test
		System.out.println("Case 16 - compareTo "
			    + "\n\t" + TestRes1.compareTo(TestRes2));
		System.out.println("Case 17 - compareTo "
			    + "\n\t" + TestRes1.compareTo(TestRes1));
		System.out.println("Case 18 - compareTo "
			    + "\n\t" + TestRes1.compareTo(TestRes4));
		System.out.println("Case 19 - compareTo "
			    + "\n\t" + TestRes2.compareTo(TestRes3));

	}

	/**
	 * @author Andreea Draghicescu and Nicolas Fontaine
	 * @param testCase, customer, room, inYear, inMonth, inDay, outYear, outMonth, 
	 * 		outDay, expectValid 
	 * Creates an instance of DawsonReservation if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testDawsonReservationConstructor(String testCase, Customer customer, 
			Room room, int inYear, int inMonth, int inDay, int outYear, int outMonth, int 
			outDay, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			DawsonReservation reservation = new DawsonReservation(customer, room, inYear, inMonth, inDay, 
					outYear, outMonth, outDay);
			System.out.print("\tThe DawsonReservation instance was created: " + reservation);

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
		} catch (DateTimeException dte) {
			System.out.print("\t " + dte.getMessage());
			if (expectValid)
				System.out.print("Error! Expected Valid. ==== FAILED TEST ====");
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}
	
	/**
	 * @author Andreea Draghicescu and Nicolas Fontaine
	 * @param testCase, res1, res2, expectValid
	 * Tests the overlap method on two instances of DawsonReservation.
	 */
	private static void testDawsonReservationOverlap(String testCase, DawsonReservation res1, DawsonReservation res2,boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			System.out.print("\t" + res1.overlap(res2));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}

}
