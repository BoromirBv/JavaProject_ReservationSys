package group1.hotel.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.io.*;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Room;
import dw317.lib.creditcard.CreditCard;
import group1.hotel.business.DawsonCustomer;
import group1.hotel.business.DawsonRoom;
 /**
  * 
  * @author Andreea Draghicescu
  *
  */
public class HotelFileLoader {
	private HotelFileLoader() {
	}
	
	/**
	 * @author Andreea Draghicescu
	 * @return Room[] An array of rooms.
	 * @param filename The file from which we take input.
	 * @throws IOException
	 */
	public static Room[] getRoomListFromSequentialFile(String filename) throws IOException {
		Room[] roomArray = new Room[1];
		Scanner inputFile = null;
		String line = null;
		try {
			BufferedReader b = new BufferedReader(
					new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));
			inputFile = new Scanner(b);
			String[] fields = null;
			int i = 0;
			while (inputFile.hasNext()) {
				line = inputFile.nextLine();
				fields = line.split("\\*");
				try {
					int roomNumber = Integer.parseInt(fields[0]);
					String roomTypeString = fields[1].toString().toUpperCase();
					RoomType roomType = RoomType.valueOf(roomTypeString);
					// Creates a new DawsonRoom with every line's fields to fill array
					roomArray[i] = new DawsonRoom(roomNumber, roomType);
					i++;
					if (i >= roomArray.length) { //Resizes array if capacity is bigger than size
						//Takes array length and gives it the necessary length
						roomArray = Arrays.copyOf(roomArray, roomArray.length * 2 + 1);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Cannot create a Room with " + line + " due to " + e.getMessage());
				}
			}
			if (i < roomArray.length)
				roomArray = Arrays.copyOf(roomArray, i);
			return roomArray;
		} catch (IOException e) {
			System.out.println("Connection error " + filename);
			return new Room[0];
		} finally {
			if (inputFile != null)
				inputFile.close();
		}
	}
	
	/**
	 * @author Andreea Draghicescu
	 * @return Customer[] An array of customers.
	 * @param filename The file from which we take input.
	 * @throws IOException
	 */
	public static Customer[] getCustomerListFromSequentialFile(String filename) throws IOException {
		Customer[] arr = new Customer[5];
		Scanner inputFile = null;
		String recordStr = null;
		try {
			BufferedReader b = new BufferedReader(
					new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));
			inputFile = new Scanner(b);
			String[] fields = null;
			int i = 0;
			while (inputFile.hasNext()) {
				recordStr = inputFile.nextLine();
				fields = recordStr.split("\\*");
				try {
					System.out.println(fields[3].toString() + " " + fields[4].toString());
					System.out.println(arr.length);
					/*if(fields[3] == null || fields[4] == null) {
						throw new NullPointerException("It's null.");
					}*/
					//CreditCard.CardType type = CreditCard.CardType.valueOf(fields[3].toUpperCase());
					//arr[i].setCreditCard(Optional.of(CreditCard.getInstance(type, fields[4])));
					arr[i] = new DawsonCustomer(fields[1], fields[2], fields[0]);
					
					System.out.println(arr[i]);
					i++;
					System.out.println(i);
					
					if (i >= arr.length)
						arr = Arrays.copyOf(arr, arr.length * 2 + 1);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Cannot create a Customer with " + recordStr + " due to " + e.getMessage());
				}
			}
			if (i < arr.length)
				arr = Arrays.copyOf(arr, i);
			return arr;
		} catch (IOException e) {
			System.out.println("Connection error " + filename);
			return new Customer[0];
		} finally {
			if (inputFile != null)
				inputFile.close();
		}
	}
}
