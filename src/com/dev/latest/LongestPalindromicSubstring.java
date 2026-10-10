package com.dev.latest;

import java.util.*;

/*Time Complexity: O(n²)
Space Complexity: O(1)
*/
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";

        int start = 0, maxLen = 0;
        
        Set<String> set = new HashSet<String>(); // print all palindrom

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);       // odd
            int len2 = expand(s, i, i + 1);   // even

            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
                set.clear();
                palindrom(s,i,len,set);//print all palindrom
            }else if(len==maxLen){ // print all palindrom
            	palindrom(s,i,len,set);
            }
        }

        System.out.println("print all : "+set);
        System.out.println(s.substring(start, start + maxLen));
    }

    private static void palindrom(String s, int i, int len, Set<String> set) { // print all palindrom
    	int start = i-(len-1)/2;
    	int end = i+len/2;
		set.add(s.substring(start, end+1));
	}

	private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
