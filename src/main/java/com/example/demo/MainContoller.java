package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.LoginBean;

@Controller
public class MainContoller {

	private LoginBean loginbean;

	// This Method is called from the /index and this method is
	// used to move to jsp
	// After this method gets executed it is forwarded to the
	// index.jsp page
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView maincontroller() {
		ModelAndView mv = new ModelAndView("index.jsp");
		loginbean = new LoginBean();
		mv.addObject(loginbean);
		return mv;
	}

	// This Method is called from the reject.jsp and this method is
		// used to reapply as his/her application has been rejected
		// After this method gets executed it is forwarded to the
		//success.jsp to confirm that the data is inserted
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ApplicationBean applicationbean = (ApplicationBean) request.getSession().getAttribute("name");
		String dept_choice = request.getParameter("dept_choice");
		String college_ch1 = request.getParameter("college_ch1");
		applicationbean.setApplicant_no(applicationbean.getApplicant_no());
		applicationbean.setDept_choice(dept_choice);
		applicationbean.setCollege_ch1(college_ch1);
		String url = "http://localhost:8180/myresource/edit";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, applicationbean, String.class);
		return "redirect:Success.jsp";

	}

	// This Method is called from the index.jsp page and this method is
		// used to Validate a user to database.
		// After this method gets executed it is forwarded to the
		// Myresource(RestController) where rest calls are made.
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String maincontroller(LoginBean loginbean, HttpServletRequest request, HttpServletResponse response) {
		String url = "http://localhost:8180/myresource/insert";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, loginbean, String.class);
		String[] values = status.split(",", 2);
		String role = values[0];
		String code = values[1];
		if (role.equals("admin")) {
			return "redirect:AdminFunctions.jsp";
		} else if (role.equals("user")) {
			return "/details";
		} else if (role.equals("subadmin")) {
			request.getSession().setAttribute("college_code", code);
			return "redirect:SubadminFunctions.jsp";
		}

		else
			return "redirect:index.jsp";
	}

	// This Method is called from the /index based on role(user) and this method is
		// used to find the status and move according the status
		// After this method gets executed it is forwarded to the
		// Jsp page according to the status
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public String detail(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		ApplicationBean applicationbean = new ApplicationBean();
		LoginBean loginbean = new LoginBean();
		String name = request.getParameter("name");
		loginbean.setName(name);
		applicationbean.setName(name);
		//directs to rest controller(Myresource)
		String url = "http://localhost:8180/myresource/viewstatus";
		RestTemplate rt = new RestTemplate();
		ApplicationBean employResponse = rt.postForObject(url, applicationbean, ApplicationBean.class);
		session.setAttribute("name", employResponse);
		if (employResponse.getStatus().equals("pending") || employResponse.getStatus().equals("accepted")) {
			return "redirect:UserFunctions.jsp";
		} else if (employResponse.getStatus().equals("rejected") && employResponse.getCount() < 2) {
			return "redirect:reject.jsp";
		} else if (employResponse.getStatus().equals("rejected") && employResponse.getCount() >= 2)
			return "redirect:finalreject.jsp";
		else {
			return "redirect:index.jsp";
		}
	}

	
	// This Method is called from the Application.jsp page  and this method is
			// used to insert the data into applications
			// After this method gets executed it is forwarded to the
			// Success.jsp page to show that the details are inserted
	@RequestMapping(value = "/insertapplicant", method = RequestMethod.POST)
	public String insert_applicant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ApplicationBean applicationbean = new ApplicationBean();
		applicationbean.setName(request.getParameter("name"));
		applicationbean.setPassword(request.getParameter("password"));
		applicationbean.setBoard(request.getParameter("board"));
		applicationbean.setPercentage(Integer.parseInt(request.getParameter("percentage")));
		applicationbean.setGpa(request.getParameter("gpa"));
		applicationbean.setSchool_name(request.getParameter("school_name"));
		applicationbean.setDept_choice(request.getParameter("dept_choice"));
		applicationbean.setCollege_ch1(request.getParameter("college_ch1"));
		applicationbean.setStatus("pending");
		applicationbean.setCount(0);
		//directs to rest controller(Myresource)
		String url = "http://localhost:8180/myresource/insert_applicant";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, applicationbean, String.class);
		return "redirect:Success.jsp";
	}

	// This Method is called from the index.jsp page  and this method is
				// used to get the list of colleges that are present in the database
				// After this method gets executed it is forwarded to the
				// Application.jsp page and the data is used in the drop down list
	@RequestMapping("/getdept")
	public ModelAndView Raiseticket() {
		String url = "http://localhost:8180/myresource/viewdeptlist";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<String>> res = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		ModelAndView mv = new ModelAndView();
		List<String> deptlist = res.getBody();
		mv.addObject("deptlist", deptlist);
		mv.setViewName("Application.jsp");
		return mv;
	}
}
