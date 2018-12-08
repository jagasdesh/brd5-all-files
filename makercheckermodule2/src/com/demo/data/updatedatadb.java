package com.demo.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.BRDConnection;

/**
 * Servlet implementation class insertdb
 */
@WebServlet("/updatedatadb")
public class updatedatadb extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String id=(String) request.getSession(false).getAttribute("updateid");
	
	System.out.println(id);
        //String CustomerID = request.getParameter("CustomerID");
		String CustomerCode = request.getParameter("CustomerCode");
		String CustomerName = request.getParameter("CustomerName");
		String CustomerAddress1 = request.getParameter("CustomerAddress1");
		String CustomerAddress2 = request.getParameter("CustomerAddress2");
		String CustomerPinCode = request.getParameter("CustomerPinCode");
		String Emailaddress = request.getParameter("Emailaddress");
		String ContactNumber = request.getParameter("ContactNumber");
		String PrimaryContactPerson = request.getParameter("PrimaryContactPerson");
		String status = request.getParameter("status");
		String customername=(String) request.getSession(false).getAttribute("username");
		System.out.println(customername);
		Date utilDate =new Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		System.out.println(date);

		try {
			PreparedStatement stmt = BRDConnection.connection
					.prepareStatement("update insertdata set CustomerCode=?,costumerName=?,CustomerAddress1=?,CostomerAddress2=?,CustomerPinCode=?,Emailaddress=?,ContactNumber=?,PrimaryContactPerson=?,ActiveInactivFlag=?,ModifiedDate=?,ModifiedBy=? where CustomerCode=? ");
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
			stmt.setString(11,customername);
			stmt.setString(12, id);
			int result=stmt.executeUpdate();
			System.out.println(result);
			if(result == 1)
			{
				response.sendRedirect("viewpage");
			}else
			{
				out.println("DataNotProperlyUpdated");
			}

		} catch (SQLException e) {

			System.out.println("service method:" + e);
		}
	}
}
