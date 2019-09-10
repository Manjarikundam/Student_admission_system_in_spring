package com.student_admission.Restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student_admission.Bean.ApplicationBean;
import com.student_admission.Bean.Selected_studentsBean;
import com.student_admission.Repository.SubadminDao;

@RestController
@RequestMapping("/myresource_subadmin")
public class Myresource_Subadmin {

	@Autowired
	SubadminDao subadmindao;

	// This method gets data from SubadminController to view applications list  and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/view_applications/{var}", method = RequestMethod.POST)
	public List<ApplicationBean> view_applications(@PathVariable("var") String var) {
		return subadmindao.getApplications(var);
	}

	// This method gets data from SubadminController to view selected_students list and these rest calls
			// are sent to service method.
	@RequestMapping(value = "/selectedlist/{var}", method = RequestMethod.POST)
	public List<Selected_studentsBean> selected_list(@PathVariable("var") String var) {
		return subadmindao.selectedlist(var);
	}

	// This method gets data from SubadminController to view selected_students list depending on department and these rest calls
			// are sent to service method.
	@RequestMapping(value = "/listbydept/{var}/{alloted_dept}", method = RequestMethod.GET)
	public List<Selected_studentsBean> getlistbyManager(@PathVariable("var") String var,
			@PathVariable("alloted_dept") String alloted_dept) {
		return subadmindao.student_givendept(var, alloted_dept);
	}

	// This method gets data from SubadminController to Confirm applicant  and these rest calls
				// are sent to service method.
	@RequestMapping(value = "/confirm/{var}", method = RequestMethod.GET)
	public List<ApplicationBean> confirm(@PathVariable("var") String var) {
		return subadmindao.confirm(var);
	}

	// This method gets data from SubadminController to accept the applicant and these rest calls
				// are sent to service method.
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public String accept(@RequestBody ApplicationBean applicationbean) {
		return subadmindao.accept(applicationbean);
	}

	// This method gets data from SubadminController to reject the applicant and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	public String reject(@RequestBody ApplicationBean applicationbean) {
		return subadmindao.reject(applicationbean);
	}

}
