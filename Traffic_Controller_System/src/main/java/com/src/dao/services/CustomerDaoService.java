package com.src.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.dao.DaoService;
import com.src.dao.interfaces.CustomerDaoInterface;
import com.src.model.Customer;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public class CustomerDaoService implements CustomerDaoInterface {
	DaoService dao = new DaoService();

	@Override
	public int addCustomer(Customer customer) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "insert into customers values( '" + customer.getCustomerId() + "' , '"
					+ customer.getCustomerName() + "' ," + " '" + customer.getCustomerPassword() + "' , "
					+ customer.getCustomerMobNum() + " , '" + customer.getCustomerEmail() + "'   )";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean validateCustomer(Customer customer) {
		boolean result = false;
		try {
			Statement st = dao.getMyStatement();
			String query = "select * from customers where customerid='" + customer.getCustomerId()
					+ "' and customerpassword='" + customer.getCustomerPassword() + "'	";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				result = true;
			}
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer getCustomerDetails(String id) {
		Customer customer = null;
		try {
			Statement st = dao.getMyStatement();
			String query = "select * from customers where customerid='" + id + "'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4),
						rs.getString(5));
			}
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Diversions> customer_allDiversions() {
		ResultSet rs = null;
		ArrayList<Diversions> div = new ArrayList<Diversions>();

		try {
			Statement st = dao.getMyStatement();
			String query = "select * from diversions  ";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String divid = rs.getString(1);
				String routetype = rs.getString(2);
				String startplace = rs.getString(3);
				String endplace = rs.getString(4);
				String startdate = rs.getString(5);
				String enddate = rs.getString(6);
				int routekms = rs.getInt(7);
				String routestatus = rs.getString(8);

				Diversions d = new Diversions(divid, routetype, startplace, endplace, startdate, enddate, routekms,
						routestatus);
				div.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return div;
	}

	@Override
	public List<Routes> customer_allRoutes() {
		ArrayList<Routes> routes = new ArrayList<Routes>();
		ResultSet rsdisplay = null;
		try {
			Statement st = dao.getMyStatement();
			String querydisplay = "select * from routes  ";
			rsdisplay = st.executeQuery(querydisplay);
			while (rsdisplay.next()) {
				String routeid = rsdisplay.getString(1);
				String routetype = rsdisplay.getString(2);
				String routevehicle = rsdisplay.getString(3);
				String routestart = rsdisplay.getString(4);
				String routeend = rsdisplay.getString(5);
				int routekms = rsdisplay.getInt(6);
				String routestatus = rsdisplay.getString(7);

				Routes r = new Routes(routeid, routetype, routevehicle, routestart, routeend, routekms, routestatus);
				routes.add(r);

			}
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return routes;
	}

	@Override
	public List<Traffics> customer_allTraffics() {
		ResultSet rs = null;
		ArrayList<Traffics> traffic = new ArrayList<Traffics>();
		try {
			Statement st = dao.getMyStatement();
			String query = "select * from traffics  ";
			rs = st.executeQuery(query);
			while (rs.next()) {
				String trafficid = rs.getString(1);
				String routetype = rs.getString(2);
				String traffictype = rs.getString(3);
				String traffictime = rs.getString(4);
				String status = rs.getString(5);
				String location = rs.getString(6);

				Traffics t = new Traffics(trafficid, routetype, traffictype, traffictime, status, location);
				traffic.add(t);
			}
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return traffic;
	}

	@Override
	public int customerUpdate(Customer customer) {
		int i = 0;

		try {
			Statement st = dao.getMyStatement();
			String query = " update customers set customername='" + customer.getCustomerName()
					+ "' , customerpassword='" + customer.getCustomerPassword() + "'  , customermobnum='"
					+ customer.getCustomerMobNum() + "'  , customeremail='" + customer.getCustomerEmail()
					+ "'  where customerid='" + customer.getCustomerId() + "'   ";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
