package com.dev.string;

import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
        String str = "abcabcbb";
        HashSet<Character> set = new HashSet<>();

        int left = 0, maxLength = 0,start=0;

        for (int right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
           // maxLength = Math.max(maxLength, right - left + 1);   // for maxlength
            
            if(right-left+1>maxLength) {
            	maxLength = right-left+1;
            	start=left;
            }
        }

        String result = str.substring(start, start+maxLength);
        System.out.println("length : "+maxLength);
        System.out.println("String : "+result);

	}

}
