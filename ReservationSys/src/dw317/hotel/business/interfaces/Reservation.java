package dw317.hotel.business.interfaces;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Nicolas Fontaine
 */

public interface Reservation extends Comparable<Reservation>, Serializable{
	
	public Customer getCustomer();	
	
	public Room getRoom();
	
	public LocalDate getCheckInDate();	
	
	public LocalDate getCheckOutDate();
	
	public int getNumberDays();
	
	public boolean overlap(Reservation other);
}
