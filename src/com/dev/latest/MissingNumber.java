package com.dev.latest;

public class MissingNumber {

	public static void main(String[] args) {
		
        int arr[] = {1,2,4,5,7};
        int n = 7;

        boolean present[] = new boolean[n + 1];

        for(int i : arr) {
            present[i] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(!present[i]) {
                System.out.print(i+" ");
            }
        }
	}

}
