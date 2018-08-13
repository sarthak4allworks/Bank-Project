package com.tcs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.CustomException.AccountNotCurrentException;
import com.tcs.CustomException.AccountNotExistException;
import com.tcs.CustomException.TransferNotAllowedException;
import com.tcs.bean.Customer;
import com.tcs.bean.Transaction;
import com.tcs.factory.AbstractFactory;
import com.tcs.factory.FactoryProducer;
import com.tcs.factory.ServiceInterface;

/**
 * Servlet implementation class CashierController
 */
@WebServlet("/CashierController")
public class CashierController extends HttpServlet {
	private static Logger logger = Logger.getLogger(CashierController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashierController() {
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
		if(action.equalsIgnoreCase("transfer"))
		{
			logger.info("Redirect to transfer page");
			response.sendRedirect("jsp/TransferPage.jsp");
		}
		else if(action.equalsIgnoreCase("TransferAmount"))
		{
			logger.info("This is used to transfer the amount");
			long amount = Long.parseLong(request.getParameter("tran_amount"));
			String source = request.getParameter("source_account");
			String target = request.getParameter("tar_account");
			if(source.equalsIgnoreCase(target))
			{
				logger.info("Account must be different for transfer the amount");
				request.setAttribute("msg", "Account must be different for transfer");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
				rd.forward(request, response);
			}
			else
			{
				AbstractFactory bankDaoFactory = FactoryProducer.getFactory("SERVICE");
				ServiceInterface service = bankDaoFactory.getService("cashierservice");
				ArrayList<Customer> customerList = new ArrayList<>();
				try {
					customerList = service.doTransaction(amount, source, target);
					request.setAttribute("customerList", customerList);
					request.setAttribute("amount", amount);
					RequestDispatcher rd = request.getRequestDispatcher("jsp/TransactionSuccess.jsp");
					rd.forward(request, response);
				} catch (SQLException | AccountNotCurrentException
						| AccountNotExistException | TransferNotAllowedException e) {
					logger.error("Exception occured "+e);
					request.setAttribute("msg", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				} 
			}
		}
		else if(action.equalsIgnoreCase("accountStatus"))
		{
			logger.info("Redirect to account status page");
			response.sendRedirect("jsp/AccountStatus.jsp");
		}
		else if(action.equalsIgnoreCase("seeTransactions"))
		{
			logger.info("Display all the transactions");
			String accountId = request.getParameter("account_id");
			String number = request.getParameter("transaction");
			String sdate = request.getParameter("start_date");
			String edate = request.getParameter("end_date");
			ArrayList<Transaction> transactionList = new ArrayList<>();
			AbstractFactory bankDaoFactory = FactoryProducer.getFactory("SERVICE");
			ServiceInterface service = bankDaoFactory.getService("cashierservice");
			if(sdate != null && edate != null && sdate != "" && edate != "")
			{
				try {
					try {
						logger.info("Redirect to transaction status page");
						transactionList = service.getTransactions(accountId, sdate, edate, number);
						request.setAttribute("transactionList", transactionList);
						request.setAttribute("acc", accountId);
						RequestDispatcher rd = request.getRequestDispatcher("jsp/TransactionStatus.jsp");
						rd.forward(request, response);
					} catch (SQLException e) {
						logger.error("SQLException occured "+e);
						request.setAttribute("msg", e.getMessage());
						RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
						rd.forward(request, response);
					}
				} catch (ParseException e) {
					logger.error("Parsing Exception "+e);
					request.setAttribute("msg", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				try {
					transactionList = service.getTransactions(accountId, number);
					request.setAttribute("transactionList", transactionList);
					request.setAttribute("acc", accountId);
					RequestDispatcher rd = request.getRequestDispatcher("jsp/TransactionStatus.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					logger.error("SQLException occured "+e);
					request.setAttribute("msg", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
			}
		}
		else
		{
			logger.error("fatal error");
			request.setAttribute("msg", "There is some server error");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
			rd.forward(request, response);
		}
	}

}
