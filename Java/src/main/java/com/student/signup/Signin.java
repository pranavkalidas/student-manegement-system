package com.student.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   Connection con;
   ResultSet result;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "SELECT * from user WHERE email = ?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email );
			result = pst.executeQuery();
			
			Boolean record = result.isBeforeFirst();
			if(!record) {
				HttpSession session = request.getSession();
				session.setAttribute("invalidUser", "1");
				request.getRequestDispatcher("singup.jsp").forward(request, response); 
			}
			
			result.next();
			String dbpassw = result.getString("password");
			
			if(!password.equals(dbpassw)) {
				HttpSession session = request.getSession();
				session.setAttribute("invalidUser", "1");
				request.getRequestDispatcher("signup.jsp").forward(request, response); 
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("validUser", "1");
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
