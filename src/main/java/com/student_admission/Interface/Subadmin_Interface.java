package com.student_admission.Interface;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student_admission.Bean.SubadBean;

public interface Subadmin_Interface extends JpaRepository<SubadBean, String> {

	

}
