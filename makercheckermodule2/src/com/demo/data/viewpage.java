package com.demo.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.DAO.*;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/viewpage")
public class viewpage extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String fetch = "select * from insertdata";
		Statement statement;
		try {
			statement = BRDConnection.connection.createStatement();
			ResultSet rs = statement.executeQuery(fetch);

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>insertdata</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<Table border=1 align=center >");

			out.println(
					"<tr><th>CustomerName</th><th>CustomerAddress1</th><th>CustomerAddress2</th><th>CustomerPinCode</th><th>Emailaddress</th><th>ContactNumber</th><th>PrimaryContactPerson</th><th>status</th><th>CreateDate</th></th><th>Created By</th><th>Modified Date</th><th>ModifiedBy</th><th>edit</th><th>delete</th>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4)
						+ "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7)
						+ "</td><td>" + rs.getString(8) + "</td><td>" + rs.getString(9) + "</td><td>" + rs.getString(10)
						+ "</td><td>" + rs.getString(11) + "</td><td>" + rs.getString(12) + "</td><td>"
						+ rs.getString(13) + "</td><td><a href='update?id=" + rs.getString(1)
						+ "'>edit</a></td> <td><a href='deletedata?id=" + rs.getString(1) + "'  onclick=\"return confirm('Are you sure you want to delete?')\">delete</a></td></tr>");
			}
			out.println("<center><a href='insertdata.html'>EnterNewUser</a><center>");
			out.println("</Table>");
			out.println("</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
