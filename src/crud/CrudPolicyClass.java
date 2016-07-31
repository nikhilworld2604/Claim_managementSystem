package crud;
import static java.lang.System.out;

//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Policy;

//import myservlet.InitServlet;

/**
 * @author iprimed
 *
 */
public class CrudPolicyClass implements CrudPolicyInterface{

	Statement statement;
	
	public CrudPolicyClass(){
		/*try {
			statement = InitServlet.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void createPolicy() {
		boolean isExisting = false;
		try {			
			String query = "create table Policy( Type_of_Insurance varchar(20) PRIMARY KEY,Max_Claim_Amount float)";
			statement.execute(query);			
		} catch (SQLException e) {
			if(e.getErrorCode() == 955){
				out.println("Policy table exists\n\n");
				isExisting = true;
			}
		}finally{
			if(!isExisting) out.println("****Policy Table created****\n\n");
		}
				
	}

	@Override
	public void insertPolicy(Policy policy) {
		try {
			String query = "insert into Policy values("+policy.getInsuranceType()+",'"+ policy.getMax_claim_amnt()+"')";
			statement.execute(query);
			out.println("****policy Table inserted with new policy details****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updatePolicy(Policy policy) {
		try {
			String query = "update Policy set Max_Claim_Amount = '"+ policy.getMax_claim_amnt()+"' where Type_of_Insurance = "+ policy.getInsuranceType();
			statement.execute(query);
			out.println("****Policy with Type_of_Insurance "+ policy.getInsuranceType() +" updated ****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deletePolicy(Policy policy) {
		try {
			String query = "delete Policy where Type_of_Insurance = "+ policy.getInsuranceType();
			statement.execute(query);
			out.println("****Policy deleted with Type_of_Insurance "+ policy.getInsuranceType() +"****\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/*@Override
	public void fetchEmployees() {
		try {		
			ResultSet results = statement.executeQuery("Select * FROM Employee ");
			if(results != null && results.next()){
				out.println("****Employee details****");
				do
				{
					out.println(results.getInt(1));
					out.println(results.getString(2));
					out.println(results.getString(3));
					out.println("\n\n");
				}while (results.next());
			}else
				out.println("No records fetched from employee");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee fetchEmployeeById(int empId) {
		Employee employee = null;
		try {		
			ResultSet results = statement.executeQuery("Select *  FROM Employee where eid =  "+ empId);
			if (results.next())
			{
				employee = new Employee();
				employee.setEmpId(results.getInt("eid"));
				employee.setEmpName(results.getString("ename"));
				employee.setSalary(results.getFloat("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}*/
}
