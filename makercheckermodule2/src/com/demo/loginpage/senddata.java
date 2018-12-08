package com.demo.loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.*;

/**
 * Servlet implementation class senddata
 */
@WebServlet("/senddata")
public class senddata extends HttpServlet {

	public void connmethod(String customerId, String CustomerCode, String CustomerName, String CustomerAddress1,
			String CustomerAddress2, String CustomerPinCode, String Emailaddress, String ContactNumber,
			String PrimaryContactPerson, String RecordStatus, String ActiveInactiveFlag, String CreateDate,
			String CreatedBy, String ModifiedDate, String ModifiedBy, String AuthorizedDate, String AuthorizedBy)
			throws SQLException, IOException {
		
		try {

			PreparedStatement stmt = BRDConnection.connection
					.prepareStatement("insert into temp_maker values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, customerId);
			stmt.setString(2, CustomerCode);
			stmt.setString(3, CustomerName);
			stmt.setString(4, CustomerAddress1);
			stmt.setString(5, CustomerAddress2);
			stmt.setString(6, CustomerPinCode);
			stmt.setString(7, Emailaddress);
			stmt.setString(8, ContactNumber);
			stmt.setString(9, PrimaryContactPerson);
			stmt.setString(10, RecordStatus);
			stmt.setString(11, ActiveInactiveFlag);
			stmt.setString(12, CreateDate);
			stmt.setString(13, CreatedBy);
			stmt.setString(14, ModifiedDate);
			stmt.setString(15, ModifiedBy);
			stmt.setString(16, AuthorizedDate);
			stmt.setString(17, AuthorizedBy);

			int i = stmt.executeUpdate();
			System.out.println("datainserted successfully");
			System.out.println(i);
			BRDConnection.connection.commit();

		} catch (Exception e) {
			System.out.println("connmethod : " + e);
		}
	}

	public void filelevel() throws SQLException {

		Statement stmt = BRDConnection.connection.createStatement();
		String str = "truncate table TEMP_MAKER";
		int i = stmt.executeUpdate(str);
        

		System.exit(0);

	}

}
