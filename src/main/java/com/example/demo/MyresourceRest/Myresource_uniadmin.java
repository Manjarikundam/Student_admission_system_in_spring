package com.example.demo.MyresourceRest;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.ClgadminBean;
import com.example.demo.DAO.UniadminDao;
import com.example.demo.Interface.Clgadmin_Interface;

@RestController
@RequestMapping("/myresource_uni")
public class Myresource_uniadmin {
	@Autowired
	UniadminDao ls;

	@Autowired
	Clgadmin_Interface clgadmininterface;

	// This method gets data from UniversityAdmin(Controller) to insert Subadmin and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/insert_admin", method = RequestMethod.POST)
	public String insert_admin(@RequestBody ClgadminBean clgbean) throws IOException {
		return ls.insert(clgbean);

	}

	// This method gets data from UniversityAdmin(Controller)  to view Subadmins and these rest calls
		// are sent to service method.
	@RequestMapping(value = "/view_admins", method = RequestMethod.GET)
	public ArrayList<ClgadminBean> view_admin() {
		return ls.getAdmins();
	}

}
