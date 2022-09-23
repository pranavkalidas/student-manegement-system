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
 * Servlet implementation class UpdateConfirm
 */
@WebServlet("/UpdateConfirm")
public class UpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con;
	ResultSet result;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int realid = (Integer)session.getAttribute("real-stdid");
		String stdname = request.getParameter("update-stdname");
		int stdid = Integer.parseInt(request.getParameter("update-stdid"));
		int m1 = Integer.parseInt(request.getParameter("update-m1"));
		int m2 = Integer.parseInt(request.getParameter("update-m2"));
		int m3 = Integer.parseInt(request.getParameter("update-m3"));
		int m4 = Integer.parseInt(request.getParameter("update-m4"));
		int m5 = Integer.parseInt(request.getParameter("update-m5"));

		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","root");
			String query = "UPDATE `project`.`std` SET `stdid` = ?, `stdname` = ?, `m1` = ?, `m2` = ?, `m3` = ? , `m4` = ? , `m5` = ? WHERE (`stdid` = ?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, stdid);
			pst.setString(2, stdname);
			pst.setInt(3, m1);
			pst.setInt(4, m2);
			pst.setInt(5, m3);
			pst.setInt(6, m4);
			pst.setInt(7, m5);
			pst.setInt(8,realid);
			pst.execute();

			session.setAttribute("success", "1");
			request.getRequestDispatcher("student.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
