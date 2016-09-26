package group1.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Room;

/**
 * @author Andreea Draghicescu
 *
 */
public class DawsonRoomTest {
	public static void main(String[] args) {
		testDawsonRoom();
	}
	
	/**
	 * @author Andreea Draghicescu 
	 * Tests the DawsonRoom class for different cases. The boolean represent 
	 * what we expect the case to return. If it returns the opposite, the test has failed.
	 */
	private static void testDawsonRoom() {
		//Room instances
		Room room1 = new DawsonRoom(108, RoomType.NORMAL);	
		Room room2 = new DawsonRoom(801, RoomType.PENTHOUSE);

		//Constructor test - Valid
		testDawsonRoomConstructor( "Case 1 - Valid data – valid DawsonRoom", 
				108, RoomType.NORMAL, true);
				
		testDawsonRoomConstructor( "Case 2 - Valid data – valid DawsonRoom", 
				801, RoomType.PENTHOUSE, true);
		
		//Constructor test - Invalid
		testDawsonRoomConstructor( "Case 3 - Invalid data – Room number", 
				809, RoomType.PENTHOUSE, false);
		testDawsonRoomConstructor( "Case 4 - Invalid data – Floor Number", 
				906, RoomType.NORMAL, false);
		testDawsonRoomConstructor( "Case 3 - Invalid data – Room number", 
				809, RoomType.PENTHOUSE, false);		
		
		//equals test
		System.out.println("Case 5 - equals data - Valid (Equal) "
			    + "\n\t" + room1.equals(room1));
		System.out.println("Case 6 - equals data - Invalid (Not equal)"
				+ "\n\t" + room1.equals(room2));
		
		//compareTo test
		System.out.println("Case 7 - compareTo data - Smaller room number"
				+ "\n\t" + room1.compareTo(room2));
		System.out.println("Case 8 - compareTo data - Bigger  room number"
				+ "\n\t" + room2.compareTo(room1));

	}

	/**
	 * @author Andreea Draghicescu.
	 * @param testCase, roomNumber, roomType, expectValid 
	 * Creates an instance of DawsonRoom if it has valid parameters 
	 * and the case are successful or not.
	 */
	private static void testDawsonRoomConstructor(String testCase, int roomNumber, RoomType roomType, boolean expectValid) {

		System.out.println("   " + testCase);

		try {
			Room room = new DawsonRoom(roomNumber, roomType);
			System.out.print("\tThe DawsonRoom instance was created: " + room);

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
