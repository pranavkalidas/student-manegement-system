package com.student.crud;

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
 * Servlet implementation class Add
 */

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stdname = request.getParameter("add-stdname");
		int stdid = Integer.parseInt(request.getParameter("add-stdid"));
		int m1 = Integer.parseInt(request.getParameter("add-m1"));
		int m2 = Integer.parseInt(request.getParameter("add-m2"));
		int m3 = Integer.parseInt(request.getParameter("add-m3"));
		int m4 = Integer.parseInt(request.getParameter("add-m4"));
		int m5 = Integer.parseInt(request.getParameter("add-m5"));

		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "INSERT INTO `project`.`std` (`stdid`, `stdname`, `m1`, `m2`, `m3`, `m4`, `m5`) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(2, stdname);
			pst.setInt(1, stdid);
			pst.setInt(3, m1);
			pst.setInt(4, m2);
			pst.setInt(5, m3);
			pst.setInt(6, m4);
			pst.setInt(7, m5);
			pst.execute();
			
			HttpSession session = request.getSession();
			session.setAttribute("success", "1");
			request.getRequestDispatcher("student.jsp").forward(request, response); 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
