package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
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

	String SIGNUP_PAGE = "/signup.jsp";

	String SIGNIN_PAGE = "/signin.jsp";

	String SHOWDATA_PAGE = "/show.jsp";

	String EDITDATA_PAGE = "/edit.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
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

		String redirect = "";

		String custName = request.getParameter("custname");

		String action = request.getParameter("action");

		if (action.equals("signup") && custName != null) {

			String custAddress = request.getParameter("custaddress");

			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			String custGender = request.getParameter("custgender");

			String[] depts = request.getParameterValues("custdepartment");

			String custDepartment = "";
			for (String str : depts) {
				custDepartment += str;
			}

			String custState = request.getParameter("custstate");

			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custName, custAddress, custAccBalance, custContactNumber, custGender,
					custDepartment, custState, custDOB, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("custList", customerServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Oops Please try again!!!");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {

			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int custId = Integer.valueOf(request.getParameter("custid"));

			String customerName = request.getParameter("custname");

			String custAddress = request.getParameter("custaddress");

			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			String custGender = request.getParameter("custgender");

			String custDepartment = "";

			String[] depts = request.getParameterValues("custdepartment");

			custDepartment = custDepartment + depts;

			String custState = request.getParameter("custstate");

			Date custDOB = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(customerName, custAddress, custAccBalance, custContactNumber, custGender,
					custDepartment, custState, custDOB, custEmailId, custPassword);

			customerServiceImpl.updateData(custId, customer);

			request.setAttribute("custList", customerServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletebyid")) {

			int custId = Integer.valueOf(request.getParameter("custid"));

			customerServiceImpl.deleteById(custId);

			request.setAttribute("custList", customerServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deleteall")) {

			customerServiceImpl.deleteAll();

			request.setAttribute("custList", customerServiceImpl.findAll());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("findbyid")) {

			int custId = Integer.valueOf(request.getParameter("custid"));

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.filter(cust -> cust.getCustId() == custId).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("findbyname")) {

			String customerName = request.getParameter("custname");

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.filter(cust -> cust.getCustName().equals(customerName)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("findbycontactnumber")) {

			Long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.filter(cust -> cust.getCustContactNumber() == custContactNumber).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("findbyemailid")) {

			String custEmailId = request.getParameter("custemailid");

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.filter(cust -> cust.getCustEmailId().equals(custEmailId)).collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("findbyanyinput")) {

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String anyInput = request.getParameter("anyinput");

			request.setAttribute("custList",
					customerServiceImpl.findAll().stream()
							.filter(cust -> dateFormat.format(cust.getCustDOB()).equals(anyInput)
									|| String.valueOf(cust.getCustId()).equals(anyInput)
									|| cust.getCustName().equals(anyInput) || cust.getCustEmailId().equals(anyInput)
									|| String.valueOf(cust.getCustContactNumber()).equals(anyInput))
							.collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;
		} else if (action.equals("findbydob")) {

			String custUIDOB = request.getParameter("custdob");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			/*
			 * List<Customer> customers = new ArrayList<Customer>();
			 * 
			 * String custUIDOB = request.getParameter("custdob");
			 * 
			 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			 * 
			 * for (Customer customer : customerServiceImpl.findAll()) {
			 * 
			 * String custDBDOB = dateFormat.format(customer.getCustDOB());
			 * 
			 * if (custUIDOB.equals(custDBDOB)) { customers.add(customer); } }
			 */
			request.setAttribute("custList",
					customerServiceImpl.findAll().stream()
							.filter(cust -> dateFormat.format(cust.getCustDOB()).equals(custUIDOB))
							.collect(Collectors.toList()));

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyid")) {

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.sorted(Comparator.comparingInt(Customer::getCustId)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {
			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Customer::getCustName)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbydob")) {
			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Customer::getCustDOB)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbyaccbalance")) {
			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.sorted(Comparator.comparingDouble(Customer::getCustAccBalance)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("sortbygender")) {
			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.sorted(Comparator.comparing(Customer::getCustGender)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("filterbyaccbalance")) {

			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));

			request.setAttribute("custList", customerServiceImpl.findAll().stream()
					.filter(cust -> cust.getCustAccBalance() >= custAccBalance).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);

		requestDispatcher.forward(request, response);
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
