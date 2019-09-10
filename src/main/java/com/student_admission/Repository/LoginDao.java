package com.student_admission.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.student_admission.StudentAdmissionApplication;
import com.student_admission.Bean.ApplicationBean;
import com.student_admission.Bean.ClgadminBean;
import com.student_admission.Bean.LoginBean;
import com.student_admission.Bean.SubadBean;
import com.student_admission.Interface.Application_Interface;
import com.student_admission.Interface.Clgadmin_Interface;
import com.student_admission.Interface.Login_Interface;
import com.student_admission.Interface.Subadmin_Interface;

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
	public String check(LoginBean loginbean) {
		String role = null;
		String code = null;
		String clg_name = null;
		LoginBean list =logininterface.findById(loginbean.getName()).get();
		//String name1 = loginbean1.get(0).getName();
	
			if (list.getName().equals(null) || list.getPassword().equals(null)) {
				role = "error";
			}
			if (list.getName().equals(loginbean.getName())
					&& list.getPassword().equals(loginbean.getPassword()))
			{
				if (list.getRole().equals("admin")) {
					role = "admin";
				} else if (list.getRole().equals("subadmin")) {
					code = clgadmininterface.findByAdminname(list.getName()).getClgcode();
					role = "subadmin";
				} else if (list.getRole().equals("user")) {
					role = "user";
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
