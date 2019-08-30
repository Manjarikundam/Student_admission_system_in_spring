package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.Selected_studentsBean;

@Controller
public class SubadminController {

	// This Method is called from the SubadminFuncnctions.jsp and this method is
	// used to review applications
	// After this method gets executed it is forwarded to the
	// Applicationreview.jsp
	@RequestMapping("/reviewApplications")
	public ModelAndView viewApplications(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		String var = (String) session.getAttribute("college_code");
		ResponseEntity<List<ApplicationBean>> responseEntity = rest.exchange(
				"http://localhost:8180/myresource_subadmin/view_applications/" + var, HttpMethod.POST, null,
				new ParameterizedTypeReference<List<ApplicationBean>>() {
				});
		mv.addObject("applications", responseEntity.getBody());
		mv.setViewName("Applicationreview.jsp");
		return mv;
	}

	// This Method is called from the SubadminFuncnctions.jsp and this method is
	// used to review selected_students list
	// After this method gets executed it is forwarded to the
	// Selectedlist.jsp
	@RequestMapping("/selectedlist")
	public ModelAndView selected_list(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		String var = (String) session.getAttribute("college_code");
		ResponseEntity<List<Selected_studentsBean>> responseEntity = rest.exchange(
				"http://localhost:8180/myresource_subadmin/selectedlist/" + var, HttpMethod.POST, null,
				new ParameterizedTypeReference<List<Selected_studentsBean>>() {
				});
		mv.addObject("selected", responseEntity.getBody());
		mv.setViewName("Selectedlist.jsp");
		return mv;
	}

	// This Method is called from the SubadminFuncnctions.jsp and this method is
	// used to insert the department name
	// After this method gets executed it is forwarded to the name.jsp
	@RequestMapping("/name")
	public String name(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		return "redirect:name.jsp";
	}

	// This Method is called from the name.jsp and this method is
	// used to get the details og students for given department
	// After this method gets executed it is forwarded to the
	// selected_ofgiven_dept.jsp
	@RequestMapping("/stude_ofgiven_dept")
	public ModelAndView stud_givendept(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String alloted_dept = request.getParameter("alloted");
		Selected_studentsBean selectedbean = new Selected_studentsBean();
		selectedbean.setAlloted_dept(alloted_dept);
		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		String var = (String) session.getAttribute("college_code");
		ResponseEntity<List<Selected_studentsBean>> responseEntity = rest.exchange(
				"http://localhost:8180/myresource_subadmin/listbydept/" + var + "/" + alloted_dept, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Selected_studentsBean>>() {
				});
		mv.addObject("list", responseEntity.getBody());
		mv.setViewName("selected_ofgiven_dept.jsp");
		return mv;
	}

	// This Method is called from the SubadminFuncnctions.jsp and this method is
	// used to confirm the application
	// After this method gets executed it is forwarded to the confirm.jsp
	@RequestMapping("/confirm")
	public ModelAndView confirm(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		String var = (String) session.getAttribute("college_code");
		ResponseEntity<List<ApplicationBean>> responseEntity = rest.exchange(
				"http://localhost:8180/myresource_subadmin/confirm/" + var, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ApplicationBean>>() {
				});
		mv.addObject("confirm", responseEntity.getBody());
		mv.setViewName("confirm.jsp");
		return mv;
	}

	// This Method is called from the confirm.jsp and this method is
	// used to accept the application
	// After this method gets executed it is forwarded to the confirm.jsp
	@RequestMapping("/acceptapplicant")
	public String accept(HttpServletRequest request, HttpServletResponse response) {
		ApplicationBean applicationbean = new ApplicationBean();
		String applicant_no1 = request.getParameter("applicant_no");
		int applicant_no = Integer.valueOf(applicant_no1);
		applicationbean.setApplicant_no(applicant_no);
		String url = "http://localhost:8180/myresource_subadmin/accept";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, applicationbean, String.class);
		return "/confirm";
	}

	// This Method is called from the confirm.jsp and this method is
	// used to reject the application
	// After this method gets executed it is forwarded to the confirm.jsp
	@RequestMapping("/rejectpage")
	public String reject(HttpServletRequest request, HttpServletResponse response) {
		ApplicationBean applicationbean = new ApplicationBean();
		String applicant_no1 = request.getParameter("applicant_no");
		int applicant_no = Integer.valueOf(applicant_no1);
		applicationbean.setApplicant_no(applicant_no);
		String url = "http://localhost:8180/myresource_subadmin/reject";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, applicationbean, String.class);
		return "/confirm";
	}

}
