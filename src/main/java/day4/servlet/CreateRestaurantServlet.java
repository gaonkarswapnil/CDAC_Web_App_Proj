package day4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.beans.Restaurant;
import day4.dao.DaoInterface;
import day4.dao.RestaurantDao;

/**
 * Servlet implementation class CreateRestaurantServlet
 */
@WebServlet(name = "myCreateRestaurantServlet", urlPatterns = { "/CreateRestaurant" })
public class CreateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public CreateRestaurantServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("restaurantId"));
		String name = request.getParameter("restaurantName");
		String cuisine = request.getParameter("restaurantCuisine");
		int branchCount = Integer.parseInt(request.getParameter("restaurantBranchCount"));
		
		
		DaoInterface<Restaurant, Integer> idao = new  RestaurantDao();
		Restaurant res = new Restaurant(id, name, cuisine, branchCount);
		idao.create(res);
		out.println("<h2>Restaurant created successfully...</h2>");
		
		
//		doGet(request, response);
	}

}
