package com.tcs.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.tcs.factory.AbstractFactory;
import com.tcs.factory.FactoryProducer;
import com.tcs.factory.ServiceInterface;
/**
 * Servlet implementation class BankController
 */
@WebServlet("/BankController")
public class BankController extends HttpServlet {
	private static Logger logger = Logger.getLogger(BankController.class);
	private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankController() {
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
		if(action.equalsIgnoreCase("log"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		}
		else if(action.equalsIgnoreCase("login"))
		{
			logger.info("Redirect to login page");
			String employeeId = request.getParameter("username");
			String password = request.getParameter("password");
			AbstractFactory bankDaoFactory = FactoryProducer.getFactory("SERVICE");
			ServiceInterface service = bankDaoFactory.getService("bankService");
			try {
				int i = service.authenticateEmployee(employeeId, password);
				if(i == 0)
				{
					request.setAttribute("msg", "You are not an authorized user");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
					rd.forward(request, response);
				}
				else if(i == 1)
				{
					logger.info("Current Employee is executive");
					HttpSession session = request.getSession(true);
					session.setAttribute("currentsessionId",employeeId); 
					session.setAttribute("RoleOfCurrentEmployee", 1);
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Executive.jsp");
					rd.forward(request, response);
				}
				else
				{
					logger.info("Current Employee is cashier");
					HttpSession session = request.getSession(true);
					session.setAttribute("currentsessionId",employeeId); 
					session.setAttribute("RoleOfCurrentEmployee", 2);
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Cashier.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				logger.error("SQL Exception occured");
				request.setAttribute("msg", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
				rd.forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("logout"))
		{
			logger.info("This is used for logout the current employee");
			HttpSession session = request.getSession();
			if(session != null)
			{
				session.setAttribute("currentsessionId",null); 
				session.setAttribute("RoleOfCurrentEmployee", 0);
				session.removeAttribute("currentsessionId");
				session.removeAttribute("currentsessionId");
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/jsp/home.jsp");
			}
			else
			{
				logger.info("session is already expired");
			}
		}
		else if(action.equalsIgnoreCase("home"))
		{
			String name = (String)request.getParameter("emp");
			if(name.equalsIgnoreCase("executive"))
			{
				logger.info("Redirect to executive dashboard");
				response.sendRedirect("jsp/Executive.jsp");
			}
			else if(name.equalsIgnoreCase("hm"))
			{
				logger.info("Redirect to home");
				response.sendRedirect("jsp/home.jsp");
			}
			else if(name.equalsIgnoreCase("hmerror"))
			{
				HttpSession session = request.getSession();
				if(session.getAttribute("RoleOfCurrentEmployee") == null)
				{
					response.sendRedirect("jsp/home.jsp");
				}
				else if((int)session.getAttribute("RoleOfCurrentEmployee") == 1)
				{
					response.sendRedirect("jsp/Executive.jsp");
				}
				else if((int)session.getAttribute("RoleOfCurrentEmployee") == 2)
				{
					response.sendRedirect("jsp/Cashier.jsp");
				}	
			}
			else 
			{
				logger.info("Redirect to cashier dashboard");
				response.sendRedirect("jsp/Cashier.jsp");
			}
		}
		else if(action.equalsIgnoreCase("about"))
		{
			logger.info("Redirect to about page");
			response.sendRedirect("jsp/about.jsp");
		}
		else
		{
			logger.error("Error occured in application");
			request.setAttribute("msg", "There is some server error");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/Error.jsp");
			rd.forward(request, response);
		}
	}
}