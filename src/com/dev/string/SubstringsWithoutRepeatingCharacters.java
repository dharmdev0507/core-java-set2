package com.dev.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Input: "ab"
Output: [a, b, ab]
 */

public class SubstringsWithoutRepeatingCharacters {

	public static void main(String[] args) {
         String str ="ab";
         List<String> result=findSubstrings(str);
         System.out.println("Result : "+result);
	}

	private static List<String> findSubstrings(String str) {

        List<String> result = new ArrayList<String>();
        
        for(int i=0;i<str.length();i++) {
        	
        	Set<Character> set = new HashSet<>();
        	StringBuilder sb = new StringBuilder();
        	
        	for(int j=i;j<str.length();j++) {
        		
        		char ch = str.charAt(j);
        		
        		if(set.contains(ch)) {
        			break;
        		}
        		
        		set.add(ch);
        		sb.append(ch);
        		
        		result.add(sb.toString());
        	}
        }
		
		return result;
	}

}
