package com.src.services;

import java.util.List;

import com.src.dao.interfaces.AdminDaoInterface;
import com.src.dao.services.AdminDaoService;
import com.src.interfacess.AdminServiceInterface;
import com.src.model.Admin;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public class AdminService implements AdminServiceInterface {

	AdminDaoInterface admindao = new AdminDaoService();

	@Override
	public int addAdmin(Admin admin) {
		return admindao.addAdmin(admin);
	}

	@Override
	public boolean validateAdmin(Admin admin) {
		return admindao.validateAdmin(admin);
	}

	@Override
	public Admin getAdminDetails(String id) {
		return admindao.getAdminDetails(id);
	}


	@Override
	public int adminUpdate(Admin admin) {
		
		return admindao.adminUpdate(admin);
	}
	@Override
	public int admin_AddDiversion(Diversions d) {
		return admindao.admin_AddDiversion(d);
	}

	@Override
	public int admin_AddRoute(Routes r) {
		return admindao.admin_AddRoute(r);
	}

	@Override
	public int admin_AddTraffic(Traffics t) {

		return admindao.admin_AddTraffic(t);
	}

	@Override
	public List<Diversions> admin_allDiversions() {
		return admindao.admin_allDiversions();
	}

	@Override
	public int admin_DeleteDiversion(Diversions d) {
		return admindao.admin_DeleteDiversion(d);
	}

	@Override
	public int admin_UpdateDiversion(Diversions d) {
		return admindao.admin_UpdateDiversion(d);
	}

	@Override
	public List<Routes> admin_allRoutes() {

		return admindao.admin_allRoutes();
	}

	@Override
	public int admin_DeleteRoute(Routes r) {

		return admindao.admin_DeleteRoute(r);
	}

	@Override
	public int admin_UpdateRoute(Routes r) {
		return admindao.admin_UpdateRoute(r);
	}

	@Override
	public List<Traffics> admin_allTraffics() {

		return admindao.admin_allTraffics();
	}

	@Override
	public int admin_DeleteTraffic(Traffics t) {

		return admindao.admin_DeleteTraffic(t);
	}

	@Override
	public int admin_UpdateTraffic(Traffics t) {

		return admindao.admin_UpdateTraffic(t);
	}


}
