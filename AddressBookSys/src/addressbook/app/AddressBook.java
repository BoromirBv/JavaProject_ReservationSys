package addressbook.app;
import dw317.lib.Address;

public class AddressBook {
	public static void main(String[] args) {
		Address myAddress = new Address("3040", "Sherbrooke", "Montreal");
		System.out.println(myAddress.getAddress());
	}
}
