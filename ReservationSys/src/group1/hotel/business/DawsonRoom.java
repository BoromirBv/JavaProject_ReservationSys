package group1.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Room;

/**
 * @author Jephthia Louis
 *
 */
public class DawsonRoom implements Room {
	private static final long serialVersionUID = 42031768871L;
	private final int roomNumber;
	private final RoomType roomType;

	public DawsonRoom(int roomNumber, RoomType roomType) {
		this.roomNumber = validateRoomNumber(roomNumber);
		this.roomType = roomType;
	}
	
	/* @author Jephthia Louis
	 * @return int
	 * @param room
	 */
	@Override
	public int compareTo(Room room) {
		if (this.getRoomNumber() > room.getRoomNumber())
			return 1;

		if (this.getRoomNumber() < room.getRoomNumber())
			return -1;

		return 0;
	}
	
	/* @author Jephthia Louis
	 * @return boolean if the objects are equal or not. Two Room objects 
	 * are considered equal if they are of the instanceof the
	 * same class and their room number attributes are equal.
	 * @param object
	 */
	@Override
	public final boolean equals(Object object) {
		if (object == null)
			return false;

		if (this == object)
			return true;

		if (object instanceof Room) {
			Room room = (Room) object;

			if (getRoomNumber() == room.getRoomNumber())
				if (getRoomType().name().equals(room.getRoomType().name()))
					return true;
		}
		return false;
	}
	
	/* @author Jephthia Louis
	 * @return floor number
	 */
	@Override
	public int getFloor() {
		return getRoomNumber() / 100;
	}
	
	/* @author Jephthia Louis
	 * @return room number on floor.
	 */
	@Override
	public int getNumber() {
		return getRoomNumber() % 100;
	}
	
	/* @author Jephthia Louis
	 * @return room number
	 */
	@Override
	public int getRoomNumber() {
		return roomNumber;
	}
	
	/* @author Jephthia Louis
	 * @return room type
	 */
	@Override
	public RoomType getRoomType() {
		return roomType;
	}

	@Override
	public final int hashCode() {
		return 0;
	}
	
	/* @author Jephthia Louis
	 * @return string of roon number and room type
	 */
	@Override
	public String toString() {
		return this.getRoomNumber() + "*" + this.getRoomType().toString();
	}
	/* @author Jephthia Louis
	 * @return valid room number.
	 * @param roomNum
	 * The room number is valid if the room number is between 1 and 8
	 * and the floor number is between 1 and 8.
	 */
	private int validateRoomNumber(int roomNum) throws IllegalArgumentException {
		int floor = roomNum / 100;
		int num = roomNum % 100;

		if (floor < 1 || floor > 8)
			throw new IllegalArgumentException("Floor number must be between 1 and 8 inclusive");

		if (num < 1 || num > 8)
			throw new IllegalArgumentException("The number must be between 1 and 8 inclusive");

		return roomNum;
	}
}