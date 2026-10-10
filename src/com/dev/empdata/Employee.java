package com.dev.empdata;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	
	private int id;
	private String name;
	private String designation;
	private String dept;
	private long salary;
	private LocalDate  dateOfJoining;
	private LocalDate  dateOfBirth;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, String designation, String dept, long salary, LocalDate dateOfJoining,
			LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.dept = dept;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
	}

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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", dept=" + dept + ", salary="
				+ salary + ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfJoining, dept, designation, id, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfJoining, other.dateOfJoining) && Objects.equals(dept, other.dept)
				&& Objects.equals(designation, other.designation) && id == other.id && Objects.equals(name, other.name)
				&& salary == other.salary;
	}
	
}
