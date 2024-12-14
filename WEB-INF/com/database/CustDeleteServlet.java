package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustDelete
 */
@WebServlet("/CustDeleteServlet")
public class CustDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String ssn_id = request.getParameter("customer_ssn_id");

		
		try(Connection con = Database.connect()) {
			
			int updated = C_Database.delete(ssn_id);
			if(updated == 1){
				out.println("<h3>Customer Details Deleted Successfully</h3>");
				out.println("<a href='EmpHome.jsp'>Go back to Employee Home Page</a>");
				//response.sendRedirect("EmpHome.jsp");
			}
			else
				out.println("<h3> Customer Not Found.</h3>");
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>Error: "+e.getMessage() +"</h3>");
		}	
		
	}

}
