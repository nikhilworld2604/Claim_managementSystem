package crud;

import entity.Customer;

public interface CrudCustomerInterface {
	public void createCustomer();
	public void insertCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void fetchCustomer();
	public Customer fetchCustomerById(int memberId);

}
