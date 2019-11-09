package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

import utils.MyUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Forward to login.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("login.jsp");

		dispatcher.forward(request, response);
	}

	// When the user enters userName & password, and click Submit.
	// This method will be executed.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DO POST");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean remember = "on".equals(request.getParameter("rememberMe"));

		User user = null;

		boolean hasError = false;
		String errorString = null;

		if (email == null || password == null || email.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password!";
		} else {
			
			

			// Validate the user in the DB.
			user = UserDAO.validate(email, password);

			if (user == null) {
				hasError = true;
				errorString = "User Name or password invalid";
			}

		}

		// If error, forward to /login.jsp
		if (hasError) {

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);

			// Forward to login.jsp
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response);
		}
		// If no error
		// Store user information in Session
		// And redirect to userInfo page.
		else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);
			session.setAttribute("user", user); // set user attribute for verification
			// System.out.println(user.getUserName());
			// If user checked "Remember me".
			if (remember) {
				MyUtils.storeUserCookie(response, user);
			}
			// Else delete cookie.
			else {
				MyUtils.deleteUserCookie(response);
			}

			// Redirect to userInfo page.
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

}
