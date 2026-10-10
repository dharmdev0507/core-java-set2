package com.dev.string;

//Time complexity:O(n)
/*
👉 Example:
Input:  a,b$c
Output: c,b$a
 */
public class ReverseStringWtSpecialCharacters {

	public static void main(String[] args) {
	
		String str = "a,b$cm";
		String subStr = str.replaceAll("[^a-zA-z]", "");
		System.out.println("Sub String :: "+subStr);
		String result = reverseStringWithoutReserveringSpecialCharacters(str);
		System.out.println("Result :: "+result);

	}

	private static String reverseStringWithoutReserveringSpecialCharacters(String str) {
        
		char[] arr=str.toCharArray();
		int left=0,right=arr.length-1;
		
		while(left<right) {
			if(!Character.isLetter(arr[left])) {
				left++;
			}else if(!Character.isLetter(arr[right])){
				right--;
			}else {
				char temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
       
		return new String(arr);
	}

}
