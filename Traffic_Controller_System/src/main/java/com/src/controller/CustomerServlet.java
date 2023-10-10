package com.src.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.interfacess.CustomerServiceInterface;
import com.src.model.Customer;
import com.src.services.CustomerService;
import com.src.services.Validations;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Validations valid = new Validations();

		if (mode.equals("customerregister")) {
			String customerid = (String) request.getParameter("customerid");
			String customername = (String) request.getParameter("customername");
			String customerpswd = request.getParameter("customerpswd");
			long customermobnum = Long.parseLong(request.getParameter("customermobnum"));
			String customeremail = request.getParameter("customeremail");

			boolean res1 = valid.checkId(customerid);
			boolean res2 = valid.checkPassword(customerpswd);

			RequestDispatcher rd = request.getRequestDispatcher("customerhome.jsp");
			

			if (res1 && res2) {
				CustomerServiceInterface customerserviceinterface = new CustomerService();

				int res = 0;

				Customer customer = new Customer(customerid, customername, customerpswd, customermobnum, customeremail);
				res = customerserviceinterface.addCustomer(customer);
				if (res > 0) {
					request.setAttribute("message",
							"Customer Registration Successful , SIGN IN now");
					rd.forward(request, response);
				} else {
					request.setAttribute("message",
							"Customer ID Already Exists , SIGN IN now");
					rd.forward(request, response);

				}

			} else {
				request.setAttribute("message","Invalid Credentials");
				rd.forward(request, response);

			}

		} else if (mode.equals("customerlogin")) {

			boolean res = false;
			String customerid = request.getParameter("customerid");
			String customerpswd = request.getParameter("customerpswd");

			RequestDispatcher rd = request.getRequestDispatcher("customerhome.jsp");
			boolean res1 = valid.checkId(customerid);
			boolean res2 = valid.checkPassword(customerpswd);

			if (res1 && res2) {
				Customer customer = new Customer(customerid, customerpswd);
				CustomerServiceInterface customerserviceinterface = new CustomerService();
				res = customerserviceinterface.validateCustomer(customer);

				if (res) {
					HttpSession id = request.getSession(true);
					id.setAttribute("id", customerid);
					response.sendRedirect("customerloginhome.jsp?id=" + customerid + "");
				} else {
					request.setAttribute("errorMessage",
							"Invalid credentials. Please check your Customer ID and password.");
					rd.forward(request, response);
				}

			} else {
				request.setAttribute("errorMessage",
						"Invalid credentials. Please check your Customer ID and password.");
				rd.forward(request, response);

			}

		}
		else if(mode.equals("customerprofileupdate")) {
			
			String customerid = (String) request.getParameter("customerid");
			String customername = (String) request.getParameter("customername");
			String customerpswd = request.getParameter("customerpswd");
			long customermobnum = Long.parseLong(request.getParameter("customermobnum"));
			String customeremail = request.getParameter("customeremail");

			Validations v = new Validations();
			boolean check = v.checkPassword(customerpswd);
			if (check) {
				CustomerServiceInterface csi = new CustomerService();
				int res = 0;
				Customer c = new Customer(customerid, customername, customerpswd, customermobnum, customeremail);
				res = csi.customerUpdate(c);
				if (res > 0) {
					HttpSession session = request.getSession();
					if (session != null) {
						session.invalidate();
						response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
						response.setHeader("Pragma", "no-cache");
						response.setDateHeader("Expires", 0);

					}
					response.sendRedirect("index.jsp");

				} else {
					out.print("update failed");
				}

			}
		}
		
		else if (mode.equals("customerlogout")) {

			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);

			}
			response.sendRedirect("index.jsp");

		}
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
