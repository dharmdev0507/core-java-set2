package com.dev.string;

//without using any inbuilt function
public class ReverseString {

	public static void main(String[] args) {
		
		 String input = "Interview";
		 char[] ch = input.toCharArray();
		 
		 int left=0;
		 int right=ch.length-1;
		 System.out.println("ch : "+ch.length);
		 
		 while(left<right) {
			 char temp=ch[left];
			 ch[left]=ch[right];
			 ch[right]=temp;
			 left++;
			 right--;
		 }
		 
		 System.out.println("Reverse String :: "+new String(ch));
	}

}
