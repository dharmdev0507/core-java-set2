package com.dev.empdata;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class EmployeeMainThird {

	public static void main(String[] args) {
		
		List<Employee> empList = List.of(
			    new Employee(1, "Ram", "Developer", "IT", 90000, LocalDate.of(2019, 1, 15), LocalDate.of(1995, 3, 12)),
			    new Employee(2, "Shyam", "Manager", "HR", 120000, LocalDate.of(2016, 5, 10), LocalDate.of(1988, 7, 25)),
			    new Employee(3, "Mohan", "Analyst", "Finance", 75000, LocalDate.of(2020, 3, 25), LocalDate.of(1993, 11, 8)),
			    new Employee(4, "Sita", "Developer", "IT", 95000, LocalDate.of(2018, 7, 12), LocalDate.of(1996, 1, 19)),
			    new Employee(5, "Geeta", "Sales Executive", "Sales", 40000, LocalDate.of(2021, 2, 20), LocalDate.of(1997, 5, 30)),
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
		
		
		//11. Youngest employee in each department ⭐⭐⭐
		Map<String,Optional<Employee>> youngestEmployee=empList.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.maxBy(Comparator.comparing(Employee::getDateOfBirth))));
		System.out.println("---Youngest employee in each department----");
		youngestEmployee.forEach((dept,empOpt)->{
			empOpt.ifPresent(emp->System.out.println(dept+":"+emp.getName()));
		});
		
		//using collectingAndThen
		Map<String,Employee> youngestEmp= empList.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getDateOfBirth)), Optional::get)));
		System.out.println("---Youngest employee in each department using collectingAndThen----");
		youngestEmp.forEach((k,v)->{
			System.out.println(k+":"+v.getName());
		});
		
		//12. Total salary of each department ⭐⭐⭐
		Map<String,Double> totalSalaryDept=empList.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.summingDouble(Employee::getSalary)
				));
		System.out.println("---Total salary of each department---");
		totalSalaryDept.forEach((k,v)->{
			System.out.println(k+":"+v);
		});
		
		
		//13. Partition employees by salary > 50000
		Map<Boolean,List<Employee>> salaryGreaterthan50k=empList.stream().collect(Collectors.partitioningBy(emp->emp.getSalary()>50000));
		System.out.println("---Partition employees by salary > 50000---");
		List<Employee> empGr50k=salaryGreaterthan50k.get(true);
		List<Employee> empLess50k=salaryGreaterthan50k.get(false);
		System.out.println("Greater 50K :"+empGr50k);
		System.out.println("Less 50K :"+empLess50k);
		
		//16. Group employees by department and sort by salary ⭐⭐⭐⭐
		Map<String,List<Employee>> departmentWiseSalary=empList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
		System.out.println("---Group employees by department and sort by salary----");
		departmentWiseSalary.forEach((dept,emlist)->{
			System.out.println(dept);
			for (Employee employee : emlist) {
				System.out.println(":"+employee.getName());	
			}
			
		});
		
		//17. Find nth highest salary 
		int nth=1;
		Employee nthHighestSalary=empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(nth-1).findFirst().get();
		System.out.println("Find "+nth+"th highest salary : "+nthHighestSalary);
		
		//19. Find employee with longest name ⭐⭐
		Employee logestname=empList.stream().max(Comparator.comparing(emp -> emp.getName().length())).get();
		System.out.println("---Find employee with longest name----");
		System.out.println(logestname.getName());

		//20. Multi-level grouping ->Group by department, then by designation.
        Map<String,Map<String,List<Employee>>> multiLevelGrouping=empList.stream().collect(Collectors.groupingBy(Employee::getDept,
        		Collectors.groupingBy(Employee::getDesignation,Collectors.toList()))
        		);
		
        System.out.println("---Multi-level grouping----");
		multiLevelGrouping.forEach((dept,multiGroup)->{
			System.out.println(dept);
			multiGroup.forEach((designation,employee)->{
				System.out.println(designation+":"+employee);
			});
		});

	}

}
