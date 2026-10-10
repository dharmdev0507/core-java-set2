package com.dev.latest;

import java.util.*;
import java.util.stream.*;

public class StudentMain {

	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(
                new Student("Amit", 101, "Math", 85.5),
                new Student("Ravi", 102, "Science", 78.0),
                new Student("Neha", 103, "Math", 92.3),
                new Student("Priya", 104, "English", 88.1),
                new Student("Abhijit", 103, "Math", 52.3),
                new Student("Priyanka", 104, "English", 88.1),
                new Student("Karan", 105, "Science", 74.6)
        );
		
		
		//Given a list of students, write a Java 8 code to partition the students who got above 60% from those who didn’t?
 
		Map<Boolean,List<Student>> studentgraterthan60Percentage = students.stream().collect(Collectors.partitioningBy(student->student.getPercentage()>60.0));
		System.out.println(studentgraterthan60Percentage.get(true));

		//Given a list of students, write a Java 8 code to get the names of top 3 performing students?
		
		List<Student> top3PerformingStudent = students.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList());
		System.out.println("top3PerformingStudent : "+top3PerformingStudent);
		
		//Given a list of students, how do you get the name and percentage of each student?
		Map<String,Double> namePercentage=students.stream().collect(Collectors.toMap(Student::getName,Student::getPercentage));
		System.out.println("namePercentage : "+namePercentage);
		
		//Given a list of students, how do you get the subjects offered in the college?
		
		String subjectOffered = students.stream().map(Student::getSubject).distinct().collect(Collectors.joining(","));
		System.out.println("subjectOffered : "+subjectOffered);
		
		//Given a list of students, write a Java 8 code to get highest, lowest and average percentage of students?
		
		DoubleSummaryStatistics studentStats = students.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
		System.out.println("Highest Percentage : "+studentStats.getMax());
		System.out.println("Lowest Percentage : "+studentStats.getMin());
		System.out.println("Average Percentage : "+studentStats.getAverage());
		
		double max = students.stream().max(Comparator.comparingDouble(Student::getPercentage)).get().getPercentage();
		double min = students.stream().min(Comparator.comparingDouble(Student::getPercentage)).get().getPercentage();
		
		double average = students.stream().mapToDouble(Student::getPercentage).average().orElse(0.0);
		System.out.println("Max : "+max);
		System.out.println("Min : "+min);
		System.out.println("Average : "+average);
		
		//How do you get total number of students from the given list of students?
		
		double count = students.stream().count();
		Long studentCount = students.stream().collect(Collectors.counting());
		System.out.println("Student count :"+count+" studentCount : "+studentCount);
		
		//How do you get the students grouped by subject from the given list of students?
		Map<String,List<Student>> studentGroupBySubject = students.stream().collect(Collectors.groupingBy(Student::getSubject,Collectors.toList()));
		
		studentGroupBySubject.forEach((k,v)->System.out.println(k+" : "+v.toString()));

		//How do you get the students grouped by subject from the given list of students?
		Map<String,Map<String,Double>> studentGroupBySubjects = students.stream().collect(Collectors.groupingBy(Student::getSubject,Collectors.toMap(Student::getName, Student::getPercentage)));
		System.out.println();
		studentGroupBySubjects.forEach((k,v)->System.out.println(k+" = "+v.toString()));
	}

}

class Student
{
    String name;
      
    int id;
      
    String subject;
      
    double percentage;
      
    public Student(String name, int id, String subject, double percentage) 
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }
      
    public String getName() 
    {
        return name;
    }
      
    public int getId() 
    {
        return id;
    }
      
    public String getSubject() 
    {
        return subject;
    }
      
    public double getPercentage() 
    {
        return percentage;
    }
      
    @Override
    public String toString() 
    {
        return name+"-"+id+"-"+subject+"-"+percentage;
    }
}
