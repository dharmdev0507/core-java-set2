package com.dev.string;

public class StringCompression {

	public static void main(String[] args) {
	    int count=1;
		String str="aaabccddddaa";
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=str.length();i++) {
			
			if(i<str.length() && str.charAt(i)==str.charAt(i-1)) {
				count++;
			}else {
				sb.append(str.charAt(i-1)).append(count);
				count=1;
			}
		}
		
		System.out.println(sb.toString());
	}

}
