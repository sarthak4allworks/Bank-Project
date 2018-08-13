package com.tcs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.bean.Account;
import com.tcs.bean.Customer;
import com.tcs.factory.AbstractFactory;
import com.tcs.factory.FactoryProducer;
import com.tcs.factory.ServiceInterface;

/**
 * Servlet implementation class ExecutiveController
 */
@WebServlet("/ExecutiveController")
public class ExecutiveController extends HttpServlet {
	private static Logger logger = Logger.getLogger(ExecutiveController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutiveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("createCustomer"))
		{
			logger.info("Redirect to create customer page");
			response.sendRedirect("jsp/CraeteCustomer.jsp");
		}
		else if(action.equalsIgnoreCase("create"))
		{
			logger.info("Customer created");
			String ssnno = request.getParameter("contact");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String address1 = request.getParameter("address");
			String address2 = request.getParameter("address1");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			Customer customer = new Customer();
			customer.setSsnId(ssnno);
			customer.setCustomerName(name);
			customer.setCustomerAge(age);
			customer.setAddress1(address1);
			customer.setAddress2(address2);
			customer.setCity(city);
			customer.setState(state);
			AbstractFactory bankDaoFactory = FactoryProducer.getFactory("SERVICE");
			ServiceInterface service = bankDaoFactory.getService("executiveservice");
			try {
				String i = service.createCustomer(customer);
				if(i.equalsIgnoreCase("Exist"))
				{
					logger.info("This customer is already registered");
					request.setAttribute("msg", "Customer with "+ssnno+" is already registered");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
				else
				{
					logger.info("Customer is created successfully");
					request.setAttribute("msg", "Customer creation wirh "+ssnno+" is initiated successfully");
					customer.setCustomerId(i);
					request.setAttribute("customer", customer);
					RequestDispatcher rd = request.getRequestDispatcher("jsp/customerSuccess.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				logger.error("SQLException occured "+e);
				request.setAttribute("msg", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
				rd.forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("createAccount"))
		{
			logger.info("Redirect to create account page");
			response.sendRedirect("jsp/CreateAccount.jsp");
		}
		else if(action.equalsIgnoreCase("AccountCreate"))
		{
			String customerId = request.getParameter("cust_id");
			String accountType = request.getParameter("acc_type");
			long amount = Long.parseLong(request.getParameter("dep_amount")); 
			Account account = new Account();
			account.setBalance(amount);
			account.setType(accountType);
			account.setStatus("SUCCESS");
			AbstractFactory bankDaoFactory = FactoryProducer.getFactory("SERVICE");
			ServiceInterface service = bankDaoFactory.getService("executiveservice");
			try {
				String str = service.createAccount(account, customerId);
				if(str.equalsIgnoreCase("SUCCESS"))
				{
					logger.info("Customer account created successfully");
					request.setAttribute("msg", "Account creation initiated successfully");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/AccountSuccess.jsp");
					rd.forward(request, response);
				}
				else if(str.equalsIgnoreCase("AccountExist"))
				{
					logger.info("Account already exist for this customer");
					request.setAttribute("msg", "Account Exist For This Customer");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
				else
				{
					logger.error("Customer is not exist");
					request.setAttribute("msg", "This Customer Does Not Exist");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				logger.error("SQLException occured "+e);
				request.setAttribute("msg", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			logger.error("fatal exception occured");
			request.setAttribute("msg", "There is some server error");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
			rd.forward(request, response);
		}
	}

}
