package com.src.model;

public class Routes {
	
	private String routeid ; 
	private String routetype ; 
	private String routevehicle ;
	private String routestart ; 
	private String routeend ; 
	private int routekms ;
	private String routestatus;
	public Routes(String routeid, String routetype, String routevehicle, String routestart, String routeend,
			int routekms, String routestatus) {
		super();
		this.routeid = routeid;
		this.routetype = routetype;
		this.routevehicle = routevehicle;
		this.routestart = routestart;
		this.routeend = routeend;
		this.routekms = routekms;
		this.routestatus = routestatus;
	}
	public Routes() {
		super();
	}
	public Routes(String routeid) {
		this.routeid = routeid;
		
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getRoutetype() {
		return routetype;
	}
	public void setRoutetype(String routetype) {
		this.routetype = routetype;
	}
	public String getRoutevehicle() {
		return routevehicle;
	}
	public void setRoutevehicle(String routevehicle) {
		this.routevehicle = routevehicle;
	}
	public String getRoutestart() {
		return routestart;
	}
	public void setRoutestart(String routestart) {
		this.routestart = routestart;
	}
	public String getRouteend() {
		return routeend;
	}
	public void setRouteend(String routeend) {
		this.routeend = routeend;
	}
	public int getRoutekms() {
		return routekms;
	}
	public void setRoutekms(int routekms) {
		this.routekms = routekms;
	}
	public String getRoutestatus() {
		return routestatus;
	}
	public void setRoutestatus(String routestatus) {
		this.routestatus = routestatus;
	} 

}
