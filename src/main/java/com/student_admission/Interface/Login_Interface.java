package com.student_admission.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_admission.Bean.LoginBean;

public interface Login_Interface extends JpaRepository<LoginBean,String>
{


}

