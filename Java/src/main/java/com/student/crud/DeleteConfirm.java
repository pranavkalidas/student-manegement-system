package com.student.crud;

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
 * Servlet implementation class DeleteConfirm
 */
@WebServlet("/DeleteConfirm")
public class DeleteConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	Connection con;
	ResultSet result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int stdid = (Integer)session.getAttribute("stdid");

		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "DELETE from std WHERE stdid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, stdid);
			pst.execute();

			session.setAttribute("success", "1");
			request.getRequestDispatcher("student.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
