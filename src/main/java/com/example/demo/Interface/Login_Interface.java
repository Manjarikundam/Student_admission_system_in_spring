package com.example.demo.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Bean.ClgadminBean;
import com.example.demo.Bean.LoginBean;

public interface Login_Interface extends JpaRepository<LoginBean,String>
{

}

