package com.epms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epms.pojo.Customer;
import com.epms.service.CustomerService;
import com.epms.service.impl.CustomerServiceImpl;

/**
 * 添加客户
 * @author Geek_ymv
 */
@WebServlet("/customer/add")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = -8002080445456093989L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		CustomerService customerService = new CustomerServiceImpl();
		
		String name = request.getParameter("name");
		String contacts = request.getParameter("contacts");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String background = request.getParameter("background");
		String remarks = request.getParameter("remarks");
		
//		System.out.println("name = " + name);
//		System.out.println("contacts = " + contacts);
//		System.out.println("phone = " + phone);
//		System.out.println("address = " + address);
//		System.out.println("background = " + background);
//		System.out.println("remarks = " + remarks);

		Customer customer = new Customer(name, contacts, phone, address, background, new Date(), remarks);
		
		int res = customerService.add(customer);
		
		if(res == 1) {
			out.write("success");	// 添加成功
		}else {
			out.write("fail");	// 添加失败
		}
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	
}
