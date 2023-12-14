package com.ApiXmlJson.Controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ApiXmlJson.DaoImpl.EmployeeImpl;
import com.ApiXmlJson.Entity.EmployeeBean;

@RestController
public class EmployeControler {
	@Autowired
	private EmployeeImpl employeeImpl;

	// @PostMapping(name = "/employe",consumes = "application/xml")
	@PostMapping("/employe")
	public ResponseEntity<EmployeeBean> insert(@RequestBody EmployeeBean employeeBean) {
		return ResponseEntity.ok(employeeImpl.insert(employeeBean));

	}

	@PutMapping("/employe/{id}")
	public ResponseEntity<EmployeeBean> update(@RequestBody EmployeeBean employeeBean, @PathVariable int id)
			throws IllegalArgumentException, IllegalAccessException {
		return ResponseEntity.ok(employeeImpl.update(employeeBean, id));

	}

	@DeleteMapping("/employe/{id}")
	public ResponseEntity<EmployeeBean> delete(@PathVariable int id) {
		return ResponseEntity.ok(employeeImpl.delete(id));

	}

	@GetMapping("/employe/{id}")
	public ResponseEntity<EmployeeBean> getSingleEmploye(@PathVariable int id) {
		Logger logger = LoggerFactory.getLogger(EmployeControler.class);
		logger.debug("Logger Started");
		return ResponseEntity.ok(employeeImpl.getSingleEmploye(id));

	}

	// @GetMapping(name = "/employe",produces = ("application/xml"))
	@GetMapping("/employe")
	public ResponseEntity<List<EmployeeBean>> listOfEmploye() {
		return ResponseEntity.ok(employeeImpl.listOfEmploye());

	}
}
