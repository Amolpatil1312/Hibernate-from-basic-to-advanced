package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	String WELCOME_PAGE = "/welcome.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

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

		String redirect = "";

		String custName = request.getParameter("custname");

		String action = request.getParameter("action");

		if (action.equals("signup") && custName != null) {

			String custAddress = request.getParameter("custaddress");

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			String custGender = request.getParameter("custgender");

			Date custDOB = null;

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				custDOB = dateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custName, custAddress, custAccountBalance, custContactNumber, custGender,
					custDOB, custEmailId, custPassword);
			
			
			customerServiceImpl.signUp(customer);
			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {


			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			if(customerServiceImpl.signIn(custEmailId, custPassword)) {

				redirect= WELCOME_PAGE;
			}else {
				request.setAttribute("message", "Oops Invalid Credentials, Please try Again!!!!!");
				redirect=SIGNIN_PAGE;
			}

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
