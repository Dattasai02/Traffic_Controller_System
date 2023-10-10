package com.src.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.dao.DaoService;
import com.src.dao.interfaces.AdminDaoInterface;
import com.src.model.Admin;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public class AdminDaoService implements AdminDaoInterface {
	DaoService dao = new DaoService();

	@Override
	public int addAdmin(Admin admin) {

		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "insert into admins values( '" + admin.getAdminId() + "' , '" + admin.getAdminName() + "' ,"
					+ " '" + admin.getAdminPassword() + "' , " + admin.getAdminmobnum() + " , '" + admin.getAdminemail()
					+ "'   )";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean validateAdmin(Admin admin) {
		boolean result = false;
		try {
			Statement st = dao.getMyStatement();
			String query = "select * from admins where adminid='" + admin.getAdminId() + "' and adminpassword='"
					+ admin.getAdminPassword() + "'	";
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
	public Admin getAdminDetails(String id) {
		Admin admin = null;
		try {
			Statement st = dao.getMyStatement();
			String query = "select * from admins where adminid='" + id + "'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
			}
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}
	@Override
	public int adminUpdate(Admin admin) {
		int i= 0 ; 
		
		try {
			Statement st = dao.getMyStatement();
			String query = " update admins set adminname='"+admin.getAdminName()+"' , adminpassword='"+admin.getAdminPassword()+"'  , adminmobnum='"+admin.getAdminmobnum()+"'  , adminemail='"+admin.getAdminemail()+"'  where adminid='"+admin.getAdminId()+"'   " ; 
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}

	@Override
	public int admin_AddDiversion(Diversions d) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "insert into diversions values( '" + d.getDivid() + "' , '" + d.getDivroutetype() + "' , '"
					+ d.getDivstart() + "' , '" + d.getDivend() + "' , '" + d.getDivstartdate() + "' , '"
					+ d.getDivenddate() + "' , " + d.getDivkms() + " , '" + d.getDivstatus() + "' )";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int admin_AddRoute(Routes r) {
		int i = 0;

		try {
			Statement st = dao.getMyStatement();
			String query = "insert into routes values( '" + r.getRouteid() + "' ,  '" + r.getRoutetype() + "' ,'"
					+ r.getRoutevehicle() + "','" + r.getRoutestart() + "' , '" + r.getRouteend() + "' , "
					+ r.getRoutekms() + " , '" + r.getRoutestatus() + "' )";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int admin_AddTraffic(Traffics t) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "insert into traffics values( '" + t.getTrafficid() + "','" + t.getTrafficroutetype()
					+ "' , '" + t.getTraffictype() + "' , '" + t.getTraffictime() + "' , '" + t.getTrafficstatus()
					+ "' , '" + t.getTrafficlocation() + "' )";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Diversions> admin_allDiversions() {
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
	public int admin_DeleteDiversion(Diversions d) {

		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "delete from diversions  where divid='" + d.getDivid() + "'";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int admin_UpdateDiversion(Diversions d) {
		int i = 0;

		DaoService dao = new DaoService();
		try {
			Statement st = dao.getMyStatement();
			String query = " update diversions set divroutetype = '" + d.getDivroutetype() + "' , divstart = '"
					+ d.getDivstart() + "' , divend='" + d.getDivend() + "' ,divstartdate='" + d.getDivstartdate()
					+ "'  , divenddate='" + d.getDivenddate() + "'  , divkms=" + d.getDivkms() + "  , divstatus='"
					+ d.getDivstatus() + "' where divid='" + d.getDivid() + "' ";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Routes> admin_allRoutes() {
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
	public int admin_DeleteRoute(Routes r) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "delete from routes  where routeid='" + r.getRouteid() + "'";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int admin_UpdateRoute(Routes r) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = " update routes set routetype='" + r.getRoutetype() + "' , routevehicle='"
					+ r.getRoutevehicle() + "' , routestart='" + r.getRoutestart() + "' ,routeend='" + r.getRouteend()
					+ "' , 				routekms=" + r.getRoutekms() + " , routestatus='" + r.getRoutestatus()
					+ "' where routeid='" + r.getRouteid() + "'  ";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Traffics> admin_allTraffics() {
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
	public int admin_DeleteTraffic(Traffics t) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "delete from traffics  where trafficid='" + t.getTrafficid() + "'";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int admin_UpdateTraffic(Traffics t) {
		int i = 0;
		try {
			Statement st = dao.getMyStatement();
			String query = "update traffics set trafficroutetype='" + t.getTrafficroutetype() + "' , traffictype='"
					+ t.getTraffictype() + "' , traffictime='" + t.getTraffictime() + "' , trafficstatus='"
					+ t.getTrafficstatus() + "' , trafficlocation='" + t.getTrafficlocation() + "' where trafficid='"
					+ t.getTrafficid() + "'  ";
			i = st.executeUpdate(query);
			dao.CloseMyStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	

}
