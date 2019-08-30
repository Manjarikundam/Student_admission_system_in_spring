package com.example.demo.Interface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.Selected_studentsBean;

public interface Application_Interface  extends CrudRepository<ApplicationBean, Integer>{


	public ApplicationBean findByName(String name);
	
	@Query("SELECT e FROM Selected_studentsBean e WHERE e.alloted_dept =:alloted_dept")
	public ArrayList<Selected_studentsBean> getalloted_dept(@Param("alloted_dept") String alloted_dept);

	@Query("select a from ApplicationBean a where a.college_ch1 in (select c.clgname from ClgadminBean c where c.clgcode = :var)")
	public List<ApplicationBean> findByClgcode(@PathVariable("var") String var);

	@Query("select a from ApplicationBean a where a.status='pending' and a.college_ch1 in (select c.clgname from ClgadminBean c where c.clgcode = :var)")
	public List<ApplicationBean> getPending(@PathVariable("var") String var);
	
}
