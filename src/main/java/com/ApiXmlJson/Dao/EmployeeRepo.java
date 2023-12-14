package com.ApiXmlJson.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiXmlJson.Entity.EmployeeBean;

public interface EmployeeRepo extends JpaRepository<EmployeeBean, Integer> {
	public Optional<EmployeeBean> findByNumber(String number);

}
