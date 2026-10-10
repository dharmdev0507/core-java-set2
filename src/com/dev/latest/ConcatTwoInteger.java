package com.dev.latest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class ConcatTwoInteger {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,4,6,3,4); 
		List<Integer> list2 = Arrays.asList(3,7,2);
	
		List<Integer> combinedList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		
		System.out.println("Combined List :: "+combinedList);
		
		int a[] = {8,10,7,14};
		int b[] = {5,11,4,9,12};
		
		int result[] = IntStream.concat(IntStream.of(a), IntStream.of(b)).sorted().toArray();
		
		for (int i = 0; i < result.length; i++) {
			System.out.println("List : "+result[i]);
		}
		
		
		List<Integer> combinedArray=Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().collect(Collectors.toList());
		System.out.println(combinedArray);
	}

}
