package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.example.demo.StudentAdmissionApplication;
import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.ClgadminBean;
import com.example.demo.Bean.LoginBean;
import com.example.demo.Bean.SubadBean;
import com.example.demo.Interface.Application_Interface;
import com.example.demo.Interface.Clgadmin_Interface;
import com.example.demo.Interface.Login_Interface;
import com.example.demo.Interface.Subadmin_Interface;

@EnableAutoConfiguration
@Service
public class LoginDao extends StudentAdmissionApplication {
	@Autowired
	ClgadminBean clgbean;
	@Autowired
	Subadmin_Interface subadmininterface;

	@Autowired
	Clgadmin_Interface clgadmininterface;

	@Autowired
	Application_Interface applicationinterface;

	@Autowired
	Login_Interface logininterface;

	//This method is used to validate the User
	public String check(LoginBean loginbean, ArrayList<LoginBean> loginbean1) {
		String role = null;
		String code = null;
		String clg_name = null;
		String name1 = loginbean1.get(0).getName();
		for (int i = 0; i < loginbean1.size(); i++) {
			if (loginbean1.get(i).getName().equals(null) || loginbean1.get(i).getPassword().equals(null)) {
				role = "error";
			}
			if (loginbean1.get(i).getName().equals(loginbean.getName())
					&& loginbean1.get(i).getPassword().equals(loginbean.getPassword())) {
				if (loginbean1.get(i).getRole().equals("admin")) {
					role = "admin";
				} else if (loginbean1.get(i).getRole().equals("subadmin")) {
					code = clgadmininterface.findByAdminname(loginbean1.get(i).getName()).getClgcode();
					role = "subadmin";
				} else if (loginbean1.get(i).getRole().equals("user")) {
					role = "user";
				}

			}

		}
		return role + "," + code;
	}

	//This method is used to insert the User
	public String insert(ApplicationBean applicationbean) {
		applicationinterface.save(applicationbean);
		LoginBean loginbean = new LoginBean();
		loginbean.setName(applicationbean.getName());
		loginbean.setPassword(applicationbean.getPassword());
		loginbean.setRole("user");
		logininterface.save(loginbean);
		return "applicant added successfully";
	}

	//This method is used to view status of the User
	public ApplicationBean viewstatus(ApplicationBean applicationbean) {
		return applicationinterface.findByName(applicationbean.getName());
	}

	//This method is used to edit the User while rejected for onetime
	public String edit(ApplicationBean applicationbean) {
		ApplicationBean applicationbean1 = applicationinterface.findById(applicationbean.getApplicant_no()).get();
		applicationbean1.setDept_choice(applicationbean.getDept_choice());
		applicationbean1.setCollege_ch1(applicationbean.getCollege_ch1());
		applicationbean1.setStatus("pending");
		applicationinterface.save(applicationbean1);
		return "appliction ";

	}

	//This method is used to get college list from database
	public List<String> getclg() {
		List<ClgadminBean> list = clgadmininterface.findAll();
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i).getClgname());
		}
		return newList;
	}

}
