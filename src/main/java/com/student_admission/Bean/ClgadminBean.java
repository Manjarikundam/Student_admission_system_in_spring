package com.student_admission.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class ClgadminBean {
	@Id
	private String clgcode;
	private String clgname;
	private String adminname;
	
	

	public String getClgcode() {
		return clgcode;
	}
	public void setClgcode(String clgcode) {
		this.clgcode = clgcode;
	}
	public String getClgname() {
		return clgname;
	}
	public void setClgname(String clgname) {
		this.clgname = clgname;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	@Override
	public String toString() {
		return "ClgadminBean [clgcode=" + clgcode + ", clgname=" + clgname + ", adminname=" + adminname + "]";
	}
	
	

}
