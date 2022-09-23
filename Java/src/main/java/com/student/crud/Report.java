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

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.student.details.StudentReport;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	ResultSet result;
	StudentReport student;
	DatabaseMetaData dbmeta;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stdid = Integer.parseInt(request.getParameter("report-stdid"));

		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "SELECT * from std WHERE stdid = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, stdid);
			result = pst.executeQuery();
			Boolean record = result.isBeforeFirst();
			if(!record) {
				HttpSession session = request.getSession();
				session.setAttribute("noRecord", "1");
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}
			else {
				result.next();
				String stdname = result.getString("stdname");
				int m1 = Integer.parseInt(result.getString("m1"));
				int m2 = Integer.parseInt(result.getString("m2"));
				int m3 = Integer.parseInt(result.getString("m3"));
				int m4 = Integer.parseInt(result.getString("m4"));
				int m5 = Integer.parseInt(result.getString("m5"));
				int total = m1 + m2 + m3 + m4 + m5;
				int avg = total/5;
				String status;
				if(total>=480)
					status = "Distinction";
				else if(total>=360&&total<480)
					status = "First class";

				else if((total>=300)&&(total<360))
					status = "Second class";

				else 
					status = "Failed";
				ArrayList<StudentReport> students = new ArrayList<StudentReport>();
				student = new StudentReport();
				student.setAvg(avg);
				student.setM1(m1);
				student.setM2(m2);
				student.setM3(m3);
				student.setM4(m4);
				student.setM5(m5);
				student.setStatus(status);
				student.setTotal(total);
				student.setStdid(stdid);
				student.setStdname(stdname);
				students.add(student);
				
				HttpSession session = request.getSession();
				session.setAttribute("displayReport", "1");
				session.setAttribute("list", students);
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
