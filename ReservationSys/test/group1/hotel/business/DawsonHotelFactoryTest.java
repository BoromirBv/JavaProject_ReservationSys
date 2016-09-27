package group1.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;
import group1.hotel.business.DawsonHotelFactory;

/**
 * @author Andreea Draghicescu
 *
 */

public class DawsonHotelFactoryTest {

	public static void main(String[] args) {
		testDawsonHotelFactory();
	}
	
	/**
	 * @author Andreea Draghicescu 
	 * Tests the DawsonHotelFactory enum for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testDawsonHotelFactory() {
		Customer customerValid1 = 
				new DawsonCustomer("Andreea", "Galchenyuk", "super_woman669@hotmail.com");
		
		Room roomValid1 = new DawsonRoom(208, RoomType.NORMAL);
		
		DawsonReservation TestRes1= new DawsonReservation(customerValid1, roomValid1, 2016, 9, 24, 2016, 9, 26);
		
		System.out.println(TestRes1);

		//Test Cases - True
		testCustomerInstance( "Case 1 - Valid data – valid CustomerInstance", 
				"Mamadou", "Mustapha", "goatislife@outlook.com", true);
		
		testCard( "Case 2 - Valid data – valid Card", "Visa", "4556737586899855", true);
		
		testRoomInstance( "Case 3 - Valid data – valid RoomInstance", 108, "normal", true);
		
		testReservationInstance( "Case 4 - Valid data – valid ReservationInstance", 
				DawsonHotelFactory.DAWSON.getCustomerInstance("Mamadou", "Mustapha", "goatislife@outlook.com"), 
					DawsonHotelFactory.DAWSON.getRoomInstance(108, "normal"), 2016, 9, 24, 2016, 9, 26, true);
		
		testReservationInstance( "Case 5 - Valid data – valid ReservationInstance", TestRes1, true);
		
		testReservationInstance( "Case 10 - Valid data – Valid ReservationInstance", TestRes1, true);
		
		//Test Cases - False
		testCustomerInstance( "Case 6 - Invalid data – Invalid CustomerInstance", 
				"Mam2adou", "Mustapha", "goatislife@outlook.com", false);
		
		testCard( "Case 7 - Invalid data – Invalid Card", "Visa", "4556734386899855", false);
		
		testRoomInstance( "Case 8 - Invalid data – Invalid RoomInstance", 908, "normal", false);
		
		testReservationInstance( "Case 9 - Invaliddata – Invalid ReservationInstance", 
				DawsonHotelFactory.DAWSON.getCustomerInstance("Mamadou", "Mustapha", "goatislife@outlook.com"), 
					DawsonHotelFactory.DAWSON.getRoomInstance(108, "normal"), 2016, 9, 24, 2016, 9, 23, false);
		
		

		

	}

	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, roomNumber, roomType, expectValid 
	 * Creates an instance of DawsonRoom if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testCustomerInstance(String testCase, String firstname, String lastname, String email, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			
			System.out.print("\tThe Customer instance was created: " 
					+ DawsonHotelFactory.DAWSON.getCustomerInstance(firstname, lastname, email));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}
	
	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, cardtype, cardtype, expectValid 
	 * Creates an instance of CreditCard if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testCard(String testCase, String cardtype, String number, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			
			System.out.print("\tThe Card instance was created: " 
					+ DawsonHotelFactory.DAWSON.getCard(cardtype, number));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}
	
	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, roomNumber, roomType, expectValid 
	 * Creates an instance of DawsonRoom if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testRoomInstance(String testCase, int roomNumber, String roomType, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			
			System.out.print("\tThe Room instance was created: " 
					+ DawsonHotelFactory.DAWSON.getRoomInstance(roomNumber, roomType));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}
	
	
	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, Customer, Room, inYear, inMonth, inDay,
			outYear, outMonth, outDay, expectValid 
	 * Creates an instance of DawsonReservation if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testReservationInstance(String testCase, Customer Customer, Room Room, int inYear, int inMonth, int inDay,
			int outYear, int outMonth, int outDay, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			
			System.out.print("\tThe Reservation instance was created: " 
					+ DawsonHotelFactory.DAWSON.getReservationInstance(Customer, Room, inYear, inMonth, inDay, outYear, outMonth, outDay));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}
	
	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, toCopy, expectValid 
	 * Creates an instance of DawsonReservation if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testReservationInstance(String testCase, Reservation toCopy, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			
			System.out.print("\tThe Reservation instance was created: " 
					+ DawsonHotelFactory.DAWSON.getReservationInstance(toCopy));

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
		}catch (Exception e) {
			System.out.print(
					"\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " + e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				System.out.print("Expected Valid.");
		}
		System.out.println("\n");
	}



}
