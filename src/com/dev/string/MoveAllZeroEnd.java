package com.dev.string;

import java.util.Arrays;

public class MoveAllZeroEnd {

	public static void main(String[] args) {
		
		int[] arr = { 0, 1,0 ,0, 3, 12 };
		
		moveZeroAtEnd(arr);
		
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}
		}

		while (index < arr.length) {
			arr[index++] = 0;
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	private static void moveZeroAtEnd(int[] arr) {
		
		int left=0,right=arr.length-1;
        while(left<right){

            while(left<right && arr[left]>=1){
               left++;  
            }
            
            while(left<right && arr[right]==0){
               right--;    
            }
            
            if(left<right){
            
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
		
		System.out.println("## : "+Arrays.toString(arr));
	}

}
