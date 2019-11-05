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
	private int result;
       
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
		String password2 = request.getParameter("password2");
		String errorString = "";
		
		User user = new User();
		user.setUserName(username);
		user.setEmail(email);
		user.setPassword(password);
		
		if(!password.equals(password2)) {
			errorString = "Password mismatch!";
        	request.setAttribute("errorString", errorString);			
        	request.setAttribute("resultREG", -1);
			//System.out.println(request.getAttribute("errorString"));
			response.sendRedirect("register.jsp");
		}else {
	        try {
	    		result = userDAO.registerUser(user);
	    		if(result == -1) {
	    			errorString =  "User already exists";
	    			
	    			request.setAttribute("errorString", errorString);			
	    			request.setAttribute("resultREG", -1);
	    			//System.out.println(request.getAttribute("resultREG"));
	    			
	    			request.getRequestDispatcher("register.jsp").forward(request, response);
	    		}else {
	    			response.sendRedirect("login.jsp");
	    		}
	    			
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	             	
	                e.printStackTrace();
	            }
		}
        
		
		
		
	}

}
