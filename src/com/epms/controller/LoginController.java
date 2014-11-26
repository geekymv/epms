package com.epms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epms.pojo.Employee;
import com.epms.service.EmployeeService;
import com.epms.service.impl.EmployeeServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -8002080445456093989L;

	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empnum = request.getParameter("empnum");
		String password = request.getParameter("password");
		
		Employee employee = employeeService.find(empnum, password);
		
		if(employee != null) {
			HttpSession session = request.getSession();
			session.setAttribute("employee", employee);
			response.sendRedirect("emps");
		}else {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		
		
	}
	
	

	
}
