package group1.hotel.business;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.Period;
import java.util.Optional;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;
import dw317.lib.creditcard.CreditCard;

/*
 * @author Andreea Draghicescu and Nicolas Fontaine
 *
 */
public class DawsonReservation implements Reservation {
	private final Customer customer;
	private final Room room;
	private final LocalDate checkInDate;
	private final LocalDate checkOutDate;

	public DawsonReservation(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay, int outYear,
			int outMonth, int outDay) {
		this.customer = aCustomer;
		this.room = aRoom;
		this.checkInDate = LocalDate.of(inYear, inMonth, inDay);
		this.checkOutDate = LocalDate.of(outYear, outMonth, outDay);
	}

	@Override
	public int compareTo(Reservation o) {
		return 0;
	}
	/*
	 * @author Nicolas Fontaine
	 * @return customer
	 */
	@Override
	public Customer getCustomer() {
		Customer custID = new DawsonCustomer(customer.getName().getFirstName(), customer.getName().getLastName(), customer.getEmail().toString());
		return custID;
	}
	/*
	 * @author Nicolas Fontaine
	 * @return room
	 */
	@Override
	public Room getRoom() {
		Room a = new DawsonRoom(room.getNumber(), room.getRoomType());
		return a;
	}
	
	/*
	 * @author Andreea Draghicescu
	 * @return LocalDate of the checkint date.
	 */
	@Override
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	/*
	 * @author Andreea Draghicescu
	 * @return LocalDate of the checkout date.
	 */
	@Override
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	
	/*
	 * @author Nicolas Fontaine
	 * @return days between check-ins and check-outs
	 */
	@Override
	public int getNumberDays() {
		int days = (int)checkInDate.until(checkOutDate, ChronoUnit.DAYS);
		return days;
	}

	@Override
	public boolean overlap(Reservation other) {
		return false;
	}
	/*
	 * @author Nicolas Fontaine
	 * @return true if two reservations are equal to each other.
	 */
	@Override
	public boolean equals(Object object) {
		if(object == null)
			return false;
		if(this == object)
			return true;
		if(object instanceof DawsonReservation){
			DawsonReservation copy = (DawsonReservation)object;
			if(copy.getCheckInDate() == this.getCheckInDate() 
					&& copy.getCheckOutDate().equals(this.getCheckOutDate())
					&& copy.getRoom().equals(this.getRoom())
					&& copy.getCustomer().equals(this.getCustomer())){
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {

		return 0;
	}
	
	/*
	 * @author Andreea Draghicescu
	 * @return string of the email, checkin date and cheout date, and room number.
	 */
	@Override
	public String toString() {
		String email = this.customer.getEmail().getAddress();
		int Number = this.room.getRoomNumber();
		String roomNumber = String.valueOf(Number);
		return email + "*" + checkInDate.getYear() + "*" + checkInDate.getMonthValue() +
				"*" + checkInDate.getDayOfMonth() + "*" + checkOutDate.getYear() +
				"*" + checkOutDate.getMonthValue() + "*" + checkOutDate.getDayOfMonth() +
				"*" + roomNumber;
	}
}