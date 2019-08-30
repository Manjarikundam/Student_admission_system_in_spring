package com.example.demo.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Bean.ClgadminBean;

public interface Clgadmin_Interface extends JpaRepository<ClgadminBean, String>{


	public ClgadminBean findByAdminname(String adminname);

	
	
	
	
}
