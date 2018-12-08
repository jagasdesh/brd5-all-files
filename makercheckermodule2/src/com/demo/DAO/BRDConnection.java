package com.demo.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connection
 */
@WebServlet("/connection")
public class BRDConnection extends HttpServlet {

	public static Connection connection = null;
	static {
		try

		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);

		}

	}

	public static int delete(String sid) {
		int status = 0;
		try {

			PreparedStatement ps = connection.prepareStatement("delete from insertdata where  customercode=?");
			ps.setString(1, sid);
			status = ps.executeUpdate();
			System.out.println(status);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
