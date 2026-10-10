package com.dev.string;

public class Palindrome {

	public static void main(String[] args) {

         String st = "madam";
         boolean isPalindrome=palindromeCheck(st);
         System.out.println(st+"-> is palindrome : "+isPalindrome); 
         
         checkPalindromString(st);
         
         //palindrome int
         int num=121;
         boolean isNumPalindrome=numPalindrome(num);
         System.out.println(num +"-> is palindrome number : "+isNumPalindrome);
	}

	private static void checkPalindromString(String st) {
	
		String reservse="";
		
		for(int i=st.length()-1;i>=0;i--) {
			reservse +=st.charAt(i); 
		}
		
		if(st.equals(reservse)) {
			System.out.println("Plaindrom String");
		}else {
			System.out.println("Not palindrom");
		}
		//System.out.println("Reservse : "+reservse);
	}

	private static boolean numPalindrome(int num) {
		
		int original=num,reverse=0;
		
		while(num!=0) {
			int remainder=num%10;
			reverse=reverse*10 + remainder;
			num=num/10;
		}
		
		if(original!=reverse) {
			return false;
		}
		
		return true;
	}

	private static boolean palindromeCheck(String st) {
        
		int left=0;
        int right=st.length()-1;
        
        while(left<right) {
	       	 if(st.charAt(left)!=st.charAt(right)) {
	       		 return false;
	       	 }
	       	 left++;
	       	 right--;
        }
		return true;
	}

}
