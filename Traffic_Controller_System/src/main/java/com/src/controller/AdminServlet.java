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

import com.src.interfacess.AdminServiceInterface;
import com.src.model.Admin;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;
import com.src.services.AdminService;
import com.src.services.Validations;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminServlet(String adminid, String adminname, String adminpswd, long adminmobnum, String adminemail) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		Validations valid = new Validations();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminServiceInterface asi = new AdminService();

		// Admin Register
		if (mode.equals("adminregister")) {
			String adminid = (String) request.getParameter("adminid");
			String adminname = (String) request.getParameter("adminname");
			String adminpswd = request.getParameter("adminpswd");
			long adminmobnum = Long.parseLong(request.getParameter("adminmobnum"));
			String adminemail = request.getParameter("adminemail");

			boolean res1 = valid.checkId(adminid);
			boolean res2 = valid.checkPassword(adminpswd);
			RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp");

			if (res1 && res2) {
				AdminServiceInterface adminserviceinterface = new AdminService();
				int res = 0;
				Admin admin = new Admin(adminid, adminname, adminpswd, adminmobnum, adminemail);
				res = adminserviceinterface.addAdmin(admin);

				if (res > 0) {
					request.setAttribute("message",
							"Admin Registration Successful , SIGN IN now");
					rd.forward(request, response);
				} else {
					request.setAttribute("message",
							"Admin ID Already Exists , SIGN IN now");
					rd.forward(request, response);

				}

			} else {
				request.setAttribute("message","Invalid Credentials");
				rd.forward(request, response);
			}

		}

		// Admin Login
		else if (mode.equals("adminlogin")) {
			boolean res = false;
			String adminid = request.getParameter("adminid");
			String adminpswd = request.getParameter("adminpswd");

			RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp");

			boolean res1 = valid.checkId(adminid);
			boolean res2 = valid.checkPassword(adminpswd);

			if (res1 && res2) {
				Admin admin = new Admin(adminid, adminpswd);
				AdminServiceInterface adminserviceinterface = new AdminService();
				res = adminserviceinterface.validateAdmin(admin);

				if (res) {

					HttpSession id = request.getSession(true);
					id.setAttribute("id", adminid);
					response.sendRedirect("adminloginhome.jsp?id=" + adminid + "");
				} else {
					request.setAttribute("errorMessage",
							"Invalid credentials. Please check your admin ID and password.");
					rd.forward(request, response);

				}
			} else {
				request.setAttribute("errorMessage",
						"Invalid credentials. Please check your admin ID and password.");
				rd.forward(request, response);

			}

		} else if (mode.equals("adminprofileupdate")) {
			String adminid = (String) request.getParameter("adminid");
			String adminname = (String) request.getParameter("adminname");
			String adminpswd = request.getParameter("adminpswd");
			long adminmobnum = Long.parseLong(request.getParameter("adminmobnum"));
			String adminemail = request.getParameter("adminemail");

			Validations v = new Validations();
			boolean check = v.checkPassword(adminpswd);
			if (check) {
				AdminServiceInterface adminserviceinterface = new AdminService();
				int res = 0;
				Admin admin = new Admin(adminid, adminname, adminpswd, adminmobnum, adminemail);
				res = adminserviceinterface.adminUpdate(admin);
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

		// Admin Logout
		else if (mode.equals("adminlogout")) {

			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);

			}

			response.sendRedirect("index.jsp");
		}

		// Admin Add Diversion
		else if (mode.equals("adddiversion")) {
			System.out.println("Checking Diversion ");
			String divid = request.getParameter("divid");
			String divroutetype = request.getParameter("divroutetype");
			String divstart = request.getParameter("divstart");
			String divend = request.getParameter("divend");
			String divstartdate = request.getParameter("divstartdate");
			String divenddate = request.getParameter("divenddate");
			int divkms = Integer.parseInt(request.getParameter("divkms"));
			String divstatus = request.getParameter("divstatus");

			Diversions d = new Diversions(divid, divroutetype, divstart, divend, divstartdate, divenddate, divkms,
					divstatus);

			int res = asi.admin_AddDiversion(d);
			RequestDispatcher rd = request.getRequestDispatcher("admin_addNewDiversion.jsp");

			if (res > 0) {
				request.setAttribute("message","Diversion Added Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","ID already exists");
				rd.include(request, response);
			}
		}
		// Admin Add route
		else if (mode.equals("addroute")) {
			String routeid = request.getParameter("routeid");
			String routetype = request.getParameter("routetype");
			String routevehicle = request.getParameter("routevehicle");
			String routestart = request.getParameter("routestart");
			String routeend = request.getParameter("routeend");
			int routekms = Integer.parseInt(request.getParameter("routekms"));
			String routestatus = request.getParameter("routestatus");

			Routes r = new Routes(routeid, routetype, routevehicle, routestart, routeend, routekms, routestatus);

			int res = asi.admin_AddRoute(r);
			RequestDispatcher rd = request.getRequestDispatcher("admin_addNewRoute.jsp");

			if (res > 0) {
				request.setAttribute("message","Route Added Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","ID already exists");
				rd.include(request, response);
			}

		}

		// Admin Add Traffic
		else if (mode.equals("addtraffic")) {
			String trafficid = request.getParameter("trafficid");
			String trafficroutetype = request.getParameter("trafficroutetype");
			String traffictype = request.getParameter("traffictype");
			String traffictime = request.getParameter("traffictime");
			String trafficstatus = request.getParameter("trafficstatus");
			String trafficlocation = request.getParameter("trafficlocation");

			Traffics t = new Traffics(trafficid, trafficroutetype, traffictype, traffictime, trafficstatus,
					trafficlocation);

			int res = asi.admin_AddTraffic(t);

			RequestDispatcher rd = request.getRequestDispatcher("admin_addNewTraffic.jsp");

			if (res > 0) {
				request.setAttribute("message","Traffic Added Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","ID already exists");
				rd.include(request, response);
			}
			// Admin Delete Diversion
		} else if (mode.equals("deletediversion")) {
			String divid = request.getParameter("divid");
			Diversions d = new Diversions(divid);

			int res = asi.admin_DeleteDiversion(d);
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_alldiversions.jsp");

			if (res > 0) {
				request.setAttribute("message","Diversion Deleted Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Diversion not deleted");
				rd.include(request, response);
			}
		} // Admin Delete Route
		else if (mode.equals("deleteroute")) {
			String routeid = request.getParameter("routeid");
			Routes r = new Routes(routeid);

			int res = asi.admin_DeleteRoute(r);
			RequestDispatcher rd = request.getRequestDispatcher("admin_allroutes.jsp");

			if (res > 0) {
				request.setAttribute("message","Route Deleted Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Route not deleted");
				rd.include(request, response);
			}

		}
		// Admin Delete Traffic
		else if (mode.equals("deletetraffic")) {
			String trafficid = request.getParameter("trafficid");
			Traffics t = new Traffics(trafficid);

			RequestDispatcher rd = request.getRequestDispatcher("admin_alltraffics.jsp");
			int res = asi.admin_DeleteTraffic(t); 
			if (res > 0) {
				request.setAttribute("message","Traffic Deleted Succcessfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Traffic not deleted");
				rd.include(request, response);
			}

		}

		// Admin Update Diversion
		else if (mode.equals("editdiversion")) {

			String edivid = request.getParameter("divid");
			String edivroutetype = request.getParameter("routetype");
			System.out.println(edivroutetype);
			String edivstart = request.getParameter("divstart");
			String edivend = request.getParameter("divend");
			String edivstartdate = request.getParameter("divstartdate");
			String edivenddate = request.getParameter("divenddate");
			int edivkms = Integer.parseInt(request.getParameter("divkms"));
			String edivstatus = request.getParameter("divstatus");

			Diversions d = new Diversions(edivid, edivroutetype, edivstart, edivend, edivstartdate, edivenddate,
					edivkms, edivstatus);

			int res = asi.admin_UpdateDiversion(d);
			RequestDispatcher rd = request.getRequestDispatcher("admin_alldiversions.jsp");
			if (res > 0) {
				request.setAttribute("message","Diversion Edited Successfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Diversion Not Edited");
				rd.include(request, response);
			}
			
			

		}
		// Admin Update Route
		else if (mode.equals("editroute")) {
			String erouteid = request.getParameter("routeid");
			String eroutetype = request.getParameter("routetype");
			String eroutevehicle = request.getParameter("routevehicle");
			String eroutestart = request.getParameter("routestart");
			String erouteend = request.getParameter("routeend");
			int eroutekms = Integer.parseInt(request.getParameter("routekms"));
			String eroutestatus = request.getParameter("routestatus");

			Routes r = new Routes(erouteid, eroutetype, eroutevehicle, eroutestart, erouteend, eroutekms, eroutestatus);
			int res = asi.admin_UpdateRoute(r);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_allroutes.jsp");
			if (res > 0) {
				request.setAttribute("message","Route Edited Successfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Route Not Edited");
				rd.include(request, response);
			}
			

		}

		// Admin Update Traffic
		else if (mode.equals("edittraffic")) {
			String etrafficid = request.getParameter("trafficid");
			String eroutetype = request.getParameter("routetype");
			String etraffictype = request.getParameter("traffictype");
			String etraffictime = request.getParameter("traffictime");
			String etrafficstatus = request.getParameter("trafficstatus");
			String etrafficlocation = request.getParameter("trafficlocation");

			Traffics t = new Traffics(etrafficid, eroutetype, etraffictype, etraffictime, etrafficstatus,
					etrafficlocation);

			int res = asi.admin_UpdateTraffic(t);
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_alltraffics.jsp");
			if (res > 0) {
				request.setAttribute("message","Traffic Edited Successfully");
				rd.include(request, response);
			} else {
				request.setAttribute("message","Traffic Not Edited");
				rd.include(request, response);
			}

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
