package com.epms.controller.task;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epms.pojo.Employee;
import com.epms.pojo.Task;
import com.epms.service.EmployeeService;
import com.epms.service.TaskService;
import com.epms.service.impl.EmployeeServiceImpl;
import com.epms.service.impl.TaskServiceImpl;
import com.epms.util.DateUtil;

@WebServlet("/task/edit")
public class UpdateTaskController extends HttpServlet {
	private static final long serialVersionUID = 5586737390225709772L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		int id = 0;
		if(idStr != null) {
			id = Integer.parseInt(idStr);
		}

		TaskService taskService = new TaskServiceImpl();
		Task task = taskService.query(id);
		request.setAttribute("task", task);
		
		request.getRequestDispatcher("/WEB-INF/view/task/edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		EmployeeService employeeService = new EmployeeServiceImpl();
		TaskService taskService = new TaskServiceImpl();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String period = request.getParameter("period"); 

		Integer executorNum = 0;
		String executorStr = request.getParameter("executor");
		if(!"".equals(executorStr)) {
			executorNum = Integer.parseInt(executorStr);
		}
		Employee executor = employeeService.queryByNumber(executorNum);
		
		Date starttime = DateUtil.string2Date(request.getParameter("starttime")); 
		Date endtime = DateUtil.string2Date(request.getParameter("endtime"));
		String priority = request.getParameter("priority"); 
		String explain = request.getParameter("explain"); 
		String status = request.getParameter("status"); 
		
		Task task = taskService.query(id);
		
		task.setTitle(title);
		task.setPeriod(period);
		task.setExecutor(executor);
		task.setStarttime(starttime);
		task.setEndtime(endtime);
		task.setPriority(priority);
		task.setExplain(explain);
		task.setStatus(status);
		
		int res = taskService.update(task);
		
		if(res == 1) {
			
			response.sendRedirect(request.getContextPath()+"/tasks");
		}
	}
}





















