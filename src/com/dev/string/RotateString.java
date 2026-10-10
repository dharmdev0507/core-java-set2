package com.dev.string;

import java.util.Arrays;

public class RotateString {

	public static void main(String[] args) {
		
		String s1 = "waterbottle";   //output : lewaterbott
		int k=2;
		//String[] result = new String[s1.length()];
		String[] result = s1.split("");
		
		for(int i=0;i<s1.length();i++) {
			result[(i+k)%s1.length()]=String.valueOf(s1.charAt(i));
		}
		
		//System.out.println(Arrays.toString(result));
		System.out.println(String.join("", result));

	}

}
