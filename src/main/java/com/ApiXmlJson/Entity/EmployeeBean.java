package com.ApiXmlJson.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dept;
	private int salary;
	private String location;
	private String number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeBean(int id, String name, String dept, int salary, String location, String number) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.location = location;
		this.number = number;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", location="
				+ location + ", number=" + number + "]";
	}

}
