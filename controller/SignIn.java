package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserDao;
import com.servlet.dto.User;
@WebServlet("/signins")
public class SignIn extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("fname");
		long phone=Long.parseLong(req.getParameter("fphone"));
		String email=req.getParameter("femail");
		String password=req.getParameter("epass");
		
		
		User u= new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		
		UserDao.saveUser(u);
		
		String html = "<html><body><h1>Registered Successfully</h1></body></html>";
		RequestDispatcher rd = req.getRequestDispatcher("logins.html");
		rd.forward(req, resp);
		
	}
	
	

}
