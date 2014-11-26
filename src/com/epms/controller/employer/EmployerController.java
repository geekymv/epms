package com.epms.controller.employer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epms.pojo.EmpType;
import com.epms.pojo.Employee;
import com.epms.pojo.JobType;
import com.epms.service.EmployeeService;
import com.epms.service.impl.EmployeeServiceImpl;
import com.epms.util.DateUtil;

@WebServlet("/emp/register")
public class EmployerController extends HttpServlet {
	private static final long serialVersionUID = -8002080445456093989L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		List<JobType> jobTypes = employeeService.jobTypes();
		request.setAttribute("jobTypes", jobTypes);
		
		List<EmpType> empTypes = employeeService.empTypes();
		request.setAttribute("empTypes", empTypes);
		
		request.getRequestDispatcher("/WEB-INF/view/emp/add.jsp").forward(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		String empNum = request.getParameter("empNum");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		Date birthday = DateUtil.string2Date(request.getParameter("birthday"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Integer empTypeId = Integer.parseInt(request.getParameter("empType"));
		Integer jobTypeId = Integer.parseInt(request.getParameter("jobType"));
		EmpType empType = new EmpType(empTypeId);
		JobType jobType = new JobType(jobTypeId);
		
		System.out.println(empType);
		System.out.println(jobType);
		
		Date hiredate = DateUtil.string2Date(request.getParameter("hiredate"));
		String description = request.getParameter("description");
		
		Employee employee = new Employee();
	
		employee.setPassword(password);
		employee.setEmpNum(empNum);
		employee.setName(name);
		employee.setGender(gender);
		employee.setBirthday(birthday);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setHiredate(hiredate);
		employee.setDescription(description);
		employee.setEmpType(empType);
		employee.setJobType(jobType);
		
		System.out.println("empnum = " + empNum);
		System.out.println("name = " + name);
		System.out.println("password = " + password );
		System.out.println("gender = " + gender);
		System.out.println("birthday = " + DateUtil.date2String(birthday));
		System.out.println("phone = " + phone);
		System.out.println("email = " + email);
		System.out.println("address = " + address);
		System.out.println("hiredate = " + DateUtil.date2String(hiredate));
		System.out.println("description = " + description);
		 
		int res = employeeService.add(employee);
		
		if(res == 1) {
			
			HttpSession session = request.getSession();
			session.setAttribute("employee", employee);
			
			response.sendRedirect(request.getContextPath() + "/emps");
		}
	}	
	
}
