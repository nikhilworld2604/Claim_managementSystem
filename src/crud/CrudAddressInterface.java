package crud;

import entity.Address;

public interface CrudAddressInterface {
	public void createAddress();
	public void insertAddress(Address address);
	public void updateAddress(Address address);
	public void deleteAddress(Address address);
	public void fetchAddress();
	public Address fetchAddressById(int address_id);

}
