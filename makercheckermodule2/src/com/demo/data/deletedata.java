package com.demo.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.DAO.BRDConnection;

@WebServlet("/deletedata")
public class deletedata extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");

		int recordstatus = BRDConnection.delete(sid);
		if (recordstatus == 1) {

			System.out.println("data deleted successfully");
			response.sendRedirect("viewpage");

		} else {
			out.println("entervaliddata");
		}

	}
}
