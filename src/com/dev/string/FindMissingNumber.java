package com.dev.string;

import java.util.*;

public class FindMissingNumber {

	public static void main(String[] args) {
		
		    int[] arr = {1, 2, 4, 5, 6, 8};
	        int n = 8;

	        List<Integer> missingNumber=findMissingNumber(arr,n);
	        System.out.println("missingNumber : "+missingNumber);
	        
	        int total = n * (n + 1) / 2;
	        int sum = 0;

	        for (int num : arr) {
	            sum += num;
	        }

	        System.out.println("Missing number: " + (total - sum));
	}

	private static List<Integer> findMissingNumber(int[] arr,int n) {
		
		List<Integer> list= new ArrayList<Integer>();
		Set<Integer> set = new HashSet();
		
		for(Integer num : arr) {
			set.add(num);
		}
		
		for(int i=1;i<=n;i++) {
			if(!set.contains(i)) {
				list.add(i);
			}
		}
		
		return list;
	}

}
