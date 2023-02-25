package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserDao;
import com.servlet.dto.User;
@WebServlet("/logins")
public class loginsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email=req.getParameter("femail");
		String password=req.getParameter("epass");
		
		UserDao ud=new UserDao();
		User u=ud.getUser(email, password);
		if (u!=null) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("home.html");
			dispatcher.forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<html><body><h1>Invalid Details</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("logins.html");
			dispatcher.include(req, resp);
		}
			
		
	}
	

}
