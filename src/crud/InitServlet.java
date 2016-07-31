package crud;

import static java.lang.System.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns = {"/InitServlet"},loadOnStartup=1)
public class InitServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	public static Connection connection;

	@Override
	public void init() throws ServletException {
		System.out.println("Init method of Welcome Servlet invoked");
		super.init();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			out.println("****Driver class registered****\n\n");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.
					getConnection("jdbc:oracle:thin:@localhost:1521:XE", "stefy", "verynice");	
			out.println("****Connected to the database successfully****\n\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
