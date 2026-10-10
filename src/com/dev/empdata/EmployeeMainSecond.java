package com.dev.empdata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMainSecond {
	
	public static void main(String[] args) {
		
		//7. Find duplicate elements ⭐⭐⭐
		int[] arr= {1,2,3,2,5,4,1}; //Output [1,2]
		Map<Integer,Long> mainMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		List<Integer> repeated=mainMap.entrySet().stream().filter(e->e.getValue()>1L).map(e->e.getKey()).collect(Collectors.toList());
		System.out.println("duplicate elements : "+repeated);
		
		//8. First non-repeated character ⭐⭐⭐
		String s="programming"; //OUTPUT : p
		
		Character nonRepeated=s.chars().mapToObj(str->(char)str).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(e->e.getValue()==1L).map(e->e.getKey()).findFirst().get();
	
		System.out.println("non-repeated character : "+nonRepeated);
		
		//9. Frequency of each character ⭐⭐⭐
		Map<Character,Long> frequency = s.chars().mapToObj(s1->(char)s1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		frequency.forEach((k,v)->System.out.println(k+":"+v));

		//14. Most frequently occurring word ⭐⭐⭐⭐
		String st1="Java Spring Java SQL Spring Java"; //OUTPUT: Java
		Map<String,Long> mostFrequentlyOccurance=Arrays.stream(st1.split(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println("----Most frequently occurring word -----");
		String mostFrequentlyChar=mostFrequentlyOccurance.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.filter(entry->entry.getValue()>1L).map(entry->entry.getKey()).findFirst().get();
		System.out.println(mostFrequentlyChar);
		//another way
		String frequentlyWord=mostFrequentlyOccurance.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		System.out.println(frequentlyWord);
		
		//15. Longest string in a list ⭐⭐
		List<String> str1=List.of("Java","SpringBoot","SQL","Hibernate"); //OUTPUT:SpringBoot
		System.out.println("---Longest string in a list---");
		String logestString=str1.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(logestString);
		
		//21. sort them according to decreasing order of their length
		System.out.println("---sort them according to decreasing order of their length---");
		String longestStr=str1.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.joining(" "));
		System.out.println(longestStr);
		
		//18. Find duplicate words in a sentence ⭐⭐⭐
		String ss="java spring java boot spring";//Output:java spring
		Map<String,Long> duplicateWord= Arrays.stream(ss.split(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println("---Find duplicate words in a sentence---");
		List<String> duplicate = duplicateWord.entrySet().stream().filter(entry->entry.getValue()>1L).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(duplicate);
		
		Map<String,Long> duplicateMap = duplicateWord.entrySet().stream().filter(entry->entry.getValue()>1L).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(duplicateMap);
		
	}

}
