package com.csi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.csi.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String custName = request.getParameter("custname");

		String custAddress = request.getParameter("custaddress");

		long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

		double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date custDOB = null;

		try {
			custDOB = dateFormat.parse(request.getParameter("custdob"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String custEmailId = request.getParameter("custemailid");

		String custPassword = request.getParameter("custpassword");

		Customer customer = new Customer(custName, custAddress, custContactNumber, custAccountBalance, custDOB,
				custEmailId, custPassword);

		CustomerService customerServiceImpl = new CustomerServiceImpl();

		customerServiceImpl.signUp(customer);

		PrintWriter printWriter = response.getWriter();
		printWriter.println("Signup Done Successfully");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
