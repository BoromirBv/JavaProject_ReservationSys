package group1.hotel.business;

import java.time.LocalDate;
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
	private final int checkinYear;
	private final int checkinMonth;
	private final int checkinDay;
	private final int checkoutYear;
	private final int checkoutMonth;
	private final int checkoutDay;

	public DawsonReservation(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay, int outYear,
			int outMonth, int outDay) {
		this.customer = aCustomer;
		this.room = aRoom;
		this.checkinYear = inYear;
		this.checkinMonth = inMonth;
		this.checkinDay = inDay;
		this.checkoutYear = outYear;
		this.checkoutMonth = outMonth;
		this.checkoutDay = outDay;
	}

	@Override
	public int compareTo(Reservation o) {
		return 0;
	}

	@Override
	public Customer getCustomer() {
		return null;
	}

	@Override
	public Room getRoom() {
		return null;
	}
	
	/*
	 * @author Andreea Draghicescu
	 * @return LocalDate of the checkint date.
	 */
	@Override
	public LocalDate getCheckInDate() {
		LocalDate a = LocalDate.of(checkinYear, checkinMonth, checkinDay);
		return a;
	}
	/*
	 * @author Andreea Draghicescu
	 * @return LocalDate of the checkout date.
	 */
	@Override
	public LocalDate getCheckOutDate() {
		LocalDate b = LocalDate.of(checkoutYear, checkoutMonth, checkoutDay);
		return b;
	}

	@Override
	public int getNumberDays() {
		return 0;
	}

	@Override
	public boolean overlap(Reservation other) {
		return false;
	}

	@Override
	public boolean equals(Object object) {
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
		return email + "*" + checkinYear + "*" + checkinMonth + "*" + checkinDay + "*" + checkoutYear + "*" + checkoutMonth + "*" + checkoutDay + "*" + roomNumber;
	}
}