package group1.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Room;

public class DawsonRoom implements Room
{
    private static final long serialVersionUID = 42031768871L;
    private final int roomNumber;
    private final RoomType roomType;
    
    public DawsonRoom(int roomNumber, RoomType roomType)
    {
        this.roomNumber = validateRoomNumber(roomNumber);
        this.roomType = roomType;
    }
    @Override public int compareTo(Room room)
    {
        if(this.getRoomNumber() > room.getRoomNumber())
            return 1;
        
        if(this.getRoomNumber() < room.getRoomNumber())
            return -1;
        
        return 0;
    }
    @Override public RoomType getRoomType()
    {
        return roomType;
    }
    @Override public int getRoomNumber()
    {
        return roomNumber;
    }
    @Override public int getFloor()
    {
        return getRoomNumber() / 100;
    }
    @Override public int getNumber()
    {
        return getRoomNumber() % 100;
    }
    @Override public final boolean equals(Object object)
    {
        if(object == null)
            return false;
        
        if(this == object)
            return true;
        
        if(object instanceof Room)
        {
            Room room = (Room)object;
            
            if(getRoomNumber() == room.getRoomNumber())
                if(getRoomType().name().equals(room.getRoomType().name()))
                    return true;
        }
        return false;
    }
    @Override public final int hashCode()
    {
        //TODO
        return 0;
    }
    @Override public String toString()
    {
        return this.getRoomNumber()+"*"+this.getRoomType().toString();
    }
    private int validateRoomNumber(int roomNum) throws IllegalArgumentException
    {
        int floor = roomNum / 100;
        int num = roomNum % 100;
        
        if(floor < 1 || floor > 8)
            throw new IllegalArgumentException("Floor number must be between 1 and 8 inclusive");
        
        if(num < 1 || num > 8)
            throw new IllegalArgumentException("The number must be between 1 and 8 inclusive");
        
        return roomNum;
    }
}