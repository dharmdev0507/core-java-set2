package com.dev.latest;

public class SumOddEven {

	public static void main(String[] args) {
		
		int arr[] = {10, 15, 20, 25, 30, 35};
		int evenNum=0,oddNum=0;
		
		for(int num:arr) {
		
			if(num%2==0) {
				evenNum +=num;
			}else {
				oddNum +=num;
			}
		}
		
		System.out.println("Even : "+evenNum+" Odd : "+oddNum);
	}

}
