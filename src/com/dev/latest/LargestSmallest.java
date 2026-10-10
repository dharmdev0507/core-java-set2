package com.dev.latest;

import java.util.Arrays;

public class LargestSmallest {

	public static void main(String[] args) {

		int arr[] = {12, 45, 7, 89, 34, 2, 67};
		
		minMaxNumber(arr);

		int min=arr[0];
		int max=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
			
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		
		System.out.println("Min : "+min);
		System.out.println("Max : "+max);
		
	}

	private static void minMaxNumber(int[] arr) {
		
		int min=Arrays.stream(arr).min().getAsInt();
		int max=Arrays.stream(arr).max().getAsInt();
		
		System.out.println("Min : "+min+" max : "+max);
	}

}
