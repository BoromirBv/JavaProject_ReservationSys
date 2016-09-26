package group1.hotel.business;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;

/**
 * @author Andreea Draghicescu and Nicolas Fontaine
 *
 */
public class DawsonReservation implements Reservation {
	private static final long serialVersionUID = 42031768871L;
	private final Customer customer;
	private final Room room;
	private final LocalDate checkInDate;
	private final LocalDate checkOutDate;
	
	/** @author Andreea Draghicescu and Nicolas Fontaine
	 * 
	 */
	public DawsonReservation(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay, int outYear,
			int outMonth, int outDay) {
		this.customer = aCustomer;
		this.room = aRoom;
		LocalDate in = LocalDate.of(inYear, inMonth, inDay);
		LocalDate out = LocalDate.of(outYear, outMonth, outDay);
		if (in.isAfter(out) || out.isBefore(in)){
			throw new IllegalArgumentException("Dates are invalid - "
					+ "Checkin and chekout dates must be placed in order.");
		}
		else{
			this.checkInDate = in;
			this.checkOutDate = out;
		}
	}

	@Override
	public int compareTo(Reservation o) {
		return 0;
	}
	
	/** @author Nicolas Fontaine
	 * @return boolean if the objects are equal or not. Two Reservation
	 * type objects are considered equal if their customer, room, checkin and
	 * checkout times are equal.
	 * @param object
	 */
	@Override
	public final boolean equals(Object object) {
		if (object == null)
			return false;
		if (this == object)
			return true;
		if (object instanceof DawsonReservation) {
			DawsonReservation copy = (DawsonReservation) object;
			if (copy.getCheckInDate() == this.getCheckInDate() && copy.getCheckOutDate().equals(this.getCheckOutDate())
					&& copy.getRoom().equals(this.getRoom()) && copy.getCustomer().equals(this.getCustomer())) {
				return true;
			}
		}
		return false;
	}

	/** @author Andreea Draghicescu
	 * @return LocalDate of the checkint date.
	 */
	@Override
	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	/** @author Andreea Draghicescu
	 * @return LocalDate of the checkout date.
	 */
	@Override
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	/** @author Nicolas Fontaine
	 * @return customer
	 */
	@Override
	public Customer getCustomer() {
		Customer custID = new DawsonCustomer(customer.getName().getFirstName(), customer.getName().getLastName(),
				customer.getEmail().toString());
		return custID;
	}

	/** @author Nicolas Fontaine
	 * @return days between check-ins and check-outs
	 */
	@Override
	public int getNumberDays() {
		int days = (int) checkInDate.until(checkOutDate, ChronoUnit.DAYS);
		return days;
	}
	
	/** @author Nicolas Fontaine
	 * @return room
	 */
	@Override
	public Room getRoom() {
		Room a = new DawsonRoom(room.getRoomNumber(), room.getRoomType());
		return a;
	}
	
	@Override
	public final int hashCode() {

		return 0;
	}
	
	/** @author Andreea Draghicescu
	 * @return boolean if the days overlap. Days overlap if the chekin day of one
	 * is before the other's check out date and the chekout date of one is after
	 * the chekin date od the other.
	 * @param other
	 */
	@Override
	public boolean overlap(Reservation other) {
		LocalDate startThis = this.checkInDate;
		LocalDate endThis = this.checkOutDate;
		LocalDate startOther = other.getCheckInDate();
		LocalDate endOther = other.getCheckOutDate();
		
		if (endThis.isBefore(startOther)){
			return false;
		}
		else if(endOther.isBefore(startThis)){
			return false;
		}
		else{
			throw new IllegalArgumentException("Dates overlap - Enter valid dates.");
		}
	}

	/** @author Andreea Draghicescu
	 * @return string of the email, checkin date and cheout date, and room
	 * number.
	 */
	@Override
	public String toString() {
		String email = this.customer.getEmail().getAddress();
		int Number = this.room.getRoomNumber();
		String roomNumber = String.valueOf(Number);
		return email + "*" + checkInDate.getYear() + "*" + checkInDate.getMonthValue() + "*"
				+ checkInDate.getDayOfMonth() + "*" + checkOutDate.getYear() + "*" + checkOutDate.getMonthValue() + "*"
				+ checkOutDate.getDayOfMonth() + "*" + roomNumber;
	}
}
