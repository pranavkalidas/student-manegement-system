package com.student.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.details.StudentDetails;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	ResultSet result;
	StudentDetails student;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdname = request.getParameter("query-stdname");

		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "SELECT * from std WHERE stdname LIKE ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,stdname + "%");
			result = pst.executeQuery();
			
			Boolean record = result.isBeforeFirst();
			if(!record) {
				HttpSession session = request.getSession();
				session.setAttribute("noRecord", "1");
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}
			else {
				ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
				while(result.next()) {
					student = new StudentDetails();
					student.setStdname(result.getString("stdname"));
					student.setStdid(Integer.parseInt(result.getString("stdid")));
					student.setM1(Integer.parseInt(result.getString("m1")));
					student.setM2(Integer.parseInt(result.getString("m2")));
					student.setM3(Integer.parseInt(result.getString("m3")));
					student.setM4(Integer.parseInt(result.getString("m4")));
					student.setM5(Integer.parseInt(result.getString("m5")));
					students.add(student);
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("displayStd", "1");
				session.setAttribute("list", students);
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
