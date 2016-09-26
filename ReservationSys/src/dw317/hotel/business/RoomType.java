package dw317.hotel.business;

/** @author Jephthia Louis
 * 
 */

public enum RoomType {
	NORMAL, SUITE, PENTHOUSE;
	
	/** @author Jephthia Louis
	 * @return a lowercase string of the type
	 */
	@Override
	public String toString(){
		return this.name().toLowerCase();
	}
}

