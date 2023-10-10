package com.src.dao.interfaces;

import java.util.List;

import com.src.model.Admin;
import com.src.model.Diversions;
import com.src.model.Routes;
import com.src.model.Traffics;

public interface AdminDaoInterface {

	public int addAdmin(Admin admin);
	public boolean validateAdmin(Admin admin) ; 
	public Admin getAdminDetails(String id) ;
	public int adminUpdate(Admin admin);
	
	public int admin_AddDiversion(Diversions d);
	public int admin_AddRoute(Routes r);
	public int admin_AddTraffic(Traffics t);
	
	public List<Diversions> admin_allDiversions();
	public int admin_DeleteDiversion(Diversions d);
	public int admin_UpdateDiversion(Diversions d);
	
	public List<Routes> admin_allRoutes();
	public int admin_DeleteRoute(Routes r);
	public int admin_UpdateRoute(Routes r);
	
	public List<Traffics> admin_allTraffics();
	public int admin_DeleteTraffic(Traffics t);
	public int admin_UpdateTraffic(Traffics t);
	

}
