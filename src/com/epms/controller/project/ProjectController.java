package com.epms.controller.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/add")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 2338539264588978716L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		request.getRequestDispatcher("/WEB-INF/view/project/add.jsp").forward(request, response);
	}
	
}
