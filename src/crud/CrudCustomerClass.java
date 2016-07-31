
package crud;
import static java.lang.System.out;

import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Customer;

//import myservlet.InitServlet;

/**
 * @author iprimed
 *
 */
public class CrudCustomerClass implements CrudCustomerInterface{

	Statement statement;
	
	public CrudCustomerClass(){
		/*try {
			statement = InitServlet.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void createCustomer() {
		boolean isExisting = false;
		try {			
			String query = "create table Customers( Member_ID int primary key,address_ID references Address(address_ID),fname varchar(20),lname varchar(20),gender varchar(10),ph_number int,emailid varchar(20),dob date,nominees_count int)";
			statement.execute(query);			
		} catch (SQLException e) {
			if(e.getErrorCode() == 955){
				out.println("Customer table exists\n\n");
				isExisting = true;
			}
		}finally{
			if(!isExisting) out.println("****Customer Table created****\n\n");
		}
				
	}

	@Override
	public void insertCustomer(Customer customer) {
		try {
			String query = "insert into Customer values("+customer.getAddressId()+",'"+ customer.getEmail()+"','"+customer.getEmail()+"','"+customer.getPh_no()+"','"+customer.getFirstName()+"','"+customer.getLastName() +"','"+customer.getDOB()+"','"+customer.getGender()+"','"+customer.getMemberId()+"','"+customer.getNomineeCount()+"')";
			statement.execute(query);
			out.println("****Customer Table inserted with new customer details****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			String query = "update Customer set fname = '"+ customer.getFirstName()+"',lname='"+customer.getLastName()+"',gender='"+customer.getGender()+"',ph_number='"+customer.getPh_no()+"',emailid='"+customer.getEmail()+"',dob='"+customer.getDOB()+"',nominees_count='"+customer.getNomineeCount()+"' where Member_ID = "+ customer.getMemberId();
			statement.execute(query);
			out.println("****Customer with Member_ID "+ customer.getMemberId() +" updated ****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try {
			String query = "delete Customer where Member_ID = "+ customer.getMemberId();
			statement.execute(query);
			out.println("***Customer deleted with Member_ID "+ customer.getMemberId() +"****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void fetchCustomer() {
		try {		
			ResultSet results = statement.executeQuery("Select * FROM Customer ");
			if(results != null && results.next()){
				out.println("****Customer details****");
				do
				{
					out.println(results.getInt(1));
					out.println(results.getString(2));
					out.println(results.getString(3));
					out.println("\n\n");
				}while (results.next());
			}else
				out.println("No records fetched from Customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer fetchCustomerById(int memberId) {
		Customer customer = null;
		try {		
			ResultSet results = statement.executeQuery("Select *  FROM Customer where Member_ID  =  "+ memberId);
			if (results.next())
			{
				customer = new Customer();
				customer.setMemberId(results.getInt("Member_ID"));
				customer.setFirstName(results.getString("fname"));
				customer.setLastName(results.getString("lname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}