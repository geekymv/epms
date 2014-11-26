package com.epms.controller.employer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epms.pojo.Employee;
import com.epms.pojo.Pager;
import com.epms.service.EmployeeService;
import com.epms.service.impl.EmployeeServiceImpl;

@WebServlet("/emps")
public class EmployerListController extends HttpServlet {
	private static final long serialVersionUID = -8002080445456093989L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();

		String offsetStr = request.getParameter("pager.offset");
		
		Integer offset = 0;
		if(offsetStr != null){
			offset = Integer.parseInt(offsetStr);
		}

		int pageOffset = 0;
		if(offset != null) {
			pageOffset = offset;
		}
		
		Pager<Employee> pager = employeeService.list(pageOffset, 5);
		request.setAttribute("pager", pager);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/emps.jsp").forward(request, response);
		
	}
}
