package com.demo.loginpage;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.CommonDialogs.Type;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("UserName");
		String password = request.getParameter("password");
		String type = request.getParameter("list");
		request.getSession(true).setAttribute("username", username);
//		
//		request.setAttribute("username",username);
//		((ServletRequest) response).getRequestDispatcher("mainmaker.jsp").forward(request, response); 

		try {
			if (validateLogin(username, password, type)) {
				if (type.equals("m")) {
					response.sendRedirect("mainmaker.jsp");
				} else {
					response.sendRedirect("checker.html");
				}
			} else {
				out.println("<b>INCORRECT USERNAME AND PASSWORD</b>");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean validateLogin(String username, String password, String type)
			throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Get a connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		PreparedStatement stmt = connection
				.prepareStatement("select count(*) from Verify_details where username=? and password=? and type=?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setString(3, type);
		stmt.execute();
		ResultSet rs = stmt.getResultSet();
		rs.next();
		System.out.println(rs.getInt(1));
		if (rs.getInt(1) > 0) {
			return true;

		} else {
			return false;
		}
	}
}
