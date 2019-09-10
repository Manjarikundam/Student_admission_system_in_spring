package com.student_admission.Restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student_admission.Bean.ApplicationBean;
import com.student_admission.Bean.LoginBean;
import com.student_admission.Interface.Clgadmin_Interface;
import com.student_admission.Interface.Login_Interface;
import com.student_admission.Repository.LoginDao;

@RestController
@RequestMapping("/myresource")
public class Myresource {

	@Autowired
	Clgadmin_Interface clgadmininterface;

	@Autowired
	Login_Interface logininterface;

	@Autowired
	LoginDao logindao;

	// This method gets data from MainController to validate user and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestBody LoginBean loginbean) {
		return logindao.check(loginbean);

	}

	// This method gets data from MainController to add a user and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/insert_applicant", method = RequestMethod.POST)
	public String insert_applicant(@RequestBody ApplicationBean applicationbean) {
		return logindao.insert(applicationbean);
	}

	// This method gets data from MainController to view status user  and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/viewstatus", method = RequestMethod.POST)
	public ApplicationBean viewstatus(@RequestBody ApplicationBean applicationbean) {
		return logindao.viewstatus(applicationbean);
	}
	// This method gets data from MainController to reapply(add) user and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String insert_admin(@RequestBody ApplicationBean applicationbean) throws IOException {
		return logindao.edit(applicationbean);
	}

	// This method gets data from MainController to view the department list and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/viewdeptlist", method = RequestMethod.GET)
	public List<String> getdeptlist() {
		return logindao.getclg();
	}

}
