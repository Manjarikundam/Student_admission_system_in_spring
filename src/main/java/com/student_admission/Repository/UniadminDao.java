package com.student_admission.Repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.student_admission.StudentAdmissionApplication;
import com.student_admission.Bean.ClgadminBean;
import com.student_admission.Bean.LoginBean;
import com.student_admission.Bean.SubadBean;
import com.student_admission.Interface.Clgadmin_Interface;
import com.student_admission.Interface.Login_Interface;
import com.student_admission.Interface.Subadmin_Interface;

@EnableAutoConfiguration
@Service
public class UniadminDao extends StudentAdmissionApplication {

	@Autowired
	Clgadmin_Interface clgadmininterface;

	@Autowired
	Subadmin_Interface subadmininterface;

	@Autowired
	Login_Interface logininterface;

	//This method is used to insert the Subadmin 
	public String insert(ClgadminBean clgbean) throws IOException {
		clgbean.getClgcode();
		clgbean.getClgname();
		clgbean.getAdminname();
		System.out.println(clgbean.toString());
		clgadmininterface.save(clgbean);

		SubadBean subbean = new SubadBean();
		subbean.setName(clgbean.getAdminname());
		subbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
		subbean.setClgcode(clgbean.getClgcode());
		System.out.println(subbean.toString());
		subadmininterface.save(subbean);

		LoginBean loginbean = new LoginBean();
		loginbean.setName(clgbean.getAdminname());
		loginbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
		loginbean.setRole("subadmin");
		System.out.println(loginbean.toString());
		logininterface.save(loginbean);
		return "admin added successfully";
	}

	//This method is used to view admins from the database
	public ArrayList<ClgadminBean> getAdmins() {
		return (ArrayList<ClgadminBean>) clgadmininterface.findAll();
	}

}
