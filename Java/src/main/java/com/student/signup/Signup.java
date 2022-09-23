package com.student.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Connection con;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "INSERT INTO `project`.`user` (`name`, `password`, `email`) VALUES (?, ?, ?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(2, password);
			pst.setString(1, name);
			pst.setString(3, email);
			pst.execute();
			
			HttpSession session = request.getSession();
			session.setAttribute("account-created", "1");
			request.getRequestDispatcher("signup.jsp").forward(request, response); 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
