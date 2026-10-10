package com.dev.string;
//Rotate array to right by K steps.
public class RotateArrayKstepRight {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 3;
		
		reversedVersion(arr,k);  //updated one

	}
	
	private static void reversedVersion(int[] arr, int k) {
		   
		int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[(i + k) % arr.length] = arr[i];
        }

        System.out.println("#############");
        
        for (int num : result) {
            System.out.print(num + " ");
        }
		
	}

}
