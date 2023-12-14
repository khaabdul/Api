package com.ApiXmlJson.DaoImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ApiXmlJson.Dao.EmployeeRepo;
import com.ApiXmlJson.Entity.EmployeeBean;

@Service
public class EmployeeImpl {
	@Autowired
	private EmployeeRepo employeeRepo;

	public EmployeeBean insert(EmployeeBean employeeBean) {
		Optional<EmployeeBean> numb = employeeRepo.findByNumber(employeeBean.getNumber());
		if (numb.isPresent()) {
			throw new DuplicateKeyException("Number Already Exist");
		}
		return employeeRepo.save(employeeBean);
	}

	public EmployeeBean update(EmployeeBean employeeBean, int id)
			throws IllegalArgumentException, IllegalAccessException {
		Optional<EmployeeBean> emp = employeeRepo.findById(id);
		if (emp.isEmpty()) {
			throw new NoSuchElementException("Id Not Present");
		}
		for (Field newData : employeeBean.getClass().getDeclaredFields()) {
			newData.setAccessible(true);
			if (newData.get(employeeBean) == null) {
				for (Field oldData : emp.get().getClass().getDeclaredFields()) {
					oldData.setAccessible(true);
					if (newData.getName().equals(oldData.getName())) {
						newData.set(employeeBean, oldData.get(emp.get()));
						employeeBean.setId(id);
					}
				}
			}
		}
		return employeeRepo.save(employeeBean);
	}

	public EmployeeBean delete(int id) {
		Optional<EmployeeBean> emp = employeeRepo.findById(id);
		if (emp.isEmpty()) {
			throw new NoSuchElementException("Id Not Present");
		}
		employeeRepo.delete(emp.get());
		return emp.get();

	}

	public EmployeeBean getSingleEmploye(int id) {
		Optional<EmployeeBean> emp = employeeRepo.findById(id);
		if (emp.isEmpty()) {
			throw new NoSuchElementException("Id Not Present");
		}
		return emp.get();
	}

	public List<EmployeeBean> listOfEmploye() {
		Optional<List<EmployeeBean>> emp = Optional.of(employeeRepo.findAll());
		if (emp.isEmpty()) {
			throw new NoSuchElementException("No Data Present");
		}
		return emp.get();

	}
}
