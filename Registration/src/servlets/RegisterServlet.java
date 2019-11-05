package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.User;
import beans.UserDAO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
	public void init() {
        userDAO = new UserDAO();
    }
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			
            userDAO.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	
            e.printStackTrace();
        }
		//System.out.println("redirect");
		response.sendRedirect("login.jsp");
	}

}
