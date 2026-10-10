package com.dev.latest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatTwoString {

	public static void main(String[] args) {
		
		List<String> s1 = Arrays.asList("test8","test5","test7");
		List<String> s2 = Arrays.asList("test1","test6","test4","test3");
	
		List<String> result = Stream.concat(s1.stream(), s2.stream()).sorted().collect(Collectors.toList());
		
		System.out.println("List :: "+result);
	
	}

}
