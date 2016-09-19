package group1.hotel.business;

import java.time.LocalDate;

import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;

public class DawsonReservation implements Reservation{
	
	private final Customer aCustomer;
	private final Room aRoom;
	private int inYear = 0;
	private int inMonth = 0;
	private int inDay = 0;
	private int outYear = 0;
	private int outMonth = 0;
	private int outDay = 0;
	
	public DawsonReservation(Customer aCustomer, Room aRoom, int inYear, 
			int inMonth, int inDay, int outYear, int outMonth, int outDay){
		
	}
	
	public Customer getCustomer(){
		return null;
		
	}
	
	public int getNumberOfDays(){
		return 0;
	}
	
	public boolean overlap(Reservation other){
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		return false;
	}
	
	@Override
	public int hashCode(){
		return 0;
	}
	
	@Override
	public String toString(){
		return null;
	}

	@Override
	public int compareTo(Reservation arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Room getRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate getCheckInDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate getCheckOutDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
