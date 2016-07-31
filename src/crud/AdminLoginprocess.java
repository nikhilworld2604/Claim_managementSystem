package crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.AdminloginClass;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/AdminLoginprocess")
public class AdminLoginprocess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginprocess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");    
	    String pwd = request.getParameter("password");
	    
	    AdminloginClass user = new AdminloginClass();
	    user.setUserName(username);
	    user.setPassword(pwd);
	    HttpSession session = request.getSession();
	    UserDAO userdao = new UserDAO();
	    if(userdao.getUser(user)){	    	
	    	session.setAttribute("username", username);	    	
	    	response.sendRedirect("MemberRegistration.jsp");
	    	
	    }else{
	    	session.setAttribute("loginerror", "User Authentication Failed");
	    	response.sendRedirect("AdminLogin.jsp");
	    }
	}

}
