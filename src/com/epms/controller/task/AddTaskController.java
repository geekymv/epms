package com.epms.controller.task;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epms.pojo.Employee;
import com.epms.pojo.Task;
import com.epms.service.EmployeeService;
import com.epms.service.TaskService;
import com.epms.service.impl.EmployeeServiceImpl;
import com.epms.service.impl.TaskServiceImpl;
import com.epms.util.DateUtil;

@WebServlet("/task/add-task")
public class AddTaskController extends HttpServlet {
	private static final long serialVersionUID = 5586737390225709772L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/task/add.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		EmployeeService employeeService = new EmployeeServiceImpl();
		TaskService taskService = new TaskServiceImpl();
		
		String title = request.getParameter("title");
		String period = request.getParameter("period"); 

		HttpSession session = request.getSession();
		Employee creator = (Employee) session.getAttribute("employee");

		Date createtime = new Date(); 
		
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
		
		Task task = new Task(title, period, creator, createtime, executor, starttime, endtime, priority, explain, status);
		
		int res = taskService.add(task);
		
		if(res == 1) {
			System.out.println("ok");
		}
	}
}





















