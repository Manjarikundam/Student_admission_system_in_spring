package com.example.demo.Interface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.ApplicationBean;
import com.example.demo.Bean.Selected_studentsBean;

public interface Selected_Interface extends JpaRepository<Selected_studentsBean, Integer>{

	@Query("SELECT e FROM Selected_studentsBean e WHERE e.alloted_college in (select c.clgname from ClgadminBean c where c.clgcode = :var) and e.alloted_dept =:alloted_dept")
	public ArrayList<Selected_studentsBean> getalloted_dept(@PathVariable("var") String var,@Param("alloted_dept") String alloted_dept);
	
	@Query("select a from Selected_studentsBean a where a.alloted_college in (select c.clgname from ClgadminBean c where c.clgcode = :var)")
	public List<Selected_studentsBean> findByClgcode(@PathVariable("var") String var);


}
