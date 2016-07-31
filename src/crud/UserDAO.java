package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import crud.InitServlet;

import entity.AdminloginClass;

public class UserDAO {

	public boolean getUser(AdminloginClass admin){
		
		String query = "Select * from users where username ='" + admin.getUserName() +"' and password='"+admin.getPassword()+"'";
		//System.out.println("Query is ==="+ query);
		try {
			Statement statement = InitServlet.connection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()){
				//System.out.println("Inside rs.next ");
				return true;								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		return false;
	}
}
