package day4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.beans.User;
import day4.beans.UserValidate;

/**
 * Servlet implementation class UserValidation
 */
@WebServlet(name = "myUserValidationServlet", urlPatterns = { "/doValidation" })
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserValidation() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Username = request.getParameter("uid");
		String Password = request.getParameter("pwd");
		
		User addUser = new User(Username, Password);
		
		boolean valid=UserValidate.isValid(addUser);
		if(valid) {
			out.println("<h2 style='color: green'> Congratulations!! </h2>");
		}
		else {
			out.println("<h2 style='color: red'> Invalid!! </h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
