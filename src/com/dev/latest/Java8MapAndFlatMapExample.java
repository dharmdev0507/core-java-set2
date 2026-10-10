package com.dev.latest;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8MapAndFlatMapExample {

	public static void main(String[] args) {

	
		List<Institute> list = List.of(new Institute("IIM", "1995",Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")),
				new Institute("IIT", "1956",Arrays.asList("Delhi", "Mumbai", "Kharagpur")),
				new Institute("NIIT", "2005",Arrays.asList("Vadodra", "Indore", "Kolkata")),
				new Institute("NIFT", "2001",Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));
		
		//Find Institute Name and location which establised in 2000 to 2006
		Map<String, List<String>> establisedList =
			    list.stream()
			        .filter(i -> {
			            int year = Integer.parseInt(i.getYears());
			            return year >= 2000 && year <= 2006;
			        })
			        .collect(Collectors.toMap(
			            Institute::getName,
			            Institute::getLocations
			        ));

		System.out.println("establisedList :"+establisedList);
		
		//Find institute name which belongs to Mumbai
		Set<String> instituteNames =
			    list.stream()
			        .flatMap(i -> i.getLocations().stream()
			                .filter(loc -> loc.equals("Mumbai"))
			                .map(instituteName -> i.getName()))
			        .collect(Collectors.toSet());
		System.out.println("instituteNames : "+instituteNames);
		
		//print institute name and location which belongs to Banglore
		Map<String, String> result =
			    list.stream()
			        .flatMap(i -> i.getLocations().stream()
			                .filter(loc -> loc.equals("Bangalore"))
			                .map(loc -> new AbstractMap.SimpleEntry<>(i.getName(), loc)))
			        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("Result ## :"+result);
		
		Map<String, List<String>> nameAndLocation =
			    list.stream()
			        .filter(i -> i.getLocations().contains("Mumbai"))
			        .collect(Collectors.toMap(
			            Institute::getName,
			            i -> i.getLocations().stream()
			                    .filter(loc -> loc.equals("Mumbai"))
			                    .collect(Collectors.toList())
			        ));
		
		System.out.println("nameAndLocation : "+nameAndLocation);
		
		//find name of Institute using map()
		String instituteName=list.stream().map(Institute::getName).collect(Collectors.joining(","));
		System.out.println("Institute Name : "+instituteName);

		//find unique location using flatmap
		Set<String> location = list.stream().flatMap(loc->loc.getLocations().stream()).collect(Collectors.toSet());
		System.out.println("Location : "+location);
		
		//find institute name which belongs to Mumbai city
		String instituteAnyMatch = list.stream()
		        .filter(st -> st.getLocations().stream()
		                .anyMatch(loc -> loc.equals("Mumbai")))
		        .map(Institute::getName)
		        .collect(Collectors.joining(","));
		
		String instituteBelongsToMumbai = list.stream()
		        .flatMap(inst -> inst.getLocations().stream()
		                .filter(loc -> loc.equals("Mumbai"))
		                .map(name -> inst.getName())
		                )
		        .collect(Collectors.joining(","));
		
		String instituteContains = list.stream()
		        .filter(st -> st.getLocations().contains("Mumbai"))
		        .map(Institute::getName)
		        .collect(Collectors.joining(","));

		System.out.println("Institute Belongs to Mumbai: " + instituteAnyMatch);
		System.out.println("Institute Belongs to Mumbai: " + instituteBelongsToMumbai);
		System.out.println("Institute Belongs to Mumbai: " + instituteContains);
		
		
	}

}


class Institute
{   
    String name;
    String years;
    List<String> locations;
     
    public Institute() {

	}

	public Institute(String name, String years, List<String> locations) {
		this.name = name;
		this.years = years;
		this.locations = locations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

}