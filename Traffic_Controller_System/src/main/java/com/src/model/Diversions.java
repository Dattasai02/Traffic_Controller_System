package com.src.model;

public class Diversions {
	
	private String divid ; 
	private String divroutetype ; 
	private String divstart ; 
	private String divend ; 
	private String divstartdate ; 
	private String divenddate ; 
	private int divkms ; 
	private String divstatus ;
	public Diversions(String divid, String divroutetype, String divstart, String divend, String divstartdate,
			String divenddate, int divkms, String divstatus) {
		super();
		this.divid = divid;
		this.divroutetype = divroutetype;
		this.divstart = divstart;
		this.divend = divend;
		this.divstartdate = divstartdate;
		this.divenddate = divenddate;
		this.divkms = divkms;
		this.divstatus = divstatus;
	}
	public Diversions() {
		super();
	}
	public Diversions(String divid) {
		this.divid = divid;
	}
	public String getDivid() {
		return divid;
	}
	public void setDivid(String divid) {
		this.divid = divid;
	}
	public String getDivroutetype() {
		return divroutetype;
	}
	public void setDivroutetype(String divroutetype) {
		this.divroutetype = divroutetype;
	}
	public String getDivstart() {
		return divstart;
	}
	public void setDivstart(String divstart) {
		this.divstart = divstart;
	}
	public String getDivend() {
		return divend;
	}
	public void setDivend(String divend) {
		this.divend = divend;
	}
	public String getDivstartdate() {
		return divstartdate;
	}
	public void setDivstartdate(String divstartdate) {
		this.divstartdate = divstartdate;
	}
	public String getDivenddate() {
		return divenddate;
	}
	public void setDivenddate(String divenddate) {
		this.divenddate = divenddate;
	}
	public int getDivkms() {
		return divkms;
	}
	public void setDivkms(int divkms) {
		this.divkms = divkms;
	}
	public String getDivstatus() {
		return divstatus;
	}
	public void setDivstatus(String divstatus) {
		this.divstatus = divstatus;
	} 
	

}
