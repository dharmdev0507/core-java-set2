package com.dev.latest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeMain {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
                new Employee(101, "Amit", 28, "Male", "IT", 2018, 75000),
                new Employee(102, "Neha", 32, "Female", "HR", 2016, 68000),
                new Employee(103, "Ravi", 25, "Male", "Finance", 2020, 55000),
                new Employee(104, "Priya", 29, "Female", "IT", 2017, 82000),
                new Employee(105, "Karan", 35, "Male", "Sales", 2015, 90000),
                new Employee(106, "Anjali", 27, "Female", "Finance", 2019, 60000)
        );
		
		//Given a list of employees, write a Java 8 code to count the number of employees in each department?
		
		Map<String,Long> noOfEmployeeInEachDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("noOfEmployeeInEachDepartment : "+noOfEmployeeInEachDepartment);
		
        //Given a list of employees, find out the average salary of male and female employees?
		
		Map<String,Double> genderWiseAveragesalary=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("genderWiseAveragesalary : "+genderWiseAveragesalary);
		
		//Write a Java 8 code to get the details of highest paid employee in the organization from the given list of employees?
		Employee highstPaidEmployee = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		System.out.println("highstPaidEmployee : "+highstPaidEmployee);
		Employee highestPaidEmp = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("Highest Paid : "+highestPaidEmp);
		
		//Write the Java 8 code to get the average age of each department in an organization?
		Map<String,Double> avgAgeDepartmentWise = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getAge)));
		System.out.println("avgAgeDepartmentWise : "+avgAgeDepartmentWise);
		
		//Given a list of employees, how do you find out who is the senior most employee in the organization?
		Optional<Employee> seniorMostEmployeeWrapper=employees.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

		Employee seniorEmployee = employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getYearOfJoining).reversed())).get();
		System.out.println("seniorEmployee : "+seniorEmployee);
		System.out.println("seniorMostEmployeeWrapper : "+seniorMostEmployeeWrapper.get());
		
		//Given a list of employees, get the details of the most youngest employee in the organization?
		Optional<Employee> youngestEmployee =employees.stream().min(Comparator.comparingInt(Employee::getAge));
		System.out.println("youngestEmployee :"+youngestEmployee.get());
		
		//How do you get the number of employees in each department if you have given a list of employees?
        Map<String, Long> employeeCountByDepartment=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("employeeCountByDepartment : "+employeeCountByDepartment);

		//Given a list of employees, find out the number of male and female employees in the organization?
        Map<String, Long> noOfMaleandFemaleEmployee=employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("noOfMaleandFemaleEmployee : "+noOfMaleandFemaleEmployee);
        
        System.out.println(IntStream.range(0, 5).sum());
	}

}

class Employee
{
    int id;
      
    String name;
      
    int age;
      
    String gender;
      
    String department;
      
    int yearOfJoining;
      
    double salary;
      
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
      
    public int getId() 
    {
        return id;
    }
      
    public String getName() 
    {
        return name;
    }
      
    public int getAge() 
    {
        return age;
    }
      
    public String getGender() 
    {
        return gender;
    }
      
    public String getDepartment() 
    {
        return department;
    }
      
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
      
    public double getSalary() 
    {
        return salary;
    }
      
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
}