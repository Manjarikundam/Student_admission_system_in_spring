package com.student_admission.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.student_admission.StudentAdmissionApplication;
import com.student_admission.Bean.ApplicationBean;
import com.student_admission.Bean.Selected_studentsBean;
import com.student_admission.Interface.Application_Interface;
import com.student_admission.Interface.Clgadmin_Interface;
import com.student_admission.Interface.Selected_Interface;

@EnableAutoConfiguration
@Service
public class SubadminDao extends StudentAdmissionApplication {

	@Autowired
	Clgadmin_Interface clgadmininterface;

	@Autowired
	Application_Interface applicationinterface;

	@Autowired
	Selected_Interface selectedinterface;

	//This method is used to get applications 
	public List<ApplicationBean> getApplications(String code) {
		return applicationinterface.findByClgcode(code);
	}

	//This method is used to get list of Selected_students
	public List<Selected_studentsBean> selectedlist(String code) {
		return selectedinterface.findByClgcode(code);
	}

	//This method is used to get list of Selected_students depending on department
	public List<Selected_studentsBean> student_givendept(String code, String alloted_dept) {
		return selectedinterface.getalloted_dept(code, alloted_dept);
	}

	//This method is used to confirm application
	public List<ApplicationBean> confirm(String code) {
		return applicationinterface.getPending(code);
	}

	//This method is used to accept the application 
	public String accept(ApplicationBean applicationbean) {
		ApplicationBean applicationbean1 = applicationinterface.findById(applicationbean.getApplicant_no()).get();
		applicationbean1.setStatus("accepted");
		applicationinterface.save(applicationbean1);

		Selected_studentsBean selectedstudents = new Selected_studentsBean();
		selectedstudents.setApplicant_no(applicationbean1.getApplicant_no());
		selectedstudents.setName(applicationbean1.getName());
		selectedstudents.setPercentage(applicationbean1.getPercentage());
		selectedstudents.setAlloted_dept(applicationbean1.getDept_choice());
		selectedstudents.setAlloted_college(applicationbean1.getCollege_ch1());
		selectedinterface.save(selectedstudents);
		return "accepted";
	}

	//This method is used to reject the application
	public String reject(ApplicationBean applicationbean) {
		ApplicationBean applicationbean1 = applicationinterface.findById(applicationbean.getApplicant_no()).get();
		applicationbean1.setStatus("rejected");
		applicationbean1.setCount(applicationbean1.getCount() + 1);
		applicationinterface.save(applicationbean1);
		return "rejected";
	}

}
