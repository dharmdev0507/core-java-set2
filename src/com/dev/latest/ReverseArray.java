package com.dev.latest;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
	
		int arr[] = {12, 45, 7, 89, 34, 2, 67};
		int result[]= new int[arr.length];
		
		for(int i=arr.length-1;i>=0;i--) {
			result[i]=arr[i];
			//System.out.print(arr[i]+" ");
		}
		
		System.out.println(Arrays.toString(result));
	}

}
