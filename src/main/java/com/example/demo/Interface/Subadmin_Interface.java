package com.example.demo.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Bean.SubadBean;

public interface Subadmin_Interface extends JpaRepository<SubadBean, String> {

	

}
