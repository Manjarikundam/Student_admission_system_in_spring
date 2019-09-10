package com.student_admission.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_admission.Bean.ClgadminBean;

public interface Clgadmin_Interface extends JpaRepository<ClgadminBean, String>{


	public ClgadminBean findByAdminname(String adminname);

	
	
	
	
}
