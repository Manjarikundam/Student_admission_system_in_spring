package com.example.demo.DAO;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.example.demo.StudentAdmissionApplication;
import com.example.demo.Bean.ClgadminBean;
import com.example.demo.Bean.LoginBean;
import com.example.demo.Bean.SubadBean;
import com.example.demo.Interface.Clgadmin_Interface;
import com.example.demo.Interface.Login_Interface;
import com.example.demo.Interface.Subadmin_Interface;

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
		clgadmininterface.save(clgbean);

		SubadBean subbean = new SubadBean();
		subbean.setName(clgbean.getAdminname());
		subbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
		subbean.setClgcode(clgbean.getClgcode());
		subadmininterface.save(subbean);

		LoginBean loginbean = new LoginBean();
		loginbean.setName(clgbean.getAdminname());
		loginbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
		loginbean.setRole("subadmin");
		logininterface.save(loginbean);
		return "admin added successfully";
	}

	//This method is used to view admins from the database
	public ArrayList<ClgadminBean> getAdmins() {
		return (ArrayList<ClgadminBean>) clgadmininterface.findAll();
	}

}
