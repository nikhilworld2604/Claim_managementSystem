package crud;

import static java.lang.System.out;

import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Address;

//import myservlet.InitServlet;

/**
 * @author iprimed
 *
 */
public class CrudAddressClass implements CrudAddressInterface{

	Statement statement;
	
	public CrudAddressClass(){
		/*try {
			statement = InitServlet.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void createAddress() {
		boolean isExisting = false;
		try {			
			String query = "create table Address( address_ID int PRIMARY KEY,address1 int,address2 varchar(20),city varchar(20),state varchar(20),pincode int,country varchar(20),location varchar(20)";
			statement.execute(query);			
		} catch (SQLException e) {
			if(e.getErrorCode() == 955){
				out.println("Address table exists\n\n");
				isExisting = true;
			}
		}finally{
			if(!isExisting) out.println("****Address Table created****\n\n");
		}
				
	}

	@Override
	public void insertAddress(Address address) {
		try {
			String query = "insert into Address values("+address.getAddress_id()+",'"+address.getAddress1() +"','"+address.getAddress2()+"','"+address.getCity()+"','"+address.getCountry()+"','"+address.getLocation()+"','"+address.getPincode()+"','"+address.getState()+"')";
			statement.execute(query);
			out.println("****Address Table inserted with new address details****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateAddress(Address address) {
		try {
			String query = "update Address set address1 = '"+address.getAddress1()+"',address2='"+address.getAddress2()+"',city='"+address.getCity()+"',state='"+address.getState()+"',country='"+address.getCountry()+"',pincode='"+address.getPincode()+"',location='"+address.getLocation()+"' where address_ID = "+ address.getAddress_id();
			statement.execute(query);
			out.println("****Address with address_ID "+ address.getAddress_id() +" updated ****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteAddress(Address address) {
		try {
			String query = "delete Address details where address_ID = "+ address.getAddress_id();
			statement.execute(query);
			out.println("***Address deleted with address_ID "+ address.getAddress_id()+"****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void fetchAddress() {
		try {		
			ResultSet results = statement.executeQuery("Select * FROM Address ");
			if(results != null && results.next()){
				out.println("****Address details****");
				do
				{
					out.println(results.getInt(1));
					out.println(results.getString(2));
					out.println(results.getString(3));
					out.println("\n\n");
				}while (results.next());
			}else
				out.println("No records fetched from Address");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Address fetchAddressById(int address_id) {
		Address address = null;
		try {		
			ResultSet results = statement.executeQuery("Select *  FROM Address where address_ID=  "+address_id);
			if (results.next())
			{
				address = new Address();
				address.setAddress_id(results.getInt("address_ID"));
				address.setAddress1(results.getString("address1"));
				address.setAddress2(results.getString("address2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
}