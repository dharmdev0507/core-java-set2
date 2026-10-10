package com.dev.string;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		
		String str="abbaca";
		StringBuffer sb = new StringBuffer();
		
		for(char ch:str.toCharArray()) {
		    
			int len=sb.length();
			
			if(len>0 && sb.charAt(len-1)==ch) {
				sb.deleteCharAt(len-1);
			}else {
				sb.append(ch);
			}
		}
		
		System.out.println(sb.toString());

	}

}
