package com.student_admission.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.student_admission.Bean.ClgadminBean;

@Controller
public class UniversityAdmin {

	/* This Method is called from the AdminFunctions.jsp and this method is
	 used to add subadmins
	 After this method gets executed it is forwarded to the success.jsp to confirm
	 that the admin added */
	@RequestMapping(value = "/add_admins", method = RequestMethod.POST)
	public String Universityadmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		ClgadminBean clgbean = new ClgadminBean();
		clgbean.setClgcode(request.getParameter("clgcode"));
		clgbean.setClgname(request.getParameter("clgname"));
		clgbean.setAdminname(request.getParameter("adminname"));
		String url = "http://localhost:8180/myresource_uni/insert_admin";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, clgbean, String.class);
		return "redirect:Success.jsp";
	}

	// This Method is called from the AdminFunctions.jsp and this method is
		// used to view admins
		// After this method gets executed it is forwarded to the viewAdmins.jsp
	@RequestMapping("/reviewAdmins")
	public ModelAndView viewAdmins() {
		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<ClgadminBean>> responseEntity = rest.exchange(
				"http://localhost:8180/myresource_uni/view_admins", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ClgadminBean>>() {
				});
		mv.addObject("admins", responseEntity.getBody());
		mv.setViewName("viewAdmins.jsp");
		return mv;
	}

}