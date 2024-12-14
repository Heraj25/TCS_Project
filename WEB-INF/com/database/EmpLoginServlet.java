package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class EmpLoginServlet
 */
@WebServlet("/EmpLoginServlet")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String loginId = request.getParameter("loginid");
		String loginpassword = request.getParameter("loginpassword");
		
		try(Connection con = Database.connect()) {
			String sql2 = "select id from BankDatabase.EmpDetails where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, loginId);
			ps.setString(2, loginpassword);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// Create a session
				HttpSession session = request.getSession();
				session.setAttribute("employeeID", loginId); // Store Employee ID
				session.setMaxInactiveInterval(1 * 60); // Session timeout (30 minutes)

				response.sendRedirect("EmpHome.jsp");
			} else {
				out.println("<h3>Invalid Employee ID or Password. Please try again.</h3>");
				out.println("<a href='EmpLogin.jsp'>Go back to login page</a>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h3>Error: "+ e.getMessage() +"</h3>");
		}
		
	}

}
