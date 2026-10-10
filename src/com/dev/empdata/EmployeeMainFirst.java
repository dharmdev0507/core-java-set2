package com.dev.empdata;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeMainFirst {

	public static void main(String[] args) {
		
		List<Employee> empList = List.of(
			    new Employee(1, "Ram", "Developer", "IT", 90000, LocalDate.of(2019, 1, 15), LocalDate.of(1995, 3, 12)),
			    new Employee(2, "Shyam", "Manager", "HR", 120000, LocalDate.of(2016, 5, 10), LocalDate.of(1988, 7, 25)),
			    new Employee(3, "Mohan", "Analyst", "Finance", 75000, LocalDate.of(2020, 3, 25), LocalDate.of(1993, 11, 8)),
			    new Employee(4, "Sita", "Developer", "IT", 95000, LocalDate.of(2018, 7, 12), LocalDate.of(1996, 1, 19)),
			    new Employee(5, "Geeta", "Sales Executive", "Sales", 60000, LocalDate.of(2021, 2, 20), LocalDate.of(1997, 5, 30)),
			    new Employee(6, "Ravi", "Tech Lead", "IT", 130000, LocalDate.of(2015, 11, 30), LocalDate.of(1985, 9, 14)),
			    new Employee(7, "Anjali", "HR Executive", "HR", 70000, LocalDate.of(2022, 6, 18), LocalDate.of(1998, 12, 3)),
			    new Employee(8, "Vikas", "Finance Manager", "Finance", 110000, LocalDate.of(2017, 9, 5), LocalDate.of(1987, 4, 22)),
			    new Employee(9, "Neha", "Sales Manager", "Sales", 90000, LocalDate.of(2019, 12, 1), LocalDate.of(1992, 8, 16)),
			    new Employee(10, "Amit", "Architect", "IT", 150000, LocalDate.of(2014, 4, 8), LocalDate.of(1983, 2, 10)),
			    new Employee(11, "Priya", "Developer", "IT", 85000, LocalDate.of(2023, 1, 10), LocalDate.of(2000, 6, 28)),
			    new Employee(12, "Karan", "Analyst", "Finance", 80000, LocalDate.of(2020, 10, 14), LocalDate.of(1994, 10, 5)),
			    new Employee(13, "Sneha", "Recruiter", "HR", 65000, LocalDate.of(2021, 8, 9), LocalDate.of(1996, 3, 18)),
			    new Employee(14, "Rahul", "Sales Executive", "Sales", 58000, LocalDate.of(2022, 11, 25), LocalDate.of(1999, 7, 11)),
			    new Employee(15, "Pooja", "Developer", "IT", 92000, LocalDate.of(2019, 6, 17), LocalDate.of(1995, 12, 27))
			);
		
		//1. Highest salary in each department
		Map<String,Optional<Employee>> hihestSalaryEachDepartment = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		
		System.out.println("--- Highest salary in each department---");
		hihestSalaryEachDepartment.forEach((dept,empOpt)->{
            empOpt.ifPresent(emp ->System.out.println(dept+ " : "+emp.getSalary()));
		});
		
		//2. Second highest salary in each department 
		Map<String,Optional<Employee>> secondHigestSalary= empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.collectingAndThen(Collectors.toList(), 
								empObj->empObj.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()
								)
						
						));
		
		System.out.println("----Second highest salary in each department----");
		secondHigestSalary.forEach((dept,empOpt)->{
			empOpt.ifPresent(emp->System.out.println(dept+" : "+emp.getSalary()));
		});
		
		//3. Count employees in each department
		Map<String,Long> empCountEachDept = empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
		System.out.println("----Count employees in each department----");
		empCountEachDept.forEach((key,value)->System.out.println(key +":"+value));
		
		//4. Average salary of each department 
		Map<String,Double> avgSalary = empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("----Average salary of each department ----");
		avgSalary.forEach((k,v)->System.out.println(k+":"+v));
		
		//5. Employee names by department 
		Map<String,List<Employee>> empName=empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
		System.out.println("---Employee names by department---");
		
		empName.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
		
		//6. Department having highest average salary ⭐⭐⭐⭐
		Map<String,Double> highestAvgSalarymain = empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
		Map.Entry<String,Double> highestAvgSalary=highestAvgSalarymain.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
		/*
		 * Map.Entry<String, Double> highestAvgSalary = highestAvgSalarymain.entrySet()
		 * .stream() .max(Map.Entry.comparingByValue()) .orElseThrow();
		 */
		System.out.println("---Department having highest average salary---");
		System.out.println(highestAvgSalary.getKey() + " = " + highestAvgSalary.getValue());
		highestAvgSalarymain.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
		
		//10. Sort employees by salary descending ⭐⭐
		List<Employee> empSalary=empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println("---Sort employees by salary descending---");
		for (Employee employee : empSalary) {
			System.out.println(employee);
		}
	
	}

}
