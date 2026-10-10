package com.dev.string;
import java.util.*;

public class FilterDuplicateNumber {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 2, 4, 5, 1};

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicates: " + duplicates);
        
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> otherSet = new HashSet<Integer>();
        
        for(int num : arr) {
            	
        	if(set.contains(num)) {
        		otherSet.add(num);
        	}
        	
        	set.add(num);
        }
        
        System.out.println("Other : "+otherSet);
	}

}
