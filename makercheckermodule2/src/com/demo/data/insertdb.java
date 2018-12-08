package com.demo.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.BRDConnection;
import java.util.*;
import java.sql.Timestamp;

/**
 * Servlet implementation class insertdb
 */
@WebServlet("/insertdb")
public class insertdb extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
	
		// String CustomerID = request.getParameter("CustomerID");
		String CustomerCode = request.getParameter("CustomerCode");
		String CustomerName = request.getParameter("CustomerName");
		String CustomerAddress1 = request.getParameter("CustomerAddress1");
		String CustomerAddress2 = request.getParameter("CustomerAddress2");
		String CustomerPinCode = request.getParameter("CustomerPinCode");
		String Emailaddress = request.getParameter("Emailaddress");
		String ContactNumber = request.getParameter("ContactNumber");
		String PrimaryContactPerson = request.getParameter("PrimaryContactPerson");
		String status = request.getParameter("status");
		String customername = (String) request.getSession(false).getAttribute("username");
		System.out.println(customername);

		try {
			PreparedStatement stmt = BRDConnection.connection
					.prepareStatement("insert into insertdata values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			// stmt.setString(1,CustomerID);
			stmt.setString(1, CustomerCode);
			stmt.setString(2, CustomerName);
			stmt.setString(3, CustomerAddress1);
			stmt.setString(4, CustomerAddress2);
			stmt.setString(5, CustomerPinCode);
			stmt.setString(6, Emailaddress);
			stmt.setString(7, ContactNumber);
			stmt.setString(8, PrimaryContactPerson);
			stmt.setString(9, status);
			stmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			stmt.setString(11, customername);
			stmt.setDate(12, null);
			stmt.setString(13, "N/A");

			int result = stmt.executeUpdate();
			System.out.println(result);
			if (result == 1) {
				response.sendRedirect("viewpage");
			} else {
				out.println("enter valid data");
			}

		} catch (SQLException e) {

			System.out.println("service method:" + e);
		}
	}
}
