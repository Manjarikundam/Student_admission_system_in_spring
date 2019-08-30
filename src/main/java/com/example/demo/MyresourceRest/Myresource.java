package com.example.demo.MyresourceRest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.LoginBean;
import com.example.demo.DAO.LoginDao;
import com.example.demo.Interface.Clgadmin_Interface;
import com.example.demo.Interface.Login_Interface;

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
		ArrayList<LoginBean> loginbean1 = (ArrayList<LoginBean>) logininterface.findAll();
		String status = logindao.check(loginbean, loginbean1);
		return status;
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
