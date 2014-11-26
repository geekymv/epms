package com.epms.controller.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epms.pojo.Pager;
import com.epms.pojo.Task;
import com.epms.service.TaskService;
import com.epms.service.impl.TaskServiceImpl;

@WebServlet("/tasks")
public class TaskListController extends HttpServlet {
	private static final long serialVersionUID = 5586737390225709772L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskService taskService = new TaskServiceImpl();
		
		String offsetStr = request.getParameter("pager.offset");
		
		Integer offset = 0;
		if(offsetStr != null){
			offset = Integer.parseInt(offsetStr);
		}

		int pageOffset = 0;
		if(offset != null) {
			pageOffset = offset;
		}
		
		Pager<Task> pager = taskService.list(pageOffset, 5);
		request.setAttribute("pager", pager);
		
		request.getRequestDispatcher("/WEB-INF/view/task/tasks.jsp").forward(request, response);
		
		
	}
}





















