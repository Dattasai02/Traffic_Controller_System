package com.src.model;

public class Traffics {
	
	private String trafficid ; 
	private String trafficroutetype ; 
	private String traffictype ; 
	private String traffictime ; 
	private String trafficstatus ; 
	private String trafficlocation ;
	public String getTrafficid() {
		return trafficid;
	}
	public void setTrafficid(String trafficid) {
		this.trafficid = trafficid;
	}
	public String getTrafficroutetype() {
		return trafficroutetype;
	}
	public void setTrafficroutetype(String trafficroutetype) {
		this.trafficroutetype = trafficroutetype;
	}
	public String getTraffictype() {
		return traffictype;
	}
	public void setTraffictype(String traffictype) {
		this.traffictype = traffictype;
	}
	public String getTraffictime() {
		return traffictime;
	}
	public void setTraffictime(String traffictime) {
		this.traffictime = traffictime;
	}
	public String getTrafficstatus() {
		return trafficstatus;
	}
	public void setTrafficstatus(String trafficstatus) {
		this.trafficstatus = trafficstatus;
	}
	public String getTrafficlocation() {
		return trafficlocation;
	}
	public void setTrafficlocation(String trafficlocation) {
		this.trafficlocation = trafficlocation;
	}
	public Traffics(String trafficid, String trafficroutetype, String traffictype, String traffictime,
			String trafficstatus, String trafficlocation) {
		super();
		this.trafficid = trafficid;
		this.trafficroutetype = trafficroutetype;
		this.traffictype = traffictype;
		this.traffictime = traffictime;
		this.trafficstatus = trafficstatus;
		this.trafficlocation = trafficlocation;
	}
	public Traffics() {
		super();
	}
	public Traffics(String trafficid) {
		this.trafficid = trafficid;
	} 

}
