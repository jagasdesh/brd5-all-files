package com.demo.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.DAO.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.data.*;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String updateid = request.getParameter("id");
		System.out.println(updateid);
		try {

			PreparedStatement stmt = BRDConnection.connection
					.prepareStatement("select *from insertdata where customercode=?");

			stmt.setString(1, updateid);
			ResultSet rs = stmt.executeQuery();
			rs.next();

			request.setAttribute("updateresult", rs);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("update.jsp");
			reqDispatcher.forward(request, response);

			request.getSession(true).setAttribute("updateid", updateid);

		} catch (SQLException e) {

			System.out.println("service method:" + e);
		}

	}
}
