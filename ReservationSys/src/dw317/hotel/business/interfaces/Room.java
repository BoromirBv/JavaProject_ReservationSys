package dw317.hotel.business.interfaces;

import java.io.Serializable;

import dw317.hotel.business.RoomType;

/* @author Nicolas Fontaine
 * 
 */

public interface Room extends Comparable<Room>, Serializable {
	public RoomType getRoomType();
	
	public int getFloor();

	public int getRoomNumber();

	public int getNumber();
}
