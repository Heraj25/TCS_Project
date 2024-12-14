package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
//import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class saveEmpDetailsServlet
 */
@WebServlet("/saveEmpDetailsServlet")
public class saveEmpDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveEmpDetailsServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("empid");
		String empfname= request.getParameter("fname");
		String emplname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword= request.getParameter("cpassword");
		String address = request.getParameter("address");
		String contact_no = request.getParameter("mobile");
		
		Employee emp = new Employee(id, empfname, emplname, email, password, cpassword, address, contact_no);
		
		try(Connection con = Database.connect()) {
			
			int flag = E_Database.insert(emp);
			
			if(flag == 1){
				out.println("<h3>Employee Registered Successfully.</h3>");
				out.println("<a href='index.jsp'>Go to Index page</a>");
//				response.sendRedirect("index.html");
			}
			else{
				out.println("<h3>Unable to register Employee.</h3>");	
				out.println("<a href='EmpReg.jsp'>Go to Employee Registration Page</a>");
			}
			
			/*
			String sql = "insert into BankDatabase.EmpDetails (id, empfname, emplname, email, password, cpassword, address, contact_no) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, empfname);
			ps.setString(3, emplname);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setString(6, cpassword);
			ps.setString(7, address);
			ps.setString(8, contact_no);
			
			int rowsInserted = ps.executeUpdate();
			if(rowsInserted > 0) {
				out.println("<h3> Emp details are saved successfully</h3>");
			} else {
				out.println("<h3> Failed to save Emp Details</h3>");
			}
			*/
			
		}catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>Error: "+e.getMessage() +"</h3>");
		}	
		
//		doGet(request, response);
	}

}
