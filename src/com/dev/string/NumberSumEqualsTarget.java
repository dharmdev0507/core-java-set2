package com.dev.string;

import java.util.*;

public class NumberSumEqualsTarget {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<>();  
		int[] arr = {2, 7, 11, 15};
	    int target = 9;

	    for(int num:arr) {
	    	
	    	int diff = target-num;
	    	if(set.contains(diff)) {
	    		System.out.println(diff+":"+num);
	    	}
	    	
	    	set.add(num);
	    }
	    
	}

}
