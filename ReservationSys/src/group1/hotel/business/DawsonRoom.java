package group1.hotel.business;

import dw317.hotel.business.RoomType;

public class DawsonRoom {
	private int roomNumber = 0;
	private final RoomType roomType;
	private static final long serialVersionUID = 42031768871L;
	
	public DawsonRoom(int roomNumber, RoomType roomType){
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public int getFloor(){
		return 0;
	}
	
	public int getNumber(){
		return 0;
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
		return (roomNumber + "*" + roomType);
	}
	
}
