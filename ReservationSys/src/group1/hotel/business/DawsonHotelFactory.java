package group1.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.HotelFactory;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;
import dw317.lib.creditcard.CreditCard;

public enum DawsonHotelFactory implements HotelFactory {
	DAWSON;
	
	/* @return the customer instance
	 * @param firstname, lastname, email
	 */
	@Override
	public Customer getCustomerInstance(String firstName, String lastName, String email) {
		return new DawsonCustomer(firstName, lastName, email);
	}
	
	/* @return credit card
	 * @param cardtype, number
	 */
	@Override
	public CreditCard getCard(String cardtype, String number) {
		return CreditCard.getInstance(CreditCard.CardType.valueOf(cardtype.toUpperCase()), number);
	}
	
	/* @return the room instance
	 * @param roomNumber, roomtype
	 */
	@Override
	public Room getRoomInstance(int roomNumber, String roomtype) {
		return new DawsonRoom(roomNumber, RoomType.valueOf(roomtype.toUpperCase()));
	}

	/* @return new Reservation
	 * @param aCustomer, aRoom, inYear, inMonth, inDay, outYear, outMonth, outDay
	 */
	@Override
	public Reservation getReservationInstance(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay,
			int outYear, int outMonth, int outDay) {
		return new DawsonReservation(aCustomer, aRoom, inYear, inMonth, inDay, outYear, outMonth, outDay);
	}
	
	/* @return the reservation instance
	 * @param toCopy
	 */
	@Override
	public Reservation getReservationInstance(Reservation toCopy) {
		return  new DawsonReservation(toCopy.getCustomer(), toCopy.getRoom(), toCopy.getCheckInDate().getYear(),
				toCopy.getCheckInDate().getMonthValue(), toCopy.getCheckInDate().getDayOfMonth(),
				toCopy.getCheckOutDate().getYear(), toCopy.getCheckOutDate().getMonthValue(),
				toCopy.getCheckOutDate().getDayOfMonth());
	}

}